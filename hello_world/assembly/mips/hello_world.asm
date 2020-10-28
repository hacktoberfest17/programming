# Joao Paulo de Castro Bento Pereira 
# github: castrob
# This code prints Hello World in MIPS assembly language
# You should use mips simulator suchas MARS 4.3 to run.

.text
.globl main
main:
	li $v0, 4 # Code to print string
	la $a0, msg # Loads a0 with msg address
	syscall
	li $v0, 10 # code to finish the machine
	syscall
	
.data
msg: .asciiz "Hello World\n"	

