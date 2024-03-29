
public class FuerzaBrutaMejorada {
  
  public static int maxSuma(int[] secuencia) {
    int max = 0;
    for(int i = 0; i < secuencia.length; i++) {
      int sumaInterna = 0;
      for(int j = i; j < secuencia.length; j++) {
        sumaInterna = sumaInterna + secuencia[j];
        if (max < sumaInterna) {
          max = sumaInterna;
        }
      }
    }
    
    return max;
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    
     int[] a = {-2, 11, -4, 13, -5, -2, -15, -2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15, -2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,
							-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15,-2, 11, -4, 13, -5, -2, -15};

    System.out.println(maxSuma(a));
    
    long endTime   = System.currentTimeMillis();
    long totalTime = endTime - startTime;
    System.out.println(totalTime);

  }
}
