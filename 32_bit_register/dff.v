/*
NAME : DARSHAN D V    

DATE : 15-10-2017

THIS IS A MEMORY CELL. BASICALLY IT IS A D FLIP FLOP WHICH HAS D LATCH. THE D LATCH CONSISTS OF AN SR LATCH
WHERE SET AND RESET ARE GIVEN THE SAME INPUT.
*/


module sr_latch(s,r,q);
input s,r;
output q;


assign q=s|(~r&q);

endmodule


module d_latch(d,clk,q);
input d,clk;
output  q;

wire w1,w2,w3;

assign w1=~d&clk;
assign w2=d&clk;
sr_latch sr1(
	.s(w2),
	.r(w1),
	.q(w3)
);
assign q=w3;

endmodule



module dff(d,clk,q);
input d,clk;
output  q;
wire w1,q1,q2;

d_latch d1(
	.d(d),
	.clk(~clk),
	.q(q1)
);
d_latch d2(
	.d(q1),
	.clk(clk),
	.q(q2)
);
 assign q=q2;

endmodule
