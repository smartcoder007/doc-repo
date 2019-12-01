package streams;

import java.util.Arrays;
import java.util.stream.Stream;

// Stream cannot be reused, once it is consumed or used, the stream will be closed

public class StreamCannotResused {
	public static void main(String[] args) {

        String[] array = {"a", "b", "c", "d", "e"};
        Stream<String> stream = Arrays.stream(array);

        // loop a stream
        stream.forEach(x -> System.out.println(x));

        // reuse it to filter again! throws IllegalStateException
        long count = stream.filter(x -> "b".equals(x)).count();
        System.out.println(count);

    }


}
