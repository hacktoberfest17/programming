#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#
#				MAKEFILE														#
#	Compiles code and had basic functionality for cleaning working 				#
#		directory and doing some basic git functions							#
#																				#
#																				#
#																				#
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#
TARGET  = tictactoe		#Output Name
RMEXTS	= *.o			#Remove Extensions
all: 
	@nasm -f elf32  tictactoe.asm && gcc -m32 -o tictactoe tictactoe.o	#Compile Command
	@echo "Probably Compiled"

clean:
	@rm -f $(RMEXTS) $(TARGET)	#Delete .o and build files
	@echo "Directory Cleaned"
run:
	@./$(TARGET) 		#Run build

gstart: clean			#Clean Directory
	@git add *		#Start Commit
	@git commit -m "${m}"	#Add commit
	@echo "Commit Created"	#Print Message
push:
	@git push origin master	#Push to repo
	@echo "Pushed"	
pull:
	@git pull		#Pull from repo
