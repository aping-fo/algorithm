package algorithm;

import java.util.Random;
import java.util.Stack;

/**
 * Created by aping.foo.
 * 二叉非递归调用
 */
public class TreeNoRecursion extends AbstractTree {
    public static void main(String[] args) {
        Random random = new Random();

        Node root = new Node(50, null, null);
        for (int i = 0; i < 10; i++) {
            Node childNode = new Node(random.nextInt(100), null, null);
            buildTree(root, childNode);
        }

        forward(root);
        middle(root);
    }

    /**
     * 前序非递归遍历
     */
    private static void forward(Node root) {
        Stack<Node> stack = new Stack<>();
        Node parent = root;
        while (parent != null || !stack.empty()) {
            while (parent != null) {
                System.out.println(parent.getValue());
                stack.push(parent);
                parent = parent.getLeft();
            }

            if (!stack.empty()) {
                parent = stack.pop();
                parent = parent.getRight();
            }
        }
    }

    /**
     * 中序非递归遍历
     */
    private static void middle(Node root) {
        Stack<Node> stack = new Stack<>();
        Node parent = root;
        while (parent != null || !stack.empty()) {
            while (parent != null) {
                stack.push(parent);
                parent = parent.getLeft();
            }

            if (!stack.empty()) {
                parent = stack.pop();
                System.out.println(parent.getValue());
                parent = parent.getRight();
            }
        }
    }

    /**
     * 后序非递归遍历
     */
    private static void laster() {

    }
}
