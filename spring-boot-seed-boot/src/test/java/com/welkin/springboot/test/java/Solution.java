package com.welkin.springboot.test.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null)
            return result;
        Arrays.parallelSort(candidates);
        return combinationSum(candidates, target, 0);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] < target) {
                for (List<Integer> list : combinationSum(candidates, target - candidates[i], i)) {
                    list.add(0, candidates[i]);
                    result.add(list);
                }
            } else if (candidates[i] == target) {
                List<Integer> res = new ArrayList<>();
                res.add(candidates[i]);
                result.add(res);
            } else {
                break;
            }
        }
        return result;
    }
}
