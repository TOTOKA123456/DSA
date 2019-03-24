package 必须掌握;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class 二叉树遍历2 {
    public static void main(String[] args) {
        BTNode b1 = new BTNode(1);
        BTNode b2 = new BTNode(2);
        BTNode b3 = new BTNode(3);
        BTNode b4 = new BTNode(4);
        BTNode b5 = new BTNode(5);
        BTNode b6 = new BTNode(6);
        b1.left = b2;
        b1.right = b3;
        b2.left = b4;
        b2.right = b5;
        b5.left = b6;
        System.out.println("DFS: "+DFS(b1).toString());
        System.out.println("BFS: "+BFS(b1).toString());
        System.out.println("Pre: "+Pre(b1).toString());
        System.out.println("In: "+In(b1).toString());
        System.out.println("Pos: "+Pos(b1).toString());
    }
    public static ArrayList<Integer> DFS(BTNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<BTNode> stack = new Stack<>();
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

    public static ArrayList<Integer> BFS(BTNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        LinkedList<BTNode> queue = new LinkedList<>();
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

    public static ArrayList<Integer> Pre(BTNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<BTNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if (root.right != null){
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return res;
    }

    public static ArrayList<Integer> In(BTNode root){
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

    public static ArrayList<Integer> Pos(BTNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null){
            return res;
        }
        Stack<BTNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            if (root.left != null){
                stack.push(root.left);
            }
            if (root.right != null){
                stack.push(root.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}


