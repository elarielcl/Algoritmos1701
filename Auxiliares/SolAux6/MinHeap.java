public class MinHeap {
   private int[] heap;
   private int n;
   
   public MinHeap(int n) {
       heap = new int[n + 1];
       n = 0;
   }

  public boolean estaVacio() {
       return n == 0;
   }

   public int tamano() {
       return n;
   }

   public int min() {
       return heap[1];
   }

  
   public void insertar(int k) {
       heap[++n] = k;
       sumergir(n);
   }

   public int extraerMinimo() {
       intercambiar(1, n);
       int min = heap[n--];
       hundir(1);
       return min;
   }


   private void sumergir(int k) {
       while (k > 1 && heap[k/2] > heap[k]) {
           intercambiar(k, k/2);
           k = k/2;
       }
   }

   private void hundir(int k) {
       while (2*k <= n) {
           int j = 2*k;
           if (j < n && heap[j] > heap[j+1]) j++;
           if (heap[k] <= heap[j]) break;
           intercambiar(k, j);
           k = j;
       }
   }

  private void intercambiar(int i, int j) {
       int t = heap[i];
       heap[i] = heap[j];
       heap[j] = t;
   }

   
   public static void main(String[] args) {
       MinHeap mh = new MinHeap(10);
       int[] elements = {1,4,2,9,8,7,0,3};
       for (int element: elements) {
    	   mh.insertar(element);
       }
       
       while (!mh.estaVacio()) {
    	   System.out.println(mh.extraerMinimo());
       }
   }

}
