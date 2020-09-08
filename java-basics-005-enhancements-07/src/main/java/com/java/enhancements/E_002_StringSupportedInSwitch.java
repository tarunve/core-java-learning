package com.java.enhancements;

/**
 * -> Switch statement existed before Java 7 as well, but it supported only int and enum types. 
 * -> After Java 7 release, Switch statement support String class also.
 */
public class E_002_StringSupportedInSwitch {

	public static void main(String[] args) {
		System.out.println(getExpendedMessage("one"));
		System.out.println(getExpendedMessage("two"));
	}

	static String getExpendedMessage(final String token) {
		String value = null;

		switch (token) {
		case ("one"):
		case ("three"):
			value = "Odd token identified";
			break;

		case ("two"):
		case ("four"):
			value = "Even token identified";
			break;

		default:
			value = "No token was identified";
		}

		return value;
	}
}
