
public class P2 {
	
	static class Nodo {
		Object info;
		Nodo izq, der;
	}
	
	static public int nnodos2hijos(Nodo x) {
		if (x == null) return 0;
		return ((x.izq != null && x.der != null) ? 1:0) + nnodos2hijos(x.izq) + nnodos2hijos(x.der);
	}

	public static void main(String[] args) {
		Nodo r = new Nodo();
		System.out.println(nnodos2hijos(r));
		
		r.izq = new Nodo();
		System.out.println(nnodos2hijos(r));
		
		
		r.der = new Nodo();
		System.out.println(nnodos2hijos(r));
		
		
		r.izq.izq = new Nodo();
		r.izq.izq.izq = new Nodo();
		r.izq.izq.der = new Nodo();
		System.out.println(nnodos2hijos(r));

		r.izq.der = new Nodo();
		System.out.println(nnodos2hijos(r));


	}

}

