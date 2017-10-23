document.addEventListener('DOMContentLoaded', function() {
  var gameEl = document.getElementById('game');
  var cells = game.querySelectorAll('.board .cell');

  window.board = new Board();

  window.board.setCallback('onTurnChanged', redrawBoard);
   // insert point C
        window.board.setCallback('onFinished', handleFinished);
  window.board.init()

  // set click listeners
  Array.prototype.forEach.call(cells, function(e, i) {
    e.setAttribute("board_cell", i );
    e.addEventListener('click', function(e) {
      window.board.play(i);
    });
  });

  function getPlayerLabel(board, player) {
    switch (player) {
      case board.PLAYER_1: return '1';
      case board.PLAYER_2: return '2';
      default: return '';
    }
  }

  function redrawBoard(board) {
    // redraw cell states:
    Array.prototype.forEach.call(cells, function(e, i) {
      var state = board.getCellState(i);
      if (state) {
        e.classList.add(state == board.PLAYER_1 ? 'tic' : 'tac');
      }
    });
    // insert point D
        drawStatusMessage(board);
  }

  // insert point E
      function drawStatusMessage(board) {
        // redraw "next player" status message:
        var message = '';
        switch (board.getBoardState()) {
          case board.STATE_PLAYING:
            message = 'Player '+getPlayerLabel(board, board.getNextPlayer());
            break;
          case board.STATE_FINISHED:
            if (board.getWinner()) {
              message = 'Winner: player '+getPlayerLabel(board, board.getWinner());
            } else {
              message = 'Draw!';
            }
            break;
        }
        game.querySelector('.controls .message').innerText = message;
      }

      game.querySelector('.controls .restart').addEventListener('click', function() {
        game.classList.remove('finished');
        Array.prototype.forEach.call(cells, function(e, i) {
          e.classList.remove('solution');
          e.classList.remove('tic');
          e.classList.remove('tac');
        });
        window.board.init();
        drawStatusMessage(board);
      });


      function handleFinished(board) {
        redrawBoard(board);
        game.classList.add('finished');
        if (board.getWinningCells()) {
          for (var c=0; c < board.getWinningCells().length ; c++) {
            if (board.getWinningCells()[c]) {
              cells.item(c).classList.add('solution');
            } else {
              cells.item(c).classList.remove('solution');
            }
          }
        }
      }
});