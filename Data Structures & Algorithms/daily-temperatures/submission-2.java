class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }   else {
                Integer cur = temperatures[i];
                while (!stack.isEmpty()) {
                    Integer idx = stack.peek();
                    Integer top = temperatures[idx];
                    if (cur > top) {
                        stack.pop();
                        result[idx] = i - idx;
                    }   else {
                        stack.push(i);
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    stack.push(i);
                }
            }
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }

        return result;
    }
}
