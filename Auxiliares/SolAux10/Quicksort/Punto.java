import java.util.Comparator;

public class Punto {
	public int x;
	public int y;
	public Punto(int x, int y){
		this.x = x;
		this.y = y;
	}
	
    public static final Comparator<Punto> ORDEN_Y = new OrdenY();

	private static class OrdenY implements Comparator<Punto> {
		public int compare(Punto p, Punto q) {
            if (p.y < q.y) return -1;
            if (p.y > q.y) return +1;
            return 0;
        }
    }
	
	 public Comparator<Punto> ordenAngulo() {
	        return new OrdenAngulo();
	 }
	
	private class OrdenAngulo implements Comparator<Punto> {
        
		public int compare(Punto q1, Punto q2) {
            int dx1 = q1.x - x;
            int dy1 = q1.y - y;
            int dx2 = q2.x - x;
            int dy2 = q2.y - y;

            if      (dy1 >= 0 && dy2 < 0) return -1;    
            else if (dy2 >= 0 && dy1 < 0) return +1;    
            else if (dy1 == 0 && dy2 == 0) {            
                if      (dx1 >= 0 && dx2 < 0) return -1;
                else if (dx2 >= 0 && dx1 < 0) return +1;
                else                          return  0;
            }
            else return -ccw(Punto.this, q1, q2);
        }
    }
	
	public static int ccw(Punto a, Punto b, Punto c) {
        double area2 = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
        if      (area2 < 0) return -1;
        else if (area2 > 0) return +1;
        else                return  0;
    }
}
