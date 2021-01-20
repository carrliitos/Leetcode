class Solution {
    public String addStrings(String num1, String num2) {
        /* Logic:
        *   - Similar to the "add binary" problem.
        *   - We just need to think about the process of addition, and how we add two numbers in the real world.
        *   - We start at the 1's place, then 10's place, then 100's, etc.
        */
        
        // declare/initialize our return value
        StringBuilder result = new StringBuilder();
        // we create 2 pointers to start at the ends of each respective numbers to make sure we add the correct values
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        // Keep track of our carry
        int carry = 0;
        // loop to keep continuing while either numbers >= 0, because that means we have a number to process
        while(i >= 0 || j >= 0) {
            // get the sum of the two columns we're looking at -- index[i] in num1, index[j] in num2
            int sum = carry;
            // edge case -- what if one number is longer in length than the other? we do a quick check in i and j
            if(i >= 0) sum += num1.charAt(i--) - '0'; // this will convert the values into ASCII
            if(j >= 0) sum += num2.charAt(j--) - '0';
            // we take whatever the results in sum, and put it in our StringBuilder result, accounting for that carry
            result.append(sum % 10);
            carry = sum / 10;
        }
        // return result accounting for the most significant digit slot resulted in a carry, and add that carry to our
        // result
        if(carry != 0) result.append(carry);
        
        return result.reverse().toString(); // we appended everything to our result, which means they're all at the back
                                            // and we need to reverse our string to get the correct result
    }
}

/* Runtime: O(n + m), where n = num1.length, m = num2.length
*   - while-loop goes through all of num1 and all of num2
* Space Complexity: max(O(n), O(m))
*   - we're creating a StringBuilder which can be at most whatever the size of n or m plus 1, if we have that carry
*/