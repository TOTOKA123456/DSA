package DSA2;

public class MinHeap {
    private int[] arr;
    public MinHeap(int[] arr) {
        this.arr = arr;
        buildHeap(arr);
    }
    public void buildHeap(int[] arr){
        int start = (arr.length-1)>>1;
        for (int i = start; i >= 0; i--){
            minHeap(arr, arr.length, i);
        }
    }
    public void minHeap(int[] arr, int size, int index){
        int leftNode = index*2+1;
        int rightNode = index*2+2;
        int min = index;
        if (leftNode < size && arr[min] > arr[leftNode]){
            min = leftNode;
        }
        if (rightNode < size && arr[min] > arr[rightNode]){
            min = rightNode;
        }
        if (min != index){
            int temp = arr[index];
            arr[index] = arr[min];
            arr[min] = temp;
            minHeap(arr, size, min);
        }
    }
    public int getRoot(){
        return arr[0];
    }
    public void setRoot(int num){
        arr[0] = num;
        minHeap(arr, arr.length, 0);
    }
}
