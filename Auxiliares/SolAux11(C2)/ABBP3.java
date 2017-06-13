/**
 * Created by sergio on 6/13/17.
 */
public class ABBP3 {

    public static class Nodo{
        Nodo izq, der;
        int val;
        public Nodo(Nodo izq, Nodo der, int val) {
            this.izq = izq;
            this.der = der;
            this.val = val;
        }
    }

    static Nodo subarbolMenor(Nodo raiz, int x){
        if(raiz == null){
            return null;
        }
        else if(raiz.val < x){
            return new Nodo(raiz.izq, subarbolMenor(raiz.der, x), raiz.val);
        }
        else{
            return subarbolMenor(raiz.izq, x);
        }
    }

    static Nodo subarbolMayor(Nodo raiz, int x){
        if(raiz == null){
            return null;
        }
        else if(raiz.val > x){
            return new Nodo(subarbolMayor(raiz.izq, x), raiz.der, raiz.val);
        }
        else{
            return subarbolMayor(raiz.der, x);
        }
    }

    public static Nodo insertarEnRaiz(Nodo abb, int x){
        Nodo sizq = subarbolMenor(abb, x);
        Nodo sder = subarbolMayor(abb, x);
        return new Nodo(sizq, sder, x);
    }

    public static void printTree(Nodo x, String spacing){
        if(x == null) return;
        printTree(x.izq, spacing + "   ");
        System.out.println(spacing + x.val);
        printTree(x.der, spacing + "   ");
    }

    public static void main(String[] args) {
        Nodo t = null;
        int[] vals = {6,9,3,4,1,2,5};
        for(int i : vals){
            t = insertarEnRaiz(t, i);
            printTree(t,"");
            System.out.println("---------------------");
        }
    }

}
