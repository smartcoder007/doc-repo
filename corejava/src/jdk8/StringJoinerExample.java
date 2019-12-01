package jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringJoinerExample {
	public static void main(String[] args) {
		
		StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString();
		
		StringJoiner sj2 = new StringJoiner("/", "prefix-", "-suffix");
        sj2.add("2016");
        sj2.add("02");
        sj2.add("26");
        String result2 = sj.toString(); //prefix-2016/02/26-suffix
        
        
        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");

    	//java | python | nodejs | ruby
    	String result3 = list.stream().map(x -> x).collect(Collectors.joining(" | "));


	}

}
