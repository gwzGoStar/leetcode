package leetcode_581_findUnsortedSubArray;

//  题目: 寻找最短无序连续子序列;
//  描述: 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
//
//          你找到的子数组应是最短的，请输出它的长度。
// 示例 1:
//          输入: [2, 6, 4, 8, 10, 9, 15]
//          输出: 5
//          解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
//   思路一:
//           暴力解法;
//             两层循环,寻找左边界和右边界; 外层遍历数组每个元素,内层遍历从该元素到最后元素不符合条件的位置(左边元素大于右边)
//                每遍历一次,更新边界值,右边界r为最大值;左边界l为最小值;

public class Solution {
    public int findUnsortedSubarray(int[] nums){
        int  l =nums.length, r =0;
        for(int i = 0;i< nums.length-1;i++){
            for(int j = i+1 ;j< nums.length;j++){
                if(nums[i]>nums[j]){
                    l = Math.min(l,i); // 这里求左边界,要比较i
                    r = Math.max(r,j); // 这里更新右边界,比较j;
                }
            }
        }
        return r-l<0?0:r-l+1;
    }

    // 排序版本;
//    public int findUnsortedSubarray(int[] nums) {
//        int[] snums = nums.clone();
//        Arrays.sort(snums);
//        int start = snums.length, end = 0;
//        for (int i = 0; i < snums.length; i++) {
//            if (snums[i] != nums[i]) {
//                start = Math.min(start, i);
//                end = Math.max(end, i);
//            }
//        }
//        return (end - start >= 0 ? end - start + 1 : 0);
//    }
}
