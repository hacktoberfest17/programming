module test(i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1);
	input a1,s1,s2,s3;
	output i1,i2,i3,i4,i5,i6,i7,i8;
	
	assign i1=(a1&(!s1)&(!s2)&(!s3));
	assign i2=(a1&(!s1)&(!s2)&(s3));
        assign i3=(a1&(!s2)&(s1)&(!s3));
        assign i4= (a1&(!s1)&(s2)&(s3));
	assign i5= (a1&(s1)&(!s2)&(!s3));
	assign i6= (a1&(s1)&(!s2)&(s3));
	assign i7= (a1&(s1)&(s2)&(!s3));
	assign i8= (a1&(s1)&(s2)&(s3));

endmodule
module tg_test(i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1);
	output reg s1,s2,s3,a1;
	input i1,i2,i3,i4,i5,i6,i7,i8;
	initial begin
		$dumpfile("de.vcd");
		$dumpvars(0,s1,s2,s3,a1);
		$monitor($time,,,"a1=%b , s1=%b, s2=%b,s3=%b,i1=%b,i2=%b,i3=%b,i4=%b,i5=%b,i6=%b,i7=%b,s3=%b,i8=%b",a1,s1,s2,s3,i1,i2,i3,i4,i5,i6,i7,i8);
		
		
		//i3=1'b0;
		//i4=1'b0;
		s1=1'b0;
		s2=1'b0;
		s3=1'b0;
		a1=1'b1;
		#1 s1=1'b0;s2=1'b0;s3=1'b0;a1=1'b1;
		#2 s1=1'b0;s2=1'b1;
		#3 a1=1'b1;
		#5 s1=1'b1;s2=1'b0;a1=1'b1;
		#6 a1=1'b0;
		#8 s1=1'b1;s2=1'b1;
		#9 a1=1'b1;
		#10 $finish;
	end
endmodule
module wb;
	wire i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1;
	test my_test (i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1);
	tg_test my_tg (i1,i2,i3,i4,i5,i6,i7,i8,s1,s2,s3,a1);
endmodule
