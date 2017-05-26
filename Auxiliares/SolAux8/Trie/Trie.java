public class Trie {

    public class Nodo{
        public char symbol;
        public Nodo hijo;
        public Nodo vecino;

        public Nodo(char symbol, Nodo hijo, Nodo vecino) {
            this.symbol = symbol;
            this.hijo = hijo;
            this.vecino = vecino;
        }
    }

    private Nodo raiz;

    public Trie(){
        raiz = new Nodo('\0',null,null);
    }

    public void insertar(String s){
        insertarInt(s+"$");
    }

    private void insertarInt(String s){
        Nodo padre = raiz;
        Nodo actual = raiz.hijo;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if(actual != null) {
                while (actual.vecino != null && actual.symbol != x) {
                    actual = actual.vecino;
                }
                if(actual.symbol == x){
                    padre = actual;
                    actual = actual.hijo;
                }
                else {
                    actual.vecino = new Nodo(x, null, null);
                    padre = actual.vecino;
                    actual = null;
                }
            }
            else {
                padre.hijo = new Nodo(x, null, null);
                padre = padre.hijo;
            }
        }
    }

    public boolean contiene(String s){
        return contieneInt(s+"$");
    }

    private boolean contieneInt(String s){
        Nodo actual = raiz.hijo;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            while(actual != null && actual.symbol != x){
                actual = actual.vecino;
            }
            if(actual == null) {
                return false;
            }
            else{
                actual = actual.hijo;
            }
        }
        return actual == null;
    }

    public void encontrarConPrefijo(String p){
        Nodo actual = raiz.hijo;
        for (int i = 0; i < p.length(); i++) {
            char x = p.charAt(i);
            while(actual != null && actual.symbol != x){
                actual = actual.vecino;
            }
            if(actual == null) {
                return;
            }
            else{
                actual = actual.hijo;
            }
        }
        imprimirNodos(p, actual);
    }

    private void imprimirNodos(String prefijo, Nodo actual) {
        if(actual != null && actual.symbol == '$'){
            System.out.println(prefijo);
        }
        else if(actual != null){
            imprimirNodos(prefijo, actual.vecino);
            imprimirNodos(prefijo + actual.symbol, actual.hijo);
        }
    }

    public static void main(String[] args) {
        System.out.println("\n ##### Parte A #####");
        Trie t = new Trie();
        t.insertar("casa");
        t.insertar("cama");
        t.insertar("chao");
        t.insertar("camion");
        t.insertar("cas");
        System.out.println(t.contiene("casa"));
        System.out.println(t.contiene("catan"));
        System.out.println(t.contiene("ca"));
        System.out.println(t.contiene("casado"));
        System.out.println(t.contiene("chao"));

        System.out.println("\n ##### Parte B ##### \n");
        t.encontrarConPrefijo("ca");
    }


}
