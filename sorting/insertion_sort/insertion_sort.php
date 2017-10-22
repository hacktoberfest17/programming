/**Function for insertion sort algorithm */

<?php
 function insertion_Sort($my_array)
{
	for($i=0;$i<count($my_array);$i++){
		$val = $my_array[$i];
		$j = $i-1;
		while($j>=0 && $my_array[$j] > $val){
			$my_array[$j+1] = $my_array[$j];
			$j--;
		}
		$my_array[$j+1] = $val;
	}
return $my_array;
}
$test_array = array(3, 0, 2, 5, -1, 4, 1);
echo "Original Array :\n";
echo implode(', ',$chk_array );
echo "\nSorted Array :\n";
print_r(insertion_Sort($chk_array));
?>


/** Chk Sample Output 
     * 
     * Original Array :                                                    
     *            3, 0, 2, 5, -1, 4, 1                                                
     *            Sorted Array :                                                      
     *            Array                                                               
     *            (                                                                   
     *                [0] => -1                                                       
     *                [1] => 0                                                        
     *                [2] => 1                                                        
     *                [3] => 2                                                        
     *                [4] => 3                                                        
     *                [5] => 4                                                        
     *                [6] => 5                                                        
     *            ) 
     */
