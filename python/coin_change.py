def coin_change(coins, amount):
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0
    for i in range(1, amount + 1):
        for coin in coins:
            if i - coin >= 0 and dp[i - coin] != float('inf'):
                dp[i] = min(dp[i], dp[i - coin] + 1)
    return -1 if dp[amount] == float('inf') else dp[amount]

if __name__ == "__main__":
    n = int(input("Enter the number of different coins: "))
    coins = list(map(int, input("Enter the coin values: ").split()))
    if len(coins) != n:
        coins = [int(input()) for _ in range(n)]
    amount = int(input("Enter the target amount: "))
    result = coin_change(coins, amount)
    if result != -1:
        print(f"Minimum number of coins required: {result}")
    else:
        print("Not possible to form the amount.")