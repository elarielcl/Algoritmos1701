import java.util.Stack;

public class T4 {
  
  private Nodo arbol;
  private Stack<Nodo> pila;
  private String ultimaExpresion;
  
  public T4(){
    arbol = new Nodo();
    pila = new Stack<Nodo>();
  }
    
  public static Nodo clonar(Nodo a){
    if(a == null){
      return null;
    }
    return new Nodo(a.value, clonar(a.izq), clonar(a.der));
  }  
  
  public void crearArbolExpresion(String expr) {
    String[] partes = expr.split(" ");
    for(int i = 0; i < partes.length; i++) {
      String actual = partes[i];
      Nodo n;
      if(actual.equals("+") || actual.equals("-") ||
         actual.equals("/") || actual.equals("*")) {
        Nodo izq = pila.pop();
        Nodo der = pila.pop();
        n = new Nodo(actual, izq, der);
      } else {
      n = new Nodo(actual);
      }
      pila.push(n);
    }
    
    arbol = pila.pop();
  }
  
  public Nodo derivar(Nodo arbol, String var) {
    if(arbol.value.equals("+") || arbol.value.equals("-")) {
      arbol = derivarSumaResta(arbol, var);
    } else if (arbol.value.equals("*")) {
      arbol = derivarMult(arbol, var);
    } else if (arbol.value.equals("/")) {
      arbol = derivarDivision(arbol, var);
    } else {
      if(arbol.value.equals(var)) {
        arbol.value = "1";
      } else {
        arbol.value = "0";
      }
    }
    
    return arbol;
  }
  
  //Se supone que el entregado nodo es una suma
  public Nodo derivarSumaResta(Nodo arbol, String var) {
    return new Nodo(arbol.value, derivar(arbol.izq, var), derivar(arbol.der, var));
  }
  
  //Se supone que el entregado nodo es una multiplicacion
  public Nodo derivarMult(Nodo arbol, String var) {
    Nodo izqClonado = clonar(arbol.izq);
    Nodo derClonado = clonar(arbol.der);
    Nodo der = new Nodo("*", derivar(arbol.izq, var), arbol.der);
    Nodo izq = new Nodo("*", izqClonado, derivar(derClonado, var));
    Nodo n = new Nodo("+", der, izq);
    return n;
  }
  
  //Se supone que el entregado nodo es una division
  public Nodo derivarDivision(Nodo arbol, String var) {
    Nodo izqClonado = clonar(arbol.izq);
    Nodo derClonado = clonar(arbol.der);
    Nodo der = new Nodo("*", derivar(arbol.izq, var), arbol.der);
    Nodo izq = new Nodo("*", izqClonado, derivar(derClonado, var));
    Nodo numerador = new Nodo("-", der, izq);
    
    Nodo denominador = new Nodo("*", izqClonado, izqClonado);
    
    return new Nodo("/", denominador, numerador);
  }

  public Nodo simplificar(Nodo arbol) {
    if(arbol == null) return arbol;
    
    if(arbol.value.equals("+")) {
      if(arbol.izq.value.equals("0")) {
        arbol = arbol.der;
      } else if (arbol.der.value.equals("0")) {
        arbol = arbol.izq;
      }
    }
    else if (arbol.value.equals("*")) {
        if(arbol.izq.value.equals("0") || arbol.der.value.equals("0")) {
          arbol = new Nodo("0", null, null);
        } else if(arbol.izq.value.equals("1")) {
          arbol = arbol.der;
        } else if(arbol.der.value.equals("1")) {
          arbol = arbol.izq;
        }
      }
    else if (arbol.value.equals("-")) {
      if(arbol.izq.value.equals("0"))
        arbol = arbol.der;
    } else if (arbol.value.equals("/")) {
      if(arbol.der.value.equals("0")) 
        arbol = new Nodo("0", null, null);

    }
    
    return new Nodo(arbol.value, simplificar(arbol.izq), simplificar(arbol.der));
  }
  
  public Nodo iterarSimplificaciones(Nodo arbol) {
    String actual = "";
    while(!actual.equals(ultimaExpresion)) {
      ultimaExpresion = nodoToString(arbol);
      arbol = simplificar(arbol);
      actual = nodoToString(arbol);
    }
    
    return arbol;
  }
  
  public boolean esNum(Nodo nodo) {
    return !(nodo.value.equals("+") || nodo.value.equals("-") ||
             nodo.value.equals("/") || nodo.value.equals("*"));
  }
  
  public String nodoToString(Nodo node) {
  
    if(node == null)
     return "";
        
    if(node.izq == null && node.der == null) {
      return node.value;
    }
    
    return "(" + nodoToString(node.der) + " " + node.value + " " + nodoToString(node.izq) + ")";
    
  }

  public String nodoToStringPulido(Nodo nodo) {
    
    if(nodo == null)
     return "";
        
    if(nodo.izq == null && nodo.der == null) {
      return nodo.value;
    }
    
    if(nodo.value.equals("+")) 
    {
      return nodoToStringPulido(nodo.der) + " " + 
          nodo.value + " " + 
          nodoToStringPulido(nodo.izq);    
    } 
    else if(nodo.value.equals("-")) 
    {
      if(nodo.der.value.equals("0"))
        return "(" + nodoToStringPulido(nodo.der) + " " +
        nodo.value + " " +
        nodoToStringPulido(nodo.izq) + ")";
      else
        return nodoToStringPulido(nodo.der) + " " + 
          nodo.value + " " + 
          nodoToStringPulido(nodo.izq);    
    } 
    else if (nodo.value.equals("*") || nodo.value.equals("/") ) {
      if(esNum(nodo.izq) && esNum(nodo.der)) {
        return nodoToStringPulido(nodo.der) + " " + 
               nodo.value + " " + 
               nodoToStringPulido(nodo.izq);
      } 
      else if(esNum(nodo.der)) {
        if(nodo.izq.value.equals("*") || nodo.izq.value.equals("/"))
          return nodoToStringPulido(nodo.der) + " " + 
          nodo.value + " " + 
          nodoToStringPulido(nodo.izq);
        else
          return nodoToStringPulido(nodo.der) + " " + 
            nodo.value + " (" + 
            nodoToStringPulido(nodo.izq) + ")";
      } 
      else if(esNum(nodo.izq)) {
        if(nodo.der.value.equals("*") || nodo.der.value.equals("/"))
          return nodoToStringPulido(nodo.der) + " " + 
          nodo.value + " " + 
          nodoToStringPulido(nodo.izq);
        else
          return nodoToStringPulido(nodo.der) + " " + 
            nodo.value + " (" + 
            nodoToStringPulido(nodo.izq) + ")";
      } 
      else if(nodo.der.value.equals("*") || nodo.der.value.equals("/"))
        return nodoToStringPulido(nodo.der) + " " + 
        nodo.value + " " + 
        nodoToStringPulido(nodo.izq);
      
      else {
        return nodoToStringPulido(nodo.der)  + " " +
            nodo.value + " " +
            nodoToStringPulido(nodo.izq);
      }
    } else {
      return arbol.value;
    }    
  }
  
  public void printLeafNodes(Nodo nodo) {
    System.out.println(nodoToString(nodo));
  }
  
  public void printLeafNodesPulido(Nodo nodo) {
    System.out.println(nodoToStringPulido(nodo));
  }
  
  public void calcular(String expr, String var) {
    
    //t.crearArbolExpresion("2 x 3 + - y x - +");
    //t.crearArbolExpresion("2 x 3 / *");
    
    crearArbolExpresion(expr);
    printLeafNodes(arbol);
    arbol = derivar(arbol, var);
    arbol = iterarSimplificaciones(arbol);
    printLeafNodes(arbol);
    System.out.println();
  }
  
  public void calcularPulido(String expr, String var) {
    
    //t.crearArbolExpresion("2 x 3 + - y x - +");
    //t.crearArbolExpresion("2 x 3 / *");
    
    crearArbolExpresion(expr);
    printLeafNodesPulido(arbol);
    arbol = derivar(arbol, var);
    arbol = iterarSimplificaciones(arbol);
    printLeafNodesPulido(arbol);
    System.out.println();
  }
  
  public static void main(String[] args) {
    T4 t = new T4();
    //2 * (x / 3) + (y - x) == 2 x 3 / * y x - +
    //t.calcular("2 x 3 / * y x - +", "y");
    //t.calcularPulido("2 x 3 / * y x - +", "x");
    //t.calcularPulido("2 x + 3 * 5 /", "x");
    //t.calcularPulido("x y / 5 /", "x");
    //t.calcularPulido(" 2 y + 3 + 5 /", "x");
    //t.calcularPulido("x y / 5 /", "x");
    t.calcularPulido("3 2 + x y + /", "y");

  }
}
