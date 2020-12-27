package leetcode.solution8;

import java.util.HashSet;
import java.util.Set;

class Solution804 {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            final String[] alphabet = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            Set<String> transformations = new HashSet<>();
            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < word.length(); ++i) {
                    char ch = word.charAt(i);
                    sb.append(alphabet[(int) (ch - 'a')]);
                }
                String transformation = sb.toString();
                transformations.add(transformation);
            }
            return transformations.size();
        }
    }
}
