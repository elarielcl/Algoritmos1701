/**
 * Class CuckooHashing
 *
 * @author Michel Llorens [@michotastico]
 * @version 01-06-17.
 */
public class CuckooHashing {

    private final int HASHING_PRIME_NUMBER = 11;
    private int MAX_ITERATIONS;

    HashingFunction hashOne = new HashingFunction() {
        @Override
        public int apply(int number) {
            return number%HASHING_PRIME_NUMBER;
        }
    };

    HashingFunction hashTwo = new HashingFunction() {
        @Override
        public int apply(int number) {
            return (number/HASHING_PRIME_NUMBER)%HASHING_PRIME_NUMBER;
        }
    };


    Integer[] firstTable, secondTable;

    public CuckooHashing(int tableSize){
        this.firstTable = new Integer[tableSize];
        this.secondTable = new Integer[tableSize];
        this.MAX_ITERATIONS = 2 * tableSize;
    }

    public boolean find(int value){
        int firstLocation = this.hashOne.apply(value);
        int secondLocation = this.hashTwo.apply(value);
        return (this.firstTable[firstLocation] == value) ||
                (this.secondTable[secondLocation] == value);
    }

    public void delete(int value){
        int firstLocation = this.hashOne.apply(value);
        int secondLocation = this.hashTwo.apply(value);

        if (this.firstTable[firstLocation] == value)
            this.firstTable[firstLocation] = null;

        if(this.secondTable[secondLocation] == value)
            this.secondTable[secondLocation] = null;
    }

    public void insert(int value) throws Exception {
        Integer valueOne, valueTwo;
        valueOne = value;
        int firstLocation, secondLocation;
        for(int i = 0; i < this.MAX_ITERATIONS; i++){
            firstLocation = this.hashOne.apply(valueOne);

            valueTwo = this.firstTable[firstLocation];
            this.firstTable[firstLocation] = valueOne;

            if(valueTwo == null)
                return;

            secondLocation = this.hashTwo.apply(valueTwo);

            valueOne = this.secondTable[secondLocation];
            this.secondTable[secondLocation] = valueTwo;

            if(valueOne == null)
                return;
        }
        throw new Exception("Max Cuckoo iterations!");
    }

    public void print(){
        System.out.println("First Table");
        this.printTable(this.firstTable);
        System.out.println("");


        System.out.println("Second Table");
        this.printTable(this.secondTable);
        System.out.println("");
    }

    private void printTable(Integer[] table){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(Integer number : table) {
            builder.append(number);
            builder.append(",");
        }
        builder.append("}");
        System.out.println(builder.toString());
    }

    public static void main(String[] args){
        int[] numbers = {20, 50, 53, 75, 100, 67, 105, 3, 36, 39};
        int loopCaseNumber = 6;

        CuckooHashing cuckoo = new CuckooHashing(10);

        System.out.println("Empty Cuckoo");
        cuckoo.print();

        try {
            for(int number: numbers)
                cuckoo.insert(number);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Normal insert");
        cuckoo.print();

        System.out.println("Loop case insert");
        try {
            cuckoo.insert(loopCaseNumber);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
