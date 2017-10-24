<?php

function gcd($a, $b){
  if($a == $b || $a == 0 || $b == 0){
      return $a;
  }
  return gcd($b, $a % $b);
}
>
