package 算法思想;

import java.util.ArrayList;
import java.util.TreeSet;

public class 全排列 {
    public static void main(String[] args) {
        String str = "abcd";
        ArrayList<String> res = Permutation(str);
        System.out.println(res.toString());
        System.out.println(res.size());
    }
    public static ArrayList<String> Permutation(String str){
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0){
            return res;
        }
        TreeSet<String> set = new TreeSet<>();
        fun(set, str.toCharArray(), 0);
        res.addAll(set);
        return res;
    }
    public static void fun(TreeSet<String> set, char[] arr, int index){
        if (index == arr.length){
            set.add(new String(arr));
            return;
        }
        for (int i = 0; i < arr.length; i++){
            swap(arr, i, index);
            fun(set, arr, index+1);
            swap(arr, i, index);
        }
    }
    public static void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
