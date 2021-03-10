package dev.ankulikov.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * <p>
 * You may return the answer in any order.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, k = 2
 * Output:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * Example 2:
 * <p>
 * Input: n = 1, k = 1
 * Output: [[1]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 *
 * @see <a href="https://leetcode.com/problems/combinations/"></a>
 */

public class Task77 {

    public List<List<Integer>> combine(int n, int k) {
        final List<List<Integer>> combs = new ArrayList<>();
        combine(combs, new ArrayList<>(k), 1, n, k);
        return combs;
    }

    private void combine(List<List<Integer>> allCombs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            allCombs.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= (n - k) + 1; i++) {
            comb.add(i);
            combine(allCombs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}
