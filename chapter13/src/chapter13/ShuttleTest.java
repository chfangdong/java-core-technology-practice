package chapter13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuttleTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<50; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		List<Integer> subList = list.subList(0, 6);
		Collections.sort(subList);
		System.out.println(subList);
	}
}
