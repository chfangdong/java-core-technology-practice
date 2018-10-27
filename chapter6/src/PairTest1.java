package src;

import java.io.Serializable;
import java.time.chrono.MinguoChronology;

import javax.swing.Spring;

public class PairTest1 {
	public static void main(String[] args) {
		String[] word = {"Marry", "had", "a", "little", "lamb"};
		Pair<String> pair = ArrayAlg.minMax(word);
		
		System.out.println("this is min: " + pair.getFirst());
		System.out.println("this is max: " + pair.getSecond());
		System.out.println("this is middle: " + ArrayAlg.getMiddle(word));
		
	}
}

class Pair<T>{
	private T first;
	private T second;
	
	public Pair() {
		// TODO Auto-generated constructor stub
	}
	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}
	
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public T getSecond() {
		return second;
	}
	public void setSecond(T second) {
		this.second = second;
	}
}

class ArrayAlg
{
	public static Pair<String> minMax(String[] a){
		if(a == null || a.length == 0) return null;
		String min = a[0];
		String max = a[0];
		for(int i=0; i < a.length; i++) {
			if(min.compareTo(a[i]) > 0)
				min=a[i];
			if(max.compareTo(a[i]) < 0)
				max = a[i];
		}
		return new Pair<String>(min, max);
	}
	public static <T> T getMiddle(T[] a) {
		return a[a.length/2];
	}
	
	public static <T extends Comparable & Serializable> T min(T[] a) {
		if(a == null || a.length == 0) return null;
		T smallest = a[0];
		for(int i=0; i < a.length; i++) {
			if(smallest.compareTo(a[i]) > 0)
				smallest = a[i];
		}
		return smallest;
	}
}