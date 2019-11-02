//%5 = 4
//Brute Force

class Solution {
    public String intToRoman(int num) {
        	String[] Ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
			String[] Tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
			String[] Hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
			String[] Thousands = {"", "M", "MM", "MMM"};

			String ans = Thousands[num / 1000] + Hundreds[num  % 1000 / 100] + Tens[num % 100 / 10] + Ones[num % 10];
			return ans;
    }
}
