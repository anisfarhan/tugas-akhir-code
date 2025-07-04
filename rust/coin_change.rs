use std::io;

fn coin_change(coins: &[i32], amount: usize) -> i32 {
    let mut dp = vec![i32::MAX; amount + 1];
    dp[0] = 0;
    for i in 1..=amount {
        for &coin in coins {
            if (i as i32) - coin >= 0 && dp[i - coin as usize] != i32::MAX {
                dp[i] = dp[i].min(dp[i - coin as usize] + 1);
            }
        }
    }
    if dp[amount] == i32::MAX {
        -1
    } else {
        dp[amount]
    }
}

fn main() {
    let mut input = String::new();

    println!("Enter the number of different coins: ");
    io::stdin().read_line(&mut input).unwrap();
    let n: usize = input.trim().parse().unwrap();

    println!("Enter the coin values: ");
    input.clear();
    io::stdin().read_line(&mut input).unwrap();
    let coins: Vec<i32> = input
        .trim()
        .split_whitespace()
        .map(|x| x.parse().unwrap())
        .collect();

    println!("Enter the target amount: ");
    input.clear();
    io::stdin().read_line(&mut input).unwrap();
    let amount: usize = input.trim().parse().unwrap();

    let result = coin_change(&coins, amount);
    if result != -1 {
        println!("Minimum number of coins required: {}", result);
    } else {
        println!("Not possible to form the amount.");
    }
}