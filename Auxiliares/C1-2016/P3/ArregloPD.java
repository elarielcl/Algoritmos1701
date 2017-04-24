public class ArregloPD {
  
  NodoPD primerElemento;
  
  //Crea una lista solo con la cabeza de lista
  ArregloPD() {
    this.primerElemento = new NodoPD(0, 0, null);
  }
  
  //Retorna el valor del elemento de índice k
  public double get(int k) {
    NodoPD actual = this.primerElemento;
    
    while(actual != null) {
      
      if(actual.indice == k) {
        return actual.info;
      }
      
      actual = actual.sgte;
    }
    
    return 0;
  }
  
  //Le asigna el valor x al elemento de indice k
  public void set(int k, double x) {
    if(x == 0 || this.get(k) == x) {
      return;
    }
    
    if(this.get(k) == 0) {
      NodoPD nuevo = new NodoPD(k, x, this.primerElemento.sgte);
      this.primerElemento.sgte = nuevo;
    }
    
    NodoPD actual = this.primerElemento;
    while(actual.indice != k) {
      actual = actual.sgte;
    }
    
    actual.info = x;
  }
  
  public void show() {
    NodoPD actual = this.primerElemento;
    while(actual != null) {
      System.out.println("Indice: " + actual.indice + " Info:" + actual.info);
      actual = actual.sgte;
    }
  }

  public static void main(String[] args) {
    //Creamos un APD
    ArregloPD apd = new ArregloPD();
    apd.set(100, 90);
    apd.set(200, 100);
    apd.set(2, 2);
    apd.show();
    
    //Obtenemos algunas infos con los indices
    System.out.println();
    System.out.println(apd.get(300));
    System.out.println(apd.get(2));
    System.out.println(apd.get(200));
    
    //Cambiamos algunos de sus valores
    System.out.println();
    apd.set(200, 2);
    apd.set(100, 55);
    apd.show();
    

    
  }


}
