import java.util.*;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for (String part : parts) {

            // Ignore empty strings and "."
            if (part.equals("") || part.equals(".")) {
                continue;
            }

            // Go to parent directory
            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } 
            else {
                // Valid directory/file name
                stack.push(part);
            }
        }

        // Build answer
        StringBuilder result = new StringBuilder();

        while (!stack.isEmpty()) {
            result.append("/").append(stack.removeLast());
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}