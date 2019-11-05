module rca(a0,a1,a2,a3,a4,a5,a6,a7,b0,b1,b2,b3,b4,b5,b6,b7,car1,car2,car3,car4,car5,car6,car7,car8,s0,s1,s2,s3,s4,s5,s6,s7);
	input a0,a1,a2,a3,a4,a5,a6,a7,b0,b1,b2,b3,b4,b5,b6,b7;
	output car1,car2,car3,car4,car5,car6,car7,car8,s0,s1,s2,s3,s4,s5,s6,s7;
	assign s0=a0^b0^0;
	assign car1=(a0&b0)|(0&(a0^b0));
	assign s1=a1^b1^car1;
	assign car2=(a1&b1)|(car1&(a1^b1));
	assign s2=a2^b2^car2;
	assign car3=(a2&b2)|(car2&(a2^b2));
	assign s3=a3^b3^car3;
	assign car4=(a3&b3)|(car3&(a3^b3));
	assign s4=a4^b4^car4;
	assign car5=(a4&b4)|(car4&(a4^b4));
	assign s5=a5^b5^car5;
	assign car6=(a5&b5)|(car5&(a5^b5));
	assign s6=a6^b6^car6;
	assign car7=(a6&b6)|(car6&(a6^b6));
	assign s7=a7^b7^car7;
	assign car8=(a7&b7)|(car7&(a7^b7));
endmodule
module rca1(a0,a1,a2,a3,a4,a5,a6,a7,b0,b1,b2,b3,b4,b5,b6,b7,car1,car2,car3,car4,car5,car6,car7,car8,s0,s1,s2,s3,s4,s5,s6,s7);
	output reg a0,a1,a2,a3,a4,a5,a6,a7,b0,b1,b2,b3,b4,b5,b6,b7;
	input car1,car2,car3,car4,car5,car6,car7,car8,s0,s1,s2,s3,s4,s5,s6,s7;
	initial begin		
		$dumpfile("rca8.vcd");
		$dumpvars(0,a0,a1,a2,a3,a4,a5,a6,a7,b0,b1,b2,b3,b4,b5,b6,b7,car1,car2,car3,car4,car5,car6,car7,car8,s0,s1,s2,s3,s4,s5,s6,s7);
		a0=1'b0;
		a1=1'b0;
		a2=1'b0;
		a3=1'b0;
		a4=1'b0;
		a5=1'b0;
		a6=1'b0;
		a7=1'b0;
		b0=1'b0;
		b1=1'b0;
		b2=1'b0;
		b3=1'b0;
		b4=1'b0;
		b5=1'b0;
		b6=1'b0;
		b7=1'b0;
		$monitor($time,,,"addend=%b %b %b %b %b %b %b %b, augend=%b %b %b %b %b %b %b %b, sum=%b %b %b %b %b %b %b %b %b",b7,b6,b5,b4,b3,b2,b1,b0,a7,a6,a5,a4,a3,a2,a1,a0,car8,s7,s6,s5,s4,s3,s2,s1,s0);
		#5 a7=1'b1;a6=1'b0;a5=1'b1;a4=1'b1;a3=1'b1;a2=1'b0;a1=1'b1;a0=1'b1;
		   b7=1'b0;b6=1'b0;b5=1'b1;b4=1'b1;b3=1'b0;b2=1'b0;b1=1'b1;b0=1'b1;
		#5 a7=1'b0;a6=1'b1;a5=1'b1;a4=1'b1;a3=1'b0;a2=1'b1;a1=1'b1;a0=1'b1;
		   b7=1'b1;b6=1'b1;b5=1'b0;b4=1'b0;b3=1'b1;b2=1'b1;b1=1'b0;b0=1'b0;
		#10 $finish;
	end
endmodule
module wb6;
	wire a0,a1,a2,a3,a4,a5,a6,a7,b0,b1,b2,b3,b4,b5,b6,b7,car1,car2,car3,car4,car5,car6,car7,car8,s0,s1,s2,s3,s4,s5,s6,s7;
	rca obj(a0,a1,a2,a3,a4,a5,a6,a7,b0,b1,b2,b3,b4,b5,b6,b7,car1,car2,car3,car4,car5,car6,car7,car8,s0,s1,s2,s3,s4,s5,s6,s7);
	rca1 obj1(a0,a1,a2,a3,a4,a5,a6,a7,b0,b1,b2,b3,b4,b5,b6,b7,car1,car2,car3,car4,car5,car6,car7,car8,s0,s1,s2,s3,s4,s5,s6,s7);
endmodule
