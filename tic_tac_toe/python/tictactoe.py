from tkinter import *
import random

# Initialize Variables
grid = [[0 for i in range(3)] for j in range(3)]
numClicks = 0
isDone = False
isXTurn = True

# Function to restart the Game
def resetGame():
	global numClicks
	global isDone
	global isXTurn
	for rw in range(0,3):
		for col in range(0,3):
			grid[rw][col].config(text=" ")
	labelStatus.config(text="X's turn")
	numClicks = 0
	isDone = False
	isXTurn = True

# Function to mark the Box appropriately
def markSpace(rw, col):
	global numClicks
	global isDone
	global isXTurn
	if isDone == True:
		return
	space = grid[rw][col].cget('text')
	if space == " ":
		if isXTurn == True:
			grid[rw][col].config(text="X", fg="red")
			labelStatus.config(text="X's Turn")
		else:
			grid[rw][col].config(text="O", fg="blue")
			labelStatus.config(text="O's Turn")
	else:
		labelStatus.config(text='Invalid Move')
		return
	isXTurn = not isXTurn
	numClicks += 1
	gameOver(rw, col)

# Function to check if Game is Over
def gameOver(rw, col) :
    global numClicks
    global isDone
    global isXTurn
    winner = ' '

    if(grid[0][0].cget('text')  == grid[1][1].cget('text') and grid[1][1].cget('text') == grid[2][2].cget('text')) :
        winner = grid[0][0].cget('text')
    elif(grid[2][0].cget('text')  == grid[1][1].cget('text') and grid[1][1].cget('text') == grid[0][2].cget('text')) :
        winner = grid[2][1].cget('text')

    else :
        for r in range(0, 3) :
            if(grid[r][0].cget('text') != ' ' and grid[r][0].cget('text') == grid[r][1].cget('text') and grid[r][1].cget('text') == grid[r][2].cget('text')):
                winner = grid[r][0].cget('text')
            elif(grid[0][r].cget('text') != ' ' and grid[0][r].cget('text') == grid[1][r].cget('text') and grid[1][r].cget('text') == grid[2][r].cget('text')):
                winner = grid[0][r].cget('text')

    isDone = True
    if(winner == ' ' and numClicks >= 9) :
       labelStatus.config(text = 'Tie Game')
    elif(winner != ' ') :
        labelStatus.config(text = winner + ' Wins!')
    else :
        labelStatus.config(text = 'X\'s Turn' if isXTurn else 'O\'s Turn')
        isDone = False  
	

# Setup the main GUI
root = Tk()
root.title("Tic-Tac-Toe")
root.geometry("355x420")
topFrame = Frame(root, width=320, height=40)
topFrame.place(x=12, y=12)
labelStatus = Label(topFrame, text="X's Turn", bg="yellow", fg="blue", font=("serif"), width=30)
labelStatus.pack(side="top")
mainFrame = Frame(root, width=315, height=300, bg="black")
mainFrame.place(x=10, y=42)

for rw in range(0,3):
	for col in range(0,3):
		grid[rw][col] = Button(mainFrame, text=" ", relief="solid", command=lambda rw=rw, col=col: markSpace(rw,col))
		grid[rw][col].config(font="monospace 36 bold", fg="red", height=1, width=2)
		grid[rw][col].place(x=rw*105+10, y=col*105+10)

btnRestart = Button(root, text="Restart", command = resetGame, width=30)
btnRestart.place(x=45, y=380)
root.mainloop()
