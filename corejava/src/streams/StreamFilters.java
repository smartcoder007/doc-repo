package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilters {
	
	public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "jarvis");

        List<String> result = lines.stream()                // convert list to stream
                .filter(test -> !"jarvis".equals(test))     // we dont like jarvis
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        result.forEach(System.out::println);                //output : spring, node

    }

}
