<?php
function dfs(&$grid, $x, $y) {
    $m = count($grid);
    $n = count($grid[0]);
    $stack = [[$x, $y]];
    $size = 0;

    while (!empty($stack)) {
        list($i, $j) = array_pop($stack);

        if ($i < 0 || $i >= $m || $j < 0 || $j >= $n || $grid[$i][$j] == 0) {
            continue;
        }

        $size++;
        $grid[$i][$j] = 0;

        $stack[] = [$i - 1, $j];
        $stack[] = [$i + 1, $j];
        $stack[] = [$i, $j - 1];
        $stack[] = [$i, $j + 1];
    }

    return $size;
}

echo "Enter the grid size: ";
list($m, $n) = array_map('intval', explode(' ', trim(fgets(STDIN))));
echo "Enter the grid:\n";
$grid = [];
for ($i = 0; $i < $m; $i++) {
    $row = array_map('intval', explode(' ', trim(fgets(STDIN))));
    $grid[] = $row;
}

echo "Enter the island coordinates: ";
list($x, $y) = array_map('intval', explode(' ', trim(fgets(STDIN))));

echo "The size of the island is: " . dfs($grid, $x, $y) . "\n";