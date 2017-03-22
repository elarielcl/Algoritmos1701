
public class Misterio {

	public static void main(String[] args) {
		/*
		int N = 4;
		
		
		int f = 0;
		int g = 1;
		for (int i = 0; i <= N; i++) {
			f = f + g;
			g = f - g;
		}
		System.out.println(f);
		*/
		System.out.println(misterio1(1));
	}
	
	
	public static int misterio1(int N) {
		int f = 0;
		int g = 1;
		for (int i = 1; i <= N; i++) {
			f = f + g;
			g = f - g;
		}
		return f;
	}
	
	
	public static int misterio2(int N) {
		if (N <= 1) {
			return N;
		}
		return misterio2(N-1) + misterio2(N-2);
	}
	
	public static int misterio3(int N) {
		int f1 = 0;
		int f2 = 1;
		for (int i = 1; i <= N; i++) {
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f1;
	}
	

}

