import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';


// Initialization of variables.
let human, computer;

// Dummy components. Only returns JSX to render when called by Board.
function Square(props) {
  return (
    <button className="square" onClick={props.onClick} value={props.number}>
      {props.value}
    </button>
  );
}

function Button(props) {
  return (
    <button className="reset" onClick={props.onClick}>
      Reset?
    </button>
  );
}


// The actual board. Where all of the rendering of the actual game is, with the algorithim.

class Board extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      squares: Array(9).fill(null), // Board definition.
      xIsNext: props.isX, // Recieving from Game based on user input. Returns true or false
    }
  }


// Calls the square and adds clicking functions to it.
  renderSquare(i) {
    return (
      <Square
        value={this.state.squares[i]}
        number={i} // testing purposes
        onClick={() => this.handleClick(i)}
      />
    );
  }


// changes the state everytime a button is clicked, but tests if the game isn't over before
  handleClick(i) {

    computer = this.state.xIsNext ? 'O' : 'X';
    human = this.state.xIsNext ? 'X' : 'O';

    const squares = this.state.squares.slice();
    if (calculateWinner(squares) || squares[i] || isItATie(squares)) {
      return;
    }
    squares[i] = this.state.xIsNext ? 'X' : 'O';
    this.setState({
      squares: squares,
      xIsNext: !this.state.xIsNext,
    },
    this.AIDecider
    );
  }


// resets the board when the button is clicked.
  resetClick() {
    this.setState({
      squares: Array(9).fill(null), // Clears the board.
      xIsNext: this.props.isX, // if true, returns 'X'. else, returns 'O'.
    });
  }


// Easier to just define the function and keep calling it with this
  copyBoard(board) {
    return board.slice();
  }

  /*
  Checks to make sure if the move that AIDecider, minScore, and maxScore is valid.
  If not, doesn't return anything.
  If it is valid, it returns every possible combination in arrays.
  */

  validMove(index, player, board) {
    let thisCopy = this.copyBoard(board);
    if (thisCopy[index] === null) {
      thisCopy[index] = player;
      return thisCopy;
    } else {
      return null;
    }
  }

  /*
  The actual decider, and beginning of the MiniMax algorithim.
  Calls maxScore, which calls minScore until it finds an index.
  Then, copies the board and gives back the board with the decision.
  */

  AIDecider() {
    let boardCopy = this.copyBoard(this.state.squares);
    let move = null;
    let bestMoveScore = -100;
    let newBoard = null;
    let publishedBoard = null;
    // doesn't do anything if the game is over
    if (calculateWinner(boardCopy) === computer || calculateWinner(boardCopy) === human || isItATie(boardCopy)) {
      return null;
    }

    /*
    The initial loop that suggests any and all moves possible. Calls maxScore which
    has its own loop which adds a move and calls validMove
    (therefore putting it a move ahead), and maxScore calls minScore that has its own loop
    (therefore putting it two moves ahead). Then, decides by point incentive whether
    it is a good move or not.
    */

    for (let i = 0; i < boardCopy.length; i++) {
      newBoard = this.validMove(i, computer, boardCopy);
      if (newBoard) {
        let moveScore = this.maxScore(newBoard);
        if (moveScore > bestMoveScore) {
          bestMoveScore = moveScore;
          move = i;
        }
      }
    }

    /*
    When the loop is over, it will assign the index that is the best move to play.
    Assigns the new index with whatever the computer is playing (X or O), then adds it onto
    a copy of the board (publishedBoard) where it will be change the state of the board.
    setTimeout given for user experience (giving the illusion that the computer is "thinking").
    */

    publishedBoard = boardCopy;
    publishedBoard[move] = computer;
    setTimeout(() => {
      this.setState({
        squares: publishedBoard,
        xIsNext: !this.state.xIsNext
      });
    }, 300);
  }

  /*
  minScore and maxScore call on each other where they add more possible moves onto
  the copied board until it is either a tie, or someone has won with the theoretical
  boards. Then, returns a number value where the loop in AIDecider will start again
  until the loop runs out.
  */

  minScore(board) {
    if (calculateWinner(board) === human) {
      return -10;
    } else if (calculateWinner(board) === computer) {
      return 10;
    } else if (isItATie(board)) {
      return 0;
    } else {
      let bestMoveValue = -100;
      let move = 0;
      for (let i = 0; i < board.length; i++) {
        let newBoard = this.validMove(i, computer, board);
        if (newBoard) {
          let predictedMoveValue = this.maxScore(newBoard);
          if (predictedMoveValue > bestMoveValue) {
            bestMoveValue = predictedMoveValue;
            move = i;
          }
        }
      }
      return bestMoveValue;
    }
  }

  // Called first by AIDecider, then calls minScore

  maxScore(board) {
    if (calculateWinner(board) === human) {
      return -10;
    } else if (calculateWinner(board) === computer) {
      return 10;
    } else if (isItATie(board)) {
      return 0;
    } else {
      let bestMoveValue = 100;
      let move = 0;
      for (let i = 0; i < board.length; i++) {
        let newBoard = this.validMove(i, human, board);
        if (newBoard) {
          let predictedMoveValue = this.minScore(newBoard);
          if (predictedMoveValue < bestMoveValue) {
            bestMoveValue = predictedMoveValue;
            move = i;
          }
        }
      }
      return bestMoveValue;
    }
  }

  render() {
    const winner = calculateWinner(this.state.squares);
    const tie = isItATie(this.state.squares);
    let status, button = null;

    if (winner) {
      status = "Winner: " + winner;
      button = <Button onClick={() => this.resetClick()}/>
    } else if (tie) {
      status = "It's a tie!";
      button = <Button onClick={() => this.resetClick()}/>
    } else {
      status = "Your turn, " + (this.state.xIsNext ? 'X' : 'O');
    }

    return (
      <div>
        <div className="status">{status}</div>
        <div style={{textAlign: 'center'}}>{button}</div>
        <div className="board-row">
          {this.renderSquare(0)}
          {this.renderSquare(1)}
          {this.renderSquare(2)}
        </div>
        <div className="board-row">
          {this.renderSquare(3)}
          {this.renderSquare(4)}
          {this.renderSquare(5)}
        </div>
        <div className="board-row">
          {this.renderSquare(6)}
          {this.renderSquare(7)}
          {this.renderSquare(8)}
        </div>
      </div>
    );
  }
}


// Initialization of game. Passes the choice of the user to Board, where the actual game will render.
class Game extends React.Component {
  constructor() {
    super();
    this.state = {
      hasChosen: false,
      isX: true,
    }
  }

  question() {
    return (
      <div className='questionRow'>
        Tic Tac Toe
        <br />
        <br />
        X or O?
        <br />
        <button className='button' onClick={() => this.test(true)}>X</button>
        <button className='button' onClick={() => this.test(false)}>O</button>
      </div>
    );
  }

  test(bool) {
    if (bool) {
      this.setState({
        hasChosen: true,
        isX: true,
      });
    } else {
      this.setState({
        hasChosen: true,
        isX: false,
      });
    }
  }

  render() {
    let board = null;

    if (!this.state.hasChosen) {
      board = this.question();
    } else {
      board = <Board isX={this.state.isX} />
    }

    return (
      <div>
        <div className="game">
          <div className="game-board">
          {board}
          </div>
        </div>
      </div>
    );
  }
}

/*
Where it calculates if there is a possible winner with the MiniMax loops, or ties.
Note: status does not render until there is an actual winner (not theoretical winners
made up by MiniMax), tested by the actual state of the board.
*/

function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      return squares[a];
    }
  }
  return null;
}

function isItATie(squares) {
  let copy = squares.slice();
  if (copy.some(element => !element)) {
    return false;
  } else {
    return true;
  }
}

ReactDOM.render(
  <Game />,
  document.getElementById('root')
);
