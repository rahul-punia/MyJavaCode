import java.util.*;

public class AVLsir {
    static class Node {
        int data;
        Node left;
        Node right;
        int ht = 1;
        int bal = 0;

        public Node() {
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static int getht(Node node){
        int lh = node.left != null? node.left.ht: 0;
        int rh = node.right != null? node.right.ht: 0;
        return Math.max(lh, rh) + 1;
    }

    static int getbal(Node node){
        int lh = node.left != null? node.left.ht: 0;
        int rh = node.right != null? node.right.ht: 0;
        return lh - rh;
    }

    static void display(Node node) {
        if (node == null) {
            return;
        }

        String str = "";
        str += node.left != null ? node.left.data + " -> " : ". -> ";
        str += node.data + "_" + node.ht + "_" + node.bal;
        str += node.right != null ? " <- " + node.right.data : " <- .";
        System.out.println(str);

        display(node.left);
        display(node.right);
    }

    static Node construct(int[] sa, int lo, int hi){
        if(lo > hi){
            return null;
        }

        Node node = new Node();
        
        int mid = (lo + hi) / 2;
        node.data = sa[mid];
        node.left = construct(sa, lo, mid - 1);
        node.right = construct(sa, mid + 1, hi);
        node.ht = getht(node);
        node.bal = getbal(node);

        return node;
    }

    static int max(Node node){
        if(node.right == null){
            return node.data;
        } else {
            return max(node.right);
        }
    }

    static Node leftRotation(Node x){
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        x.right = t2;

        x.ht = getht(x);
        x.bal = getbal(x);
        y.ht = getht(y);
        y.bal = getbal(y);

        return y;
    }

    static Node rightRotation(Node x){
        Node y = x.left;
        Node t3 = y.right;
        y.right = x;
        x.left = t3;

        x.ht = getht(x);
        x.bal = getbal(x);
        y.ht = getht(y);
        y.bal = getbal(y);

        return y;
    }

    static Node add(Node node, int data){
        if(node == null){
            return new Node(data, null, null);
        }

        if(data > node.data){
            node.right = add(node.right, data);
        } else if(data < node.data){
            node.left = add(node.left, data);
        } else {
            // 
        }

        node.ht = getht(node);
        node.bal = getbal(node);
        if(node.bal > 1){
            if(node.left.bal >= 0){
                // ll - xyz => n, n.l, n.l.l
                node = rightRotation(node);
            } else {
                // lr - xyz => n, n.l, n.l.r
                node.left = leftRotation(node.left);
                node = rightRotation(node);
            }
        } else if(node.bal < - 1){
            if(node.right.bal <= 0){
                // rr => xyz => n, n.r, n.r.r
                node = leftRotation(node);
            } else {
                // rl => xyz => n, n.r, n.r.l
                node.right = rightRotation(node.right);
                node = leftRotation(node);
            }
        }

        return node;
    }

    static Node remove(Node node, int data){
        if(node == null){
            return null;
        }

        if(data > node.data){
            node.right = remove(node.right, data);
        } else if(data < node.data){
            node.left = remove(node.left, data);
        } else {
            if(node.left == null || node.right == null){
                node = node.left == null? node.right: node.left;
            } else {
                int lmax = max(node.left);
                node.data = lmax;
                node.left = remove(node.left, lmax);
            }
        }

        if(node != null){
            node.ht = getht(node);
            node.bal = getbal(node);
            if(node.bal > 1){
                if(node.left.bal >= 0){
                    // ll - xyz => n, n.l, n.l.l
                    node = rightRotation(node);
                } else {
                    // lr - xyz => n, n.l, n.l.r
                    node.left = leftRotation(node.left);
                    node = rightRotation(node);
                }
            } else if(node.bal < - 1){
                if(node.right.bal <= 0){
                    // rr => xyz => n, n.r, n.r.r
                    node = leftRotation(node);
                } else {
                    // rl => xyz => n, n.r, n.r.l
                    node.right = rightRotation(node.right);
                    node = leftRotation(node);
                }
            }
        }

        return node;
    }


    public static void main(String[] args){
        int[] sa = {12, 25, 37, 50, 62, 75, 87};
        Node root = construct(sa, 0, sa.length - 1);
        // display(root);
        add(root, 30);
        add(root, 28);
        add(root, 29);
        root = remove(root, 12);
        root = remove(root, 25);
        root = remove(root, 37);
        display(root);
    }
}