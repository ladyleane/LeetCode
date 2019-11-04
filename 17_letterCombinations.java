//Brute Force

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
			checkLetter("", digits);
		return output;
    }

	Map<String, String> numLetter = new HashMap<String, String>(){{
		put("2", "abc");
		put("3", "def");
		put("4", "ghi");
		put("5", "jkl");
		put("6", "mno");
		put("7", "pqrs");
		put("8", "tuv");
		put("9", "wxyz");
	}};

	List<String> output = new ArrayList<String>();

	public void checkLetter(String combination, String next_digits){
		if (next_digits.length() == 0) {
			output.add(combination);
		}
		else{
			String digit = next_digits.substring(0, 1);
			String letters = numLetter.get(digit);
			for (int i = 0; i < letters.length(); i++){
				String letter = numLetter.get(digit).substring(i, i + 1);
				checkLetter(combination + letter, next_digits.substring(1));
			}
		}
	}

}
