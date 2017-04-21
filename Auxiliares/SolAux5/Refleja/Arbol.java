/**
 * Class Arbol
 *
 * @author Michel Llorens [@michotastico]
 * @version 21-04-2017.
 */
public class Arbol {

    private class Nodo{
        int valor;
        Nodo izquierda;
        Nodo derecha;

        public Nodo(int valor){
            this.valor = valor;
        }
    }

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

    public void reflejar(){
        reflejar(this.raiz);
    }

    private void reflejar(Nodo nodo){
        if(nodo == null)
            return;

        Nodo temporal = nodo.izquierda;
        nodo.izquierda = nodo.derecha;
        nodo.derecha = temporal;

        reflejar(nodo.izquierda);
        reflejar(nodo.derecha);

    }

    public boolean sonIguales(Arbol arbol){
        return comparar(this.raiz, arbol.raiz);
    }

    private boolean comparar(Nodo propio, Nodo externo){
        if((propio != null && externo == null) || (propio == null && externo != null))
            return false;

        if(propio == null && externo == null){
            return true;
        }
        if(propio.valor != externo.valor)
            return false;

        boolean primeraComparacion;
        boolean segundaComparacion;

        primeraComparacion = comparar(propio.izquierda, externo.izquierda) &&
                comparar(propio.derecha, externo.derecha);

        segundaComparacion = comparar(propio.izquierda, externo.derecha) &&
                comparar(propio.derecha, externo.izquierda);

        return primeraComparacion || segundaComparacion;
    }
}
