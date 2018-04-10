package leetcode;

import java.util.HashSet;
import java.util.Set;

class Solution500 {
    class Solution {
        private final Set<Character> firstRow = new HashSet<Character>() {{
            add(Character.valueOf('q'));
            add(Character.valueOf('Q'));
            add(Character.valueOf('w'));
            add(Character.valueOf('W'));
            add(Character.valueOf('e'));
            add(Character.valueOf('E'));
            add(Character.valueOf('r'));
            add(Character.valueOf('R'));
            add(Character.valueOf('t'));
            add(Character.valueOf('T'));
            add(Character.valueOf('y'));
            add(Character.valueOf('Y'));
            add(Character.valueOf('u'));
            add(Character.valueOf('U'));
            add(Character.valueOf('i'));
            add(Character.valueOf('I'));
            add(Character.valueOf('o'));
            add(Character.valueOf('O'));
            add(Character.valueOf('p'));
            add(Character.valueOf('P'));
        }};
        private final Set<Character> secondRow = new HashSet<Character>() {{
            add(Character.valueOf('a'));
            add(Character.valueOf('A'));
            add(Character.valueOf('s'));
            add(Character.valueOf('S'));
            add(Character.valueOf('d'));
            add(Character.valueOf('D'));
            add(Character.valueOf('f'));
            add(Character.valueOf('F'));
            add(Character.valueOf('g'));
            add(Character.valueOf('G'));
            add(Character.valueOf('h'));
            add(Character.valueOf('H'));
            add(Character.valueOf('j'));
            add(Character.valueOf('J'));
            add(Character.valueOf('k'));
            add(Character.valueOf('K'));
            add(Character.valueOf('l'));
            add(Character.valueOf('L'));
        }};
        private final Set<Character> thirdRow = new HashSet<Character>() {{
            add(Character.valueOf('z'));
            add(Character.valueOf('Z'));
            add(Character.valueOf('x'));
            add(Character.valueOf('X'));
            add(Character.valueOf('c'));
            add(Character.valueOf('C'));
            add(Character.valueOf('v'));
            add(Character.valueOf('V'));
            add(Character.valueOf('b'));
            add(Character.valueOf('B'));
            add(Character.valueOf('n'));
            add(Character.valueOf('N'));
            add(Character.valueOf('m'));
            add(Character.valueOf('M'));
        }};

        public String[] findWords(String[] words) {
            int write = 0;
            for (String word : words) {
                if (containsOnly(word, firstRow)
                        || containsOnly(word, secondRow)
                        || containsOnly(word, thirdRow)) {
                    words[write++] = word;
                }
            }
            String[] result = new String[write];
            System.arraycopy(words, 0, result, 0, write);
            return result;
        }

        private boolean containsOnly(String word, Set<Character> characters) {
            for (int i = 0; i < word.length(); ++i) {
                if (!characters.contains(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
