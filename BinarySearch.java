package DSA2;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,5,7,7,9};  //排好序
        int target = 3;
        int res = BinarySearch(arr, target);
        System.out.println(res);
        int left = getLeft(arr, target);
        System.out.println(left);
        int right = getRight(arr, target);
        System.out.println(right);
    }
    //二分查找，从中间开始
    public static int BinarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int mid = (left + right)>>1;
        while (left < right){
            if (arr[mid] == target){
                return mid;
            }else if (arr[mid] > target){
                left = mid+1;
            }else{
                right = mid-1;
            }
            mid = (left + right)>>1;
        }
        return -1;
    }
    //最左边出现的位置
    public static int getLeft(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int mid = (left + right)>>1;
        while (left <= right){
            if (arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            mid = (left + right)>>1;
        }
        return left;
    }
    //最右边出现的位置
    public static int getRight(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        int mid = (left + right)>>1;
        while (left <= right){
            if (arr[mid] > target){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            mid = (left + right)>>1;
        }
        return right;
    }
}
