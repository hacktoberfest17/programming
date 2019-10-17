library IEEE;
use IEEE.STD_LOGIC_1164.all;
entity test is
	 port(
		 CLK : in STD_LOGIC;
	     );
end test;

architecture test of test is
begin
	process(CLK)
	begin
	report "Hello world";
	end process;
end test;