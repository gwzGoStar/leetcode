package leetcode001_DP.leetcode_diffrenPath.leetcode_062_differentPath01;

//  题目: 不同路径;(没有障碍物)
//  描述: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//        机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//        问总共有多少条不同的路径？
//
//  思路: dp;

public class Solution1 {
    public int uniquePaths(int m, int n) {
        int[][] dp =new int[m][n];
        // 初始化,第一行,第一列都为1(只有一条路径);
        for(int i = 0;i < n;i++) dp[0][i] = dp[0][i] = 1;
        for(int i = 0; i < m;i++) dp[i][0] = dp[i][0] = 1;
        for(int i = 1;i < m; i++){
            for(int j = 1;j < n;j++){
                // 转移方程;dp[i][j] = dp[i][j-1]左边 + dp[i-1][j]上边
                dp[i][j] = dp[i-1][j] +dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
