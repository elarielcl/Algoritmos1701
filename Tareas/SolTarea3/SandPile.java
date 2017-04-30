import java.util.Stack;

public class SandPile {

    private static final int N = 400;
    private static final int G = 100000;

    public static void main(String[] args) {
        int[][] mat = new int[N][N];
        mat[N/2][N/2] = G;
        long ti = System.currentTimeMillis();
        mat = gravity2(mat);
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
                        mat[i][j-1] += 1;
                        mat[i][j+1] += 1;
                        mat[i+1][j] += 1;
                        mat[i-1][j] += 1;
                        mat[i][j] -= 4;
                    }
                }
            }
        }
        return mat;
    }

    private static int[][] gravity2(int[][] mat) {
        Stack<int[]> pila = new Stack<>();
        pila.push(new int[]{N / 2, N / 2});

        while(!pila.empty()){
            int[] coords = pila.pop();
            int i = coords[0];
            int j = coords[1];

            mat[i][j-1] += 1;
            if(mat[i][j-1] == 4)
                pila.push(new int[]{i, j-1});

            mat[i][j+1] += 1;
            if(mat[i][j+1] == 4)
                pila.push(new int[]{i, j+1});

            mat[i+1][j] += 1;
            if(mat[i+1][j] == 4)
                pila.push(new int[]{i+1, j});

            mat[i-1][j] += 1;
            if(mat[i-1][j] == 4)
                pila.push(new int[]{i-1, j});

            mat[i][j] -= 4;
            if(mat[i][j] >= 4)
                pila.push(new int[]{i, j});
        }

        return mat;
    }

    private static int[][] gravity3(int[][] mat) {
        Stack<int[]> pila = new Stack<>();
        pila.push(new int[]{N / 2, N / 2});

        while(!pila.empty()){
            int[] coords = pila.pop();
            int i = coords[0];
            int j = coords[1];

            int r = mat[i][j] % 4;
            int k = mat[i][j] / 4;

            mat[i][j-1] += k;
            if(mat[i][j-1] >= 4 && mat[i][j-1] - k < 4)
                pila.push(new int[]{i, j-1});

            mat[i][j+1] += k;
            if(mat[i][j+1] >= 4 && mat[i][j+1] - k < 4)
                pila.push(new int[]{i, j+1});

            mat[i+1][j] += k;
            if(mat[i+1][j] >= 4 && mat[i+1][j] - k < 4)
                pila.push(new int[]{i+1, j});

            mat[i-1][j] += k;
            if(mat[i-1][j] >= 4 && mat[i-1][j] - k < 4)
                pila.push(new int[]{i-1, j});

            mat[i][j] = r;
        }

        return mat;
    }


}
