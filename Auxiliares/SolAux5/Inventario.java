
public class Inventario {

    static class Nodo{
        int val;
        Nodo sig;

        Nodo(int val, Nodo sig) {
            this.val = val;
            this.sig = sig;
        }
    }

    private static Nodo primero = new Nodo(0,null);

    private static int demanda(int t){
        return 5 - t + t*t/16;
    }

    static int inventario(int t){
        return nodoInventario(primero, t, 0).val;
    }

    private static Nodo nodoInventario(Nodo nodo, int t, int actual){
        if(actual == t){
            return nodo;
        }
        else if(nodo.sig == null){
            nodo.sig = new Nodo(Math.max(0, nodo.val + 20 - demanda(actual)), null);
        }
        return nodoInventario(nodo.sig, t, actual+1);
    }


    public static void main(String[] args) {
        int mes3 = inventario(3);
        System.out.println("Mes 3: " + mes3);

        int mes100 = inventario(100);
        System.out.println("Mes 100: " + mes100);

        int mes20 = inventario(20);
        System.out.println("Mes 20: " + mes20);

    }


}
