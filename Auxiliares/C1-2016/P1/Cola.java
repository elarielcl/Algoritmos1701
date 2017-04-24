
public class Cola {
	
	class Nodo {
		Nodo prev, next;
		int info;
	}
	
	private Nodo head;
	private Nodo tail;
	
	public Cola() {
		this.head = null;
		this.tail = null;
	}
	
	public boolean estaVacia() {
		return head == null && tail == null;
	}
	
	public void encolar(int v) {
		Nodo n = new Nodo();
		n.info = v;
		
		if (estaVacia())
			head = tail = n;
		else {
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
	}
	
	public int desencolar() {
		if (estaVacia()) return -1;
		
		int v = head.info;
		head = head.next;
		
		if (head == null) {
			tail = null;
			return v;
		}
		
		head.prev = null;
		return v;
	}
	
	static public void main(String[] args) {
		Cola c = new Cola();
		System.out.println(c.estaVacia());
		c.encolar(4);
		c.encolar(5);
		System.out.println(c.estaVacia());
		
		System.out.println(c.desencolar());
		System.out.println(c.estaVacia());
		
		System.out.println(c.desencolar());
		System.out.println(c.estaVacia());
		
		c.encolar(7);
		System.out.println(c.estaVacia());
	}

}

