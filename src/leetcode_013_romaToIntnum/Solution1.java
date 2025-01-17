package leetcode_013_romaToIntnum;

//     题目: 罗马数字转阿拉伯数字;
//     描述: 与leetcode_012 相互反转;
//           罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
//
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000
//例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
//
//通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
//
//I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
//X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
//C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
//给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

//  思路:  遍历字符串,判断当前字符和下一个字符大小关系,小于下一个字符,
//            则结果 res- 当前对应的数字(HashMap或者本题的Switch方法);
//               大于下一个字符,直接 res + 字符对应的数字;

//   注意: 该题只能遍历添加到倒数第二个,要不然会出界,所以最后要把最后一个字符对应的数字添加进去;

public class Solution1 {
    public int romanToInt(String s) {
        if(s == null) return 0;
        int res =0;
        for(int i = 0;i < s.length()-1;i++){
            if(check(s.charAt(i)) < check(s.charAt(i+1))){
                res -= check(s.charAt(i));
            }else{
                res +=check(s.charAt(i));
            }
        }
        // 添加最后一个字符对应的数字;
        res +=check( s.charAt(s.length()-1) );
        return res;
    }

    public int check(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
