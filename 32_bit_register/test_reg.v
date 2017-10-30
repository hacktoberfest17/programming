`include "reg.v"

`timescale 1ns/100ps

module test;

reg [31:0]inp;
wire [31:0]out;
reg clk;

register regi(clk,inp,out);

initial begin
$dumpfile("register.vcd");
$dumpvars(0,test);

clk=1;
repeat(20)
#10 clk=~clk;
end
initial begin
inp=32'b01010101010101010101010101010101;


#100

inp=32'b1011110111;

end

initial begin
$monitor ("input=%b output=%b\n",inp,out);
end
endmodule
