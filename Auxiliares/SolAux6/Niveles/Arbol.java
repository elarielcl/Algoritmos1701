/**
 * Class Arbol
 *
 * @author Michel Llorens [@michotastico]
 * @version 21-04-2017.
 */
public class Arbol {

    private Nodo raiz;

    public Arbol(int valorInicial){
        this.raiz = new Nodo(valorInicial);
    }

    public void agregar(int valor){
        Nodo nuevoNodo = new Nodo(valor);
        Nodo puntero = this.raiz;

        while(true){
            if(puntero.valor < valor){
                if(puntero.derecha != null)
                    puntero = puntero.derecha;
                else {
                    puntero.derecha = nuevoNodo;
                    break;
                }
            }
            else{
                if(puntero.izquierda != null)
                    puntero = puntero.izquierda;
                else{
                    puntero.izquierda = nuevoNodo;
                    break;
                }
            }
        }
    }

    public Nodo getRaiz(){
        return this.raiz;
    }
}
