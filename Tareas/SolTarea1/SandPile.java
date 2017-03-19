
public class SandPile {

    private static final int N = 400;
    private static final int G = 100000;

    public static void main(String[] args) {
        int[][] mat = new int[N][N];
        mat[N/2][N/2] = G;
        long ti = System.currentTimeMillis();
        mat = gravity(mat);
        System.out.println("Calcular matriz toma: " + (System.currentTimeMillis() - ti) + "ms");
        Ventana v = new Ventana(600);
        ti = System.currentTimeMillis();
        v.mostrarMatriz(mat);
        System.out.println("Mostrar matriz toma:  " + (System.currentTimeMillis() - ti) + "ms");
    }

    private static int[][] gravity(int[][] mat) {
        boolean stable = false;
        while(!stable){
            stable = true;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if(mat[i][j] >= 4){
                        stable = false;
                        mat[i+1][j] += 1;
                        mat[i-1][j] += 1;
                        mat[i][j-1] += 1;
                        mat[i][j+1] += 1;
                        mat[i][j] -= 4;
                    }
                }
            }
        }
        return mat;
    }


}
