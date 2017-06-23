public class Internet{

    static int[][] G = new int[][]{
            {0,0,12,0,0,10,12,11,0,10},
            {0,0,0,0,0,13,9,10,0,13},
            {12,0,0,0,10,0,0,10,14,11},
            {0,0,0,0,11,15,9,11,0,0},
            {0,0,10,11,0,10,12,11,10,9},
            {10,13,0,15,10,0,11,13,11,0},
            {12,9,0,9,12,11,0,10,9,15},
            {11,10,10,11,11,13,10,0,9,0},
            {0,0,14,0,10,11,9,9,0,0},
            {10,13,11,0,9,0,15,0,0,0}
    };

    static int[][] P = new int[][]{
            {0,0,2,0,0,1,1,3,0,2},
            {0,0,0,0,0,1,2,2,0,1},
            {2,0,3,0,1,0,0,1,1,1},
            {0,0,0,0,1,2,2,2,0,0},
            {0,0,1,1,1,2,2,2,2,2},
            {1,1,0,2,2,0,2,1,1,0},
            {1,2,0,2,2,2,0,3,3,1},
            {3,2,1,2,2,1,3,0,2,0},
            {0,0,1,0,2,1,3,2,0,0},
            {2,1,1,0,2,0,1,0,0,0}
    };

    static int[][] floyd(int[][] G){
        int n = G.length;
        int[][] C = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(G[i][j] != 0)
                    C[i][j] = G[i][j];
                else if(i == j)
                    C[i][j] = 0;
                else
                    C[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(C[i][k] != Integer.MAX_VALUE && C[k][j] != Integer.MAX_VALUE)
                        C[i][j] = Math.min(C[i][j], C[i][k] + C[k][j]);
                }
            }
        }

        return C;
    }

    // Implementacion ineficiente de dijkstra (solo para probar)
    static int[] dijkstra(int[][] G, int src){
        int n = G.length;
        int[] dist = new int[n];

        boolean[] visitado = new boolean[n];

        for (int i = 0; i < n; i++){
            dist[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }

        dist[src] = 0;

        for (int i = 0; i < n; i++){
            int u = -1;
            int d = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(!visitado[j] && dist[j] < d){
                    d = dist[j];
                    u = j;
                }
            }

            visitado[u] = true;

            for (int j = 0; j < n; j++) {
                if (!visitado[j] && G[u][j]!=0 && dist[u] != Integer.MAX_VALUE)
                    dist[j] = Math.min(dist[j], dist[u] + G[u][j]);
            }

        }

        return dist;
    }

    // Usando floyd
    static int host(int[] amigos){
        int[][] C = floyd(G);
        int s = Integer.MAX_VALUE;
        int hostAmigo = 0;
        for (int i = 0; i < amigos.length; i++) {
            int p = 0;
            for (int j = 0; j < amigos.length; j++)
                p += C[amigos[i]][amigos[j]];
            if(p < s){
                s = p;
                hostAmigo = amigos[i];
            }
        }
        return hostAmigo;
    }

    //Usando dijkstra
    static int host2(int[] amigos){
        int s = Integer.MAX_VALUE;
        int hostAmigo = 0;
        for (int i = 0; i < amigos.length; i++) {
            int[] dist = dijkstra(G, amigos[i]);
            int p = 0;
            for (int j = 0; j < amigos.length; j++)
                p += dist[amigos[j]];
            if(p < s){
                s = p;
                hostAmigo = amigos[i];
            }
        }
        return hostAmigo;
    }

    static int proovedor(int i, int j){
        int s = Integer.MAX_VALUE;
        int p = 1;
        int n = G.length;
        for (int k = 1; k <= 3; k++) {
            int[][] nuevoCosto = new int[n][n];
            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if(P[y][x] == k)
                        nuevoCosto[y][x] = G[y][x];
                    else
                        nuevoCosto[y][x] = 2*G[y][x];
                }
            }
            int[] dist = dijkstra(nuevoCosto, i);
            if(dist[j] < s){
                p = k;
                s = dist[j];
            }
        }
        return p;
    }

    public static void main(String[] args) {
        int[] amigos = new int[]{3,2,7};
        System.out.println(host(amigos));
        System.out.println(host2(amigos));

        System.out.println(proovedor(5,8));
        System.out.println(proovedor(6,4));
    }

}