
public class Test5 {
	public static double max(double... values) {
		double largest = Double.MIN_VALUE;
		for(double v: values) 
			largest = v > largest?v:largest;
		return largest;
	}
	
}


