<?php

class TicTacToe
{
    private $board;
    private $moves = 0;

    public function __construct()
    {
        $this->board = [[' ', ' ', ' '], [' ', ' ', ' '], [' ', ' ', ' ']];
    }

    public function printBoard(): void
    {
        foreach ($this->board as $nthRow => $row) {
            foreach ($row as $nthCell => $cell) {
                echo " $cell ".(($nthCell !== 2) ? '|' : '');
            }
            echo ($nthRow !== 2) ? "\n-----------\n" : "\n";
        }
        echo "\n\n";
    }

    /**
     * @return false|[X, O]
     */
    public function checkForWinner()
    {
        for ($i = 0; $i < 3; $i++) {
            if ($this->board[$i][0] !== ' ' &&
                $this->board[$i][0] === $this->board[$i][1] &&
                $this->board[$i][0] === $this->board[$i][2]) {
                return $this->board[$i][0];
            }
        }

        for ($i = 0; $i < 3; $i++) {
            if ($this->board[0][$i] !== ' ' &&
                $this->board[0][$i] === $this->board[1][$i] &&
                $this->board[0][$i] === $this->board[2][$i]) {
                return $this->board[0][$i];
            }
        }

        if ($this->board[0][0] !== ' ' &&
            $this->board[0][0] === $this->board[1][1] &&
            $this->board[0][0] === $this->board[2][2]) {
            return $this->board[0][0];
        }
        if ($this->board[0][2] !== ' ' &&
            $this->board[0][2] === $this->board[1][1] &&
            $this->board[0][2] === $this->board[2][0]) {
            return $this->board[0][2];
        }

        return false;
    }

    public function isValidMove($row, $col): bool
    {
        return $this->board[$row][$col] === ' ';
    }

    public function move($player, $row, $col): void
    {
        if ($this->isValidMove($row, $col)) {
            $this->board[$row][$col] = $player;
            $this->moves++;
        }
    }

    public function isFinished(): bool
    {
        if ($this->checkForWinner()) {
            return true;
        }
        return $this->moves === 9;
    }
}

$ttt = new TicTacToe();
$player = 'X';
while (!$ttt->isFinished()) {
    $ttt->printBoard();
    echo "\033[7A";
    usleep(300000);
    do {
        $row = random_int(0,2);
        $col = random_int(0,2);
    } while (!$ttt->isValidMove($row, $col));
    $ttt->move($player, $row, $col);

    $player = $player === 'X' ? 'O' : 'X';
}
$ttt->printBoard();
$winner = $ttt->checkForWinner();
if ($winner) {
    echo "The winner is '".$winner."'\n";
} else {
    echo "Tie\n";
}
