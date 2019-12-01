package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import model.Person;

public class Stream_Filter_Map {

	public static void main(String[] args) {

		List<Person> persons = Arrays.asList(new Person("javaris", 30), new Person("jack", 20),
				new Person("lawrence", 40));

		String name = persons.stream().filter(x -> "jack".equals(x.getName())).map(Person::getName) // convert stream to
																									// String
				.findAny().orElse("");

		System.out.println("name : " + name);

		List<String> collect = persons.stream().map(Person::getName).collect(Collectors.toList());

		collect.forEach(System.out::println);

	}
}
