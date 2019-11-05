<?php

/**
 * Function to get minimum number of trials needed in worst case with $n eggs and $k floors
 * 
 * @param int $n
 * @param int $k
 * @return int
 */
function eggDrop(int $n, int $k): int
{
    $eggFloor = [];

    for ($i = 1; $i <= $n; $i++) {
        $eggFloor[$i][1] = 1;
        $eggFloor[$i][0] = 0;
    }

    for ($j = 1; $j <= $k; $j++) {
        $eggFloor[1][$j] = $j;
    }

    for ($i = 2; $i <= $n; $i++) {
        for ($j = 2; $j <= $k; $j++) {
            $eggFloor[$i][$j] = PHP_INT_MAX;
            for ($x = 1; $x <= $j; $x++) {
                $result = 1 + max($eggFloor[$i - 1][$x - 1], $eggFloor[$i][$j - $x]);
                if ($result < $eggFloor[$i][$j]) {
                    $eggFloor[$i][$j] = $result;
                }
            }
        }
    }

    return $eggFloor[$n][$k];
}


$n = readline('Enter number of eggs: ');
$k = readline('Enter number of floors: ');
echo 'Minimum number of trials in worst case: '.eggDrop($n, $k)."\n";
