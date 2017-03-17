
public class RotacionCircular {

	public static void main(String[] args) {
		String r = "kerstic";
		String w = "sticker";
		System.out.println(esRotacionCircular(r, w));
	}
	
	public static boolean esRotacionCircular(String r, String w) {
		return (r.length() == w.length()) && ((w+w).indexOf(r) != -1);
	}

}
