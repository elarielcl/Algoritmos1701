import java.io.*;

/**
 * Class IO
 *
 * @author Michel Llorens [@michotastico]
 * @version 16-03-2017.
 */
public class IO {

    public static void FileFibonacci(){
        int previousPreviousNumber, previousNumber, nextNumber;
        String line;

        try {
            FileReader readableFile = new FileReader("fibonacci.txt");
            BufferedReader reader = new BufferedReader(readableFile);

            /*
            The Input file has at least the two first digits of Fibonacci.
             */

            previousPreviousNumber = Integer.parseInt(reader.readLine());
            previousNumber = Integer.parseInt(reader.readLine());

            System.out.println(previousPreviousNumber);
            System.out.println(previousNumber);

            line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                previousPreviousNumber = previousNumber;
                previousNumber = Integer.parseInt(line);
                line = reader.readLine();
            }

            /*
            After read a file, we need to close the file.
             */

            reader.close();
            readableFile.close();

            /*
            Now we calculate the next value and append to the existing file.
             */

            nextNumber = previousPreviousNumber + previousNumber;
            line = String.valueOf(nextNumber);

            FileWriter writableFile = new FileWriter("fibonacci.txt", true);
            BufferedWriter writer = new BufferedWriter(writableFile);

            writer.write(line);
            writer.newLine();

            writer.close();
            writableFile.close();

            System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void FileFibonacci(int iterations){
        int previousPreviousNumber, previousNumber, nextNumber;
        String line;

        try {
            FileReader readableFile = new FileReader("fibonacci.txt");
            BufferedReader reader = new BufferedReader(readableFile);

            /*
            The Input file has at least the two first digits of Fibonacci.
             */

            previousPreviousNumber = Integer.parseInt(reader.readLine());
            previousNumber = Integer.parseInt(reader.readLine());

            System.out.println(previousPreviousNumber);
            System.out.println(previousNumber);

            line = reader.readLine();

            while (line != null) {
                System.out.println(line);
                previousPreviousNumber = previousNumber;
                previousNumber = Integer.parseInt(line);
                line = reader.readLine();
            }

            /*
            After read a file, we need to close the file.
             */

            reader.close();
            readableFile.close();

            /*
            Now we calculate the next values on a for-loop and add them to the existing file.
             */

            FileWriter writableFile = new FileWriter("fibonacci.txt", true);
            BufferedWriter writer = new BufferedWriter(writableFile);

            for(int index = 0; index < iterations; index++){
                nextNumber = previousPreviousNumber + previousNumber;
                line = String.valueOf(nextNumber);
                System.out.println(line);
                writer.write(line);
                writer.newLine();
                previousPreviousNumber = previousNumber;
                previousNumber = nextNumber;
            }

            writer.close();
            writableFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
