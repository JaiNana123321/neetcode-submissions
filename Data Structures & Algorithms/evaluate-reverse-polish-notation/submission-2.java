class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> valStack = new ArrayDeque<>();
        for(String s: tokens){
            if(s.equals("+")){
                valStack.push(valStack.pop() + valStack.pop());
            }else if(s.equals("-")){
                valStack.push(-valStack.pop() + valStack.pop());
            }else if (s.equals("*")){
                valStack.push(valStack.pop() * valStack.pop());
            }else if (s.equals("/")){
                int b = valStack.pop();
                int a = valStack.pop();
                valStack.push(a/b);
            }else{
                valStack.push(Integer.parseInt(s));
            }
        }
        return valStack.pop();
    }
}
