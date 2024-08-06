//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
class WildCardMatching {
    public boolean isMatch(String s, String p) { 
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0] = true;

        for(int j = 1; j <= n; j++) {
            char pChar = p.charAt(j-1);
            if(pChar == '*') {
                dp[0][j] = dp[0][j-1];
            }
        }

        for(int i = 1; i <=m; i++) {
            for(int j = 1; j <=n ; j++) {
                char pChar = p.charAt(j-1);
                if(pChar == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else {
                    if(pChar == '?' || pChar == s.charAt(i-1)) {
                        dp[i][j] = dp[i-1][j-1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }
}