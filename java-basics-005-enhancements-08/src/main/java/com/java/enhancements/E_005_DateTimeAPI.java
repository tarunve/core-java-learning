package com.java.enhancements;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.Year;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.TemporalAdjusters;
import java.time.zone.ZoneRules;

/**
 *	->	A big part of developer community has been complaining about Date and Calendar classes. Reasons were many 
 *		such as hard to understand, hard to use and not flexible. Date class has even become obsolete and java docs 
 *		suggest to use Calendar class instead of Date class. And on top of all, Date comparison is buggy and I have 
 *		also faced such issue in past.
 *	->	Moving forward, JAVA 8 (Lambda) is expected to release the new Date and Time APIs/classes (JSR-310), also 
 *		called as ThreeTen, which will simply change the way you have been doing till date. This A key part of this 
 *		is providing a new API that is dramatically easier to use and less error prone.
 */
public class E_005_DateTimeAPI {
	
	public void print() {
		System.out.println("Tarun is here ");
	}

	
	public static void main(String[] args) {
		/**
		 * New classes to represent local date and TimeZone
		 */
		/*
		 * LocalDate : The LocalDate class represents a date. There is no representation of a time or time-zone.
		 */
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.toString());                
		System.out.println(localDate.getDayOfWeek().toString()); 
		System.out.println(localDate.getDayOfMonth());           
		System.out.println(localDate.getDayOfYear());            
		System.out.println(localDate.isLeapYear());              
		System.out.println(localDate.plusDays(12).toString());   
		
		/*
		 * LocalTime : The LocalTime class represents a time. There is no representation of a date or time-zone.
		 */
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime.toString());    
		System.out.println(localTime.getHour());     
		System.out.println(localTime.getMinute());   
		System.out.println(localTime.getSecond());   
		System.out.println(LocalTime.MIDNIGHT);      
		System.out.println(LocalTime.NOON); 
		
		/*
		 * LocalDateTime : The LocalDateTime class represents a date-time. There is no representation of a time-zone.
		 */
		LocalDateTime localDateTime = LocalDateTime.now(); 
		System.out.println(localDateTime.toString());      
		System.out.println(localDateTime.getDayOfMonth()); 
		System.out.println(localDateTime.getHour());       
		System.out.println(localDateTime.getNano());       
		
		/**
		 * New classes to represent timestamp and duration
		 */
		/*
		 * Instant : 
		 * ->	For representing the specific timestamp ant any moment, the class needs to be used is Instant. The 
		 * 		Instant class represents an instant in time to an accuracy of nanoseconds. Operations on an Instant 
		 * 		include comparison to another Instant and adding or subtracting a duration.
		 */
		Instant instant = Instant.now();
		System.out.println(instant.toString());                                 
		System.out.println(instant.plus(Duration.ofMillis(5000)).toString());   
		System.out.println(instant.minus(Duration.ofMillis(5000)).toString());  
		System.out.println(instant.minusSeconds(10).toString());  
		
		/*
		 * Duration : 
		 * ->	Duration class is a whole new concept brought first time in java language. It represents the 
		 * 		time difference between two time stamps.
		 */
		Duration duration = Duration.ofMillis(5000);
		System.out.println(duration.toString());     
		duration = Duration.ofSeconds(60);
		System.out.println(duration.toString());     
		duration = Duration.ofMinutes(10);
		System.out.println(duration.toString());     
		duration = Duration.ofHours(2);
		System.out.println(duration.toString());     
		duration = Duration.between(Instant.now(), Instant.now().plus(Duration.ofMinutes(10)));
		System.out.println(duration.toString());  
		
		/*
		 * Period
		 * ->	To interact with human, you need to get bigger durations which are presented with Period class.
		 */
		Period period = Period.ofDays(6);
		System.out.println(period.toString());    
		period = Period.ofMonths(6);
		System.out.println(period.toString());    
		period = Period.between(LocalDate.now(), LocalDate.now().plusDays(60));
		System.out.println(period.toString());
		
		/**
		 * Added utility classes over existing enums
		 */
		/*
		 * DayOfWeek
		 * ->	The current Java SE platform uses int constants for months, day-of-week and am-pm etc. Now a lot 
		 * 		of extra utility classes have been added which work on top of these enums. I am taking an example 
		 * 		such a class DayOfWeek. This class is a wrapper of day enums and can be used consistently with other 
		 * 		classes also.
		 */
		System.out.println(DayOfWeek.of(2));                     
		DayOfWeek day = DayOfWeek.FRIDAY;
		System.out.println(day.getValue());                     
		LocalDate localDateNew = LocalDate.now();
		System.out.println(localDateNew.with(DayOfWeek.MONDAY));
		
		/**
		 * Date adjusters
		 * ->	Date adjusters are another beautiful and useful addition in date handling tools. It easily solves 
		 * 		the problems like : How do you find last day of the month? Or the next working day? Or a week on Tuesday?
		 */
		LocalDate date = LocalDate.of(2020, Month.JUNE, 7);                     
		LocalDate endOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
		System.out.println(endOfMonth.toString());                              
		LocalDate nextTue = date.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
		System.out.println(nextTue.toString()); 
		
		/**
		 * Creating date objects
		 * ->	Creating date objects now can be done using builder pattern also. The builder pattern allows the object 
		 * 		you want to be built up using individual parts. This is achieved using the methods prefixed by “at”.
		 */
		//Builder pattern used to make date object
		 OffsetDateTime date1 = Year.of(2020).atMonth(Month.JUNE).atDay(7).atTime(0, 0).atOffset(ZoneOffset.of("+03:00"));
		 System.out.println(date1);                           
		//factory method used to make date object
		OffsetDateTime date2 = OffsetDateTime.of(2013, 5, 15, 0, 0, 0, 0, ZoneOffset.of("+03:00"));
		System.out.println(date2);        
		
		/**
		 * New class to simulate system/machine clock
		 * ->	A new class Clock is proposed in new release. This simulates the system clock functionality.
		 * 		While doing unit testing. you are often required to test a API in future date. For this we had been 
		 * 		forwarding the system clock for next date, and then again restart the server and test the application.
		 */
		Clock clock = Clock.systemDefaultZone();
		System.out.println(clock);                      
		System.out.println(clock.instant().toString()); 
		System.out.println(clock.getZone());            
		Clock anotherClock = Clock.system(ZoneId.of("Europe/Tiraspol"));
		System.out.println(anotherClock);                 
		System.out.println(anotherClock.instant().toString());
		System.out.println(anotherClock.getZone());           
		Clock forwardedClock  = Clock.tick(anotherClock, Duration.ofSeconds(600));
		System.out.println(forwardedClock.instant().toString());
		
		/**
		 * Timezone Changes
		 * ->	Timezone related handling is done by 3 major classes. These are ZoneOffset, TimeZone, ZoneRules.
		 * ->	The ZoneOffset class represents a fixed offset from UTC in seconds. This is normally represented as a string of the format “±hh:mm”.
		 * ->	The TimeZone class represents the identifier for a region where specified time zone rules are defined.
		 * ->	The ZoneRules are the actual set of rules that define when the zone-offset changes.
		 */
		System.out.println(ZoneRules.of(ZoneOffset.of("+02:00")).isDaylightSavings(Instant.now()));
		System.out.println(ZoneRules.of(ZoneOffset.of("+02:00")).isFixedOffset());
		
		/**
		 * Date Formatting
		 * ->	Date formatting is supported via two classes mainly i.e. DateTimeFormatterBuilder and DateTimeFormatter. 
		 * ->	DateTimeFormatterBuilder works on builder pattern to build custom patterns where as DateTimeFormatter 
		 * 		provides necessary input in doing so.
		 */
		DateTimeFormatterBuilder formatterBuilder = new DateTimeFormatterBuilder();
		formatterBuilder.append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
		                .appendLiteral("-")
		                .appendZoneOrOffsetId();
		DateTimeFormatter formatter = formatterBuilder.toFormatter();
		System.out.println(formatter.format(ZonedDateTime.now()));
		
		/*for (String s : ZoneId.getAvailableZoneIds()) {
			System.out.println(s);
		}*/
		System.out.println(ZoneId.getAvailableZoneIds().stream().count());
	}
}
