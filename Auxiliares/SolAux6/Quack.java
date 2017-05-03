public class Quack 
{
    private Node primero, ultimo;
    private int tamano;
    private class Node
    {
        Object item;
        Node sgte;
    }
    
   public Quack()                  
   {
       primero = null;
       ultimo = null;
       tamano = 0;
   }
   
   public boolean estaVacia()        
   {
       return tamano == 0;
   }
   
   public int tamano()               
   {
       return tamano;
   }
   
   public void push(Object item) 
   {
       if (estaVacia())
       {
           primero = new Node();
           primero.item = item;
           primero.sgte = null;
           ultimo = primero;
       }
       
       else
       {
           Node anteriorPrimero = primero;
           primero = new Node();
           primero.item = item;
           primero.sgte = anteriorPrimero;
       }
        
       ++tamano;
       
   }
   
   public void encolar(Object item)  
   {
       if (estaVacia())
       {
           primero = new Node();
           primero.item = item;
           primero.sgte = null;
           ultimo = primero;
       }
       
       else
       {
           Node anteriorUltimo = ultimo;
           ultimo = new Node();
           ultimo.item = item;
           ultimo.sgte = null;
           anteriorUltimo.sgte = ultimo;
       }
       
       ++tamano;
   }
   
   public Object pop()       
   {
       if (estaVacia())
       {
           throw new java.util.NoSuchElementException();
       }
      
       Object r = primero.item;
       if (tamano == 1)
       {
           primero = null;
           ultimo = null;
       }   
       
       else
       {
           primero = primero.sgte;
       }
       
       --tamano;
       return r;
       
   }
   
   
   public static void main(String[] args)
   {
	   String[] ejemplos = {"Hola", "Como estas", "Bien y tu", "Adios"};
	   Quack pila = new Quack();
	   Quack cola = new Quack();
	   System.out.println(pila.estaVacia());
	   
	   for (String ejemplo : ejemplos) {
		   pila.push(ejemplo);
		   cola.encolar(ejemplo);
	   }
	   
	   while (!pila.estaVacia()) {
		   System.out.println(pila.pop());
	   }
	   
	   System.out.println(cola.tamano());
	   while (!cola.estaVacia()) {
		   System.out.println(cola.pop());
	   }
   }
   
}
