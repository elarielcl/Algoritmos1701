import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int raiz = 50;
        int[] values = new int[10];
        for(int i = 0; i < 10; i++){
            values[i] = random.nextInt(100);
            System.out.println(values[i]);
        }

        Arbol original = new Arbol(raiz);
        Arbol reflejo = new Arbol(raiz);

        for(int value : values){
            original.agregar(value);
            reflejo.agregar(value);
        }

        reflejo.reflejar();

        System.out.println("Original igual a reflejo?: "+original.sonIguales(reflejo));

    }
}
