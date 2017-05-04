/**
 * Class Cola
 *
 * @author Michel Llorens [@michotastico]
 * @version 04-05-17.
 */
public class Cola {
    private class NodoCola{
        Nodo nodo;
        NodoCola sgte;

        public NodoCola(Nodo nodo){
            this.nodo = nodo;
        }
    }

    private NodoCola cabeza;
    private NodoCola cola;

    public Cola(){
        this.cabeza = this.cola = null;
    }

    public boolean estaVacia(){
        return this.cabeza == null;
    }

    public void encolar(Nodo nodo){
        if(nodo == null)
            return;

        NodoCola tmp = new NodoCola(nodo);

        if(this.estaVacia()){
            this.cabeza = tmp;
            this.cola = this.cabeza;
        }
        else{
            this.cola.sgte = tmp;
            this.cola = this.cola.sgte;
        }
    }

    public Nodo desencolar(){
        Nodo nodo = this.cabeza.nodo;
        this.cabeza = this.cabeza.sgte;
        return nodo;
    }
}
