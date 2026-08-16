class Solution {
    public boolean isNumber(String s) {
        boolean digit = false;
        boolean dot = false;
        boolean exp = false;
        boolean expDigit = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digit = true;

                if (exp) {
                    expDigit = true;
                }
            }
            else if (c == '+' || c == '-') {
                // Sign is valid only at beginning or after e/E
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else if (c == '.') {
                // Dot cannot appear twice or after exponent
                if (dot || exp) {
                    return false;
                }
                dot = true;
            }
            else if (c == 'e' || c == 'E') {
                // e cannot appear twice and must have a number before it
                if (exp || !digit) {
                    return false;
                }

                exp = true;
                expDigit = false;
            }
            else {
                return false;
            }
        }

        return digit && expDigit;
    }
}