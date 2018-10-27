package src;

import java.util.Scanner;
import java.util.logging.Logger;

import com.sun.java_cup.internal.runtime.Symbol;
import com.sun.org.apache.xml.internal.security.utils.UnsyncByteArrayOutputStream;

public class StackTraceTest {
	private static final Logger logger = Logger.getLogger("src");
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int factorial(int n) {
		System.out.println("factorial(" + n + "):");
		Throwable t = new Throwable();
		StackTraceElement[] frames = t.getStackTrace();
		for(StackTraceElement f: frames)
			System.out.println(f);
		
		int r;
		if (n <= 1)
			r = 1;
		else
			r = n * factorial(n-1);
		logger.info("return " + r);
		return r;	
	}
	
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter n: ");
//		int n = scanner.nextInt(); 
//		factorial(n);	
//		logger.info("factorial is end!!!!2");
//	}
}
