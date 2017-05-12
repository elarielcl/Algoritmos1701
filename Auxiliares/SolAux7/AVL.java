class Nodo {
	Nodo izq, der;
	int info;
	public Nodo(Nodo izq, int info, Nodo der) {
		this.info = info;
		this.izq = izq;
		this.der = der;
	}
	
	public int altura() {
		int altizq = izq == null? -1 : izq.altura();
		int altder = der == null? -1 : der.altura();
		return 1 + Math.max(altizq, altder);
	}
	
}

public class Avl {
	
	public static int alturaDer(Nodo n) {
		return n.der == null? -1: n.der.altura();
	}
	
	public static int alturaIzq(Nodo n) {
		return n.izq == null? -1: n.izq.altura();
	}
	
	
	public static Nodo insertar(Nodo a, int x) {
		if (a == null)
			return new Nodo(null, x, null);
		Nodo b = a;
		if (x < b.info) {
			b.izq = insertar(b.izq,x);
			if (Math.abs(alturaIzq(b) - alturaDer(b)) == 2) {
				if (alturaDer(b.der) <= alturaIzq(b.der))
					b = rotateRight(b); 
				else
					b = doubleRight(b);
			}
		}
		else if (x > b.info) {
			b.der = insertar(b.der, x);
			if (Math.abs(alturaIzq(b) - alturaDer(b)) == 2) {
				if (alturaDer(b.der) >= alturaIzq(b.der))
					b = rotateLeft(b); 
				else
					b = doubleLeft(b); 
			}
		}
		return b;
	}

	private static Nodo doubleLeft(Nodo b) {
		b.der = rotateRight(b.der);
		return rotateLeft(b);
	}

	private static Nodo rotateLeft(Nodo padre) {
		Nodo hijo = padre.der;
		padre.der = hijo.izq;
		hijo.izq = padre;
		return hijo;
	}

	private static Nodo doubleRight(Nodo b) {
		b.izq = rotateLeft(b.izq);
		return rotateRight(b);
	}

	private static Nodo rotateRight(Nodo padre) {		
		Nodo hijo = padre.izq;
		padre.izq = hijo.der;
		hijo.der = padre;
		return hijo;
	}
	
	static int i;
	static int[] b;
	
	public static void inOrden(Nodo r) {
		if (r == null) return;
		inOrden(r.izq);
		b[i++] = r.info;
		inOrden(r.der);
	}
	
	public static int[] ordenarAVL(int[] a) {
		i = 0;
		b = new int[a.length];
		Nodo r = new Nodo(null, a[0], null);
		
		for (int i = 1; i<a.length; ++i) {
			r = insertar(r, a[i]);
		}
		inOrden(r);
		return b;
	}
	public static void main(String[] args) {
		
		int[] a = {1, 5, 3, 8, 2, 7, 9, 4, 6, 0};
		
		for (int e : ordenarAVL(a))
			System.out.print(e + " ");
	}
}
