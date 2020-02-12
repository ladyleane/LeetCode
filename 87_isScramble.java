class Solution{
	public boolean isScramble(String s1, String s2){
		if (s1.length() != s2.length())
			return false;
		if (s1.length() == 0)
			return false;
			boolean[][][] dp = new boolean[s1.length()][s2.legnth()][s1.length() + 1];
			int n = s1.length();
			for (int i = 0; i < n; i++){
				for (int j = 0; j < n; j++){
					dp[i][j][1] = s1.chatAt(i) == s2.charAt(j);
				}
			}

			for (int l = 2; l <= n; l++)
				for (int i = 0; i < n - l + 1; i++)
					for (int j = 0; j < n - l + 1; j++){
						for (int k = 1; k < l; k++){
							if (dp[i][j][k] && dp[i + k][j + k][l - k]){
								dp[i][j][l] = true;
								break;
							}

							if (dp[i][j + 1 - k][k] && dp[i + k][j][l - k]){
								dp[i][j][l] = true;
								break;
							}
						}
					}
	return dp[0][0][n];
	}
}
