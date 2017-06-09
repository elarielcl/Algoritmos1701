public class QuicksortExample {
  
  public static int randomPivot(int largo, int izq, int der) {
    return izq + ((int) Math.random() * (largo)) / (der - izq + 1);
  }
  
  public static int medianaPivot(Pedido pedidos[], int izq, int der) {
    int med = (izq + der) / 2;
    
    if(pedidos[izq].nOrden <= pedidos[med].nOrden) {
      if(pedidos[der].nOrden <= pedidos[izq].nOrden) { //izq < med y der < izq
        return izq;
      } else { //izq < med y izq < der
        return (pedidos[med].nOrden <= pedidos[der].nOrden) ? med : der;
      }
    } else {
      if(pedidos[der].nOrden <= pedidos[med].nOrden) { //med < izq y der < med
        return med;
      } else { //med < izq y med < der
        return (pedidos[izq].nOrden <= pedidos[der].nOrden) ? izq : der;
      }
    }
  }



  public static void quicksort(Pedido pedidos[], int izq, int der) {
    
    //int pIndex = randomPivot(pedidos.length, izq, der);
    int pIndex = medianaPivot(pedidos, izq, der);
    
    Pedido pivote = pedidos[pIndex];

    int i = izq;
    int j = der;

    swap(pedidos, izq, pIndex);

    while (i < j) {
       while(pedidos[i].nOrden <= pivote.nOrden && i < j) i++;
       
       while(pivote.nOrden < pedidos[j].nOrden) j--;         
       
       if (i < j) {                                            
           swap(pedidos,i,j);
       }
     }
    
     swap(pedidos,j,izq);
     
     if(izq < j - 1)
        quicksort(pedidos, izq, j - 1);
     
     if(j + 1 < der)
        quicksort(pedidos, j + 1, der);
  }

    private static void swap(Pedido[] pedidos, int i, int j) {
        Pedido aux = pedidos[i];
        pedidos[i] = pedidos[j];
        pedidos[j] = aux;
    }

    public static void main(String[] args) {
    Pedido a = new Pedido(1, "Italiana", "Beauchef 850");
    Pedido b = new Pedido(12, "Pina", "Beauchef 851");
    Pedido c = new Pedido(4, "Napolitana", "Providencia 1134");
    Pedido d = new Pedido(54, "Tres carnes", "Av. Matta 201");
    Pedido e = new Pedido(2, "Tres quesos", "Santa Isabel 399");
    Pedido f = new Pedido(3, "Hawaiana", "Marin 30");
    Pedido g = new Pedido(6, "Vegetariana", "Nevada 25");
    Pedido h = new Pedido(10, "Completa", "Alameda 50");
    
    Pedido pedidos[] = {a, b, c, d, e, f, g, h};
    for(int i = 0; i < pedidos.length; i++) {
      System.out.print(pedidos[i].nOrden + " ");
    }
    System.out.println("");
    
    quicksort(pedidos, 0, pedidos.length - 1);
    
    for(int i = 0; i < pedidos.length; i++) {
      System.out.print(pedidos[i].nOrden + " ");
    }
  }

}
