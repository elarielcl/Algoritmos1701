import java.util.Random;

/**
 * Class Niveles
 *
 * @author Michel Llorens [@michotastico]
 * @version 04-05-17.
 */
public class Niveles {

    private static Nodo getArbol(){
        Random random = new Random();
        int raiz = 50;
        int[] values = new int[10];
        for(int i = 0; i < 10; i++){
            values[i] = random.nextInt(100);
        }

        Arbol arbol = new Arbol(raiz);
        for(int value : values)
            arbol.agregar(value);

        return arbol.getRaiz();
    }

    public static void imprimirNiveles(Nodo raiz){
        Cola cola = new Cola();
        cola.encolar(raiz);

        Nodo nodoActual;
        while(!cola.estaVacia()){
            nodoActual = cola.desencolar();
            System.out.println(nodoActual.valor);
            cola.encolar(nodoActual.izquierda);
            cola.encolar(nodoActual.derecha);
        }
    }

    public static void main(String[] args){
        Nodo arbol = getArbol();
        imprimirNiveles(arbol);
    }
}
