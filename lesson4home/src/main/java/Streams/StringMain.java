package Streams;

import java.util.ArrayList;
import java.util.List;

public class StringMain {

	public static void main(String[] args) {

		List <String> wordList = new ArrayList<String>();
		wordList.add("one");
		wordList.add("two");
		wordList.add("three");
		wordList.add("four");
		wordList.add("five");

		wordList.parallelStream().map(w -> w.concat("A")).forEach(w -> System.out.println(w));

	}

}
