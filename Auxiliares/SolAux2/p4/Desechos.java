
public class Desechos {

    private static final int N = 100000;

    public static char machine(char state, char res){
        switch (state){
            case 'E':
                return res;
            case 'A':
                if(res == 'B') return 'E';
                else return 'A';
            case 'B':
                if(res == 'A') return 'E';
                else return 'B';
        }
        return state;
    }

    public static char recibeRecurso(){
        if(Math.random()<0.5) return 'A';
        return 'B';
    }

    public static void main(String[] args) {
        char state = 'E';
        int desechado = 0;
        for (int i = 0; i < N; i++) {
            char anterior = state;
            state = machine(state, recibeRecurso());
            if (state == anterior) desechado++;
        }
        float porcentaje = (((float) desechado*100)/N); // Debería ser 
cercano a 33.33
        System.out.println("Desechado: " + porcentaje + "%");
        if(porcentaje <= 35.0){
            System.out.println("La producción es rentable");  //Deberia 
dar siempre este para N grande por LLN
        }
        else{
            System.out.println("La producción NO es rentable");
        }
    }

}

