package lec_2;

import java.util.*;

public class level_order_input {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static Node root;

    public static void lever_order() {

        Scanner sc = new Scanner(System.in);
        Queue<Node> q = new LinkedList<>();
        int data = sc.nextInt();
        Node newnode = new Node(data);
        root = newnode;
        q.add(newnode);
        while (!q.isEmpty()) {
            Node r = q.poll();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();
            if (c1 != -1) {
                Node node = new Node(c1);
                r.left = node;
                q.add(node);

            }
            if (c2 != -1) {
                Node node = new Node(c2);
                node.data = c2;
                r.right = node;
                q.add(node);

            }
        }

    }

    public static void main(String[] args) {
        // [10,5,7,8,-1,9,-1,-1,-1,16,-1,-1,-1];

    }

}
