import java.util.Queue;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    //Mỗi node có thể có tối đa 2 con: left và right
    Node root;
    public BinaryTree() {
        root = null;
    }

    //Insert method to add nodes to the tree
    public void insert(int data) {
        root = insertRec(root, data);
    }

    //Search method to find a node in the tree
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        //Node left < Node root < Node right
         if (root == null) {
                root = new Node(data);
                return root;
         }
         if (data < root.data) {
             root.left = insertRec(root.left, data);
         } else if (data > root.data) {
             root.right = insertRec(root.right, data);
         } return root;
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }
        if (value > root.data) {
            return searchRec(root.right, value);
        }
        return searchRec(root.left, value);
    }

    //NLR: Root -> Left -> Right
    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //LNR: Left -> Root -> Right
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //LRN: Left -> Right -> Root
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    //Breadth-First Search (BFS) or Level Order Traversal
    public void levelOrder() {
        if (root == null) return;
        Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BinaryTree tree = new BinaryTree();
        System.out.println("Enter number of nodes to insert:");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            tree.insert(a[i]);
        }

        System.out.println("In-order (LNR): ");
        tree.inOrder(tree.root);  // Output: 20 30 40 50 60 70 80
        System.out.println();

        System.out.println("Pre-order (NLR): ");
        tree.preOrder(tree.root);  // Output: 50 30 20 40 70 60 80
        System.out.println();

        System.out.println("Post-order (LRN): ");
        tree.postOrder(tree.root); // Output: 20 40 30 60 80 70 50
        System.out.println();

        System.out.println("Level-order (BFS): ");
        tree.levelOrder();         // Output: 50 30 70 20 40 60 80
        System.out.println();

        System.out.println("Search 40: " + tree.search(40)); // true
        System.out.println("Search 90: " + tree.search(90)); // false

        sc.close();
    }
}