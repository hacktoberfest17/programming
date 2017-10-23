(function(context) {

  var WINNERS = [
      [1,1,1,0,0,0,0,0,0],
      [0,0,0,1,1,1,0,0,0],
      [0,0,0,0,0,0,1,1,1],
      [1,0,0,1,0,0,1,0,0],
      [0,1,0,0,1,0,0,1,0],
      [0,0,1,0,0,1,0,0,1],
      [1,0,0,0,1,0,0,0,1],
      [0,0,1,0,1,0,1,0,0]
    ];

  var callbacks = {
    onTurnChanged: null,
    onFinished: null
  }

  Board.prototype.PLAYER_1=1;
  Board.prototype.PLAYER_2=-1;

  Board.prototype.STATE_NOT_STARTED=0;
  Board.prototype.STATE_PLAYING=1;
  Board.prototype.STATE_FINISHED=2;

  /**
   * Object prototype that encapsulates all the gaming logic.
   **/
  function Board() {
    this.state = this.STATE_NOT_STARTED;
  }

  // Initialize required variables and notify callbacks that the
  // game has started.
  Board.prototype.init = function() {
    this.board = [0,0,0,0,0,0,0,0,0];
    this.winner = 0;
    this.winningCells = null;
    this.nextPlayer = this.PLAYER_1;
    this.state = this.STATE_PLAYING;
    callbacks.onTurnChanged && callbacks.onTurnChanged(this);
  }


  Board.prototype.setCallback = function(type, callback) {
    callbacks[type] = callback;
  }

  // If allowed, execute a movement to the cell specified parameter
  // as the current player. Parameter i is the cell number on the board:
  //    0 1 2
  //    3 4 5
  //    6 7 8
  // Invalid board state or trying to play on a cell that is not empty
  // will be silently ignored. 0 <= i <= board.length is assumed to be true.
  Board.prototype.play = function(i) {
    if (this.state != this.STATE_PLAYING || this.board[i] != 0) {
      return false;
    }
    this.board[i] = this.nextPlayer;

    if (!checkWinners.apply(this) && checkAvailablePlays.apply(this)) {
      this.nextPlayer = this.nextPlayer * -1;
      callbacks.onTurnChanged && callbacks.onTurnChanged(this);
    } else {
      callbacks.onFinished && callbacks.onFinished(this);
    }
    return true;
  }

  // Return 0 for an empty cell and Board.PLAYER_1 or Board.PLAYER_2 for
  // a non-empty cell.
  Board.prototype.getCellState = function(cell) {
    return this.board[cell];
  }

  // Return one of the Board.STATE_* constants according to the current
  // state of the game.
  Board.prototype.getBoardState = function() {
    return this.state;
  }

  // Return 0, Board.PLAYER_1 or Board.PLAYER_2 depending on who is the
  // current turn's.
  Board.prototype.getNextPlayer = function() {
    return this.state == this.STATE_PLAYING ? this.nextPlayer : 0;
  }

  // Return 0, Board.PLAYER_1 or Board.PLAYER_2 depending on who won the
  // game.
  Board.prototype.getWinner = function() {
    return this.state == this.STATE_FINISHED ? this.winner : 0;
  }

  // Return a board mask with 1's representing the cells that have the
  // winning move and 0's on all the other cells.
  Board.prototype.getWinningCells = function() {
    return this.state == this.STATE_FINISHED ? this.winningCells : null;
  }

  // ---- private methods:

  // Return true if there is at least one empty cell in the board. Note
  // that this method has a side effect of setting  the game's state to a
  // draw if there is no remaining empty cell.
  function checkAvailablePlays() {
    for (var c=0; c < this.board.length; c++) {
      if (!this.board[c]) {
        return true;
      }
    }
    this.state = this.STATE_FINISHED;
    this.winner = 0;
    this.nextPlayer = 0;
    return false;
  }

  // Return true if the board has a winning combination. Note
  // that this method has a side effect of setting the game's state to
  // finished if a winning combination is found.
  function checkWinners() {
    // check possible solutions:
    for (var s=0; s < WINNERS.length; s++) {
      var maybeWinner = 0;
      for (var c=0; c < this.board.length; c++) {
        if (WINNERS[s][c] == 1) {
          if ( !this.board[c] || maybeWinner && this.board[c] != maybeWinner) {
            maybeWinner = 0;
            break;
          }
          if ( !maybeWinner || maybeWinner && this.board[c] == maybeWinner) {
            maybeWinner = this.board[c];
          }
        }
      }

      if (maybeWinner) {
        this.state = this.STATE_FINISHED;
        this.winner = maybeWinner;
        this.nextPlayer = 0;
        this.winningCells = WINNERS[s];
        return true;
      }
    }
    return false;
  }

  window.Board = Board;

})(window);