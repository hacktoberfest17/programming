let fib x =
  let rec infib = function
    | 0 -> 0
    | 1 -> 0
    | 2 -> 1
    | n -> infib (n-1) + infib (n-2)
  List.map infib [1..x];;
