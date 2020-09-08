package com.java.enhancements;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class E_010_StringOperations {

	public static class StringJoin {

		public static void main(String[] args) {
			/*
			 * Join String Array – Java 8 String.join()
			 */
			String joinedString = String.join(", ", "How", "To", "Do", "In", "Java");
			System.out.println(joinedString);

			List<String> strList = Arrays.asList("How", "To", "Do", "In", "Java");
			String joinedStr = String.join(", ", strList);
			System.out.println(joinedStr);

			String[] strArray = { "How", "To", "Do", "In", "Java" };
			String joinedArrayStr = String.join(", ", strArray);
			System.out.println(joinedArrayStr);

			/*
			 * Java 8 StringJoiner for formatted output
			 */
			StringJoiner joiner = new StringJoiner(", ", "[", "]");
			joiner.add("How").add("To").add("Do").add("In").add("Java");

			/*
			 * String list of string with Collectors.joining()
			 */
			List<String> numbers = Arrays.asList("How", "To", "Do", "In", "Java");
			String joinedNumbers = numbers.stream().collect(Collectors.joining(", ", "[", "]"));
			System.out.println(joinedNumbers);
		}
	}

	public static class StringToDateConversion {
		public static void main(String[] args) {
			/*
			 * Convert string to date in ISO8601 format
			 */
			String armisticeDate = "2016-04-04";
			LocalDate aLD = LocalDate.parse(armisticeDate);
			System.out.println("Date: " + aLD);
			String armisticeDateTime = "2016-04-04T11:50";
			LocalDateTime aLDT = LocalDateTime.parse(armisticeDateTime);
			System.out.println("Date/Time: " + aLDT);

			/*
			 * Convert string to date in custom formats
			 */
			String anotherDate = "04 Apr 2016";
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd MMM yyyy");
			LocalDate random = LocalDate.parse(anotherDate, df);
			System.out.println(anotherDate + " parses as " + random);
		}
	}

	public static class Base64Encoding {
		@SuppressWarnings("unused")
		public static void main(String[] args) throws IOException {
			/*
			 * Encoding a string to base 64
			 */
			Base64.Encoder encoder = Base64.getEncoder();
			String normalString = "Asmsa1:Asmsa1";
			String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
			System.out.println(encodedString);

			/*
			 * Decoding a base 64 encoded string
			 */
			Base64.Decoder decoder = Base64.getDecoder();
			byte[] decodedByteArray = decoder.decode(encodedString);
			System.out.println(new String(decodedByteArray));

			/*
			 * Wrap to a base 64 encoded output stream
			 */
			Path originalPath = Paths.get("c:/temp", "mail.txt");
			Path targetPath = Paths.get("c:/temp", "encoded.txt");
			Base64.Encoder mimeEncoder = Base64.getMimeEncoder();
			try (OutputStream output = Files.newOutputStream(targetPath)) {
				//Copy the encoded file content to target file
				Files.copy(originalPath, mimeEncoder.wrap(output));
				//Or simply use the encoded output stream
				OutputStream encodedStrem = mimeEncoder.wrap(output);
			}
		}
	}

	public static class RegexToPredicate {
		public static void main(String[] args) {
			/*
			 * Convert Regex to Predicate
			 */
			Predicate<String> emailFilter = Pattern.compile("^(.+)@example.com$").asPredicate();
			List<String> emails = Arrays.asList("alex@example.com", "bob@yahoo.com", "cat@google.com", "david@example.com");
			List<String> desiredEmails = emails.stream().filter(emailFilter).collect(Collectors.<String>toList());
			desiredEmails.forEach(System.out::println);

			/*
			 * Using Regex using Pattern.matcher()
			 */
			Pattern pattern = Pattern.compile("^(.+)@example.com$");
			for (String email : emails) {
				Matcher matcher = pattern.matcher(email);
				if (matcher.matches()) {
					System.out.println(email);
				}
			}
		}
	}
}
