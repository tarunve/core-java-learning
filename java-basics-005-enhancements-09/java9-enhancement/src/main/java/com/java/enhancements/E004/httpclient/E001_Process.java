package com.java.enhancements.E004.httpclient;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.time.Instant;
import java.util.Comparator;

/**
 *  Process:
 *  -------
 *  - Represents native process created from Java.
 *
 *
 *  ProcessHandle
 *  -------------
 *  - Represents any native process on the operation system.
 */
public class E001_Process {

    public static void main(String[] args) throws IOException {
        processIdExample();
        listProcessesExample();
        killChildProcessExample();
        killOtherProcessesExample();
    }

    private static void processIdExample() {
        // Before Java 9 :(
        long pidOld = Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);

        // With the new ProcessHandle API in Java 9:
        long pidNew = ProcessHandle.current().pid();
        long parentPid = ProcessHandle.current().parent().get().pid();

        System.out.printf("{ pidOld: %s, pidNew: %s }\nparentPid (IDE): %s%n", pidOld, pidNew, parentPid);
    }

    private static void listProcessesExample() {
        ProcessHandle.allProcesses()
                .map(ProcessHandle::info)
                .sorted(Comparator.comparing(info -> info.startInstant().orElse(Instant.MAX)))
                .forEach(E001_Process::printInfo);
    }

    private static void printInfo(ProcessHandle.Info info) {
        if(info.startInstant().isPresent() && info.command().isPresent()) {
            System.out.println("Started at: " + info.startInstant().get()
                    + ", Command: " + info.command().get());
        }

    }

    private static void killChildProcessExample() throws IOException {
        Process process = new ProcessBuilder("bash", "-c", "while true; do sleep 1; done").start();

        ProcessHandle handle = process.toHandle();
        handle.onExit().thenAccept(p -> System.out.println("Process " + p + " was killed"));

        System.out.println("Press enter to continue");
        System.in.read();

        if (handle.supportsNormalTermination()) {
            System.out.println("Killing process");
            handle.destroy();
        }

        System.out.println("Press enter to finish");
        System.in.read();
    }

    private static void killOtherProcessesExample() {
        ProcessHandle textEditHandle = ProcessHandle.allProcesses()
                .filter(h -> h.info().commandLine().map(cmd -> cmd.contains("TextEdit")).orElse(false))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No matching handle found"));

        System.out.println(textEditHandle.info());

        textEditHandle.onExit().thenAccept(h -> System.out.println("TextEdit was killed by Java!"));

        boolean shutdown = textEditHandle.destroy();
        textEditHandle.onExit().join();
        System.out.println("Shutdown: " + shutdown);
    }
}
