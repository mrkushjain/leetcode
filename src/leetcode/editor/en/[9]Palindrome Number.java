//Determine whether an integer is a palindrome. An integer is a palindrome when 
//it reads the same backward as forward. 
//
// Follow up: Could you solve it without converting the integer to a string? 
//
// 
// Example 1: 
//
// 
//Input: x = 121
//Output: true
// 
//
// Example 2: 
//
// 
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes
// 121-. Therefore it is not a palindrome.
// 
//
// Example 3: 
//
// 
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
// Example 4: 
//
// 
//Input: x = -101
//Output: false
// 
//
// 
// Constraints: 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics Math 
// 👍 2913 👎 1669


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) {
            //case 1: for all negative numbers, it is not a pallindrome
            return false;
        }
        if(x < 10) {
            //case 2: for single digits from [0,9], it is a pallindrome
            return true;
        }
        if(x%10 == 0) {
            //case 3: for positive numbers ending in 0, it is not a pallindrome
            return false;
        }
        //To avoid a situation where the revert of the number can be out of MAX_INT range, we only revert half the number

        int num = x;
        int halfRevertedNum = 0;
        //since a 3 digit number is always bigger than a 2 digit number, we will check till original number becomes less than or equal to halfRevertedNum
        while(num > halfRevertedNum){
            halfRevertedNum = halfRevertedNum * 10 + num%10;
            num = num / 10;
        }

        //if halfRevertedNum is same as num or in case if there are odd digits in original x , we drop the middle digit from halfRevertedNum and then compare with num
        return (halfRevertedNum == num) || (halfRevertedNum/10 == num);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
