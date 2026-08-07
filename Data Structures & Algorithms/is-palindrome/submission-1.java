class Solution {

    private boolean isValid(char c){
        if(Character.isLetter(c) || Character.isDigit(c))
            return true;
        return false;
    }

    public boolean isPalindrome(String s) {
        if(s.length() == 0) return true;
        int first = 0;
        int last = s.length() - 1;
        while(first < last){
            char cFirst = Character.toLowerCase(s.charAt(first));
            char cLast = Character.toLowerCase(s.charAt(last));
            if(!isValid(cFirst))
                first++;
            else if (!isValid(cLast))
                last--;
            else{
                if(cFirst != cLast)
                    return false;
                first++;
                last--;
            }
        }
        return true;
    }
}
