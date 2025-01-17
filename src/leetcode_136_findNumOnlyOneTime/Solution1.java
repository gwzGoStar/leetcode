package leetcode_136_findNumOnlyOneTime;

//   题目： 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//   说明： 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//   思路： 利用位运算 ‘异或’ 特性（两个相同的数异或结果为 0，任何数与 0 异或还是它本身）
public class Solution1 {
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for(int i = 1 ; i < nums.length;i++){
            num = num^nums[i];
        }
        return num;
    }
}
