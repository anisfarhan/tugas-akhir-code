<?php
function search($text, $pattern) {
    $n = strlen($text);
    $m = strlen($pattern);

    for ($i = 0; $i <= $n - $m; $i++) {
        $j = 0;
        // Check for match at position i
        for (; $j < $m; $j++) {
            if ($text[$i + $j] !== $pattern[$j]) {
                break;
            }
        }
        // If full pattern matched
        if ($j == $m) {
            return $i;
        }
    }
    return -1;
}

echo "Enter a text to search in: ";
$text = trim(fgets(STDIN));
echo "Enter a pattern to search for: ";
$pattern = trim(fgets(STDIN));
$result = search($text, $pattern);
if ($result != -1) {
    echo "Pattern found at index: $result\n";
} else {
    echo "Pattern not found.\n";
}