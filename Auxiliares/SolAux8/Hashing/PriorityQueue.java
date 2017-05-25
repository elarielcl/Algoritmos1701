import java.util.Random;

/**
 * Class PriorityQueue
 *
 * @author Michel Llorens [@michotastico]
 * @version 24-05-2017.
 */
public class PriorityQueue {
    private class Node{
        String key;
        Object element;
        long priority;

        Node next, prev;

        Node(Object element, String key){
            this.element = element;
            this.key = key;
            this.priority = 0;
        }
    }

    private Node head, tail;
    private int counter, total;

    public PriorityQueue(){
        head = tail = new Node("", "");
        counter = total = 0;
    }

    public void insert(Object element, String key){
        Node newNode = new Node(element, key);
        if(head.next == null){
            head.next = newNode;
            head.next.prev = head;
            tail = head.next;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = tail.next;
        }
    }

    public Object find(String key){
        Node pointer = head.next;
        Object element = null;
        Node swapper;
        int counter = 0;
        // Iterate over the linked list to find the element.
        while(pointer != null){
            counter++;
            // Key match
            if(pointer.key.equals(key)){
                element = pointer.element;
                // Update the priority.
                pointer.priority++;
                // Swapping process
                while(pointer != head.next){
                    if(pointer.priority > pointer.prev.priority){
                        swapper = pointer.prev;

                        if(pointer == tail){
                            swapper.prev.next = pointer;
                            pointer.prev = swapper.prev;
                            pointer.next = swapper;
                            swapper.prev = pointer;
                            tail = swapper;
                            tail.next = null;
                        }
                        else{
                            swapper.prev.next = pointer;
                            pointer.prev = swapper.prev;

                            swapper.next = pointer.next;
                            pointer.next.prev = swapper;

                            pointer.next = swapper;
                            swapper.prev = pointer;
                        }
                    }
                    else
                        break;
                }
                break;
            }
            else{
                pointer = pointer.next;
            }
        }

        this.total += counter;
        this.counter++;

        return element;
    }

    public void printAVG(){
        double avg = (this.total*1.0)/this.counter;
        System.out.println("Queue find AVG: "+avg);
    }

    public static void main(String [] args){
        int words = 1500;
        int divisionFactor = 8;
        PriorityQueue queue = new PriorityQueue();

        for(int i = 0; i < words; i++){
            queue.insert(String.valueOf(i), String.valueOf(i));
        }

        Random random = new Random();
        int randomIndex;
        int searches = words;

        for(int i = 0; i < searches; i++){
            randomIndex = random.nextInt(words/divisionFactor);
            queue.find(String.valueOf(randomIndex));
        }

        queue.printAVG();
    }
}
