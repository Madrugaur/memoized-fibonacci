import java.math.BigInteger;
import java.util.Base64;
import java.util.Hashtable;
import java.util.Scanner;

public class Driver {
	private Hashtable<Integer, BigInteger> memos;
	public static void main(String[] args) {
		new Driver();
	}
	public Driver() {
		memos = new Hashtable<Integer, BigInteger>();
		Scanner in = new Scanner(System.in);
		int i = 1;
		boolean running = true;
		while (running) {
			System.out.print(">");
			i = in.nextInt();
			if (i <= 0) running = false;
			else {
				for (int l = 1; l < i - 1; l++) {
					recFib(l);
				}
				System.out.println(recFib(i));	
			}
		}
	}
	private BigInteger recFib(int i) {
		if (i == 2) return new BigInteger("1");
		if (i == 1) return new BigInteger("1");
		if (memos.containsKey(i)) return memos.get(i);
		else {
			BigInteger val = recFib(i - 1).add(recFib(i - 2));
			memos.put(i, val);
			return val; 
		}
	}
}
