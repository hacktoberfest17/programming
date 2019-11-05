#Computer Architecture Lab

This file contains the code written during Computer Architecture Lab (CS493) course.

###How to run in Linux Environment

1. Install ```iverilog``` by the following command 
```sudo apt-get install iverilog```
2. Compile the .v file using 
```iverilog <filename>.v``` to generate the output on standard ```a.out``` file 
or ```iverilog <filename>.v -o <filename2>``` to store the output file on ```<filename2>```
3. Run the output file by ```./a.out``` or ```./<filename>```
4. To view the output of the vcd file, install gtkwave by the command ```sudo apt-get install gtkwave```
5. Open the vcd file in gtkwave by the command ```gtkwave <filename>.vcd```
