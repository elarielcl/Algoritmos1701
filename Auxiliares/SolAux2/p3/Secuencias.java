package SolAux2.p3;

/**
 * Class Secuencias
 *
 * @author Michel Llorens [@michotastico]
 * @version 24-03-2017.
 */
public class Secuencias {


    /*
    Invariante: (sum_i < sum_i+1 && i <= N) || (element_i > element_i+1 && i <= N)
    Inicialización: N > 0 && i = 1 => (0 < 1 <= N) . sum_0 = 0 && sum_1 = 1 => sum_0 < sum_1
    Término: i > N.
     */
    static double f (int N){
        double sum = 0;
        for(int i = 1; i <= N; i++){
            sum += 1.0/i;
        }
        return sum;
    }

    static double f_checkInvariant(int N) throws Exception {
        double sum = 0;
        double previousSum = sum;
        for(int i = 1; i <= N; i++){
            sum += 1.0/i;
            if (sum < previousSum || i > N)
                throw new Exception("Invariante inválido");
        }
        return sum;

    }

    /*
    Máquina de dos estados. Positivo y negativo en el que cada paso alterna su posición.
    Perfectamente puede escribirse como
    static char stateMachine(char state){
        switch(state){
            case 'P':
                return 'N';
            case 'N':
                return 'P';
        }
        return 'P';
     */
    static boolean stateMachine(boolean state){
        return !state;
    }

    static double g (int N){
        boolean state = false;
        double sum = 0;
        double currentValue;
        for(int i = 1; i <= N; i++){
            state = stateMachine(state);
            currentValue = 1.0/i;
            if(state)
                sum += currentValue;
            else
                sum -= currentValue;
        }
        return sum;
    }


    public static void main(String[] args){
        System.out.println("Función f");
        for(int i = 1; i < 100; i++){
            System.out.println(f(i));
        }
        System.out.println();
        System.out.println("Función f con chequeo de invariante por excepción");
        try {
            for(int i = 1; i < 100; i++){
                System.out.println(f_checkInvariant(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("Función g");
        for(int i = 1; i < 100; i++){
            System.out.println(g(i));
        }
    }
}
