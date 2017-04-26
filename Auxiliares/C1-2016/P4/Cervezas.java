package P4;

public class Cervezas {

    // Arreglo de ejemplo (primer elemento basura, para usar notacion 1-based)
    static int[] C = {-1, 100, 1, 2, 100, 3, 15, 21, 12, 8, 32, 42, 3, 4, 12, 33, 21, 1, 76, 87, 16, 4, 24, 3, 12, 4, 12, 33, 21, 1, 100, 1, 56, 4, 12, 33, 21, 1, 2, 120};

    static int tomarIneficiente(int n){
        if(n <= 1)
            return C[1]*n;
        else{
            int caso1 = tomarIneficiente(n-1);
            int caso2 = C[n] + tomarIneficiente(n-2);
            return Math.max(caso1, caso2);
        }
    }

    static int tomarEficiente(int n){
        // Tabulación
        int[] T = new int[n+1];
        T[0] = 0;
        T[1] = C[1];
        for (int i = 2; i <= n; i++) {
            int caso1 = T[i-1];
            int caso2 = C[i] + T[i-2];
            T[i] = Math.max(caso1, caso2);
        }
        return T[n];
    }


    public static void main(String[] args) {
        int N = C.length - 1;
        // Ineficiente
        long ti = System.currentTimeMillis();
        int res1 = tomarIneficiente(N);
        System.out.println("Lo máximo que se puede tomar es: " + res1);
        System.out.println("Ineficiente tarda " + (System.currentTimeMillis() - ti) + "ms");
        // Eficiente
        ti = System.currentTimeMillis();
        int res2 = tomarEficiente(N);
        System.out.println("Lo máximo que se puede tomar es: " + res2);
        System.out.println("Eficiente tarda " + (System.currentTimeMillis() - ti) + "ms");
    }

}
