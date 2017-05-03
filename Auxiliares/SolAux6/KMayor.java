
public class KMayor {
	static int mayores;
	
	static public boolean mayor(int[] minHeap, int k, int x) {
		mayores = 0;
		mayorRecursivo(minHeap, k, x, 1);
		return mayores >= k;
	}
	
	static void mayorRecursivo(int[] minHeap, int k, int x, int i) {
		if (i >= minHeap.length) return;
		if (x> minHeap[i]) {
			++mayores;
			if (mayores == k) return;
			mayorRecursivo(minHeap, k, x, 2*i);
			mayorRecursivo(minHeap, k, x, 2*i+1);
		}
	}
	public static void main(String[] args) {
		int[] minHeap = {0,10,14,19,26,31,42,27,44,35,33};
		System.out.println(mayor(minHeap, 3, 19));
	}

}
