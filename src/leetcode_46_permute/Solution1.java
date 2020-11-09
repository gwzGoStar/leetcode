package leetcode_46_permute;

//      给定一个 没有重复 数字的序列，返回其所有可能的全排列。

//

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    public List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    void dfs(int [] nums, int len,int depth,List<Integer> path,boolean[] used,List<List<Integer>> list){
        if(depth == len) {
            list.add(new ArrayList<Integer>(path));
            return ;
        }
        for(int i = 0;i < len ; i++) {
            used[depth] = true;
            path.add(nums[depth]);
            dfs(nums, len,depth + 1,path,used,list);
            used[depth] = false;
            path.remove(path.size()-1);
        }
    }
}
