package leetcode_008_StringToNum;

//  题目:  字符串转换为整数;
//  描述： 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
//
//首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
//
//      如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
//        假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
//         该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
//注意： 假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，
//          则你的函数不需要进行转换，即无法进行有效转换。
//      在任何情况下，若函数不能进行有效的转换时，请返回 0 。
// 提示：
//      本题中的空白字符只包括空格字符 ' ' 。
//        假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
//       如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
//
//  思路：
public class Solution1 {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;

        int res = 0; // 保存结果；
//        for (int i = 0; i < s.length(); i++) {} 此题不好用 for 循环遍历整个字符串，因为可能只有一部分，
//        当开始将中间某一串字符转换为数字，当停止转换（某一位置开始不为数字了）不能终止；
        char[] ch = s.toCharArray();
        int i = 0;   // 下标；
        // 去除前面空格；
        while(i<ch.length && ch[i] == ' ') {
                i++;
        }
        // 检查”    “空串情况
        if(i == s.length() -1) return 0;
        // 判断正负；
        boolean flag = false; // 正负，符号标志；
        if (ch[i] == '-') {
            flag = true;
            i++;
        } else if (ch[i] == '+') {
            i++;
        }else if(!Character.isDigit(ch[i])){
            return 0;
        }
        // 循环将中间某一正规数字字符串求出；
        while (i < s.length() && ch[i] - '0' >= 0 && ch[i] - '0' <= 9) {
            int num = ch[i] - '0';
            if (!flag && (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)))
                return Integer.MAX_VALUE;
            if (flag && (res < Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num == 9)))
                return Integer.MIN_VALUE;
            res = res * 10 + num;
            i++;
        }
        // 根据符号输出相应的值；
        return flag? -1*res : res;
    }
}
