package com.peter.dailyCodingProblem;

import java.util.ArrayList;
import java.util.List;

/*
The power set of a set is the set of all its subsets. Write a function that, given a set, generates its power set.

For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.

You may also use a list or array to represent a set.
*/
public class Problem37 {
    public static void main(String[] args) {
        int[] set = {1, 2, 3};
        List<List<Integer>> powerSet = getPowerSet(set);
        System.out.println(powerSet);//should return {{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}} if sorted
    }

    private static List<List<Integer>> getPowerSet(int[] set) {//if we do not care about order
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());//added: []
        for (int num : set) {  // ①从数组中取出每个元素
            int size = res.size(); //1 -> 2 ->4
            for (int i = 0; i < size; i++) {
                List<Integer> temp = new ArrayList<>(res.get(i));  // ②逐一取出中间结果集
                temp.add(num);  // ③将 num 放入中间结果集
                res.add(temp);  // ④加入到结果集中
            }
        }
        return res;
    }
    //                 1 -> 2 ------->  4
    //Analyze:  [[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]
}
