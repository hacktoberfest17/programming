/* =============================
   *** Hail Stack Overflow ***
================================ */

//Global variables
var on = false;
var resetIsNotReset = false;
var patterns = ["G","R","Y","B"];
var simonPattern = [];
var humanPattern = [];
var count = 0;
var  keepTrack = 0;

$(document).ready(function(){

	function reset(){

		simonPattern = [];
		humanPattern = [];
		count = 0;
		keepTrack = 0;

		$("#green, #red, #yellow, #blue").removeClass('cursor');
		$("#start").removeClass("hide");
		$("#reset").addClass("hide");

		if(on){
			$("#count").val("--");
		}
		else{
			$("#count").val("");
		}
		return;

	}

	function converter(arg){	//Convert audio id to element id and vice-versa
		if(arg=="green")
			return "G";
		else if(arg=="red")
			return "R";
		else if(arg=="yellow")
			return "Y";
		else if(arg=="blue")
			return "B";
		else if(arg=="G")
			return "green";
		else if(arg=="R")
			return "red";
		else if(arg=="Y")
			return "yellow";
		else if(arg=="B")
			return "blue";
	}

	function simon(pattern){		//Produce the pattern
		var i=0;
		var timer = setInterval(function(){
			if(!on || resetIsNotReset || i==pattern.length){
				clearInterval(timer);
			}
			else{
				var color = converter(pattern[i]);
				var audio = document.getElementById(pattern[i]);
				$("#"+color).fadeIn('500').fadeOut('500').fadeIn('500');
				audio.play();
				i++;
			}
		},800);

		setTimeout(function(){
			game("human");
		},900*pattern.length);

		return;
	}

	function human(id){			//Human function
		var color = converter(id);
		humanPattern.push(color);
		if(humanPattern[keepTrack]!==simonPattern[keepTrack]){	//Check if pattern is wrong
			$("span").css("pointer-events", "none");
			$("#"+id).fadeIn('500').fadeOut('500').fadeIn('500').fadeOut('500').fadeIn('500');
			$("#count").val('!!');
			$("#count").fadeIn('500').fadeOut('500').fadeIn('500').fadeOut('500').fadeIn('500');
			document.getElementById('wrong').play();
			keepTrack = 0;
			humanPattern = [];
			if($("#strict").hasClass('box-shadow')){	//If not strict mode
				setTimeout(function(){
					simon(simonPattern);
					$("#count").val((count<10) ? '0'+count : count);
					$("#count").fadeIn('500').fadeOut('500').fadeIn('500');
				},2000);
			}
			else{		//If strict mode
				setTimeout(function(){
					simonPattern = [];
					count = 0;
					game("simon");
				},2000);
			}
		}
		else{		//If pattern is correct, update + continue
			$("#"+id).fadeIn('500').fadeOut('500').fadeIn('500');
			var audio = document.getElementById(color);
			audio.play();
			keepTrack = keepTrack + 1;
		}
		if(keepTrack==count){	//if count over
			keepTrack = 0;
			humanPattern = [];
			if(count == 20){
				simonPattern = [];
				count = 0;
				$("#count").val('0'+count);
				end();
				setTimeout(function(){
					return game("simon");
				},3100);
			}
			else{
				return game("simon");
			}
		}
	}

	function game(turn){

		if(turn=="simon" && count<=20){
			if(!on || resetIsNotReset){
				return;
			}
			$("span").css("pointer-events", "none");
			setTimeout(function(){
				if(!on || resetIsNotReset){
					return;
				}
				count = count + 1;
				$("#count").val((count<10) ? '0'+count : count);
				$("#count").fadeIn('500').fadeOut('500').fadeIn('500');
				var random = Math.floor(Math.random()*4);
				simonPattern.push(patterns[random]);
				simon(simonPattern);
			},500);
		}

		else if(turn=="human"){
			$("span").css("pointer-events", "auto");
			if(!on || resetIsNotReset){
				return;
			}
			$("span").off('click');
			$("span").on('click',function(){
				return human(this.id);
			});
		}
		return;

	}

	function end(){
		setTimeout(function(){
			$("#simon").addClass("hide");
			$("#result").removeClass("hide");
			setTimeout(function(){
				$("#green").fadeIn('500').fadeOut('500').fadeIn('500');
			},100);
			setTimeout(function(){
				$("#red").fadeIn('500').fadeOut('500').fadeIn('500');
			},200);
			setTimeout(function(){
				$("#yellow").fadeIn('500').fadeOut('500').fadeIn('500');
			},300);
			setTimeout(function(){
				$("#blue").fadeIn('500').fadeOut('500').fadeIn('500');
			},400);
		},1000);

		setTimeout(function(){
			$("#simon").removeClass("hide");
			$("#result").addClass("hide");
		},3000);
	}

	$("#on-off").change(function(){
		on = $(this).prop('checked');
		if(on){
			$("#count").val("--");
		}
		else{
			$("#count").val("");
			$("#strict").addClass("box-shadow");
			$("#strict").css({'background-color':'darkorange'});
			reset();
		}
	});

	$("#start").click(function(){
		if(on){
			resetIsNotReset = false;
			$("#green, #red, #yellow, #blue").addClass('cursor');
			$("#start").addClass("hide");
			$("#reset").removeClass("hide");
			game("simon");
		}
	});

	$("#reset").click(function(){
		if(on){
			resetIsNotReset = true;
			reset();
		}
	});

	$("#strict").click(function(){
		var bool = $(this).hasClass("box-shadow");
		if(bool && on){
			$("#strict").removeClass("box-shadow");
			$("#strict").css({'background-color':'crimson'});
		}
		else{
			$("#strict").addClass("box-shadow");
			$("#strict").css({'background-color':'darkorange'});
		}
	});

});
