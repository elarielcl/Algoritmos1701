public class InsertionSort {

	//Parte a -> 10 comparaciones [1 + 2 + 3 + 4]

	//Parte b -> 5 comparaciones [O(n) mejor caso]

	public static void showArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
		}
		System.out.println();
	}

	public static void insertionSort(int[] a) {
		showArray(a);
		//Invariante a[i] < a[i+1] con i=0 hasta k-2
		for(int k = 0; k < a.length; k++) {
			for(int j = k; 0 < j && a[j] < a[j-1]; j--) {
				int t = a[j];
				a[j] = a[j-1];
				a[j-1] = t;
			}
		}
		showArray(a);
	}

	public static void insertionSortTwo(int[] a) {
		showArray(a);
		//Invariante a[i] < a[i+1] con i=0 hasta k-2
		for(int k = 0; k < a.length; k++) {
			int t = a[k];
			int j;
			for(j = k; 0 < j && t < a[j - 1]; j--) {
				a[j] = a[j-1];
			}
			a[j] = t;
		}
		showArray(a);
	}


	public static void main (String[] args) {
		int[] a = new int[] {5,4,3,2,1};
		insertionSort(a);
		
		int[] b = new int[] {5,4,3,2,1};
		insertionSortTwo(b);
	}
}