<?php
function factorial($number){
    $result = 1;
    foreach(range(1, $number) as $i)
        $result *= $i;
    return $result;
}
