<?php
function multiplyMatrices($matrix1, $matrix2) {
    $r1 = count($matrix1);
    $c1 = count($matrix1[0]);
    $r2 = count($matrix2);
    $c2 = count($matrix2[0]);

    if ($c1 != $r2) {
        echo "The number of columns of the first matrix must be equal to the number of rows of the second matrix.\n";
        return null;
    }

    $result = array_fill(0, $r1, array_fill(0, $c2, 0));
    for ($i = 0; $i < $r1; $i++) {
        for ($j = 0; $j < $c2; $j++) {
            for ($k = 0; $k < $c1; $k++) {
                $result[$i][$j] += $matrix1[$i][$k] * $matrix2[$k][$j];
            }
        }
    }
    return $result;
}

function readMatrix($rows, $cols) {
    $matrix = [];
    for ($i = 0; $i < $rows; $i++) {
        // echo "Enter row " . ($i + 1) . " (space separated): ";
        $line = trim(fgets(STDIN));
        $row = array_map('intval', explode(' ', $line));
        if (count($row) != $cols) {
            echo "Invalid number of columns.\n";
            exit(1);
        }
        $matrix[] = $row;
    }
    return $matrix;
}

// echo "Enter the number of rows and columns of the first matrix: ";
list($r1, $c1) = array_map('intval', explode(' ', trim(fgets(STDIN))));
// echo "Enter the first matrix:\n";
$matrix1 = readMatrix($r1, $c1);

// echo "Enter the number of rows and columns of the second matrix: ";
list($r2, $c2) = array_map('intval', explode(' ', trim(fgets(STDIN))));
// echo "Enter the second matrix:\n";
$matrix2 = readMatrix($r2, $c2);

$result = multiplyMatrices($matrix1, $matrix2);

if ($result !== null) {
    // echo "The product of the two matrices is:\n";
    for ($i = 0; $i < count($result); $i++) {
        for ($j = 0; $j < count($result[0]); $j++) {
            echo $result[$i][$j] . " ";
        }
        echo "\n";
    }
} else {
    echo "Matrix multiplication is not possible.\n";
}