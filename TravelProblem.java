package 算法思想;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TravelProblem {
    double s = 0;                 //总距离值
    private int citynumbers = 10; //城市数目
    private double[][] distance;  //距离矩阵，距离为欧式空间距离
    int[] visited;                //确定是否访问过
    int[] path;                   //存放路径，路径的值从1开始

    public static void main(String[] args) throws IOException{
        long a = System.currentTimeMillis();
        TravelProblem tsp = new TravelProblem();
        tsp.readData("D://TSP10cities.tsp");
        tsp.solve();
        tsp.print();
        long b = System.currentTimeMillis();
        long c = b-a;
        System.out.println("运行时间："+c);
    }
    //读取10个城市的坐标数据，并计算distance矩阵
    public void readData(String filename) throws IOException{
        int[] x = new int[citynumbers];
        int[] y = new int[citynumbers];
        distance = new double[citynumbers][citynumbers];
        String a;
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        for (int i = 0; i < citynumbers; i++){
            a = in.readLine();
            String[] b = a.split(" ");
            x[i] = Integer.valueOf(b[1]);
            y[i] = Integer.valueOf(b[2]);
        }
        in.close();
        for (int i = 0; i < citynumbers; i++){
            for (int j = 0; j < citynumbers; j++){
                distance[i][j] = Math.sqrt((x[i]-x[j])*(x[i]-x[j])+(y[i]-y[j])*(y[i]-y[j]));
            }
        }
    }
    //贪心法解决问题
    public void solve(){
        visited = new int[citynumbers];     //是否访问过
        path = new int[citynumbers];        //访问路径
        for (int i = 0; i < citynumbers; i++){
            visited[i] = 0;
        }
        path[0] = 1;
        visited[0] = 1;
        int k = 0;         //当前访问城市
        int next = k+1;    //下一个访问城市
        double min = Double.MAX_VALUE;
        int count = 1;     //已访问计数
        while (count < citynumbers){
            for (int j = 0; j < citynumbers; j++){   //遍历未访问过的城市，选择距离最短的
                if (visited[j] == 0){
                    if (distance[k][j] < min){
                        min = distance[k][j];
                        next = j;    //将j标记为下一个城市
                    }
                }
            }
            s += min;                //总距离
            path[count] = next + 1;  //记录路径
            visited[next] = 1;       //访问标记
            k = next;
            count++;
            min = Double.MAX_VALUE;
            next = k+1;
        }
    }

    public void print(){
        s = s + distance[path[citynumbers-1]-1][0];
        for (int i = 0; i < citynumbers; i++){
            System.out.print(path[i] + " ");
        }
        System.out.println(path[0]);
        System.out.println(s);
    }
}

/**
 1 2066 2333
 2 935 1304
 3 1270 200
 4 1389 700
 5 984 2810
 6 2253 478
 7 949 3025
 8 87 2483
 9 3094 1883
 10 2706 3130
 */
