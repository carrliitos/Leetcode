class Solution {
    public int romanToInt(String s) {
        int result = 0, current = 0, next = 0;        
        for(int i = 0; i < s.length() - 1; i++){
            current = numeralValue(s.charAt(i));
            next = numeralValue(s.charAt(i + 1));
            if(numeralValue(s.charAt(i)) < numeralValue(s.charAt(i + 1))) {
                result -= current;
            }else {
                result += current;
            }
        }
        return result + numeralValue(s.charAt(s.length() - 1));
    }
    
    private int numeralValue(char c) {
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}