import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Expand {
    static public void main(String[] args) throws IOException{
        for (String fileName : args) {
            System.out.println(fileName);
            System.out.println("---------------------------------");
            ArrayList<String> history = new ArrayList<String>();
            history.add(fileName);
            expand(fileName, history);
        }
    }

    static public void expand(String fileName, ArrayList<String> history) throws IOException{
        BufferedReader br  = new BufferedReader(new FileReader(fileName));
        String linea = br.readLine();
        while (linea != null) {
            int ind;
            while((ind = linea.indexOf("<<<")) != -1) {
                int indf = linea.indexOf(">>>", ind+3);
                if (indf == -1) break;
                System.out.print(linea.substring(0, ind));
                String fN = linea.substring(ind+3, indf);
                if (history.contains(fN)) {
                    System.out.println("\n---------------------------------");
                    System.out.println("ARCHIVOS CONTIENEN LOOP");
                    System.out.println("---------------------------------");
                    System.exit(0);
                }
                history.add(fN);
                expand(fN, history);
                history.remove(history.size()-1);

                linea = linea.substring(indf+3);
            }
            System.out.println(linea);
            linea = br.readLine();
        }
        br.close();
    }
}
