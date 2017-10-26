module counter(b,c,e,f);
	input b,c;
	output e,f;
	assign e=(~b)&c|b&(~c);
	assign f=~c;
endmodule
module init(b,c,e,f);
	output reg b,c;
	input e,f;
	initial begin
		$dumpfile("counter.vcd");
		$dumpvars(0,b,c,e,f);
		$monitor($time,,,"PS-b=%b,c=%b,NS-e=%b,f=%b",b,c,e,f);
		b=1'b0;
		c=1'b0;
		#5 b=1'b0; c=1'b1;
		#10 b=1'b1; c=1'b0;
		#15 b=1'b1; c=1'b1;
	end
endmodule
module testbench;
	wire b,c,e,f;
	init in(b,c,e,f);
	counter c_n(b,c,e,f);
endmodule
