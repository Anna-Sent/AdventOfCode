package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution274 {
    public int hIndex(int[] citations) {
        int N = citations.length;
        List<Map.Entry<Integer, Integer>> papers = new ArrayList<>();
        for (int i = 0; i < N; ++i) {
            final int key = i;
            papers.add(new Map.Entry<Integer, Integer>() {
                @Override
                public Integer getKey() {
                    return key;
                }

                @Override
                public Integer getValue() {
                    return citations[key];
                }

                @Override
                public Integer setValue(Integer value) {
                    throw new UnsupportedOperationException();
                }
            });
        }
        papers.sort(Map.Entry.comparingByValue());
        for (int i = N; i >= 1; --i) {
            boolean accepted = true;
            for (int j = i; j >= 1; --j) {
                if (papers.get(N - j).getValue() < i) {
                    accepted = false;
                }
            }
            if (accepted) {
                return i;
            }
        }
        return 0;
    }
}
