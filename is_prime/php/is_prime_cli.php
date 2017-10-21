#!/usr/bin/php
<?php

function is_prime(int $number): bool {
    if ($number <= 1) {
        return false;
    }

    for ($i = 2; $i < $number; $i++) {
        if ($i !== $number && $number % $i === 0) {
            return false;
        }
    }

    return true;
}


if ($argc < 2 || !is_numeric($argv[1])) {
    echo "Usage: is_prime.php [NUMBER]\n";
    exit;
}

echo $argv[1] . " is" . (!is_prime($argv[1]) ? " not" : "") . " a prime number!\n";



