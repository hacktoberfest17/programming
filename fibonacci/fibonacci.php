#!/usr/bin/php
<?php

function fibonacci(int $count, int $current = null, int $before = null): array {
    if ($count <= 0) {
        return [];
    }

    $new = [$current + $before];
    if (is_null($current)) {
        $current = 0;
        $before = 1;
        $new = [0, 1];
    }

    return array_merge(
        $new,
        fibonacci(
            --$count,
            $current + $before,
            $current
        )
    );
}


if ($argc < 2 || !is_numeric($argv[1])) {
    echo "Usage: fibonacci.php [COUNT]\n";
    exit;
}

$fibonacci = fibonacci($argv[1]);
if (count($fibonacci) > $argv[1]) {
    $fibonacci = array_slice($fibonacci, 0, $argv[1]);
}

echo implode(' ', $fibonacci) . "\n";

