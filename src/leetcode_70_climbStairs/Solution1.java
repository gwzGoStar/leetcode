package leetcode_70_climbStairs;

//   题目：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
//        每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
//       注意：给定 n 是一个正整数。

public class Solution1 {
    public int climbStairs(int n){
        if(n <= 2) return n;
        int prePre = 1,  pre= 2;
        for(int i = 0; i < n -2;i++){
            int temp = prePre;
            prePre = prePre + pre;
            pre = temp;
        }
        return prePre;
    }
}
