module test(i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1);
	input i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3;
	output a1;
	
	//assign a1=i1&(!s1)&(!s2)&(!s3);
	assign a1=((i1&(!s1)&(!s2)&(!s3))|(i2&(!s1)&(!s2)&(s3))|(i3&(!s1)&(s2)&(!s3))|(i4&(!s1)&(s2)&(s3))|(i5&(s1)&(!s2)&(!s3))|(i6&(s1)&(!s2)&(s3))|(i7&(s1)&(s2)&(!s3))|(i8&(s1)&(s2)&(s3)));

endmodule
module tg_test(i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1);
	output reg s1,s2,s3,i1,i2,i3,i4,i5,i6,i7,i8;
	input a1;
	initial begin
		$dumpfile("mux.vcd");
		$dumpvars(0,s1,s2,s3,a1,i1,i2,i3,i4,i5,i6,i7,i8);
		$monitor($time,,,"i1=%b , i2=%b, i3=%b,i4=%b,i5=%b , i6=%b, i7=%b,i8=%b,s1=%b,s2=%b,s3=%b,a1=%b",i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1);
		i1=1'b0;
		i2=1'b0;
		i3=1'b0;
		i4=1'b0;
		i5=1'b0;
		i6=1'b0;
		i7=1'b0;
		i8=1'b0;
		s1=1'b0;
		s2=1'b0;
		s3=1'b0;
		//#5 i1=1'b1;s1=1'b0;s2=1'b0;s3=1'b0;
		#1 s1=1'b0;s2=1'b0;s3=1'b0;i1=1'b1;
		#2 s1=1'b0;s2=1'b0;s3=1'b1;i1=1'b0;i2=1'b1;
		#3 s1=1'b0;s2=1'b1;s3=1'b0;i2=1'b0;i3=1'b1;
		#5 s1=1'b0;s2=1'b1;s3=1'b1;i3=1'b0;i4=1'b1;
		#6 s1=1'b1;s2=1'b0;s3=1'b0;i4=1'b0;i5=1'b1;
		#8 s1=1'b1;s2=1'b0;s3=1'b1;i5=1'b0;i6=1'b1;
		#9  s1=1'b1;s2=1'b1;s3=1'b0;i6=1'b0;i7=1'b1;
		#10 s1=1'b1;s2=1'b1;s3=1'b1;i7=1'b0;i8=1'b1;
		#11 $finish;
	end
endmodule
module wb;
	wire i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1;
	test my_test (i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1);
	tg_test my_tg (i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1);
endmodule
