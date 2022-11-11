/*

https://leetcode.com/problems/combination-sum/

Ques_39------>>>>>>>>
                    Given an array of distinct integers candidates and a target integer target,
                    return a list of all unique combinations of candidates where the chosen numbers sum to target.
                    You may return the combinations in any order.

                    The same number may be chosen from candidates an unlimited number of times.
                    Two combinations are unique if the frequency of at least one of the chosen numbers is different.

                    The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


Example 1:----->>>>>
                Input: candidates = [2,3,6,7], target = 7
                Output: [[2,2,3],[7]]
                Explanation:----->>>>>
                                2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
                                7 is a candidate, and 7 = 7.
                                These are the only two combinations.

Example 2:----->>>>>
                Input: candidates = [2,3,5], target = 8
                Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:----->>>>>
                Input: candidates = [2], target = 1
                Output: []

 */
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;

        System.out.println(combinationSum(candidates, target));

    }
    private static void Combinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            Combinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        Combinations(ind + 1, arr, target, ans, ds);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Combinations(0, candidates, target, ans, new ArrayList<>());
        return ans;

    }
}
