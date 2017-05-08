package jdk8;

import java.util.Arrays;

public class MethodReferences {

	public void printByStringLength() {
		String names[] = { "abcde", "abc", "ab", "abcd", "a" };
		Arrays.sort(names, Test::matchStringLength); // method reference
		System.out.println(Arrays.toString(names));
	}

	public static void main(String args[]) {
		new MethodReferences().printByStringLength();
	}
}

class Test {
	public static int matchStringLength(String str1, String str2) {
		return str1.length() - str2.length();
	}
}