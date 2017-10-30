<?php
/**
* Calculate a factorial given a number.
* For different results, change the function call.
*/
function factorial($number) { 
    if ($number < 2) { 
        return 1; 
    } else { 
        return ($number * factorial($number-1)); 
    } 
}
$fact_res = factorial(10);
echo $fact_res;
