<?php
function coinChange($coins, $amount) {
    $dp = array_fill(0, $amount + 1, PHP_INT_MAX);
    $dp[0] = 0;

    for ($i = 1; $i <= $amount; $i++) {
        foreach ($coins as $coin) {
            if ($i - $coin >= 0 && $dp[$i - $coin] != PHP_INT_MAX) {
                $dp[$i] = min($dp[$i], $dp[$i - $coin] + 1);
            }
        }
    }

    return $dp[$amount] == PHP_INT_MAX ? -1 : $dp[$amount];
}

echo "Enter the number of different coins: ";
$n = intval(trim(fgets(STDIN)));

echo "Enter the coin values: ";
$coins = array_map('intval', explode(' ', trim(fgets(STDIN))));

echo "Enter the target amount: ";
$amount = intval(trim(fgets(STDIN)));

$result = coinChange($coins, $amount);
if ($result != -1) {
    echo "Minimum number of coins required: $result\n";
} else {
    echo "Not possible to form the amount.\n";
}