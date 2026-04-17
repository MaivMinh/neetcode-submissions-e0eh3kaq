class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            }   else {
                while (!stack.isEmpty())    {
                    Integer top = stack.peek();
                    Integer cur = temperatures[i];
                    if (temperatures[top] < cur) {
                        int dif = i - top;
                        result[top] = dif;
                        stack.pop();
                    }   else {
                        stack.push(i);
                        break;
                    }
                }
                if (stack.isEmpty())    stack.push(i);
            }
        }

        while (!stack.isEmpty())    {
            Integer top = stack.pop();
            result[top] = 0;
        }

        return result;
    }
}
