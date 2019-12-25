package test;

import java.util.*;

public class TestSubsets {

    public static void main(String[] args) {
        System.out.println(subsets1(Arrays.asList("a", "b", "c")));
        System.out.println(subsets2(Arrays.asList("a", "b", "c")));
    }

    private static Set<Set<String>> subsets1(List<String> set) {
        Set<Set<String>> result = new HashSet<>();
        int n = set.size();
        for (int i = 0; i < (1 << n); ++i) {
            Set<String> subset = new HashSet<>();
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) > 0) {
                    subset.add(set.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }

    private static List<List<String>> subsets2(List<String> set) {
        List<List<String>> result = new ArrayList<>();
        int n = set.size();
        for (int i = 0; i < (1 << n); ++i) {
            List<String> subset = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                if ((i & (1 << j)) > 0) {
                    subset.add(set.get(j));
                }
            }
            result.add(subset);
        }
        return result;
    }
}
