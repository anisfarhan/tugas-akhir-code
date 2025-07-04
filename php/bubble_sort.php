<?php
function bubbleSort(&$arr) {
    $n = count($arr);
    for ($i = 0; $i < $n - 1; $i++) {
        for ($j = 0; $j < $n - $i - 1; $j++) {
            if ($arr[$j] > $arr[$j + 1]) {
                $temp = $arr[$j];
                $arr[$j] = $arr[$j + 1];
                $arr[$j + 1] = $temp;
            }
        }
    }
}

echo "Enter the number of elements: ";
$n = intval(trim(fgets(STDIN)));

echo "Enter the elements (space separated): ";
$line = trim(fgets(STDIN));
$arr = array_map('intval', explode(' ', $line));

bubbleSort($arr);

echo "Sorted array: ";
foreach ($arr as $num) {
    echo $num . " ";
}
echo PHP_EOL;
?>