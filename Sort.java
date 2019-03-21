package DSA2;

import Practice1.MaxHeap;
import Practice1.MergeSort;
import 排序算法.Merge;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {9,4,6,7,3,8,2,1,0};
        //BubbleSort(arr);
        //InsertSort(arr);
        //ShellSort(arr);
        //SelectSort(arr);
        //QuickSort(arr);
        //MergeSort(arr);
        HeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //冒泡排序
    public static void BubbleSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++){  //比较的次数
            for (int j = 0; j < arr.length-1-i; j++){  //未排序数组的长度
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    //插入排序
    public static void InsertSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j;
            for (j = i-1; j>=0 && arr[j]>temp; j--){
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }
    //希尔排序
    public static void ShellSort(int[] arr){
        for (int step = arr.length/2; step > 0; step /= 2){
            for (int i = step; i < arr.length; i+=step){
                int temp = arr[i];
                int j;
                for (j = i-step; j>=0 && arr[j]>temp; j-=step){
                    arr[j+step] = arr[j];
                }
                arr[j+step] = temp;
            }
        }
    }
    //选择排序
    public static void SelectSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = i;
            for (int j = i+1; j < arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    //快速排序
    public static void QuickSort(int[] arr){
        QuickSort(arr, 0, arr.length-1);
    }
    public static void QuickSort(int[] arr, int left, int right){
        if (left > right){     //注意边界判断
            return;
        }
        int index = partition(arr, left, right);
        QuickSort(arr, left, index-1);
        QuickSort(arr, index+1, right);
    }
    public static int partition(int[] arr, int left, int right){
        int base = arr[left];
        while (left < right){
            while (left < right && arr[right]>=base){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left]<=base){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = base;
        return right;
    }
    //归并排序
    public static void MergeSort(int[] arr){
        MergeSort(arr, 0, arr.length-1);
    }
    public static void MergeSort(int[] arr, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (left + right)>>1;
        MergeSort(arr, left, mid);
        MergeSort(arr, mid+1, right);
        Merge(arr, left, mid, right);
    }
    public static void Merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid+1;
        for (int k = left; k <= right; k++){
            if (i > mid){
                arr[k] = temp[j++];
            }else if (j > right){
                arr[k] = temp[i++];
            }else if (temp[i] > temp[j]){
                arr[k] = temp[j++];
            }else{
                arr[k] = temp[i++];
            }
        }
    }
    //堆排序
    public static void HeapSort(int[] arr){
        //构建大顶堆
        int start = (arr.length-1)>>1;
        for (int i = start; i >= 0; i--){
            MaxHeap(arr, arr.length, i);
        }
        //首尾交换，保持大顶堆性质
        for (int j = arr.length-1; j>0; j--){
            int temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            MaxHeap(arr, j, 0);  //保持大顶堆性质
        }
    }
    public static void MaxHeap(int[] arr, int size, int index){
        int leftNode = index*2+1;
        int rightNode = index*2+2;
        int max = index;
        if (leftNode < size && arr[leftNode] > arr[max]){
            max = leftNode;
        }
        if (rightNode < size && arr[rightNode] > arr[max]){
            max = rightNode;
        }
        if (max != index){
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            MaxHeap(arr, size, max);    //子树也要保持大顶堆性质
        }
    }
}
