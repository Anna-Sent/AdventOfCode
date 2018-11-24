package leetcode;

import java.util.HashSet;
import java.util.Set;

class Solution929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        String localName, parts[];
        for (String email : emails) {
            parts = email.split("@");
            localName = parts[0];
            localName = localName.replace(".", "");
            int plusIndex = localName.indexOf('+');
            localName = localName.substring(0, plusIndex);
            email = localName + "@" + parts[1];
            uniqueEmails.add(email);
        }
        return uniqueEmails.size();
    }
}
