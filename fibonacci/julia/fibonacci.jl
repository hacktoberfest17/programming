function fib(n::Int)::Int
    if n == 0
        return 1
    end
    if n == 1
        return 1
    end

    return fib(n - 1) + fib(n - 2)
end

println(fib(6))
