/**Function for sorting an array with insertion sort algorithm
  */

<?php
 function insertion_Sort($this_array)
{
	for($i=0;$i<count($this_array);$i++){
		$val = $this_array[$i];
		$j = $i-1;
		while($j>=0 && $this_array[$j] > $val){
			$this_array[$j+1] = $this_array[$j];
			$j--;
		}
		$this_array[$j+1] = $val;
	}
return $this_array;
}
$test_array = array(3, 0, 2, 5, -1, 4, 1);
echo "Original Array :\n";
echo implode(', ',$chk_array );
echo "\nSorted Array :\n";
print_r(insertion_Sort($chk_array));
?>


/** +++++++++++ Sample Output ++++++++++++
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
