package lec_2;

public class delete_node {
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

    public static int maxa(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int da = maxa(root.right);
        return Math.max(da, root.data);

    }

    public static Node delete(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data < key) {
            root.right = delete(root.right, key);
        } else if (root.data > key) {
            root.right = delete(root.left, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;

            } else {

            }

        }
        return root;

    }

    public static void main(String[] args) {
        int[] nodes = { 10, 20, 30, 40, 50, 60, 70 };
        Node root = buildTree(0, nodes.length - 1, nodes);
        System.out.print(root.data);

    }

}
