package lec_2;

public class insert_a_node_inbst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = left;
            this.right = right;
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

    public static Node Insert_in_bst(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (root.data < val) {
            root.right = Insert_in_bst(root.right, val);

        } else {
            root.left = Insert_in_bst(root.left, val);
        }
        return root;

    }

    public static void Display(Node root) {
        if (root == null) {
            return;
        }
        String s = "";
        s = "<--" + root.data + "-->";
        if (root.left != null) {
            s = root.left.data + s;
        } else {
            s = "." + s;
        }
        if (root.right != null) {
            s = s + root.right.data;
        } else {
            s = s + ".";
        }
        System.out.print(s);
        Display(root.left);
        Display(root.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 10, 20, 30, 40, 50, 60, 70 };
        Node root = buildTree(0, nodes.length - 1, nodes);
        System.out.print(root.data);
        Insert_in_bst(root, 80);

    }

}
