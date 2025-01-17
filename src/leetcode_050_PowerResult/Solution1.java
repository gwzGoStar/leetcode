package leetcode_050_PowerResult;

//   题目: pow(x,n);
//   描述: 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
// 示例 1:
//          输入: 2.00000, 10
//          输出: 1024.00000

public class Solution1 {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n < 0){
            n = -n;
            x = 1/x;
        }
        double res = 1;
        for(int i=n;i != 0;i=i/2){
            if(i%2 != 0){
                res *= x;
            }
            x *=x;
        }
        return res;
    }
}
