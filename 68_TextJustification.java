class Solution{
	public List<String> fullJustify(String[] words, int maxWidth){
		List<String> ans = new ArrayList<>();
		int currentLen = 0;
		List<String> row = new ArrayList<>();

		for (int i = 0; i < words.length;){
			if (currentLen == 0 && currentLen + words[i].length() <= maxWidth
			|| currentLen > 0 && currentLen + 1 + words[i].length() <= maxWidth){
				row.add(words[i]);
				if (currentLen == 0){
					currentLen = currentLen + words[i].length();
				} else {
					currentLen = currentLen + 1 + words[i].length();
				}
				i++;
			} else{
				int sub = maxWidth - currentLen + row.size() - 1;
				if (row.size() == 1){
					String blank = getStringBlank(sub);
					ans.add(row.get(0) + blank);
				} else {
					StringBuilder temp = new StringBuilder();
					temp.append(row.get(0));
					int averageBlank = sub / (row.size() - 1);
					int missing = sub - averageBlank * (row.size() - 1);
					String blank = getStringBlank(averageBlank + 1);
					int k = 1;
					for (int j = 0; j < missing; j++){
						temp.append(blank + row.get(k));
						k++;
					}
					blank = getStringBlank(averageBlank);
					for(; k < row.size(); k++){
						temp.append(blank + row.get(k));
					}
					ans.add(temp.toString());
				}
				row = new ArrayList<>();
				currentLen = 0;
			}
		}

		StringBuilder temp = new StringBuilder();
		temp.append(row.get(0));
		for (int i = 1; i < row.size(); i++){
			temp.append(" " + row.get(i));
		}

		temp.append(getStringBlank(maxWidth - currentLen));
		ans.add(temp.toString());
		return ans;
	}

	private String getStringBlank(int n){
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < n; i++){
			str.append(" ");
		}
		return str.toString();
	}

}
