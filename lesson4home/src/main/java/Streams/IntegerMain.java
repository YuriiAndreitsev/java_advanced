package Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class IntegerMain {

	public static void main(String[] args) {
		List <Integer> numList = new ArrayList<Integer>();
		numList.add(1);
		numList.add(4);
		numList.add(5);
		numList.add(1);
		numList.add(2);
		numList.add(8);
		numList.add(6);
		numList.add(4);
		numList.add(9);
		numList.add(3);
		
//		Integer[] resultList = numList.stream().filter(e -> e % 2 ==0).sorted().toArray(Integer[]::new);
		
		List<Integer> resultList = numList.stream().filter(e -> e % 2 ==0).sorted().collect(Collectors.toList());
		
		for (Integer integer : resultList) {
			System.out.println(integer);
		}
	}

}
