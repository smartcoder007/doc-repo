package jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilters {
	
	public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // convert list to stream
                .filter(test -> !"mkyong".equals(test))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println);                //output : spring, node

    }

}
