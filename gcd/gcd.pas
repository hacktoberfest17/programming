program gcd (input, output);
{gives out the greatest common divisor of two integers}

	var
	a,
	b : integer;
	
begin
	writeln ('Please type in two integers > 0. ');
	readln(a);
	readln(b);
	if (a <= 0) or (b <= 0) then
		writeln ('Error!')
	else
	begin
		write ('The gcd of ', a, ' and ', b, ' is ');
		
		while a <> b do
			if a > b then
				a := a - b
			else
				b := b - a;
		writeln (a, '.')
	end
end. 
