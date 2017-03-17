
public class Ordenar3 {

	public static void main(String[] args) {
		int a = 3;
		int b = 7;
		int c = 1;
		
		//////////////////////
		int t; //Variable temporal
		
		if (a > b) { t = a; a = b; b = t; }
		if (a > c) { t = a; a = c; c = t; }
		if (b > c) { t = b; b = c; c = t; }
		///////////////////////
		
		System.out.println("El menor es: " + a);
		System.out.println("El del medio es: " + b);
		System.out.println("El mayor es: " + c);
	}

}
