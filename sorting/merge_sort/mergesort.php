<?php    
$unsorted = array(43,21,2,1,9,24,2,99,23,8,7,114,92,5);

    function merge_sort($array)

    {

    $length = count($array);

    if($length <= 1)

    {

    return $array;

    }

    $left = $right = $result = array();

    $middle = round($length / 2,0);

    for($i=0;$i<$middle;$i++)

    {

    $left[] = $array[$i];

    }

    for($j=$middle;$j<$length;$j++)

    {

    $right[] = $array[$j];

    }

    $left = merge_sort($left);

    $right = merge_sort($right);

    $result = merge($left, $right);

    return $result;

    }

    function merge($left, $right)

    {

    $result = array();

    while(count($left) > 0 || count($right) > 0)

    {

    if(count($left) > 0 && count($right) > 0)

    {

    if($left[0] <= $right[0]){

    // get first item from array and shift items over

    $result[] = array_shift($left);

    }

    else{

    $result[] = array_shift($right);

    }

    }

    elseif(count($left) > 0){

    $result[] = array_shift($left);

    }

    else{

    $result[] = array_shift($right);

    }

    }

    return $result;

    }

    $sorted = merge_sort($unsorted);

    print_r($sorted);
?>
