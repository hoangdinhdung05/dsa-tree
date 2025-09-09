import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Khởi tạo Node lưu data và con trái, con phải
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}


//Binary Tree Search: với quy tắc Node trái < Node gốc < Node phải
class BTS {
    Node node;
    public BTS() {
        node = null;
    }

    //Insert
    private Node insert(Node node, int data) {
         if (node == null) {
             return new Node(data);
         }
         if (data < node.data) node.left = insert(node, data);
         else if (data > node.data) node.right = insert(node, data);
         return node;
    }

    public void insert(int data) {
        node = insert(node, data);
    }

    //Delete
    private Node delete(Node node, int key) {
        if (node == null) return null;
        if (key < node.data) {
            node.left = delete(node, key);
        } else if (key > node.data) {
            node.right = delete(node, key);
        } else {
            //Trường hợp node lá chỉ có 1 node con
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;

            //trường hợp node có 2 con
            node.data = minValue(node.right); // Tìm giá trị nhỏ nhất trong cây con bên phải
            node.right = delete(node.right, node.data); // Xóa giá trị nhỏ
        }
        return node;
    }

    public void delete(int key) {
        node = delete(node, key);
        System.out.println("Deleted " + key);
    }

    //Duyệt

    //1. In-order (LNR): Left -> Node -> Right
    public void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    //2. Pre-order (NLR): Node -> Left -> Right
    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //3. Post-order (LRN): Left -> Right -> Node
    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }

    //4. Level-order (BFS)
    public void levelOrder() {
        if (node == null) return; // cây rỗng => dừng
        Queue<Node> queue = new LinkedList<>(); // Tạo Queue để lưu các node
        queue.add(node);
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

    //Search
    private boolean searchRec(Node node, int key) {
        //Check root != null && key == root.data => return true
        if (node == null) return false;
        if (node.data == key) return true;

        // Key > root => tìm phải
        if (key > node.data) return searchRec(node.right, key);

        // key < root => tìm trái
        return searchRec(node.left, key);
    }

    public boolean search(int key) {
        return searchRec(node, key);
    }


    //PUBLIC METHOD
    int minValue(Node node) {
        int min = node.data;
        while (node.left != null) {
            node = node.left;
            min = node.data;
        }
        return min;
    }

    public Node getNode() {
        return node;
    }

}


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BTS tree = new BTS();

        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            //Insert call
            tree.insert(a[i] = sc.nextInt());
        }

        //Duyệt cây
        System.out.println("In-order (Left -> Node -> Right): ");
        tree.inOrder(tree.node);
        System.out.println();

        System.out.println("Pre-order (Node -> Left -> Right): ");
        tree.preOrder(tree.node);
        System.out.println();

        System.out.println("Post-order (Left -> Right -> Node): ");
        tree.postOrder(tree.node);
        System.out.println();

        System.out.println("Level-order (BFS): ");
        tree.levelOrder();
        System.out.println();

        //Delete
        System.out.println("Enter value to delete: ");
        int key = sc.nextInt();
        tree.delete(key);
        System.out.println("In-order after delete " + key + ": ");
        tree.inOrder(tree.node);
        System.out.println();

        //Search
        System.out.println("Enter value to search: ");
        int searchKey = sc.nextInt();
        if (tree.search(searchKey)) {
            System.out.println("Found " + searchKey + " in the tree.");
        } else {
            System.out.println(searchKey + " not found in the tree.");
        }

        sc.close();
    }
}