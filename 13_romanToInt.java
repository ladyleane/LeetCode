class Solution {
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
		int num = 0;
		for (int i = 0; i < ch.length - 1; i++){
			if (ch[i] == 'I' && (ch[i + 1] == 'V' || ch[i + 1] == 'X'))
				num -= 2;
			if (ch[i] == 'X' && (ch[i + 1] == 'L' || ch[i + 1] == 'C'))
				num -= 20;
			if (ch[i] == 'C' && (ch[i + 1] == 'D' || ch[i + 1] == 'M'))
				num -= 200;
		}

		for (int i = 0; i < ch.length; i++){
			switch (ch[i]){
				case 'M':{
					num += 1000;
					continue;
				}

				case 'D':{
					num += 500;
					continue;
				}

				case 'C':{
					num += 100;
					continue;
				}

				case 'L':{
					num += 50;
					continue;
				}

				case 'X':{
					num += 10;
					continue;
				}

				case 'V':{
					num += 5;
					continue;
				}

				default:{
					num += 1;
					continue;
				}
			}
		}
		return num;
    }
}
