//Tic Tac Toe game in JavaScript with two different levels
//Author: Bharath Kumar
//Github: https://github.com/iambk

/* GLOBAL variables */
var human = "X";	//Default
var computer = "O";	//Default
var humanMoves = [];
var computerMoves = [];
var player1Moves = [];
var player2Moves = [];
var level = "";
var turn = "";
var ai;
var result;
var winMoves = [
	[0,1,2],
	[0,3,6],
	[0,4,8],
	[1,4,7],
	[2,5,8],
	[2,4,6],
	[3,4,5],
	[6,7,8]
];
var board = [
	'E', 'E', 'E',
	'E', 'E', 'E',
	'E', 'E', 'E'
];

$(document).ready(function(){

	function reset(){
		$("#tictactoe").hide().fadeIn('fast');
		$("#X").removeClass("shadow");
		$("#O").removeClass("shadow");
		$("#Xturn").addClass("hide");
		$("#Oturn").addClass("hide");
		if(level=="noob"||level=="pro"){
			$("#playAs").removeClass("hide");
		}
		humanMoves = [];
		computerMoves = [];
		player1Moves = [];
		player2Moves = [];
		turn = "";
		board = [
			'E', 'E', 'E',
			'E', 'E', 'E',
			'E', 'E', 'E'
		];
		$("td").html("");
		$("input").val(0);
	}

	/* Check for win and implement effects*/
	function checkWin(moves){
		for(var i=0;i<winMoves.length;i++){
			if(moves.indexOf(winMoves[i][0])!==-1 && moves.indexOf(winMoves[i][1])!==-1 && moves.indexOf(winMoves[i][2])!==-1){
				setTimeout(function(){
					$("#"+winMoves[i][0]).addClass('color');
					$("#"+winMoves[i][1]).addClass('color');
					$("#"+winMoves[i][2]).addClass('color');
				},400);
				return true;
			}
		}
		return false;
	}

	/* Return end score for minimax */
	function score(boardState){
		for(var i=0;i<winMoves.length;i++){
			if(boardState[winMoves[i][0]]==human && boardState[winMoves[i][1]]==human && boardState[winMoves[i][2]]==human)
				return -10;
			else if(boardState[winMoves[i][0]]==computer && boardState[winMoves[i][1]]==computer && boardState[winMoves[i][2]]==computer)
				return +10;
		}
		if(boardState.indexOf('E')==-1)
			return 0;
	}

	function minimax(board,depth,maximizingPlayer){
		var bestValue;
		var scoreCheck = score(board);

		if(scoreCheck==-10)
			return depth-10;
		else if(scoreCheck==10)
			return 10-depth;
		else if(scoreCheck===0)
			return 0;
		
		if(maximizingPlayer){
			bestValue = -1000;
			for(var child=0;child<9;child++){
				if(board[child]=='E'){
					board[child]=computer;
					var val = minimax(board,depth+1,false);
					bestValue = Math.max(bestValue,val);
					board[child]='E';
				}
			}
			return bestValue;	
		}
		else{
			bestValue = +1000;
			for(var child=0;child<9;child++){
				if(board[child]=='E'){
					board[child]=human;
					var val = minimax(board,depth+1,true);
					bestValue = Math.min(bestValue,val);
					board[child]='E';
				}
			}
			return bestValue;
		}
	}

	function bestMove(board){
		var bestVal = -1000;
		for(var i=0;i<9;i++){
			if(board[i]=='E'){
				board[i]=computer;
				var moveVal = minimax(board,0,false);
				board[i]='E';
				if(moveVal>bestVal){
					ai = i;
					bestVal = moveVal;
				}
			}
		}
		return ai;
	}

	/* Level Pro */
	function pro(){
		reset();
		if(level=="friend"||level=="noob"){
			return;
		}
		$("#"+human+"").addClass("shadow");
		$("#"+human+"turn").removeClass("hide");

		var turn = "human";	//Local variable turn

		if(turn=="human"){
			$("td").click(function(){
				if(level=="friend"||level=="noob"||turn=="computer"){
					return false;
				}
				$("#playAs").addClass("hide");
				var id = this.id;
				if(board[id]=='E'){
					turn = "computer";
					$("#"+id).html(human);
					humanMoves.push(Number(id));
					board[id] = human;
					$("#ai").removeClass("hide");
					$("#"+computer+"").addClass("shadow");
					$("#"+human+"").removeClass("shadow");
					$("#"+human+"turn").addClass("hide");
					$("#"+computer+"turn").removeClass("hide");
					if(humanMoves.length>=3){
						result = checkWin(humanMoves);
						if(result){
							$("td").click(function(){
								return false;
							});
							turn="human";
							$("#ai").addClass("hide");
							$("#playAs").removeClass("hide");
							$("#"+computer+"").removeClass("shadow");
							$("#"+computer+"turn").addClass("hide");
							$("#"+human+" input").val(Number($("#"+human+" input").val())+1);
							setTimeout(function(){
								$("td").html("");
								$("table").addClass('hide');
								$("#result").removeClass('hide');
								$("#result").html("	Congrats <br>	you <br>	Won !!");
								humanMoves = [];
								computerMoves = [];
								board = [
									'E', 'E', 'E',
									'E', 'E', 'E',
									'E', 'E', 'E'
								];
								$("td").removeClass('color');
								setTimeout(function(){
									$("#result").addClass('hide')
									$("table").removeClass('hide');
									if(turn=="computer"){
										$("#ai").removeClass("hide");
										$("#"+computer+"").addClass("shadow");
										$("#"+human+"").removeClass("shadow");
										$("#"+human+"turn").addClass("hide");
										$("#"+computer+"turn").removeClass("hide");
									}
									else{
										$("#ai").addClass("hide");
										$("#"+human+"").addClass("shadow");
										$("#"+computer+"").removeClass("shadow");
										$("#"+computer+"turn").addClass("hide");
										$("#"+human+"turn").removeClass("hide");
									}
								},2000);		
							},1200);
						}
						else if(!result && humanMoves.length+computerMoves.length==9){
							$("td").click(function(){
								return false;
							});
							turn="human";
							$("#ai").addClass("hide");
							$("#playAs").addClass("hide");
							$("#"+computer+"").removeClass("shadow");
							$("#"+computer+"turn").addClass("hide");								
							setTimeout(function(){
								$("td").html("");
								$("table").addClass('hide');
								$("#result").removeClass('hide');
								$("#result").html("<br>		X-O <br>		Draw ");
								humanMoves = [];
								computerMoves = [];
								board = [
									'E', 'E', 'E',
									'E', 'E', 'E',
									'E', 'E', 'E'
								];
								$("td").removeClass('color');
								setTimeout(function(){
									$("#result").addClass('hide')
									$("table").removeClass('hide');
									if(turn=="computer"){
										$("#ai").removeClass("hide");
										$("#"+computer+"").addClass("shadow");
										$("#"+human+"").removeClass("shadow");
										$("#"+human+"turn").addClass("hide");
										$("#"+computer+"turn").removeClass("hide");
									}
									else{
										$("#ai").addClass("hide");
										$("#"+human+"").addClass("shadow");
										$("#"+computer+"").removeClass("shadow");
										$("#"+computer+"turn").addClass("hide");
										$("#"+human+"turn").removeClass("hide");
									}
								},2000);		
							},1200);
						}	
					}
				}
				if(turn=="computer"){
					$("td").click(function(){
						return false;
					});
					setTimeout(function(){

						turn = "human";
						$("#ai").addClass("hide");

						ai = bestMove(board);
						$("#"+ai).html(computer);
						computerMoves.push(Number(ai));
						board[ai] = computer;
						$("#ai").addClass("hide");
						$("#"+human+"").addClass("shadow");
						$("#"+computer+"").removeClass("shadow");
						$("#"+computer+"turn").addClass("hide");
						$("#"+human+"turn").removeClass("hide");
						if(computerMoves.length>=3){
							result = checkWin(computerMoves);
							if(result){
								$("td").click(function(){
									return false;
								});
								$("#ai").addClass("hide");
								$("#playAs").removeClass("hide");
								$("#"+human+"").removeClass("shadow");
								$("#"+human+"turn").addClass("hide");
								$("#"+computer+" input").val(Number($("#"+computer+" input").val())+1);									
								setTimeout(function(){
									$("td").html("");
									$("table").addClass('hide');
									$("#result").removeClass('hide');
									$("#result").html("	Haha <br>	you <br>	Lose !!");
									humanMoves = [];
									computerMoves = [];
									board = [
										'E', 'E', 'E',
										'E', 'E', 'E',
										'E', 'E', 'E'
									];
									$("td").removeClass('color');
									setTimeout(function(){
										$("#result").addClass('hide');
										$("table").removeClass('hide');
										if(turn=="computer"){
											$("#ai").removeClass("hide");
											$("#"+computer+"").addClass("shadow");
											$("#"+human+"").removeClass("shadow");
											$("#"+human+"turn").addClass("hide");
											$("#"+computer+"turn").removeClass("hide");
										}
										else{
											$("#ai").addClass("hide");
											$("#"+human+"").addClass("shadow");
											$("#"+computer+"").removeClass("shadow");
											$("#"+computer+"turn").addClass("hide");
											$("#"+human+"turn").removeClass("hide");
										}
									},2000);		
								},1200);
							}
							else if(!result && humanMoves.length+computerMoves.length==9){
								$("td").click(function(){
									return false;
								});
								$("#ai").addClass("hide");
								$("#playAs").removeClass("hide");
								$("#"+human+"").removeClass("shadow");
								$("#"+human+"turn").addClass("hide");
								setTimeout(function(){
									$("td").html("");
									$("table").addClass('hide');
									$("#result").removeClass('hide');
									$("#result").html("<br>		X-O <br>		Draw ");
									humanMoves = [];
									computerMoves = [];
									board = [
										'E', 'E', 'E',
										'E', 'E', 'E',
										'E', 'E', 'E'
									];
									$("td").removeClass('color');
									setTimeout(function(){
										$("#result").addClass('hide')
										$("table").removeClass('hide');
										if(turn=="computer"){
											$("#ai").removeClass("hide");
											$("#"+computer+"").addClass("shadow");
											$("#"+human+"").removeClass("shadow");
											$("#"+human+"turn").addClass("hide");
											$("#"+computer+"turn").removeClass("hide");
										}
										else{
											$("#ai").addClass("hide");
											$("#"+human+"").addClass("shadow");
											$("#"+computer+"").removeClass("shadow");
											$("#"+computer+"turn").addClass("hide");
											$("#"+human+"turn").removeClass("hide");
										}
									},2000);		
								},1200);
							}	
						}
					},1000);	
				}	
			});	
		}
	}

	/* Two players */
	function twoPlayers(){
		reset();
		if(level=="noob"||level=="pro"){
			return;
		}
		$("#X").addClass("shadow");
		$("#Xturn").removeClass("hide");
		/* We are assuming player 1 as X and player 2 as O */

		turn = "player1";

		if(level=="friend"){
			$("td").click(function(){
				if(level=="noob"||level=="pro"){
					return false;
				}
				var id = this.id;
				if(turn=="player1"){
					if(player1Moves.indexOf(Number(id))==-1 && player2Moves.indexOf(Number(id))==-1){
						turn = "player2";
						$("#"+id).html("X");
						player1Moves.push(Number(id));
						$("#O").addClass("shadow");
						$("#X").removeClass("shadow");
						$("#Xturn").addClass("hide");
						$("#Oturn").removeClass("hide");
						if(player1Moves.length>=3){
							result = checkWin(player1Moves);
							if(result){
								$("#O").removeClass("shadow");
								$("#Oturn").addClass("hide");
								$("#X input").val(Number($("#X input").val())+1);
								setTimeout(function(){
									$("td").html("");
									$("table").addClass('hide');
									$("#result").removeClass('hide');
									$("#result").html("	Player 1 <br>	X <br>	Wins !!");
									player1Moves = [];
									player2Moves = [];
									$("td").removeClass('color');
									setTimeout(function(){
										$("#result").addClass('hide')
										$("table").removeClass('hide');
										if(turn=="player2"){
											$("#O").addClass("shadow");
											$("#X").removeClass("shadow");
											$("#Xturn").addClass("hide");
											$("#Oturn").removeClass("hide");
										}
										else{
											$("#X").addClass("shadow");
											$("#O").removeClass("shadow");
											$("#Oturn").addClass("hide");
											$("#Xturn").removeClass("hide");
										}
									},2000);		
								},1200);
							}
							else if(!result && player1Moves.length+player2Moves.length==9){
								$("#O").removeClass("shadow");
								$("#Oturn").addClass("hide");
								setTimeout(function(){
									$("td").html("");
									$("table").addClass('hide');
									$("#result").removeClass('hide');
									$("#result").html("<br>		X-O <br>		Draw ");
									player1Moves = [];
									player2Moves = [];
									$("td").removeClass('color');
									setTimeout(function(){
										$("#result").addClass('hide')
										$("table").removeClass('hide');
										if(turn=="player2"){
											$("#O").addClass("shadow");
											$("#X").removeClass("shadow");
											$("#Xturn").addClass("hide");
											$("#Oturn").removeClass("hide");
										}
										else{
											$("#X").addClass("shadow");
											$("#O").removeClass("shadow");
											$("#Oturn").addClass("hide");
											$("#Xturn").removeClass("hide");
										}
									},2000);		
								},1200);
							}	
						}
					}
				}
				else if(turn=="player2"){
					if(player1Moves.indexOf(Number(id))==-1 && player2Moves.indexOf(Number(id))==-1){
						turn = "player1";
						$("#"+id).html("O");
						player2Moves.push(Number(id));
						$("#X").addClass("shadow");
						$("#O").removeClass("shadow");
						$("#Oturn").addClass("hide");
						$("#Xturn").removeClass("hide");
						if(player2Moves.length>=3){
							result = checkWin(player2Moves);
							if(result){
								$("#X").removeClass("shadow");
								$("#Xturn").addClass("hide");
								$("#O input").val(Number($("#O input").val())+1);
								setTimeout(function(){
									$("td").html("");
									$("table").addClass('hide');
									$("#result").removeClass('hide');
									$("#result").html("	Player 2 <br>	O <br>	Wins !!");
									player1Moves = [];
									player2Moves = [];
									$("td").removeClass('color');
									setTimeout(function(){
										$("#result").addClass('hide')
										$("table").removeClass('hide');
										if(turn=="player2"){
											$("#O").addClass("shadow");
											$("#X").removeClass("shadow");
											$("#Xturn").addClass("hide");
											$("#Oturn").removeClass("hide");
										}
										else{
											$("#X").addClass("shadow");
											$("#O").removeClass("shadow");
											$("#Oturn").addClass("hide");
											$("#Xturn").removeClass("hide");
										}
									},2000);		
								},1200);
							}
							else if(!result && player1Moves.length+player2Moves.length==9){
								$("#X").removeClass("shadow");
								$("#Xturn").addClass("hide");
								setTimeout(function(){
									$("td").html("");
									$("table").addClass('hide');
									$("#result").removeClass('hide');
									$("#result").html("<br>		X-O <br>		Draw ");
									player1Moves = [];
									player2Moves = [];
									$("td").removeClass('color');
									setTimeout(function(){
										$("#result").addClass('hide')
										$("table").removeClass('hide');
										if(turn=="player2"){
											$("#O").addClass("shadow");
											$("#X").removeClass("shadow");
											$("#Xturn").addClass("hide");
											$("#Oturn").removeClass("hide");
										}
										else{
											$("#X").addClass("shadow");
											$("#O").removeClass("shadow");
											$("#Oturn").addClass("hide");
											$("#Xturn").removeClass("hide");
										}
									},2000);		
								},1200);
							}	
						}
					}
				}
			});
		}
	}

	function noob(){
		reset();
		if(level=="friend"||level=="pro"){
			return;
		}
		$("#"+human+"").addClass("shadow");
		$("#"+human+"turn").removeClass("hide");

		var turn = "human";	//Local turn

		if(turn=="human"){
			$("td").click(function(){
				if(level=="friend"||level=="pro"||turn=="computer"){
					return false;
				}
				$("#playAs").addClass("hide");
				var id = this.id;
				if(humanMoves.indexOf(Number(id))==-1 && computerMoves.indexOf(Number(id))==-1){
					turn = "computer";
					$("#"+id).html(human);
					humanMoves.push(Number(id));
					$("#"+computer+"").addClass("shadow");
					$("#"+human+"").removeClass("shadow");
					$("#"+human+"turn").addClass("hide");
					$("#"+computer+"turn").removeClass("hide");
					if(humanMoves.length>=3){
						result = checkWin(humanMoves);
						if(result){
							$("td").click(function(){
								return false;
							});
							turn="human";
							$("#playAs").removeClass("hide");
							$("#"+computer+"").removeClass("shadow");
							$("#"+computer+"turn").addClass("hide");
							$("#"+human+" input").val(Number($("#"+human+" input").val())+1);
							setTimeout(function(){
								$("td").html("");
								$("table").addClass('hide');
								$("#result").removeClass('hide');
								$("#result").html("	Congrats <br>	you <br>	Won !!");
								humanMoves = [];
								computerMoves = [];
								$("td").removeClass('color');
								setTimeout(function(){
									$("#result").addClass('hide')
									$("table").removeClass('hide');
									if(turn=="computer"){
										$("#"+computer+"").addClass("shadow");
										$("#"+human+"").removeClass("shadow");
										$("#"+human+"turn").addClass("hide");
										$("#"+computer+"turn").removeClass("hide");
									}
									else{
										$("#"+human+"").addClass("shadow");
										$("#"+computer+"").removeClass("shadow");
										$("#"+computer+"turn").addClass("hide");
										$("#"+human+"turn").removeClass("hide");
									}
								},2000);		
							},1200);
						}
						else if(!result && humanMoves.length+computerMoves.length==9){
							$("td").click(function(){
								return false;
							});
							turn="human";
							$("#playAs").addClass("hide");
							$("#"+computer+"").removeClass("shadow");
							$("#"+computer+"turn").addClass("hide");								
							setTimeout(function(){
								$("td").html("");
								$("table").addClass('hide');
								$("#result").removeClass('hide');
								$("#result").html("<br>		X-O <br>		Draw ");
								humanMoves = [];
								computerMoves = [];
								$("td").removeClass('color');
								setTimeout(function(){
									$("#result").addClass('hide')
									$("table").removeClass('hide');
									if(turn=="computer"){
										$("#"+computer+"").addClass("shadow");
										$("#"+human+"").removeClass("shadow");
										$("#"+human+"turn").addClass("hide");
										$("#"+computer+"turn").removeClass("hide");
									}
									else{
										$("#"+human+"").addClass("shadow");
										$("#"+computer+"").removeClass("shadow");
										$("#"+computer+"turn").addClass("hide");
										$("#"+human+"turn").removeClass("hide");
									}
								},2000);		
							},1200);
						}	
					}
				}
				if(turn=="computer"){
					setTimeout(function(){
						$("td").click(function(){
							return false;
						});
						while(true){
							ai = Math.floor(Math.random()*9+1);
							if(humanMoves.indexOf(Number(ai))==-1 && computerMoves.indexOf(Number(ai))==-1)
								break;
						}
						turn = "human";
						$("#"+ai).html(computer);
						computerMoves.push(Number(ai));
						$("#"+human+"").addClass("shadow");
						$("#"+computer+"").removeClass("shadow");
						$("#"+computer+"turn").addClass("hide");
						$("#"+human+"turn").removeClass("hide");
						if(computerMoves.length>=3){
							result = checkWin(computerMoves);
							if(result){
								$("td").click(function(){
									return false;
								});
								$("#playAs").removeClass("hide");
								$("#"+human+"").removeClass("shadow");
								$("#"+human+"turn").addClass("hide");
								$("#"+computer+" input").val(Number($("#"+computer+" input").val())+1);									
								setTimeout(function(){
									$("td").html("");
									$("table").addClass('hide');
									$("#result").removeClass('hide');
									$("#result").html("	Haha <br>	you <br>	Lose !!");
									humanMoves = [];
									computerMoves = [];
									$("td").removeClass('color');
									setTimeout(function(){
										$("#result").addClass('hide');
										$("table").removeClass('hide');
										if(turn=="computer"){
											$("#"+computer+"").addClass("shadow");
											$("#"+human+"").removeClass("shadow");
											$("#"+human+"turn").addClass("hide");
											$("#"+computer+"turn").removeClass("hide");
										}
										else{
											$("#"+human+"").addClass("shadow");
											$("#"+computer+"").removeClass("shadow");
											$("#"+computer+"turn").addClass("hide");
											$("#"+human+"turn").removeClass("hide");
										}
									},2000);		
								},1200);
							}
							else if(!result && humanMoves.length+computerMoves.length==9){
								$("td").click(function(){
									return false;
								});
								$("#playAs").removeClass("hide");
								$("#"+human+"").removeClass("shadow");
								$("#"+human+"turn").addClass("hide");
								setTimeout(function(){
									$("td").html("");
									$("table").addClass('hide');
									$("#result").removeClass('hide');
									$("#result").html("<br>		X-O <br>		Draw ");
									humanMoves = [];
									computerMoves = [];
									$("td").removeClass('color');
									setTimeout(function(){
										$("#result").addClass('hide')
										$("table").removeClass('hide');
										if(turn=="computer"){
											$("#"+computer+"").addClass("shadow");
											$("#"+human+"").removeClass("shadow");
											$("#"+human+"turn").addClass("hide");
											$("#"+computer+"turn").removeClass("hide");
										}
										else{
											$("#"+human+"").addClass("shadow");
											$("#"+computer+"").removeClass("shadow");
											$("#"+computer+"turn").addClass("hide");
											$("#"+human+"turn").removeClass("hide");
										}
									},2000);		
								},1200);
							}	
						}
					},1000);	
				}	
			});	
		}
	}

	/* <!-- SELECT OPTIONS and BUTTON --> */

	$("#playerSelect").change(function(){
		human = $('#playerSelect option:selected').val();
		computer = (human == "X") ? "O" : "X" ;
		$("#"+human+"").addClass("shadow");
		$("#"+computer+"").removeClass("shadow");
		$("#"+computer+"turn").addClass("hide");
		$("#"+human+"turn").removeClass("hide");
	});

	$("#levelSelect").change(function(){
		level = $('#levelSelect option:selected').val();
		if(level=="friend"){
			$("#playAs").addClass("hide");
			twoPlayers();
		}
		else{
			$("#playAs").removeClass("hide");
			if(level=="noob"){
				noob();
			}
			else if(level=="pro"){
				pro();
			}
		}
	});

	//If level isn't selected 
	$("td").click(function(){
		if(level=="")
			alert("Please chooose a level");	
	});

	$("#reset").click(reset);
});