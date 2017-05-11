import java.util.LinkedList;

/**
 * Class RedBlackTree
 *
 * @author Michel Llorens [@michotastico]
 * @version 11-05-17.
 */
public class RedBlackTree {

    private enum Color {RED, BLACK}

    private class RBNode{
        Color color;
        int value;

        RBNode father, left, right;

        RBNode(int value){
            this.value = value;
            this.color = Color.RED;
        }

        void print(){
            String color = "RED: ";
            if (isBlack())
                color = "BLACK: ";
            System.out.println(color + value);
        }

        void nowIsBlack(){
            this.color = Color.BLACK;
        }

        boolean isBlack(){
            return this.color == Color.BLACK;
        }

        void nowIsRed(){
            this.color = Color.RED;
        }
    }

    private RBNode root;

    public RedBlackTree(){
        this.root = new RBNode(0);
    }

    public void insert(int value){
        RBNode newNode = new RBNode(value);
        if(this.root.right == null) {
            this.root.right = newNode;
            newNode.father = this.root;
        }
        else
            insert(newNode);

        while(newNode != null){
            newNode = recolorAndRotate(newNode);
        }
    }

    private void insert(RBNode newNode){
        RBNode pointer = this.root.right;

        while(true){
            if(pointer.value < newNode.value){
                if(pointer.right != null)
                    pointer = pointer.right;
                else {
                    pointer.right = newNode;
                    break;
                }
            }
            else{
                if(pointer.left != null)
                    pointer = pointer.left;
                else{
                    pointer.left = newNode;
                    break;
                }
            }
        }

        newNode.father = pointer;
    }

    private RBNode recolorAndRotate(RBNode node){
        /*
        CASE 0: The node is the root. The root is always black.
         */
        RBNode uncle;
        RBNode father;
        RBNode grandfather;

        father = node.father;

        if(this.root.right == node)
            node.nowIsBlack();
        else if(!father.isBlack()){
            grandfather = father.father;

            if(grandfather == this.root)
                father.nowIsBlack();

            else if(grandfather.left == father){
                uncle = grandfather.right;
                /*
                CASE 1: Recolor
                 */
                if(uncle != null && !uncle.isBlack()){
                    father.nowIsBlack();
                    uncle.nowIsBlack();
                    grandfather.nowIsRed();
                    return grandfather;
                }
                else{
                    /*
                    CASE 2
                     */
                    if(father.right == node){
                        grandfather.nowIsRed();
                        node.nowIsBlack();
                        rotateToLeft(father);
                        rotateToRight(grandfather);
                    }
                    /*
                    CASE 3
                     */
                    else{
                        father.nowIsBlack();
                        grandfather.nowIsRed();
                        rotateToRight(grandfather);
                    }
                }
            }
            else{
                uncle = grandfather.left;
                /*
                CASE 1: Recolor
                 */
                if(uncle != null && !uncle.isBlack()){
                    father.nowIsBlack();
                    uncle.nowIsBlack();
                    grandfather.nowIsRed();
                    return grandfather;
                }
                else{
                    /*
                    CASE 2
                     */
                    if(father.left == node){
                        grandfather.nowIsRed();
                        node.nowIsBlack();
                        rotateToRight(father);
                        rotateToLeft(grandfather);
                    }
                    /*
                    CASE 3
                     */
                    else{
                        father.nowIsBlack();
                        grandfather.nowIsRed();
                        rotateToLeft(grandfather);
                    }
                }
            }
        }


        return null;
    }

    private void rotateToLeft(RBNode father) {
        RBNode grandfather = father.father;
        boolean isLeft = true;
        if (grandfather.right == father)
            isLeft = false;

        RBNode node = father.right;
        RBNode nodeRight = node.left;

        /*
        Rotate
         */
        father.right = nodeRight;
        node.left = father;
        /*
        Update fathers.
         */
        father.father = node;
        node.father = grandfather;
        if(isLeft)
            grandfather.left = node;
        else
            grandfather.right = node;

        if (nodeRight != null)
            nodeRight.father = father;

    }

    private void rotateToRight(RBNode father) {
        RBNode grandfather = father.father;
        boolean isLeft = true;
        if (grandfather.right == father)
            isLeft = false;

        RBNode node = father.left;
        RBNode nodeRight = node.right;

        /*
        Rotate
         */
        father.left = nodeRight;
        node.right = father;
        /*
        Update fathers.
         */
        father.father = node;
        node.father = grandfather;
        if(isLeft)
            grandfather.left = node;
        else
            grandfather.right = node;

        if (nodeRight != null)
            nodeRight.father = father;

    }

    public static void main(String[] args){
        int[] values = {2, 1, 4, 5, 9, 3, 6, 7};
        RedBlackTree tree = new RedBlackTree();
        for(int value: values){
            System.out.println("Inserting: "+ value);
            tree.insert(value);
            printTree(tree);
            System.out.println("");
        }

    }

    private static void printTree(RedBlackTree tree){
        /*
        Its a Queue
         */
        LinkedList<RBNode> queue = new LinkedList<>();
        queue.add(tree.root.right);
        RBNode current, left, right;
        while(!queue.isEmpty()){
            current = queue.removeFirst();
            current.print();

            left = current.left;
            right = current.right;
            if(left != null)
                queue.add(left);
            if(right != null)
                queue.add(right);
        }
    }
}
