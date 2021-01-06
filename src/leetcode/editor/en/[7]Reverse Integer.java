//Given a 32-bit signed integer, reverse digits of an integer. 
//
// Note: 
//Assume we are dealing with an environment that could only store integers withi
//n the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this prob
//lem, assume that your function returns 0 when the reversed integer overflows. 
//
// 
// Example 1: 
// Input: x = 123
//Output: 321
// Example 2: 
// Input: x = -123
//Output: -321
// Example 3: 
// Input: x = 120
//Output: 21
// Example 4: 
// Input: x = 0
//Output: 0
// 
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 4157 👎 6442


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int newNum = 0;
        int absoluteX = Math.abs(x);
        while(absoluteX > 0) {
            if(newNum>(Integer.MAX_VALUE-absoluteX%10)/10){
                return 0;
            }
            newNum = newNum * 10 + absoluteX%10;
            absoluteX = absoluteX/10;
        }
        if(x<0){
            return -newNum;
        }
        return newNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
