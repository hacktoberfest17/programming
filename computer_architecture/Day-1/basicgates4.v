// Implementation of NOT 
module test(i1,a1);
	input i1;
	output a1;

	assign a1=(!i1);

endmodule
module tg_test(i1,a1);
	output reg i1;
	input a1;
	initial begin
		$dumpfile("basic4.vcd");
		$dumpvars(0,i1,a1);
		$monitor($time,,,"i1=%b , a1=%b",i1,a1);
		i1=1'b0;
		//i2=1'b1;
		#5 i1=1'b1;
		//#7 i2=1'b0;
		#10 $finish;
	end
endmodule
module wb;
	wire i1,a1;
	test my_test (i1,a1);
	tg_test my_tg (i1,a1);
endmodule
