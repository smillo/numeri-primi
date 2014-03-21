import java.io.Serializable;


public class PrimeNumber implements Task<Integer>, Serializable {
	
	private long num;
	
	public PrimeNumber(long n){
		num=n;
	}
	public long execute() {
		return SecondoPrimo(num);
	}

	static boolean isPrime(long num2) {
		
		// check if n is a multiple of 2
		if (num2%2 == 0)
			return false;
		// if not , then just check the odds
		for (int i = 3; i * i <= num2; i += 2) {
			if (num2 % i == 0)
				return false;
		}
		return true;
	}
	public static long SecondoPrimo(long n){
		if(isPrime(n)) return n;
		if(n%2==0) n++;
		else n=n+2;
		while(!isPrime(n)){
			n=n+2;}
		return n;
	}

}
