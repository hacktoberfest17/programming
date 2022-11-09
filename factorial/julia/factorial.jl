function fact(n)
    if n == 1
        n
    else
        n * fact(n-1)
    end
end

println(fact(6))
