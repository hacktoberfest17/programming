function NumPlain($get, $fem = 0) {
	$nums = explode(',', str_replace('.', '', preg_replace('/^,/', '0,', $get)), 2);
	$array1 = array('', 'um', 'dois', 'tr&ecirc;s', 'quatro', 'cinco', 'seis', 'sete', 'oito', 'nove', 'dez', 'onze', 'doze', 'treze', 'catorze', 'quinze', 'dezesseis', 'dezessete', 'dezoito', 'dezenove');
	$array2 = array('', '', 'vinte', 'trinta', 'quarenta', 'cinquenta', 'sessenta', 'setenta', 'oitenta', 'noventa');
	$array3 = array('', 'cento', 'duzentos', 'trezentos', 'quatrocentos', 'quinhentos', 'seiscentos', 'setecentos', 'oitocentos', 'novecentos');
	foreach($nums as $num) {
		$num = (int)strtr($num, array(',' => '', '-' => ''));
		if(strlen($num) < 16 && $num !== 0) {
			$trio = str_split(strrev($num), 3);
			for($i = 0, $count = count($trio); $i < $count; $i++) {
				$ints = str_split($trio[$i]);
				if(!empty($ints[2]) && $ints[2].$ints[1].$ints[0] == 100) {
					$str[0] = 'cem';
					$next = 3;
				}
				elseif(!empty($ints[1]) && $ints[1].$ints[0] > 9 && $ints[1].$ints[0] < 20) {
					$str[0] = $array1[$ints[1].$ints[0]];
					$next = 2;
				}
				else {
					$str[0] = $array1[$ints[0]];
					$next = 1;
				}
				if(!empty($ints[1]) && $next == 1) {
					if($ints[1] > 0 && $ints[0] > 0) {
						$str[1] = 'e';
					}
					$str[2] = $array2[$ints[1]];
				}
				if(!empty($ints[2]) && $next < 3) {
					if($ints[1] + $ints[0] !== 0) {
						$str[3] = 'e';
					}
					$str[4] = $array3[$ints[2]];
				}
				if($i == 1) {
					if($trio[0] > 0 && (strrev($trio[0]) < 101 || strrev($trio[0]) % 100 == 0)) {
						$flush[] = 'e';
					}
					if($trio[1] > 0) {
						$flush[] = 'mil';
					}
				}
				elseif($i == 2 && $trio[2] > 0) {
					$flush[] = $trio[2] == 1 ? 'milh&atilde;o' : 'milh&otilde;es';
				}
				elseif($i == 3 && $trio[3] > 0) {
					$flush[] = $trio[3] == 1 ? 'bilh&atilde;o' : 'bilh&otilde;es';
				}
				elseif($i == 4 && $trio[4] > 0) {
					$flush[] = $trio[4] == 1 ? 'trilh&atilde;o' : 'trilh&otilde;es';
				}
				$flush[] = implode(' ', array_reverse($str));
				unset($str);
			}
		}
		elseif($num == 0) {
			$flush[] = 'zero';
		}
		else {
			$flush[] = 'inv&aacute;lido';
		}
		$ext[] = $fem ? preg_replace(array('/^um mil /', '/um$/', '/dois$/', '/dois mil /'), array('mil ', 'uma', 'duas', 'duas mil '), str_replace('  ', ' ', implode(' ', array_reverse($flush)))) : preg_replace('/^um mil /', 'mil ', str_replace('  ', ' ', implode(' ', array_reverse($flush))));
		unset($flush);
	}
	$ret = strpos($get, ',') !== false ? implode(' v&iacute;rgula ', $ext) : $ext[0];
	return $nums[0] < 0 ? 'menos '.$ret : $ret;
}
