package 算法思想;

import java.util.ArrayList;
import java.util.Arrays;

public class 排列组合 {
    public static void main(String[] args) {
        String[] arr = {"a","b","c","d"};
        arrangementSelect(arr, 2);
        System.out.println();
        combinationSelect(arr, 2);
    }

    //阶乘
    public static long factorial(int n){
        long sum = 1;
        while (n > 0){
            sum = sum * n;
            n--;
        }
        return sum;
    }

    //排列 数量
    public static long arrangement(int m, int n){
        return m <= n ? factorial(n)/factorial(n-m) : 0;
    }

    //组合 数量
    public static long combination(int m, int n){
        return m <= n ? factorial(n)/(factorial(m) * factorial(n-m)) : 0;
    }

    //有时候，我们不仅需要知道排列或组合的数量，而且需要知道有哪些排列或组合
    //排列
    public static void arrangementSelect(String[] dataList, int n){
        System.out.println(String.format("A(%d, %d) = %d", dataList.length, n, arrangement(n, dataList.length)));
        arrangementSelect(dataList, new String[n], 0);
    }
    public static void arrangementSelect(String[] dataList, String[] resultList, int resultIndex){
        int resultLen = resultList.length;
        if(resultIndex >= resultLen){     // 全部选择完时，输出排列结果
            System.out.println(Arrays.asList(resultList));
            return;
        }
        for(int i = 0; i < dataList.length; i++){  // 递归选择下一个
            boolean exists = false;     // 判断待选项是否存在于排列结果中
            for (int j = 0; j < resultIndex; j++){
                if (dataList[i].equals(resultList[j])){
                    exists = true;
                    break;
                }
            }
            if (!exists){
                resultList[resultIndex] = dataList[i];
                arrangementSelect(dataList, resultList, resultIndex+1);
            }
        }
    }

    //组合
    public static void combinationSelect(String[] dataList, int n){
        System.out.println(String.format("C(%d, %d) = %d", dataList.length, n, combination(n, dataList.length)));
        combinationSelect(dataList,0, new String[n], 0);
    }
    public static void combinationSelect(String[] dataList, int dataIndex, String[] resultList, int resultIndex){
        int reslutLen = resultList.length;
        int resultCount = resultIndex + 1;
        if (resultCount > reslutLen){
            System.out.println(Arrays.asList(resultList));
            return;
        }
        for (int i = dataIndex; i < dataList.length + resultCount - reslutLen; i++){
            resultList[resultIndex] = dataList[i];
            combinationSelect(dataList, i+1, resultList, resultIndex+1);
        }
    }
}
