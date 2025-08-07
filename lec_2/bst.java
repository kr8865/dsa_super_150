package lec_2;

public class bst {
    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node buildTree(int si, int ei, int[] nodes) {
        int mid = (si + ei) / 2;

        if (si > ei) {
            return null;

        }

        int root = nodes[mid];
        Node newnode = new Node(root);

        newnode.left = buildTree(si, mid - 1, nodes);
        newnode.right = buildTree(mid + 1, ei, nodes);
        return newnode;

    }

    public static void main(String[] args) {

        int[] nodes = { 10, 20, 30, 40, 50, 60, 70 };
        Node root = buildTree(0, nodes.length - 1, nodes);
        System.out.print(root.data);

    }

}
