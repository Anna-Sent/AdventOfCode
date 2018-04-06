class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.endsWith("f") || s.endsWith("F") || s.endsWith("d") || s.endsWith("D")) {
            return false;
        }
        try {
            double d = Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
