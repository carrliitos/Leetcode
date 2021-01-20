class Solution {
    public String defangIPaddr(String address) {
        /* Logic:
        *   All we're really doing is taking each perion and enclosing them with brackets
        *   Example:
        *       Input: address = "1.1.1.1"
        *       Output: "1[.]1[.]1[.]1"
        *   We just need to iterate through the given IP address and everytime we see a period,
        *   we ajust need to make sure that we replace it with the brackets.
        *   And then to make sure that it is a valid IP, we need to make sure that we only have 4 digits
        */
        // First thing, we want a StringBuilder because in Java strings are really expensive to build
        StringBuilder result = new StringBuilder();
        // We start to iterate through our IP address
        for(int i = 0; i < address.length(); i++) {
            // We just get the character we are currently on
            char current = address.charAt(i);
            // We check for the period, if so, we need to make sure that we append the [] to our result
            if(current == '.') result.append("[.]");
            // if not, then we simply append the digit we are currently on to the result
            else result.append(current);
        }
        // then we just return our result as a string
        return result.toString();
    }
}

/* Runtime: O(n)
*   - We're running through all the characters in our address
*  Space complexity: O(n)
*   - We're simply building a new string that will eventually hold n characters + a few chracters to include periods
*/