package DSA2;

import java.util.Arrays;

public class TopK {
    public static void main(String[] args) {
        int[] arr = {99,11,44,6,78,32,100,2,45};
        int k = 3;
        int[] res = quickTopk(arr, k);
        System.out.println(Arrays.toString(res));
        int[] res2 = heapTopk(arr, k);
        System.out.println(Arrays.toString(res2));
    }
    //快排思想的实现
    public static int[] quickTopk(int[] arr, int k){
        int[] res = new int[k];
        int index = partition(arr, 0, arr.length-1);
        while (index != arr.length-k){
            if (index > arr.length-k){
                index = partition(arr, 0, index-1);
            }else {
                index = partition(arr, index+1, arr.length-1);
            }
        }
        for (int i = 0; i < k; i++){
            res[i] = arr[index+i];
        }
        return res;
    }
    public static int partition(int[] arr, int left, int right){
        int base = arr[left];
        while (left < right){
            while (left < right && arr[right] >= base){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= base){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = base;
        return right;
    }
    //小顶堆思想的实现
    public static int[] heapTopk(int[] arr, int k){
        int[] temp = new int[k];
        for (int i = 0; i < k; i++){
            temp[i] = arr[i];
        }
        MinHeap heap = new MinHeap(temp);
        for (int i = k; i < arr.length; i++){
            if (arr[i] > heap.getRoot()){
                heap.setRoot(arr[i]);
            }
        }
        return temp;
    }

}
