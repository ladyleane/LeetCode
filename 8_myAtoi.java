//String to Integer
//好想喝奶茶

class Solution {
    public int myAtoi(String str) {
        if (str == null){
			return 0;
		}
		String temp = str.trim();
		if (temp == "" || temp.length() == 0){
			return 0;
		}

		boolean flag = true;
		char[] bits = temp.toCharArray();
		int i = 0;
		int res = 0;
		int bit = 0;

		if (bits[0] == '-'){
			flag = false;
		}

		if (bits[0] == '+' || bits[0] == '-'){
			i++;
		}

		for (; i < bits.length; i++){
			if (bits[i] >= '0' && bits[i] <= '9'){
				bit = bits[i] - '0';
			}
			else{
				break;
			}

			if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && bit > 7)){
				return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			res = res * 10 + bit;
		}
		return flag ? res : -res;
    }
}
