package leetcode;

import java.util.*;

public class Solution49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String s : strs) {
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                String key = String.valueOf(chars);
                List<String> value = map.get(key);
                if (value == null) {
                    List<String> list = new ArrayList();
                    list.add(s);
                    map.put(key, list);
                } else {
                    value.add(s);
                }
            }
            List<List<String>> result = new ArrayList();
            result.addAll(map.values());
            return result;
        }
    }
}
