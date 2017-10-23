module test(i1,i2,a1);
	input i1,i2;
	output a1;

	assign a1=(i1^i2);

endmodule
module tg_test(i1,i2,a1);
	output reg i1,i2;
	input a1;
	initial begin
		$dumpfile("basic3.vcd");
		$dumpvars(0,i1,i2,a1);
		$monitor($time,,,"i1=%b , i2=%b, a1=%b",i1,i2,a1);
		i1=1'b0;
		i2=1'b1;
		#5 i1=1'b1;
		#7 i2=1'b0;
		#10 $finish;
	end
endmodule
module wb;
	wire i1,i2,a1;
	test my_test (i1,i2,a1);
	tg_test my_tg (i1,i2,a1);
endmodule
