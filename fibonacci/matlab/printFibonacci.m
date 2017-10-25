function printFibonacci(depth)
fibonacci = zeros(1,depth);
fibonacci(1)=1;
buff=0;
preCount = 0;
curCount = 1;

for i=2:depth
    buff = curCount;
    curCount = curCount + preCount;
    fibonacci(i) = curCount;
    preCount = buff;
end
display(fibonacci);