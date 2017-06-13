import java.util.Arrays;
import java.util.Stack;

public class GrahamScan {
	public static Punto[] grahamScan(Punto[] P) {
	    int n = P.length;
		Stack<Punto> envoltura = new Stack<Punto>();
	    
	    Arrays.sort(P, Punto.ORDEN_Y);

        Arrays.sort(P, 1, n, P[0].ordenAngulo());

        envoltura.push(P[0]);

        // find index k1 of first point not equal to a[0]
        int k1;
        for (k1 = 1; k1 < n; k1++)
            if (!P[0].equals(P[k1])) break;
        if (k1 == n) return null;        // all points equal

        // find index k2 of first point not collinear with a[0] and a[k1]
        int k2;
        for (k2 = k1+1; k2 < n; k2++)
            if (Punto.ccw(P[0], P[k1], P[k2]) != 0) break;
        envoltura.push(P[k2-1]);    // a[k2-1] is second extreme point

        // Graham scan; note that a[n-1] is extreme point different from a[0]
        for (int i = k2; i < n; i++) {
            Punto top = envoltura.pop();
            while (Punto.ccw(envoltura.peek(), top, P[i]) <= 0) {
                top = envoltura.pop();
            }
            envoltura.push(top);
            envoltura.push(P[i]);
        }
        
        Punto[] E = new Punto[envoltura.size()];
        for (int i = 0; i< E.length; ++i) {
        	E[i] = envoltura.pop();
        }
        return E;
	}
	
	public static void printArray(Punto[] array){
		System.out.print("[");
		for(Punto p: array)
			System.out.print("(" + p.x + "," + p.y + "), ");
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		Punto[] pointCloud = new Punto[5];
		
		pointCloud[0] = new Punto(0,0);
		pointCloud[1] = new Punto(10,0);
		pointCloud[2] = new Punto(10,10);
		pointCloud[3] = new Punto(0,10);
		pointCloud[4] = new Punto(5,5);
		
		System.out.println("Point Cloud");
		printArray(pointCloud);
		
		Punto[] convexHull = grahamScan(pointCloud);
		
		System.out.println("Convex Hull");
		printArray(convexHull);

	}

}
