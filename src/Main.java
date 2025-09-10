import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

// Node lưu data và con trái, con phải
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

// Binary Search Tree (BST)
class BTS {
    private Node root;

    public BTS() {
        root = null;
    }

    // ------------------- INSERT -------------------
    private Node insert(Node node, int data) {
        if (node == null) return new Node(data);
        if (data < node.data) node.left = insert(node.left, data);
        else if (data > node.data) node.right = insert(node.right, data);
        return node;
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    public void insertTree() {
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.left.left.left = new Node(11);
    }

    // ------------------- DELETE -------------------//
    private Node delete(Node node, int key) {
        if (node == null) return null;

        if (key < node.data) node.left = delete(node.left, key);
        else if (key > node.data) node.right = delete(node.right, key);
        else {
            // Node có 1 hoặc 0 con
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node có 2 con
            node.data = minValue(node.right);
            node.right = delete(node.right, node.data);
        }
        return node;
    }

    public void delete(int key) {
        root = delete(root, key);
        System.out.println("Deleted " + key);
    }

    // ------------------- SEARCH -------------------//
    private boolean searchRec(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        if (key < node.data) return searchRec(node.left, key);
        return searchRec(node.right, key);
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    // ------------------- TRAVERSALS -------------------

    //========== IN ORDER ==========//
    //========== LNR = Left - Node - Right ===========//
    //Đệ qui
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //Stack
    public void inOrder() {
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            // Đi hết con trái
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.data + " ");
            current = current.right;
        }
    }


    //========== PRE ORDER ==========//
    //========== NLR = Node - Left - Right ===========//
    //Đệ qui
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //Stack
    public void preOrder() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");

            //Vào sau ra trước => đẩy con phải trước
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }

    //========== POST ORDER ==========//
    //========== LRN = Left - Right - Node ===========//
    //Đệ qui
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    //Stack
    public void postOrder() {
        if (root == null) return;
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            Node node = stack1.pop();
            stack2.push(node);
            if (node.left != null) stack1.push(node.left);
            if (node.right != null) stack1.push(node.right);
        }
        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + " ");
        }
    }

    //========== LEVEL ORDER ==========//
    //========== BFS = Breadth First Search ===========//
    public void levelOrder() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.print(temp.data + " ");
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }

    // ------------------- UTILITY -------------------//
    private int minValue(Node node) {
        int min = node.data;
        while (node.left != null) {
            node = node.left;
            min = node.data;
        }
        return min;
    }

    public Node getRoot() {
        return root;
    }
}

// ------------------- MAIN -------------------
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BTS tree = new BTS();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

//        System.out.println("Enter elements: ");
//        for (int i = 0; i < n; i++) {
//            tree.insert(sc.nextInt());
//        }

        tree.insertTree();

        tree.preOrder();

        sc.close();
    }
}
