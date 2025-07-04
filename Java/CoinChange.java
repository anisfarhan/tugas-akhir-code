import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    
    // time complexity: O(n * amount)
    // space complexity: O(amount)
    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number of different coins: ");
        int n = sc.nextInt();
        
        int[] coins = new int[n];
        System.out.println("Enter the coin values: ");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        
        System.out.println("Enter the target amount: ");
        int amount = sc.nextInt();

        int result = coinChange(coins, amount);
        if (result != -1) {
            System.out.println("Minimum number of coins required: " + result);
        } else {
            System.out.println("Not possible to form the amount.");
        }
        
        sc.close();
    }
}
