module test(a1,b1,a2,b2,a3,b3,a4,b4,s1,s2,s3,s4,c1,c2,c3,c4);
	input a1,a2,a3,a4,b1,b2,b3,b4;
	output s1,s2,s3,s4,c1,c2,c3,c4;
	assign s1=a1^b1;
	assign c1=a1&b1;
	assign s2=a1^b1^c1;
	assign c2=a2&b2 + a2&c1 + b2&c1;
	assign  s3=a2^b2^c2;
	assign c3=a3&b3 + a3&c2 + b3&c2;
	assign s4=a4^b4^c3;
	assign c4=a4&b4 + a4&c3 + b4&c3;
endmodule
module tg_test(a1,b1,a2,b2,a3,b3,a4,b4,s1,s2,s3,s4,c1,c2,c3,c4);
	input s1,s2,s3,s4,c1,c2,c3,c4;
	output reg  a1,a2,a3,a4,b1,b2,b3,b4;
	initial begin
		$dumpfile("rca.vcd");
		$dumpvars(a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,s1,s2,s3,s4);
		a1=1'b0;
		a2=1'b1;
		a3=1'b0;
		a4=1'b1;
		b1=1'b0;
		b2=1'b1;
		b3=1'b1;
		b4=1'b0;
		$monitor("addend is %b %b %b %b and augend is  %b %b %b %b s um is %b %b %b %b %b ",a4,a3,a2,a1,b4,b3,b2,b1,s4,s3,s2,s1,c4);
	end
endmodule
module wb;
	wire a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,s1,s2,s3,s4;
	test  mytest(a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,s1,s2,s3,s4);
	tg_test my_tg(a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,s1,s2,s3,s4);
endmodule
