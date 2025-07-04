<?php
function f($x) {
    return $x * $x;
}

function trapezoidalRule($a, $b, $n) {
    $h = ($b - $a) / $n;
    $sum = f($a) + f($b);
    for ($i = 1; $i < $n; $i++) {
        $xi = $a + $i * $h;
        $sum += 2 * f($xi);
    }
    return ($h / 2) * $sum;
}

echo "Enter lower bound (a): ";
$a = floatval(trim(fgets(STDIN)));
echo "Enter upper bound (b): ";
$b = floatval(trim(fgets(STDIN)));
echo "Enter number of partitions (n): ";
$n = intval(trim(fgets(STDIN)));

$result = trapezoidalRule($a, $b, $n);
printf("Hasil integral dari x^2 antara %.1f hingga %.1f dengan n=%d adalah %.6f\n", $a, $b, $n, $result);