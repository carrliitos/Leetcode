class Solution {
    public int balancedStringSplit(String s) {
        /* Logic:
        *   - We're given some string containing "L" and "R" characters, we're basically asked to return the maximum
        *   amount of balanced strings. And balanced strings are defined as any string, or substring, "who have equal 
        *   quantity of 'L' and 'R' characters".
        *   - Basically, if our input is: 'RLRRLLRLRL', our output is: 4. Because we can break down our input as
        *   'RL' == balanced substring, 'RRLL' == balanced substring, 'RL' == balanced substring, and 'RL' == balanced
        *   substring, which comes out to 4 balanced substrings.
        *
        *   - This is a greedy approach to the problem because we're asked to return the maximum amount of stuff we 
        *   could have. So, we're "greedily" trying to create balanced strings.
        *   - We need a number to return the max number of balanced substrings, and a count to count the individual
        *   strings we're going through.
        */
        
        // create/initialize our return variable
        int balancedCount = 0;
        // create/initialize the count
        int count = 0;
        // we start walking our String s
        for(int i = 0; i < s.length(); i++) {
            // get the first character that we are one
            char current = s.charAt(i);
            /* Do something to account for the logic of counting however many L's and R's there are.
            *   For this case, we make L positive and R negative -- so if we ever see an L, we increment our
            *   count, and if we see R, we decrement our count. If we ever get to a point where our count == 0,
            *   then we've found a balanced string, and count it.
            */
            if(current == 'L') count++;
            else if(current == 'R') count--;
            
            if(count == 0) balancedCount++;
        }
        // return the balancedCount
        return balancedCount;
    }
}

/* Runtime: O(n)
*   - Obvious that we have O(n) runtime, where n = # of characters in our string s
*   - we have one loop, which will go through our entire string once
*
*  Space complexity: O(1)
*   - we're only declaring a couple of variables that will increment and decrement
*/