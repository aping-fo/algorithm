package algorithm;

import java.util.Random;

/**
 * Created by aping.foo
 * 二叉树
 */
public class Tree {

    public static void main(String[] args) {
        Random random = new Random();

        Node root = new Node(50, null, null);
        for (int i = 0; i < 10; i++) {
            Node childNode = new Node(random.nextInt(100), null, null);
            buildTree(root, childNode);
        }

        print(root);
    }

    /**
     * 递归遍历
     *
     * @param root
     */
    private static void print(Node root) {
        System.out.print("root=" + root.value);
        if (root.getRight() != null) {
            System.out.print(" right=" + root.getRight().getValue());
            print(root.getRight());
        }
        if (root.getLeft() != null) {
            System.out.print(" left=" + root.getLeft().getValue());
            print(root.getLeft());
        }
    }

    /**
     * 构建二叉树
     *
     * @param root
     * @param node
     */
    private static void buildTree(Node root, Node node) {
        if (node.getValue() >= root.getValue()) {
            if (root.getRight() == null) {
                root.setRight(node);
            } else {
                buildTree(root.getRight(), node);
            }
        } else {
            if (root.getLeft() == null) {
                root.setLeft(node);
            } else {
                buildTree(root.getLeft(), node);
            }
        }
    }

    static class Node {
        private int value;
        private Node right;
        private Node left;

        public Node(int value, Node right, Node left) {
            this.value = value;
            this.right = right;
            this.left = left;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }
    }
}
