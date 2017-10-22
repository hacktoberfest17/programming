open System
open System.Text.RegularExpressions

type Mark = O | X 
type Square = Free of int | Mark of Mark
type Board = Map<int, Square>

type Player = {
    name: string
    mark: Mark 
    wins: int }

type Result = PlayOn | Tie | Win

type validationResult =  OK | Fail of string

let printsn = printfn "%s"
let clear () = try Console.Clear() with e -> ()
let pause () = Console.ReadLine() |> ignore

let createBoard () = 
    [1..9] 
    |> List.map (fun i -> (i, Free i))
    |> Map.ofList

let posToText (board : Board) i  =
    board.[i] |> function
        | Mark m -> m.ToString()
        | Free f -> f.ToString()

let isFree = function (Free _) -> true | _ -> false

let checkMovePos (board : Board) i =
    if not (board.ContainsKey i) then
        Fail "That's not on the board!"
    else if not (isFree board.[i]) then
        Fail "That's not free!"
    else OK   

let rec getUserInput prompt validate =
    printfn "%s" prompt
    let input = Console.ReadLine()
    match validate input with
    | OK -> input
    | Fail errorMessage -> 
        printsn errorMessage
        getUserInput prompt validate

let getPlayerName mark =
    let prompt = sprintf "Name of player using '%O'?" mark
    let validate input = 
        match Regex.IsMatch(input, "^\w+( \w+)*$") with
        | true -> OK
        | false -> Fail "Are you sure that's your name?"
    getUserInput prompt validate
 
let getMove checkPosition prompt =
    let validate input =
        match Int32.TryParse(input) with
        | false, _ -> Fail (sprintf "'%s' doesn't look like a number to me." input)
        | true, pos -> checkPosition pos
    int <| getUserInput prompt validate    

let display board =    
    clear ()
    let s = posToText board
    printsn "┌───┬───┬───┐"
    printfn "│ %s │ %s │ %s │" (s 1) (s 2) (s 3)
    printsn "├───┼───┼───┤"
    printfn "│ %s │ %s │ %s │" (s 4) (s 5) (s 6)
    printsn "├───┼───┼───┤"
    printfn "│ %s │ %s │ %s │" (s 7) (s 8) (s 9)
    printsn "└───┴───┴───┘"

let lines = [[1; 2; 3]; [4; 5; 6]; [7; 8; 9]; [1; 4; 7]; 
            [2; 5; 8]; [3; 6; 9]; [1; 5; 9]; [3; 5; 7]]

let isWinningLine (board : Board) line =
    line |> List.map (fun i -> board.[i]) |> List.distinct |> List.length = 1
    
let gameStatus (board : Board) = 
    if lines |> List.exists (isWinningLine board) then
        Win
    else if board |> Map.toList |> List.exists (snd >> isFree) then
        PlayOn
    else Tie

let rec takeTurn (player : Player) (opponent : Player) (board : Board) = 
    display board
    let move = getMove (checkMovePos board) (sprintf "%s's turn. Place your %O" player.name player.mark)
    let newBoard = board.Add(move, Mark player.mark)    
    gameStatus newBoard |> function
        | PlayOn -> takeTurn opponent player newBoard
        | Tie -> finishGame board opponent player "No winner this time!"
        | Win -> finishGame board opponent 
                    {player with wins = player.wins + 1}
                    (sprintf "Congratulations %s won!" player.name) 

and finishGame board nextPlayer nextOpponent message =
    display board
    printsn message
    pause(); clear ()
    newGame nextPlayer nextOpponent

and newGame player opponent =
    let desc p = printfn "%s winner of %i games playing as %O" p.name p.wins p.mark
    desc player
    printsn "           - vs -"
    desc opponent
    pause (); clear ()
    takeTurn player opponent (createBoard ())


let player = { name = getPlayerName O; mark = O; wins = 0; }
let opponent = { name = getPlayerName X; mark = X; wins = 0; }
clear ()
newGame player opponent |> ignore
