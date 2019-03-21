package DSA2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class 二叉树遍历 {
    public static void main(String[] args) {
        BTNode b1 = new BTNode(1);
        BTNode b2 = new BTNode(2);
        BTNode b3 = new BTNode(3);
        BTNode b4 = new BTNode(4);
        BTNode b5 = new BTNode(5);
        BTNode b6 = new BTNode(6);
        b1.left = b2;
        b1.right = b6;
        b2.left = b3;
        b2.right = b4;
        b4.left = b5;
        ArrayList<Integer> res = preOrder(b1);
        System.out.println(res.toString());
        ArrayList<Integer> res2 = inOrder(b1);
        System.out.println(res2.toString());
        ArrayList<Integer> res3 = postOrder(b1);
        System.out.println(res3.toString());
        ArrayList<Integer> res4 = DFS(b1);
        System.out.println(res4.toString());
        ArrayList<Integer> res5 = BFS(b1);
        System.out.println(res5.toString());
    }
    //前序遍历，非递归
    public static ArrayList<Integer> preOrder(BTNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BTNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                res.add(root.val);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }
        return res;
    }
    //中序遍历，非递归
    public static ArrayList<Integer> inOrder(BTNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BTNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()){
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
    //后序遍历，非递归
    public static ArrayList<Integer> postOrder(BTNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root != null){
            Stack<BTNode> s1 = new Stack<>();
            Stack<BTNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()){
                root = s1.pop();
                s2.push(root);
                if (root.left != null){
                    s1.push(root.left);
                }
                if (root.right != null){
                    s1.push(root.right);
                }
            }
            while (!s2.isEmpty()){
                res.add(s2.pop().val);
            }
        }
        return res;
    }
    //DFS，栈
    public static ArrayList<Integer> DFS(BTNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BTNode> stack = new Stack<>();
        if (root == null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
        return res;
    }
    //BFS，链表
    public static ArrayList<Integer> BFS(BTNode root){
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<BTNode> queue = new LinkedList<>();
        if (root == null){
            return res;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            res.add(root.val);
            if (root.left != null){
                queue.add(root.left);
            }
            if (root.right != null){
                queue.add(root.right);
            }
        }
        return res;
    }

}

class BTNode{
    int val;
    BTNode left;
    BTNode right;

    public BTNode(int val) {
        this.val = val;
    }
}
