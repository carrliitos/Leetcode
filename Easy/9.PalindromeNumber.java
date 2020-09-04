/* Problem: Determine whether an integer is a palindrome. 
*      An integer is a palindrome when it reads the same backward as forward.
*/

class Solution {
    public boolean isPalindrome(int x) {
        /* Logic: 
        *   Compare a reversed integer to the original integer
        */
        
        /* Numbers less than 0 are automatically false since -121 and 121- returns false */
        if(x < 0) return false;
        int reversed = 0;
        int original = x; // temporary var to store the original int
        
        while(x != 0) {
            reversed = (reversed * 10) + (x % 10);
            x /= 10;
        }
        
        // If the original is equal to the reversed -- we've achieved palindrome
        return original == reversed;
    }
}