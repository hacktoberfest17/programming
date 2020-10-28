<?php
//$value means the value that you want to say
//Array $vs is the array that the items are included

function contains($value, Array $vs)
{
	foreach ($vs as $val) {
		if ($value === $val) return true;
	}
	return false;
}
?>