module d(q,q1,d,c);
	output q,q1;
	input d,c;
	reg q,q1;
	initial
		begin
			$monitor($time,,,"c=%b,d=%b,q=%b,q1=%b",c,d,q,q1);
			$dumpfile("lolwa.vcd");
			$dumpvars(0,q,q1,d,c);
			q=1'b0;
			q1=1'b1;
		end
		always @ (posedge c)
			begin 
				q=d;
				q1=~d;
			end
	
endmodule
module  lol(q,q1,d,c);
	output reg d,c;
	input q,q1;
	initial begin
		d=1'b0;
		c=1'b1;
		#5 d=1'b0; c=1'b0;
		#10 d=1'b1; c=1'b0;
		#15 d=1'b1; c=1'b1;
	end
endmodule
module lolwa;
	wire q,q1,d,c;
	lol l_a(q,q1,d,c);
	d d_a(q,q1,d,c);
endmodule
