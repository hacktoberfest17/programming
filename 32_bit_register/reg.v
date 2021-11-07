/*
NAME : DARSHAN D V     16CO216

DATE : 15-10-2017

THIS IS A 32 BIT REGISTER. HERE EACH BIT IS A D FLIP FLOP WHICH TAKES BITWISE INPUT 
AND STORES IT IN OUTPUT. THE ENTIRE 32 BIT INPUT IS LOADED TO THE OUTPUT IN 1 CLOCK CYCLE.
*/

`include "dff.v"

module register (clk, inp, out);
input [31:0]inp;
output [31:0]out;
input clk;

genvar i;
generate

for (i=0 ; i<32 ; i=i+1) begin
	dff d_ff(.clk(clk), .d(inp[i]), .q(out[i]));
end

endgenerate
endmodule
