/**
 * @param {number} n
 * @return {number}
 */
var climbStairs = function(n) {
         const dp = new Array(n + 1).fill(-1); 
         dp[0] = 0;
         dp[1] = 1;
         fibonacci(n,dp);
         return dp[dp.length - 1] + dp[dp.length -2];
};
function fibonacci(n, dp) {
  if (n <= 1) return n;
  if (dp[n] !== -1) {
    return dp[n]; 
  }
  return (dp[n] = fibonacci(n - 1, dp) + fibonacci(n - 2, dp));
}