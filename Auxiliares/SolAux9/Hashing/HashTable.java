import java.util.Random;

/**
 * Class HashTable
 *
 * @author Michel Llorens [@michotastico]
 * @version 25-05-2017.
 */
public class HashTable {
    private int size;
    private PriorityQueue[] table;

    private int hashFunction(int element){
        int prime = 73;
        Random randomPonderator = new Random(element);
        int nextInt;
        if(element > 0)
            nextInt = randomPonderator.nextInt(Integer.MAX_VALUE/element);
        else
            nextInt = 0;
        int premod = nextInt*element;
        return (premod % prime) % this.size;
    }

    public HashTable(int size){
        this.size = size;
        this.table = new PriorityQueue[this.size];
        for(int i = 0; i < size; i++)
            this.table[i] = new PriorityQueue();
    }

    public void insert(int value){
        int position = this.hashFunction(value);
        this.table[position].insert(value, String.valueOf(value));
    }

    public Integer search(int value){
        int position = this.hashFunction(value);
        return (Integer) this.table[position].find(String.valueOf(value));
    }

    public void printAverages(){
        for(PriorityQueue queue: this.table)
            queue.printAVG();
    }

    public static void main(String[] args){
        HashTable table = new HashTable(100);
        Random random = new Random(42);
        int iterations = 100000;
        int MAX_VALUE = Integer.MAX_VALUE/42;
        for(int i = 0; i < iterations; i++)
            table.insert(random.nextInt(MAX_VALUE));
        for(int i = 0; i < iterations; i++)
            table.search(random.nextInt(MAX_VALUE/16));
        table.printAverages();
    }
}
