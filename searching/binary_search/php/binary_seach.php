<?php
//$value means the value that you need to search
//Array $vs is the array that the items are included in

function contains($value, Array $vs)
{
	if (count($vs) === 0) return false;
	$left = 0; //$left is to setting the left index for comparison - initially 0 (1st element of the array)
	$right = count($vs) - 1;
	
	while (($left + 1) < $right) {
		$mid = $left + ($right - $left) / 2;
		if ($value < $vs[$mid]) {
			$right = $mid;
		} else {
			$left = $mid;
		}
	}
	return $vs[$left] === $value;
}