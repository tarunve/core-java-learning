package com.java.enhancements;

import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Properties;

/**
 *	Java WatchService to Auto Reload Properties
 *	===========================================
 *	->	Automatically refresh the configuration files whenever any change happens in those files – It is a very common problem 
 *		seen in the most application.
 *	->	Every application has some configuration which is expected to be refreshed on every change in the configuration file. 
 *	->	Past approaches to solve this problem had consisted of having a Thread, which periodically poll for file change based 
 *		on the 'last update timestamp' of the configuration file.
 *
 *	Java WatchService API
 *	=====================
 *	->	A WatchService is the JDKs internal service which watches for changes on registered objects. These registered objects 
 *		are necessarily the instances of Watchable interface. When registering the watchable instance with WatchService, we 
 *		need to specify the kind of change events we are interested in.
 *	->	There are four type of events as of now:
 *		->	ENTRY_CREATE
 *			->	public static final WatchEvent.Kind<Path> ENTRY_CREATE
 *			->	Directory entry created.
 *			->	When a directory is registered for this event then the WatchKey is queued when it is observed that an entry 
 *				is created in the directory or renamed into the directory. The event count for this event is always 1.
 *		->	ENTRY_DELETE
 *			->	public static final WatchEvent.Kind<Path> ENTRY_DELETE
 *			->	Directory entry deleted.
 *			->	When a directory is registered for this event then the WatchKey is queued when it is observed that an 
 *				entry is deleted or renamed out of the directory. The event count for this event is always 1.
 *		->	ENTRY_MODIFY
 *			->	public static final WatchEvent.Kind<Path> ENTRY_MODIFY
 *			->	Directory entry modified.
 *			->	When a directory is registered for this event then the WatchKey is queued when it is observed that an 
 *				entry in the directory has been modified. The event count for this event is 1 or greater.
 *		->	OVERFLOW
 *			->	public static final WatchEvent.Kind<Object> OVERFLOW
 *			->	A special event to indicate that events may have been lost or discarded.
 *			->	The context for this event is implementation specific and may be null. The event count may be greater than 1.
 *	->	WatchService interface extends Closeable interface, means service can be closed as and when required. Normally, it 	
 *		should be done using JVM provided shut down hooks.
 *	->	WatchService provides two methods take() and poll(). While take() method wait for next change to happen and until it 
 *		is blocked, poll() immediately check for change event. If nothing changed from last poll() call, it will return null. 
 *		poll() method does not block the execution, so should be called in a Thread with some sleep time.
 */
public class E_008_WatchService {

	/*
	 * 	Application Configuration Provider:
	 * 		A configuration provider is simply a wrapper for holding the set of properties in java,util.Properties instance. 
	 * 		It also provides methods to get the configured properties using their KEY.
	 */
	public static class ApplicationConfiguration {
		private final static ApplicationConfiguration INSTANCE = new ApplicationConfiguration();

		private ApplicationConfiguration() {}
		
		public static ApplicationConfiguration getInstance() {
			return INSTANCE;
		}

		private static Properties configuration = new Properties();

		private static Properties getConfiguration() {
			return configuration;
		}

		public void initilize(final String file) {
			InputStream in = null;
			try {
				in = new FileInputStream(new File(file));
				configuration.load(in);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public String getConfiguration(final String key) {
			return (String) getConfiguration().get(key);
		}

		public String getConfigurationWithDefaultValue(final String key, final String defaultValue) {
			return (String) getConfiguration().getProperty(key, defaultValue);
		}
	}

	/*
	 * 	Configuration Change Listener – File Watcher
	 * 		Now when we have our basic wrapper for our in-memory cache of configuration properties, we need a mechanism to 
	 * 		reload this cache on runtime, whenever configuration file stored in file system changes.
	 */
	public static class ConfigurationChangeListner implements Runnable {
		private String configFileName = null;
		private String fullFilePath = null;

		public ConfigurationChangeListner(final String filePath) {
			this.fullFilePath = filePath;
		}

		public void run() {
			try {
				register(this.fullFilePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void register(final String file) throws IOException {
			final int lastIndex = file.lastIndexOf("/");
			String dirPath = file.substring(0, lastIndex + 1);
			String fileName = file.substring(lastIndex + 1, file.length());
			this.configFileName = fileName;

			configurationChanged(file);
			startWatcher(dirPath, fileName);
		}

		private void startWatcher(String dirPath, String file) throws IOException {
			final WatchService watchService = FileSystems.getDefault().newWatchService();
			Path path = Paths.get(dirPath);
			path.register(watchService, ENTRY_MODIFY);

			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					try {
						watchService.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			});

			WatchKey key = null;
			while (true) {
				try {
					key = watchService.take();
					for (WatchEvent<?> event : key.pollEvents()) {
						if (event.context().toString().equals(configFileName)) {
							configurationChanged(dirPath + file);
						}
					}
					boolean reset = key.reset();
					if (!reset) {
						System.out.println("Could not reset the watch key.");
						break;
					}
				} catch (Exception e) {
					System.out.println("InterruptedException: " + e.getMessage());
				}
			}
		}

		public void configurationChanged(final String file) {
			System.out.println("Refreshing the configuration.");
			ApplicationConfiguration.getInstance().initilize(file);
		}
	}

	/*
	 * Test Code
	 */
	public static class ConfigChangeTest {
		private static final String FILE_PATH = new ConfigChangeTest().getResourceFIles("test.properties").substring(1);

		public static void main(String[] args) {
			ConfigurationChangeListner listner = new ConfigurationChangeListner(FILE_PATH);
			try {
				new Thread(listner).start();
				while (true) {
					Thread.sleep(2000l);
					System.out.println(ApplicationConfiguration.getInstance().getConfiguration("TEST_KEY"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public String getResourceFIles(String name){
			return getClass().getClassLoader().getResource(name).getFile();
		}
	}
}
