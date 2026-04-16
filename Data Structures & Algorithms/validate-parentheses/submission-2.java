class Solution {
    private boolean isCloseBracket(char c) {
        return (c == ')' || c == '}' || c == ']');
    }
    public boolean isValid(String s) {
        if (s.length() % 2 == 1)    return false;
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (!stack.isEmpty() && isCloseBracket(c)) {
                Character cur = stack.peek();
                if (cur == '(' && c == ')'  ||
                    cur == '[' && c == ']'  ||
                    cur == '{' && c == '}') 
                    stack.pop();
                else return false;
            }   else if (isCloseBracket(c)) {
                return false;
            }   else stack.push(c);
        }
        return stack.isEmpty();
    }
}
