
public class Invertir {

	public static void main(String[] args) {
		System.out.println(pow(3,4));
		
		System.out.println(log(2,7));
		System.out.println(log(2,8));
		System.out.println(log(2,9));
			
		System.out.println(invertir(1203));
	}
	
	static int pow(int a, int N) {
		if (N == 0) return 1;
		return a*pow(a, N-1);
	}

	static int log(int a, int N) {
	    if (N < a) return 0;
	    return log(a, N/a) + 1 ;
	}
	
	static int invertir(int N){
		if (N < 10) return N;
		return  (N % 10) * pow(10, log(10,N)) + invertir(N/10);
	}
	
}

