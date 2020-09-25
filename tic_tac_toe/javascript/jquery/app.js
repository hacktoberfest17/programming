var board = [0,1,2,3,4,5,6,7,8];
var human, ai, round = 0, reset = 1;

$(document).ready (function() {
	var sign = "x";
	human = sign.toUpperCase();
	ai = sign === "x" ? "O" : "X";

	$("#sign").on("click", function() {
		if (reset === 1) {
			if(sign === "x") {
				$("#sign").html("<strong>O</strong>");
				sign = "o";
			}
			else {
				$("#sign").html("<i id='x' class='fa fa-close'></i>");
				sign = "x";
			}
			human = sign.toUpperCase();
			ai = sign === "x" ? "O" : "X";
		}
		else alert("You can't change this while playing! Please reset to change it.");
	});

	$.each([1,2,3,4,5,6,7,8,9], function(i,val) {
		$("#"+val).on("click", function() {
			reset = 0;
			$("#"+val).html("<span>"+ human +"</span>");
			$("#"+val).css("padding","3.5% 0");
			$("#turn").text("Computer's Turn");
			$("#"+val).css("pointer-events", "none");
			board[val - 1] = human;
			console.log(board);
			if (winning(board, human)) {
				setTimeout(function() {
					alert("You win");
					restart();
				}, 500);
				return;
			}
			else if (round > 3) {
				setTimeout(function() {
					alert("Tie");
					restart();
				}, 500);
				return;
			}
			else {
				round++;
				var aiPos = minimax(board, ai).index;
				board[aiPos] = ai;
				console.log(board);
				setTimeout(function() {
					$("#"+(aiPos+1)).html("<span>"+ ai +"</span>");
					$("#"+(aiPos+1)).css("padding","3.5% 0");
					$("#"+(aiPos+1)).css("pointer-events", "none");
					$("#turn").text("Your Turn");
				}, 500);

				if (winning(board, ai)) {
					setTimeout(function() {
						alert("You Lose");
						restart();
					},600);
					return;
				}
				else if (round === 0) {
					setTimeout(function() {
						alert("Tie");
						restart();
					});
					return;
				}
			}
		});
	});

	$("#reset").on("click", function() {
		restart();
		console.log(board);
		console.log("reset: "+reset);
	});
});

function restart() {
	$("#turn").text("Your Turn");
	$.each([1,2,3,4,5,6,7,8,9], function(i,val) {
		$("#"+val).css("pointer-events","auto");
		$("#"+val).html("");
		$("#"+val).css("padding","15% 0");
	});
	round = 0;
	reset = 1;
	board = [0,1,2,3,4,5,6,7,8];
}

// the main minimax function, taken from https://github.com/ahmadabdolsaheb/minimaxarticle
function minimax(newBoard, player){
	//available spots
	var free = available(newBoard);

	// checks for the terminal states such as win, lose, and tie and returning a value accordingly
	if (winning(newBoard, human))	return {score:-10};
	else if (winning(newBoard, ai))	return {score:10};
	else if (free.length === 0)		return {score:0};

	// an array to collect all the objects
	var moves = [];

	// loop through available spots
	for (var i = 0; i < free.length; i++){
		var move = {};
		move.index = newBoard[free[i]];

		// set the empty spot to the current player
		newBoard[free[i]] = player;

		//if collect the score resulted from calling minimax on the opponent of the current player
		if (player === ai){
			var result = minimax(newBoard, human);
			move.score = result.score;
		}
		else{
			var result = minimax(newBoard, ai);
			move.score = result.score;
		}

		//reset the spot to empty
		newBoard[free[i]] = move.index;

		// push the object to the array
		moves.push(move);
	}

	// if it is the computer's turn loop over the moves and choose the move with the highest score
	var bestMove;
	if(player === ai){
		var bestScore = -10000;
		for(var i = 0; i < moves.length; i++){
			if(moves[i].score > bestScore){
				bestScore = moves[i].score;
				bestMove = i;
			}
		}
	}
	else{
		// else loop over the moves and choose the move with the lowest score
		var bestScore = 10000;
		for(var i = 0; i < moves.length; i++){
			if(moves[i].score < bestScore){
				bestScore = moves[i].score;
				bestMove = i;
			}
		}
	}

	// return the chosen move (object) from the array to the higher depth
	return moves[bestMove];
}

// returns the available spots on the board
function available(newboard){
	return  newboard.filter(s => s != "O" && s != "X");
}

// winning combinations using the board indexies for instace the first win could be 3 xes in a row
function winning(newboard, player){
	if (
        (newboard[0] === player && newboard[1] === player && newboard[2] === player) ||
        (newboard[3] === player && newboard[4] === player && newboard[5] === player) ||
        (newboard[6] === player && newboard[7] === player && newboard[8] === player) ||
        (newboard[0] === player && newboard[3] === player && newboard[6] === player) ||
	    (newboard[1] === player && newboard[4] === player && newboard[7] === player) ||
	    (newboard[2] === player && newboard[5] === player && newboard[8] === player) ||
	    (newboard[0] === player && newboard[4] === player && newboard[8] === player) ||
	    (newboard[2] === player && newboard[4] === player && newboard[6] === player)
    )		
		return true;
    else
    	return false;
}