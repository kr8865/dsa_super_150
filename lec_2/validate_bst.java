package lec_2;

public class validate_bst {
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

    static class Bst {
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        boolean isbst = true;
        int sum = 0;
        int ans = 0;// only bst part ka sum

    }

    public int maxsumBST(Node root) {

    }

    public boolean isValid(Node root) {
        return validBST(root).isbst;

    }

    public Bst validBST(Node root) {
        if (root == null) {
            return new Bst();
        }
        Bst lbp = validBST(root.left);
        Bst rbp = validBST(root.right);
        Bst sbp = new Bst();
        sbp.min = Math.min(lbp.min, Math.min(rbp.min, root.data));
        sbp.max = Math.max(lbp.max, Math.max(rbp.max, root.data));
        sbp.sum = lbp.sum + rbp.sum + root.data;
        sbp.isbst = lbp.isbst && rbp.isbst && lbp.max < root.data && rbp.min > root.data;
        if (sbp.isbst) {
            sbp.ans = Math.max(lbp.ans, Math.max(rbp.ans, sbp.sum));
        } else {
            sbp.ans = Math.max(lbp.ans, rbp.ans);

        }
        return sbp;

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

    }

}
