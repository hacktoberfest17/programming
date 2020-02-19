;To Compile
;nasm -f elf32 tictactoe.asm && gcc -m32 -o tictactoe tictactoe.o
;Or use the make file - That is easier

;~~~~C Functions~~~~;
extern printf           ;Printing to the screen
extern scanf            ;Receiving input
extern srand            ;Seed random
extern rand             ;Random
extern time             ;For srand
global main
;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
SECTION .data
	;Prompts
	cpuname:	db "Hal",0			
	greetings:	db "Hello Human.", 10, "My name is Hal. What is yours?: ",0
	shittalk:	db "Hello, %s, prepare to lose!", 10, 0
	playerwins:	db "%s wins the game!",10,0
	halwins:	db "HAHA!",10,"You lose, %s!",10,0
	menu:		db "Play(1) Help(2) or Exit(3)?",0
	makemove:	db "Make a move sucka'?", 10, 0
	endgame:	db "Play again? 1(Yes) 2(No)",10,0
	noinput:	db "Make a wrong input there?",10,0
	scores:		db "Wins:  %s-%d	Hal-%d		Draws-%d",10,0
	percentages:	db "Win Percentages: %s-%d	Hal-%d		Draws-%d",10,0
	turnprompt	db "Hal is thinking...",10,0
	drawprompt	db "Draw!",10,0
	;Formats
	strfmt:		db '%s',0
	intfmt:		db '%d',0
	CWLstr:		db "CWL TEST %d",10,0
	what_step:	db "We got to %d",10,0
	;TicTacToe Grid
	vertbord: 	db 179,0			;This is our vertical border |
	horbord:	db 196,196,196,196,0		;This is our horizontal border --
	joint:		db 197,0			;A Cross section for the two borders
	newline:	db 10,0				;Makes life easier for printing the grid
	xRow1:		db " \/ ",0			;Top row of X
	xRow2:		db " /\ ",0			;Bottom row of X
	oRow1:		db 218,196,196,191,0		;Top row of O
	oRow2:		db 192,196,196,217,0		;Bottom row of O
	nothing:	db "    ",0			;Incase nothing on that slot of board
	;Help TicTacToe Grid
	helpboard:	db 49,179,50,179,51,10,196,196,196,196,196,10,52,179,53,179,54,10,196,196,196,196,10,55,179,56,179,57,10,0
	;0 For nothing | 1 for X | -1 for O
	topleft:	times 4 db 0			;Our player(s) and CPU should change these values
	topmid:		times 4 db 0
	topright:	times 4 db 0
	midleft:	times 4 db 0
	midmid:		times 4 db 0
	midright:	times 4 db 0
	bottomleft:	times 4 db 0
	bottommid:	times 4 db 0
	bottomright:	times 4 db 0
	tempslot	times 4 db 0			;Reserved for slot manipulation
	;Misc
	limit:		dd 2				;We mod random with this to pick who goes first
	easymodelimit	dd 9
	bef:		db "Before",0
	aft:		db "After",0
	currentPlayer:	times 4 db 0
	currentMove:	times 4 db 0
	clearReg:	times 4 db 0			;Let's use this to clear out EAX between operations
	playerWins:	times 4 db 0
	HalWin:		times 4 db 0
	return:		times 4 db 0			;At this point im abusing the times stuff, but so far it has solved some bugs for me
	playerid:	times 4 db 0
	HalID:		times 4 db 0
	playerwinamt:	times 4 db 0			;These are for the checkwin function, they will go between 3 and -3
	Halwinamt:	times 4 db 0
	drawamt:	times 4 db 0
	HalPercentage	times 4 db 0
	humanPercentage	times 4 db 0
	drawPercentage	times 4 db 0
	temp_step:	times 4 db 0
	;Escape Sequences
	clearscr:	db 27,'[H',27,'[2J',0;		;PrintF this to clear the screen between draws
	;Background Colors
	greenbackgrnd:	db 27,'[42m',0			;Change what were drawing to have a green background
	redbackgrnd:	db 27,'[41m',0			;Change what were drawing to have a red background
	cyanbackgrnd:	db 27,'[45m',0			;Change what were drawing to have a cyan background
	;Font Colors
	gfont:		db 27,'[32m',0
	rfont:		db 27,'[31m',0
	wfont:		db 27,'[37m',0
	;DEBUG
	ChkWinDebug:	db "It got this far %d",10,0
;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
SECTION .bss
	name		resb	20			;Reserve memory for user's name
	terminal	resb	9 			;One byte for each board position, (0=empty,1=Human,2=CPU)
	random  	resw	1			;Memory for our random value, who goes first
	menuinput	resw	1			;Will get a 4byte integer for menu input
;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
SECTION .text

main:
	;--------------
	;Let's try initializing data
	xor EAX,EAX		;Neat way of getting 0
	mov [random],EAX
	mov [currentPlayer],EAX
	mov [currentMove],EAX
	mov [playerWins],EAX
	mov [HalWin],EAX
	mov [drawamt],EAX

	call clearScreen	;Clear screen
	call grnfont
	push dword greetings 	;Push our message
	call printf		;Print it
	add esp,4
	
	push name		;Let's get our users name
	push strfmt		;Push the format to extract a string
	call scanf		;Call the function
	add esp,8		;Move the stack pointer

	call clearScreen

	call menuloop		;Handles menu and game logic

	jmp Exit		;Exit our program
;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	calcPercentage:
		mov EBX,HalWin			;Get the total number of turns
		add EBX,playerWins
		add EBX,drawamt
		mov EAX,clearReg
		add EAX,100
		div EBX
		mov ECX,EAX
		
		mov EAX,[HalWin]
		imul ECX
		mov [HalPercentage],EAX

		push dword [HalPercentage]
		push intfmt
		call printf
		add esp,8

		mov EAX,[playerWins]
		mul ECX
		mov [humanPercentage],EAX
	
		mov EAX,[HalWin]
		mul ECX
		mov [drawPercentage],EAX
	
		push dword [drawPercentage]
		push intfmt
		call printf
		add esp,8

	ret

	delay:
		push 0                  ;Push 0 for default time
        	call time               ;Seed random and generate number
        	add esp,4               ;Move stack pointer; time is in EAX
		mov EBX,EAX
	delayLoop:
		push 0
		call time
		add esp,4
		cmp EAX,EBX
		jz delayLoop
	ret

	menuloop:
		call clearScreen
		push name
		push menu
		call printf
		add esp,8
		
		push menuinput
		push intfmt
		call scanf
		add esp,8
	
		mov EAX,[menuinput]
		cmp EAX,1		;Play
		jz menuplay
		cmp EAX,2		;Help
		jz menuhelp
		cmp EAX,3		;Exit
	ret
		push noinput
		call printf
		add esp,4
		jmp menuloop

	menuplay:
		push name		;Push user's name
		push dword shittalk	;Let's shittalk
		call printf		;Print to screen
		add esp,8		;Move stack pointer
		call delay
		call delay
		call pickPlayer		;Let's pick who goes first
	menuplayGame:
		call clearScreen
		call loopGame
		
		mov EAX,[HalID]		;Have the ids swapped and ready incase of another game
		mov EBX,[playerid]
		mov [playerid],EAX
		mov [HalID],EBX
		
		mov [currentPlayer],dword 1
	
		mov EAX,[playerwinamt]
		mov EBX,[Halwinamt]
		mov [playerwinamt],EBX
		mov [Halwinamt],EAX
		
		push endgame
		call printf
		add esp,4
		
		push menuinput
		push intfmt
		call scanf
		add esp,8

		mov EAX,[menuinput]
		cmp EAX,1
		jz menuplayGame
	ret
	menuhelp:
		push helpboard
		call printf
		add esp,4
		xor EAX,EAX
		mov [menuinput],EAX
		call delay
		call delay
		call delay
		jmp menuloop

	loopGame:
		call resetBoard
	loopGameLoop:			;Loop until someone wins
		call drawBoard
		call playTurn		;Play current players turn
		call clearScreen
		call checkDraw		;If no draw then check wins.
		cmp EAX,0
		jz noDraw
		call delay
		call delay
	ret
	
	noDraw:
		call checkWin
		cmp EAX,0
		jz loopGameLoop
		call delay
		call delay
	ret
	
	checkWin:		;So neat way to check if they've won
				;We know that all player slot values are 1 and 
				;all Hal slot values are -1.
				;There are only 8 patterns to win tictactoe
				;So by adding those patterns up, a Player win should be 3
				;And a Hal win should be -3
	
	;Row 1
		mov EAX,[topleft]
		add EAX,[topmid]
		add EAX,[topright]
		call chkPlayerWin
		cmp EAX,0		;Check the result of our chkPlayerWin
		jnz checkWinExit
	;Row 2
		mov EAX,[midleft]
		add EAX,[midmid]
		add EAX,[midright]
		call chkPlayerWin
		cmp EAX,0		;Check the result of our chkPlayerWin
		jnz checkWinExit
	;Row 3
		mov EAX,[bottomleft]
		add EAX,[bottommid]
		add EAX,[bottomright]
		call chkPlayerWin
		cmp EAX,0		;Check the result of our chkPlayerWin
		jnz checkWinExit
	;Col 1
		mov EAX,[topleft]
		add EAX,[midleft]
		add EAX,[bottomleft]
		call chkPlayerWin
		cmp EAX,0		;Check the result of our chkPlayerWin
		jnz checkWinExit
	;Col 2
		mov EAX,[topmid]
		add EAX,[midmid]
		add EAX,[bottommid]
		call chkPlayerWin
		cmp EAX,0		;Check the result of our chkPlayerWin
		jnz checkWinExit
	;Col 3
		mov EAX,[topright]
		add EAX,[midright]
		add EAX,[bottomright]
		call chkPlayerWin
		cmp EAX,0		;Check the result of our chkPlayerWin
		jnz checkWinExit
	;TLtoBR Diag
		mov EAX,[topleft]
		add EAX,[midmid]
		add EAX,[bottomright]
		call chkPlayerWin
		cmp EAX,0		;Check the result of our chkPlayerWin
		jnz checkWinExit
	;BLtoTR Diag
		mov EAX,[bottomleft]
		add EAX,[midmid]
		add EAX,[topright]
		call chkPlayerWin

	checkWinExit:
	ret

	checkDraw:			;If any slots are 0 then there isn't a draw yet
		
		mov EAX,[topleft]
		cmp EAX,0
		jz checkDrawSlotOpen
		
		mov EAX,[topmid]
		cmp EAX,0
		jz checkDrawSlotOpen
	
		mov EAX,[topright]
		cmp EAX,0
		jz checkDrawSlotOpen
		
		mov EAX,[midleft]
		cmp EAX,0
		jz checkDrawSlotOpen
		
		mov EAX,[midmid]
		cmp EAX,0
		jz checkDrawSlotOpen
		
		mov EAX,[midright]
		cmp EAX,0
		jz checkDrawSlotOpen
		
		mov EAX,[bottomleft]
		cmp EAX,0
		jz checkDrawSlotOpen
		
		mov EAX,[bottommid]
		cmp EAX,0
		jz checkDrawSlotOpen
		
		mov EAX,[bottomright]
		cmp EAX,0
		jz checkDrawSlotOpen
			
	CheckDrawExit:			;There is a draw and we will exit
		mov EAX,[drawamt]
		add EAX,1
		mov [drawamt],EAX
		mov EAX,1

		call drawBoard
		push drawprompt
		call printf
		add esp,8
		
		ret

	checkDrawSlotOpen:		;Slot still open so don't do anything
		mov EAX,0
		ret
;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~




;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;Checks which player won
	chkPlayerWin:
		cmp EAX,[playerwinamt]
		jz playerWon		;Check if our math worked and player won
	chkHalWin:
		cmp EAX,[Halwinamt]
		jz HalWon		;Check if math worked and Hal won
		mov EAX,0		;Noone won so put 0 in EAX so our earlier loop knows
	ret

	playerWon:			;Add 1 to the amount of player wins
		mov EAX,[playerWins]
		add EAX,1
		mov [playerWins],EAX
		mov EAX,1		;Let's our earlier loop know player won

		call drawBoard
		push name
		push playerwins
		call printf
		add esp,8

		call delay
		call delay
	ret

	HalWon:			;Add 1 to the amount of Hal wins
		mov EAX,[HalWin]
		add EAX,1
		mov [HalWin],EAX
		mov EAX,-1		;Let's our loop know Hal won
	
		call drawBoard
		push name
		push halwins
		call printf
		add esp,8

		call delay
		call delay
	ret
;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	




;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;A group of game logic (starting the game, playing turns, player moves, etc
;Also probably the largest chuck of functions in the code

	startGame:			;Starts our game of tictactoe
		call resetBoard			;Get our game ready
		
	ret

	printcurplayer:
		push dword [currentPlayer]
		push intfmt
		call printf
		add esp,8
		call printnewline
	ret

	playTurn:
		cmp dword [playerid],0
		jg playTurnPlayerX			;If playerid is bigger than 0(1 for X) jump somehwere else
	
		cmp dword [currentPlayer],0		;Compare who should go with 0 to jump to said players turn
		jl xmoveHuman				;So if the current player ID is smaller than 0 than human turn
		call xmoveHAL
	
		jmp playTurnExit
	
	playTurnPlayerX:
		cmp dword [currentPlayer],0
		jg xmoveHuman
		call xmoveHAL

	playTurnExit:
		mov EAX,[playerid]
		mov [currentPlayer],EAX	
		
		push turnprompt
		call printf
		add esp,4

		call delay
		call delay
		call drawBoard				;Drawboard and delay for 1 second
	ret

	xmoveHuman:		
		call xmovePlayer
		playerMakeMove:
		mov EAX,[playerid]
		mov [currentPlayer],EAX
		call parseMove
		cmp EAX,0
		je xmovePlayer
	
		mov EAX,[HalID]
		mov [currentPlayer],EAX
	ret
	
	xmoveHAL:		;This is utilizing the 8 steps to win TicTacToe on wikipedia
	
		call HalrandomMove
		cmp EAX,0
		ja xmoveHalExit

		call HalChkWin
		cmp EAX,0
		ja xmoveHalExit
		
		call HalChkBlockWin
		cmp EAX,0
		ja xmoveHalExit
		
		call HalChkFork
		cmp EAX,0
		ja xmoveHalExit

		call HalChkBlockFork
		cmp EAX,0
		ja xmoveHalExit

		call HalChkCenter
		cmp EAX,0
		ja xmoveHalExit

		call HalChkOpCorner
		cmp EAX,0
		ja xmoveHalExit

		call HalChkCorner
		cmp EAX,0
		ja xmoveHalExit

		call HalChkSide
		cmp EAX,0
		ja xmoveHalExit


	xmoveHalExit:
	ret
	
	
	CWLdebug:
		PUSHAD
		push ECX
		push CWLstr
		call printf
		add esp,8
		POPAD
	ret
	
	HalChkWin:
		mov EBX,[HalID]		;We're checking for 2 slots, each slot of ours will have our ID. Therefore,
		add EBX,[HalID]		;We can make our cmp number on the fly here to check everything else with

		mov ECX,4
	
	HalChkWinLoop:
		

		mov EAX,[topleft]	;Slot 1 + Slot 2
		add EAX,[topmid]
		mov EDX,dword 3
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin2
		mov EAX,[topright]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin2:
		mov EAX,[topleft]	;Slot 1 + Slot 3
		add EAX,[topright]
		mov EDX,dword 2
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin3
		mov EAX,[topmid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin3:
		mov EAX,[topleft]	;Slot 1 + Slot 4
		add EAX,[midleft]
		mov EDX,dword 7
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin4
		mov EAX,[bottomleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin4:
		mov EAX,[topleft]	;Slot 1 + Slot 7
		add EAX,[bottomleft]
		mov EDX,dword 4
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin5
		mov EAX,[midleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin5:
		mov EAX,[topleft]	;Slot 1 + Slot 5
		add EAX,[midmid]
		mov EDX,dword 9
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin6
		mov EAX,[bottomright]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin6:
		mov EAX,[topleft]	;Slot 1 + Slot 9
		add EAX,[bottomright]
		mov EDX,dword 5
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin7
		mov EAX,[midmid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin7:
		mov EAX,[midleft]	;Slot 4 + Slot 7
		add EAX,[bottomleft]
		mov EDX,dword 1
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin8
		mov EAX,[topleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin8:
		mov EAX,[midmid]	;Slot 5 + Slot 9
		add EAX,[bottomright]
		mov EDX,dword 1
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin9
		mov EAX,[topleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin9:
		mov EAX,[topmid]	;Slot 2 + Slot 3
		add EAX,[topright]
		mov EDX,dword 1
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin10
		mov EAX,[topleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin10:
		mov EAX,[topmid]	;Slot 2 + Slot 8
		add EAX,[bottommid]
		mov EDX,dword 5
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin11
		mov EAX,[midmid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin11:
		mov EAX,[topmid]	;Slot 2 + Slot 5
		add EAX,[midmid]
		mov EDX,dword 8
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWin12
		mov EAX,[bottommid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit

	HalChkWin12:
		mov EAX,[midmid]	;Slot 5 + Slot 8
		add EAX,[bottommid]
		mov EDX,dword 2
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkWinDone
		mov EAX,[topmid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkWinExit



	HalChkWinDone:

		dec ECX
		call rotateBoard
		jg HalChkWinLoop	;Rotate and check again
	
		jmp HalChkWinNoMoveExit	;Couldnt find a move so just exit

	HalChkWinExit:
		mov [currentMove],EDX	;Let's make our move
		call parseMove		
		call finishBoardRotate	;Let's rotate our board back to its original rotation
		mov EAX,1		;Return 1
	ret

	HalChkWinNoMoveExit:
		call finishBoardRotate
		mov EAX,0		;Return 0
	ret
	
	HalChkBlockWin:
		mov EBX,[playerid]	;We're checking for 2 slots, each slot of ours will have the players ID. Therefore,
		add EBX,[playerid]	;We can make our cmp number on the fly here to check everything else with

		mov ECX,4		;For our rotation
	
	HalChkBlockWinLoop:
		mov EAX,[topleft]	;Slot 1 + Slot 2
		add EAX,[topmid]
		mov EDX,3
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin2
		mov EAX,[topright]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin2:
		mov EAX,[topleft]	;Slot 1 + Slot 3
		add EAX,[topright]
		mov EDX,2
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin3
		mov EAX,[topmid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin3:
		mov EAX,[topleft]	;Slot 1 + Slot 4
		add EAX,[midleft]
		mov EDX,7
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin4
		mov EAX,[bottomleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin4:
		mov EAX,[topleft]	;Slot 1 + Slot 7
		add EAX,[bottomleft]
		mov EDX,4
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin5
		mov EAX,[midleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin5:
		mov EAX,[topleft]	;Slot 1 + Slot 5
		add EAX,[midmid]
		mov EDX,9
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin6
		mov EAX,[bottomright]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin6:
		mov EAX,[topleft]	;Slot 1 + Slot 9
		add EAX,[bottomright]
		mov EDX,5
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin7
		mov EAX,[midmid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit
		
	HalChkBlockWin7:
		mov EAX,[midleft]	;Slot 4 + Slot 7
		add EAX,[bottomleft]
		mov EDX,1
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin8
		mov EAX,[topleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin8:
		mov EAX,[midmid]	;Slot 5 + Slot 9
		add EAX,[bottomright]
		mov EDX,1
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin9
		mov EAX,[topleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin9:
		mov EAX,[topmid]	;Slot 2 + Slot 3
		add EAX,[topright]
		mov EDX,1
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin10
		mov EAX,[topleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin10:
		mov EAX,[topmid]	;Slot 2 + Slot 8
		add EAX,[bottommid]
		mov EDX,5
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin11
		mov EAX,[midmid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin11:
		mov EAX,[topmid]	;Slot 2 + Slot 5
		add EAX,[midmid]
		mov EDX,8
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWin12
		mov EAX,[bottommid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit

	HalChkBlockWin12:
		mov EAX,[midmid]	;Slot 5 + Slot 8
		add EAX,[bottommid]
		mov EDX,2
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockWinDone
		mov EAX,[topmid]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockWinExit



	HalChkBlockWinDone:

		call rotateBoard
		dec ECX
		jg  HalChkBlockWinLoop	;Rotate and check again
	
		jmp HalChkBlockWinNoMoveExit	;Couldnt find a move so just exit

	HalChkBlockWinExit:
		mov [currentMove],EDX	;Let's make our move
		call parseMove		
		call finishBoardRotate	;Let's rotate our board back to its original rotation
		mov EAX,1		;Return 1
	ret

	HalChkBlockWinNoMoveExit:
		call finishBoardRotate
		mov EAX,0		;Return 0
	ret

	





	HalChkFork:
		mov EBX,[HalID]	;Have our cmp value ready
		mov ECX,[clearReg]	;0 in ECX

		mov EAX,[topleft]
		mov EDX,9		;9 is opposite of top left
		cmp EAX,EBX		;Compare topleft to playerid
		jnz HalChkFork2
		mov EAX,[bottomright]
		cmp EAX,ECX		;Compare opposite slot to 0
		jz tookForkExit
	
	HalChkFork2:
		mov EAX,[topright]
		mov EDX,7		;7 is opposite of top right
		cmp EAX,EBX		
		jnz HalChkFork3
		mov EAX,[bottomleft]
		cmp EAX,ECX		;Compare opposite slot to 0
		jz tookForkExit
	

	HalChkFork3:
		mov EAX,[bottomleft]
		mov EDX,3		;3 is opposite of bottom left
		cmp EAX,EBX		
		jnz HalChkFork4
		mov EAX,[topright]
		cmp EAX,ECX		;Compare opposite slot to 0
		jz tookForkExit
	

	HalChkFork4:
		mov EAX,[bottomright]
		mov EDX,1		;1 is opposite of bottom right
		cmp EAX,EBX		
		jnz HalChkForkExit
		mov EAX,[topleft]
		cmp EAX,ECX		;Compare opposite slot to 0
		jz tookForkExit
	
	jmp HalChkForkExit
	
	tookForkExit:
		mov [currentMove],EDX
		call parseMove
		mov EAX,1
	ret

	HalChkForkExit:
		mov EAX,0
	ret

	HalChkBlockFork:
		mov EBX,[playerid]	;We're checking for 2 slots, each slot of ours will have the players ID. Therefore,
		add EBX,[playerid]
	
	HalChkBlockForkLoop:
		mov EAX,[midleft]	;Slot 4 + Slot 2
		add EAX,[topmid]
		mov EDX,1
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockFork2
		mov EAX,[topleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockForkExit

	HalChkBlockFork2:
		mov EAX,[bottomleft]	;Slot 7 + Slot 3
		add EAX,[topright]
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockFork3
		call HalChkSide		;This is really all we can do to block a fork that's on the corners, not sides
		cmp EAX,0
		jg sidetookfork

	HalChkBlockFork3:
		mov EAX,[bottommid]	;Slot 8 + Slot 6
		add EAX,[midright]
		mov EDX,9
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockFork4
		mov EAX,[bottomright]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockForkExit

	HalChkBlockFork4:
		mov EAX,[midleft]	;Slot 4 + Slot 8
		add EAX,[bottommid]
		mov EDX,7
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockFork5
		mov EAX,[bottomleft]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkBlockForkExit

	HalChkBlockFork5:
		mov EAX,[topleft]	;Slot 1 + Slot 9
		add EAX,[bottomright]
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockFork6
		call HalChkSide
		cmp EAX,0
		jg sidetookfork

	HalChkBlockFork6:
		mov EAX,[topmid]	;Slot 2 + Slot 6
		add EAX,[midright]
		mov EDX,3
		cmp EAX,EBX		;Check if those slots are taken
		jnz HalChkBlockForkNoMoveExit
		mov EAX,[topright]	;Let's see if our last spot is open or not(else we'll make the same move)
		cmp EAX,0
		jz HalChkForkExit

		jmp HalChkBlockForkNoMoveExit
	
	HalChkBlockForkExit:
		mov [currentMove],EDX	;Let's make our move
		call parseMove		
		mov EAX,1		;Return 1
	ret

	sidetookfork:
		mov EAX,1
	ret

	HalChkBlockForkNoMoveExit:
		mov EAX,0		;Return 0
	ret



	HalChkCenter:
		mov EAX,[midmid]	;Pull Center value into EAX
		cmp EAX,0
		jnz HalChkCenterExit
		mov dword [currentMove],5
		call parseMove
		mov EAX,1
	ret

	HalChkCenterExit:
		mov EAX,0
	ret

	HalChkOpCorner:
		mov EBX,[playerid]	;Have our cmp value ready
		mov ECX,[clearReg]	;0 in ECX

		mov EAX,[topleft]
		mov EDX,9		;9 is opposite of top left
		cmp EAX,EBX		;Compare topleft to playerid
		jnz HalChkOpCorner2
		mov EAX,[bottomright]
		cmp EAX,ECX		;Compare opposite slot to 0
		jz tookOpCornerExit
	
	HalChkOpCorner2:
		mov EAX,[topright]
		mov EDX,7		;7 is opposite of top right
		cmp EAX,EBX		
		jnz HalChkOpCorner3
		mov EAX,[bottomleft]
		cmp EAX,ECX		;Compare opposite slot to 0
		jz tookOpCornerExit
	

	HalChkOpCorner3:
		mov EAX,[bottomleft]
		mov EDX,3		;3 is opposite of bottom left
		cmp EAX,EBX		
		jnz HalChkOpCorner4
		mov EAX,[topright]
		cmp EAX,ECX		;Compare opposite slot to 0
		jz tookOpCornerExit
	

	HalChkOpCorner4:
		mov EAX,[bottomright]
		mov EDX,1		;1 is opposite of bottom right
		cmp EAX,EBX		
		jnz HalChkOpCornerExit
		mov EAX,[topleft]
		cmp EAX,ECX		;Compare opposite slot to 0
		jz tookOpCornerExit
	
	jmp HalChkOpCornerExit
	
	tookOpCornerExit:
		mov [currentMove],EDX
		call parseMove
		mov EAX,1
	ret

	HalChkOpCornerExit:
		mov EAX,0
	ret

	



	HalChkCorner:
		xor EBX,EBX		;Have our cmp value ready

		mov EAX,[topleft]
		xor EDX,EDX
		mov EDX,1		;9 is opposite of top left
		cmp EAX,EBX		;Compare topleft to playerid
		jz tookCornerExit

		mov EAX,[topright]
		mov EDX,3		;7 is opposite of top right
		cmp EAX,EBX		
		jz tookCornerExit

		mov EAX,[bottomleft]
		mov EDX,7		;3 is opposite of bottom left
		cmp EAX,EBX		
		jz tookCornerExit

		mov EAX,[bottomright]
		mov EDX,9		;1 is opposite of bottom right
		cmp EAX,EBX		
		jz tookCornerExit
	
		jmp HalChkCornerExit
	
	tookCornerExit:
		mov [currentMove],EDX
		call parseMove
		mov EAX,1
	ret

	HalChkCornerExit:
		mov EAX,0
	ret

	



	HalChkSide:
		xor EBX,EBX		;Have our cmp value ready
		xor EDX,EDX
	
		mov EAX,[midleft]
		mov EDX,4		;9 is opposite of top left
		cmp EAX,EBX		;Compare topleft to playerid
		jz tookSideExit

		mov EAX,[midright]
		mov EDX,6		;7 is opposite of top right
		cmp EAX,EBX		
		jz tookSideExit

		mov EAX,[bottommid]
		mov EDX,8		;3 is opposite of bottom left
		cmp EAX,EBX		
		jz tookSideExit

		mov EAX,[topmid]
		mov EDX,2		;1 is opposite of bottom right
		cmp EAX,EBX		
	
		jz tookSideExit
	
		jmp HalChkSideExit
	
	tookSideExit:
		mov [currentMove],EDX
		call parseMove
		mov EAX,1
	ret

	HalChkSideExit:
		mov EAX,0
	ret








	;This is our Easy Peasy mode AI
	;Basically if somewhere if our logic we don't know what to do, just do this
	;It works pretty well
	HalrandomMove:
		mov EAX,[topleft]
		cmp EAX,0
		jnz HalNotFirstTurn
	chkHRM1:
		mov EAX,[topmid]
		cmp EAX,0
		jnz HalNotFirstTurn
	chkHRM2:
		mov EAX,[topright]
		cmp EAX,0
		jnz HalNotFirstTurn
	chkHRM3:
		mov EAX,[midleft]
		cmp EAX,0
		jnz HalNotFirstTurn
	chkHRM4:
		mov EAX,[midmid]
		cmp EAX,0
		jnz HalNotFirstTurn
	chkHRM5:
		mov EAX,[midright]
		cmp EAX,0
		jnz HalNotFirstTurn
	chkHRM6:
		mov EAX,[bottomleft]
		cmp EAX,0
		jnz HalNotFirstTurn
	chkHRM7:
		mov EAX,[bottommid]
		cmp EAX,0
		jnz HalNotFirstTurn
	chkHRM8:
		mov EAX,[bottomright]
		cmp EAX,0
		jnz HalNotFirstTurn
	chkHRM9:
		jz HalMakeRandomMove
	HalNotFirstTurn:
		mov EAX,0		;We didn't make a move
	ret
	HalMakeRandomMove:
		push 0                  ;Push 0 for default time
        	call time               ;Seed random and generate number
        	add esp,4               ;Move stack pointer
	
		push EAX                ;Push the time it returned
        	call srand              ;Now lets seed our random func with it
        	add esp,4               ;Move stack pointer
        
		push EAX                ;Push so random will store in EAX
        	call rand               ;Let's get our random value
        	add esp,4               ;Move stack pointer
        
		mov EBX,[easymodelimit]         ;Move 9 to EBX
        	xor EDX,EDX             	;Clear out EDX
        	div EBX                 	;Divide EAX by EBX remainder stored in EDX
		mov EAX,EDX
		cbw
		cwd
		add EAX,1			;So we changed the byte to a doubleword and added one so 0 can't be an input
		mov [currentMove],EAX	
		mov EAX,[HalID]
		mov [currentPlayer],EAX
		call parseMove
	
		cmp EAX,0		;Let's see if we made a move
		je HalrandomMove
		mov EAX,1		;We made a move
	ret
	
	xmovePlayer:
		push makemove		;Tell the player to input a move
		push strfmt
		call printf
		add esp,8

		push currentMove	;For now were gonna get input in a shitty way until I feel like doing it a good way
		push intfmt		;board goes in order 1-TL 2-TM 3-TR and so on until 9 is BR
		call scanf
		add esp,8

	ret


	parseMove:
		mov EAX,[currentMove]

	pmoveTL:
		sub EAX,1
		jnz pmoveTM
		mov EAX,[topleft]
		cmp EAX,0
		jnz parseMoveSlotFilled
		mov EAX,[currentPlayer]
		mov [topleft],EAX
		jmp xmovePlayerExit

	pmoveTM:
		sub EAX,1
		jnz pmoveTR
		mov EAX,[topmid]
		cmp EAX,0
		jnz parseMoveSlotFilled
		mov EAX,[currentPlayer]
		mov [topmid],EAX
		jmp xmovePlayerExit

	pmoveTR:
		sub EAX,1
		jnz pmoveML
		mov EAX,[topright]
		cmp EAX,0
		jnz parseMoveSlotFilled
		mov EAX,[currentPlayer]
		mov [topright],EAX
		jmp xmovePlayerExit

	pmoveML:
		sub EAX,1
		jnz pmoveMM
		mov EAX,[midleft]
		cmp EAX,0
		jnz parseMoveSlotFilled
		mov EAX,[currentPlayer]
		mov [midleft],EAX
		jmp xmovePlayerExit

	pmoveMM:
		sub EAX,1
		jnz pmoveMR
		mov EAX,[midmid]
		cmp EAX,0
		jnz parseMoveSlotFilled
		mov EAX,[currentPlayer]
		mov [midmid],EAX
		jmp xmovePlayerExit

	pmoveMR:
		sub EAX,1
		jnz pmoveBL
		mov EAX,[midright]
		cmp EAX,0
		jnz parseMoveSlotFilled
		mov EAX,[currentPlayer]
		mov [midright],EAX
		jmp xmovePlayerExit

	pmoveBL:
		sub EAX,1
		jnz pmoveBM
		mov EAX,[bottomleft]
		cmp EAX,0
		jnz parseMoveSlotFilled
		mov EAX,[currentPlayer]
		mov [bottomleft],EAX
		jmp xmovePlayerExit

	pmoveBM:
		sub EAX,1
		jnz pmoveBR
		mov EAX,[bottommid]
		cmp EAX,0
		jnz parseMoveSlotFilled
		mov EAX,[currentPlayer]
		mov [bottommid],EAX
		jmp xmovePlayerExit

	pmoveBR:
		sub EAX,1
		jnz xmovePlayerExit
		mov EAX,[bottomright]
		cmp EAX,0
		jnz parseMoveSlotFilled
		mov EAX,[currentPlayer]
		mov [bottomright],EAX
	
	xmovePlayerExit:
		mov EAX,1		;Let's earlier functions know move was made
	ret

	parseMoveSlotFilled:
		mov EAX,0		;Move was not made, slot was full
	ret	

	
	rotateBoard:		;Rotates our tictactoe board 90 degrees
	;Corners
		mov EAX,[topleft]
		mov [tempslot],EAX

		mov EAX,[bottomleft]
		mov [topleft],EAX

		mov EAX,[bottomright]
		mov [bottomleft],EAX

		mov EAX,[topright]
		mov [bottomright],EAX

		mov EAX,[tempslot]
		mov [topright],EAX

	;Sides
		mov EAX,[midleft]
		mov [tempslot],EAX
	
		mov EAX,[bottommid]
		mov [midleft],EAX

		mov EAX,[midright]
		mov [bottommid],EAX

		mov EAX,[topmid]
		mov [midright],EAX

		mov EAX,[tempslot]
		mov [topmid],EAX
	ret

	finishBoardRotate:		;We call this after our AI has solved a spot early. We do this so our board is the original rotation
		cmp ECX,0
		jz FBRExit
	FBRLoop:
		call rotateBoard
		dec ECX
		jg FBRLoop		;HEY!!!! Weird glitch, using Loop instead of dec and jg caused a huge bug where it took 30 seconds to compute this
	FBRExit:
	ret

	resetBoard:			;Resets all slots to 0
		xor EAX,EAX
		mov [topleft],EAX
		mov [topmid],EAX
		mov [topright],EAX
	
		mov [midleft],EAX
		mov [midmid],EAX
		mov [midright],EAX
	
		mov [bottomleft],EAX
		mov [bottommid],EAX
		mov [bottomright],EAX
	ret
;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
;Drawing funcions

	clearScreen:			;Will clear the screen of everything
		push dword clearscr
		call printf
		add esp,4
	ret

	drawBoard:			;PrintSlotTop and PrintSlopBottom are printing the top and bottom halfs of each slot based on the number in the given slot
		push dword [drawamt]
		push dword [HalWin]
		push dword [playerWins]
		push name
		push scores
		call printf
		add esp,20
	
		;calcPercentage Function not working
		;push dword [drawPercentage]
		;push dword [HalPercentage]
		;push dword [humanPercentage]
		;push name
		;push percentages
		;call printf
		;add esp,20


		mov EAX,[topleft]	;Print each row one after another
		call printslottop	;Top Left Slot
		call printvertbord	

		mov EAX,[topmid]	;Top Middle Slot
		call printslottop	;Prints top half of X,O,or nothing
		call printvertbord

		mov EAX,[topright]	;Top Right Slot
		call printslottop	;
		call printnewline	;This is the end so newline

		mov EAX,[topleft]	;Top Left Slot - Bottom
		call printslotbottom	;Prints bottom half of X,O,or nothing
		call printvertbord
	
		mov EAX,[topmid]	;Top Middle Slot
		call printslotbottom	;Prints the bottom half of X,o,or nothing
		call printvertbord

		mov EAX,[topright]
		call printslotbottom
		call printnewline

		call printhorbord	;1st Horizontal boundary
		call printjoint		;Cross section
		call printhorbord
		call printjoint
		call printhorbord
		call printnewline
	
		mov EAX,[midleft]	;Middle Rows
		call printslottop
		call printvertbord

		mov EAX,[midmid]
		call printslottop
		call printvertbord

		mov EAX,[midright]
		call printslottop
		call printnewline
	
		mov EAX,[midleft]
		call printslotbottom
		call printvertbord

		mov EAX,[midmid]
		call printslotbottom
		call printvertbord

		mov EAX,[midright]
		call printslotbottom
		call printnewline

		call printhorbord	;2nd Horizontal boundary
		call printjoint
		call printhorbord
		call printjoint
		call printhorbord
		call printnewline
	
		mov EAX,[bottomleft]
		call printslottop
		call printvertbord

		mov EAX,[bottommid]
		call printslottop
		call printvertbord

		mov EAX,[bottomright]
		call printslottop
		call printnewline

		mov EAX,[bottomleft]
		call printslotbottom
		call printvertbord

		mov EAX,[bottommid]
		call printslotbottom
		call printvertbord

		mov EAX,[bottomright]
		call printslotbottom
		call printnewline
	ret

	printslottop:		;Prints the top half of an X,O,or nothing depending on the value in EAX(-1(O),0( ),1(X))
		cmp EAX,0
		jg prnsxtop
		jl prnsotop
		jz prnsn
	
	printslotbottom:	;Prints the bottom half of an X,O,or nothing depending on the value in EAX(-1(O),0( ),1(X))
		cmp EAX,0
		jg prnsxbottom
		jl prnsobottom
		jz prnsn
	
	prnsxtop:		;Prints top half of X
		push xRow1
		push strfmt
		call printf
		add esp,8
	ret

	prnsotop:		;Prints the top half of O
		push oRow1
		push strfmt
		call printf
		add esp,8
	ret

	prnsxbottom:		;Prints the bottom half of X
		push xRow2
		push strfmt
		call printf
		add esp,8
	ret

	prnsobottom:		;Prints the bottom half of O
		push oRow2
		push strfmt
		call printf
		add esp,8
	ret

	prnsn:			;Prints a whole lotta nothing
		push nothing
		call printf
		add esp,4
	ret

	printvertbord:		;Prints a vertical border (|)
		push vertbord
		push strfmt
		call printf
		add esp,8
	ret

	printhorbord:		;Prints a horizontal border (----)
		push horbord
		push strfmt
		call printf
		add esp,8
	ret

	printjoint:		;Prints a cross section (+)
		push joint
		push strfmt
		call printf
		add esp,8
	ret

	printnewline:		;Prints newline char
		push newline
		push strfmt
		call printf
		add esp,8
	ret
;~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

	pickPlayer:		;Randomly picks who will go first(Value is stored in random)
		xor EAX,EAX
		mov [random],EAX
        
		push 0                  ;Push 0 for default time
        	call time               ;Seed random and generate number
        	add esp,4               ;Move stack pointer
	
		push EAX                ;Push the time it returned
        	call srand              ;Now lets seed our random func with it
        	add esp,4               ;Move stack pointer
        
		push EAX                ;Push so random will store in EAX
        	call rand               ;Let's get our random value
        	add esp,4               ;Move stack pointer
        
		mov EBX,[limit]         ;Move 2 to EBX
        	xor EDX,EDX             ;Clear out EDX
        	div EBX                 ;Divide EAX by EBX remainder stored in EDX
		mov EAX,EDX		;Store random result in random (0 = cpu goes first, 1 = human goes first
	
		cmp EAX,0		;Except our moveparser is going to use -1 for cpu and 1 for human so we need to change it
		jz pickPlayerCPU
	
		mov EAX,1		;Move 1 into playerid for X and -1 into HalID for O and set current player to 1(player)
		mov [playerid],EAX
		mov [currentPlayer],EAX
		mov EAX,-1
		mov [HalID],EAX
	
		mov EAX,3		;Move the correct amount into playerwinamt and Halwinamt that they will need for the check win function
		mov [playerwinamt],EAX
		mov EAX,-3
		mov [Halwinamt],EAX
	ret

	pickPlayerCPU:
		mov EAX,1		;Move 1(X) into HalID so Hal is X and -1 into playerid so player is O and set current player to -1(Hal)
		mov [HalID],EAX
		mov [currentPlayer],EAX
		mov EAX,-1
		mov [playerid],EAX
		;mov [currentPlayer],EAX
	
		mov EAX,-3		;Move the correct amount into playerwinamt and Halwinamt that they will need for the check win function
		mov [playerwinamt],EAX
		mov EAX,3
		mov [Halwinamt],EAX
	ret

	redback:		;Changes the cursor background to red
		push dword redbackgrnd
		call printf
		add esp,4
	ret
	
	greenback:		;Changes the cursor background to green
		push dword greenbackgrnd
		call printf
		add esp,4
	ret

	grnfont:		;Changes font to green
		push dword gfont
		call printf
		add esp,4
	ret

	whitefont:		;Changes font to white
		push dword wfont
		call printf
		add esp,4
	ret

	
	
Exit:
	call clearScreen	;One last clearscreen to exit gracefully
	ret

