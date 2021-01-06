//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// Example 4: 
//
// 
//Input: s = "([)]"
//Output: false
// 
//
// Example 5: 
//
// 
//Input: s = "{[]}"
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 6400 👎 263


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        //Initialize braces map
        Map<Character, Character> closingBracesMap = new HashMap<Character, Character>();
        closingBracesMap.put(')', '(');
        closingBracesMap.put('}', '{');
        closingBracesMap.put(']', '[');

        Stack stack = new Stack();

        for(char c: s.toCharArray()){
            if(!closingBracesMap.containsKey(c)){
                //it is an opening brace
                stack.push(c);
            } else {
                //it is a closing brace
                if(stack.isEmpty()){
                    //closing brace without opening brace
                    return false;
                }
                if(stack.peek() != closingBracesMap.get(c)){
                    //opening braces for current char does not match stack top
                    return false;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            //opening braces still remain
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
