
public class Merge3 {

  public static int[] merge3(int[] a, int[] b, int[] c) {
    
    int[] ans = new int[(a.length + b.length + c.length)];;
    int index = 0;
    int i = 0;
    int j = 0;
    int k = 0;
    int ai, bj, ck;
    int value = 0;
    
    while(i < a.length || j < b.length || k < c.length) {
      ai = get(a, i);
      bj = get(b, j);
      ck = get(c, k);
      
      value = min(ai, bj, ck);
      
      if(value == ai) {
        i++;
      } else if(value == bj) {
        j++;
      } else {
        k++;
      }
      
      ans[index] = value;
      index++;

    }
    
    return ans;
  }
  
  public static int get(int[] array, int index) {
    if(index < array.length) {
      return array[index];
    }
    return Integer.MAX_VALUE;
  }
  
  public static int min(int a, int b, int c) {
    if(a <= b && a <= c) {
      return a;
    }
    else if(b <= a && b <= c) {
      return b;
    }
    
    return c;
  }
  
  public static void main(String[] args) {
    int a[] = {1, 4, 7, 10};
    int b[] = {2, 5, 8, 11, 14};
    int c[] = {3, 6, 9, 12, 13, 15};
    
    int ans[] = merge3(a, b, c);
    
    for(int i = 0; i < ans.length; i++) {
      System.out.print(ans[i] + " ");
    }
  }

}
