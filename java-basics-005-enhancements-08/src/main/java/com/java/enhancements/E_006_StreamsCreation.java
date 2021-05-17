package com.java.enhancements;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class E_006_StreamsCreation {

    public static void main(String[] args) {
        streamFromArray();
        streamFromTextFile();
        streamFromRegularExp();
        streamFromString();
        skippingAndLimiting();
    }

    private static void streamFromArray() {
        Person p1 = new Person("tarun", 28);
        Person p2 = new Person("deepak", 27);
        Person p3 = new Person("rajat", 23);
        Person p4 = new Person("yuvraj", 30);
        Person p5 = new Person("kuldeep", 27);
        Person[] people = {p1, p2, p3, p4, p5};

        //First way of creating stream from aray
        long count = Stream.of(people).count();
        System.out.println("Count of people : " + count);

        //second way of creating stream from array
        Arrays.stream(people).forEach(p -> System.out.println(p.getName()));
    }

    private static void streamFromTextFile() {
        try {
            Stream<String> lines = Files.lines(Paths.get("abc.txt"));
            long count = lines.count();
            System.out.println("count of lines : " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void streamFromRegularExp() {
        String sentence = "the quick brown fox jumps over the lazy dog";
        // First way - cost addition for creation of array
        String[] words = sentence.split(" ");
        Stream<String> wordsAsStream = Arrays.stream(words);
        System.out.println("Count : " + wordsAsStream.count());

        // Second way - more efficient
        Pattern pattern = Pattern.compile(" ");
        long count = pattern.splitAsStream(sentence).count();
        System.out.println("Count : "+ count);
    }

    private static void streamFromString() {
        String sentence = "the quick brown fox jumps over the lazy dog";
        sentence.chars()
                .mapToObj(ch -> Character.toString((char) ch))
                .filter(letter -> !letter.equals(" "))
                .distinct()
                .sorted()
                .forEach(System.out::print);
    }

    private static void skippingAndLimiting() {
        IntStream.range(0, 30)
                .skip(10)
                .limit(10)
                .forEach(index -> System.out.println(index + " "));
    }
}

@Data
@NoArgsConstructor
@ToString
class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age= age;
    }
}