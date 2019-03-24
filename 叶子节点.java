package 必须掌握;

import java.util.ArrayList;
import java.util.Arrays;

public class 叶子节点 {
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
        ArrayList<Integer> list = new ArrayList<>();
        leaf(b1, list);
        System.out.println(list.toString());
    }
    public static void leaf(BTNode root, ArrayList<Integer> res){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            res.add(root.val);
        }
        leaf(root.left, res);
        leaf(root.right, res);
    }
}
