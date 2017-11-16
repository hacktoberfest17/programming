uint factorial(in uint n) pure nothrow @nogc
in {
    assert(n <= 12);
} body {
    if (n == 0)
        return 1;
    else
        return n * factorial(n - 1);
}

pragma(msg, 12.factorial);

void main() {
    import std.stdio;

    12.factorial.writeln;
}