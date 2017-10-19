let rec quicksort list =
    match list with
    | []    -> []
    | x::xs ->
        let smaller, larger = List.partition (fun y -> y < x) xs
        in List.concat [quicksort smaller; [x]; quicksort larger]
