//Roman numerals are represented by seven different symbols: I, V, X, L, C, D an
//d M. 
//
// 
//Symbol       Value
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// For example, 2 is written as II in Roman numeral, just two one's added togeth
//er. 12 is written as XII, which is simply X + II. The number 27 is written as XX
//VII, which is XX + V + II. 
//
// Roman numerals are usually written largest to smallest from left to right. Ho
//wever, the numeral for four is not IIII. Instead, the number four is written as 
//IV. Because the one is before the five we subtract it making four. The same prin
//ciple applies to the number nine, which is written as IX. There are six instance
//s where subtraction is used: 
//
// 
// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900. 
// 
//
// Given a roman numeral, convert it to an integer. 
//
// 
// Example 1: 
//
// 
//Input: s = "III"
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: s = "IV"
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: s = "IX"
//Output: 9
// 
//
// Example 4: 
//
// 
//Input: s = "LVIII"
//Output: 58
//Explanation: L = 50, V= 5, III = 3.
// 
//
// Example 5: 
//
// 
//Input: s = "MCMXCIV"
//Output: 1994
//Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 15 
// s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M'). 
// It is guaranteed that s is a valid roman numeral in the range [1, 3999]. 
// 
// Related Topics Math String 
// 👍 2824 👎 3860


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<String, Integer> romanIntMap;

    Solution() {
        //Initialize the roman int map
        romanIntMap = new HashMap<String, Integer>();
        romanIntMap.put("I", 1);
        romanIntMap.put("IV", 4);
        romanIntMap.put("V", 5);
        romanIntMap.put("IX", 9);
        romanIntMap.put("X", 10);
        romanIntMap.put("XL", 40);
        romanIntMap.put("L", 50);
        romanIntMap.put("XC", 90);
        romanIntMap.put("C", 100);
        romanIntMap.put("CD", 400);
        romanIntMap.put("D", 500);
        romanIntMap.put("CM", 900);
        romanIntMap.put("M", 1000);
    }

    public int romanToInt(String s) {
        //result to store final num
        int result =0;

        //iterate over entire string
        for(int i=0;i<s.length();i++) {

            if(i<s.length() -1) {
                //if its between first to  second last letter
                char[] twoLetterArray = {s.charAt(i), s.charAt(i+1)};
                String twoLetterString = new String(twoLetterArray);

                if(romanIntMap.containsKey(twoLetterString)) {
                    //checking first for two letters combination key
                    result += romanIntMap.get(twoLetterString);
                    //skipping next letter as it has already been considered
                    i++;
                    continue;
                }
            }
            //consider only the current letter since it didn't hit continue that means it is not a two letter combo
            String singleLetterString = String.valueOf(s.charAt(i));
            result += romanIntMap.get(singleLetterString);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
