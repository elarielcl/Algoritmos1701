
public class Lineal {

  public static int maxSuma(int[] secuencia) {
    int ssm = 0;
    int sp = 0;

    for(int j = 0; j < secuencia.length; j++) {
      sp = sp + secuencia[j];
      if(ssm < sp) {
        ssm = sp;
      } else if(sp < 0) {
        sp = 0;
      }
    }
    return ssm;
  }

  public static void main(String[] args) {
    long startTime = System.nanoTime();
    
    int[] a = {-2, 11, -4, 13, -5, -2};
    System.out.println(maxSuma(a));
    
    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println(totalTime);

  }

}
