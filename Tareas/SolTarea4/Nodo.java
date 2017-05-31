
public class Nodo {
    String value;
    Nodo izq;
    Nodo der;
    
    public Nodo() {
      value = null;
      izq = null;
      der = null;
    }
    
    public Nodo(String s) {
      value = s;
      izq = null;
      der = null;
    }
    
    public Nodo(String s, Nodo izq, Nodo der) {
      value = s;
      this.izq = izq;
      this.der = der;
    }
}
