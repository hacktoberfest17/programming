<?php
// A minimal PHP IRC bot
// See Alanaktion/chatbot-irc for a more complete implementation of this

$config = [
    "channel" => "#general",
    "server" => "example.com",
    "port" => 6667,
    "nick" => "chatbot",
];

$socket = fsockopen($config['server'], $config['port']);
fwrite($socket, "USER {$config['nick']} 0 * :{$config['nick']}\n");
fwrite($socket, "NICK {$config['nick']}\n");
fwrite($socket, "JOIN {$config['channel']}\n");

while (($data = fgets($this->socket)) !== false) {
    echo $data; // Show raw stream for dev/debug purposes

    $ex = explode(' ', rtrim($data, "\n"));
    if ($ex[0] == 'PING') {
        $this->write("PONG {$ex[1]}");
        continue;
    }

    if ($ex[1] == 'PRIVMSG' && @$ex[3]{1} == '!') {
        $target = $ex[2]; // Usually a #channel name
        $command = ltrim($ex[3], ':!'); // All commands start with !

        // Get command arguments
        $args = '';
        for ($i = 4; $i < count($ex); $i++) {
            $args .= $ex[$i] . ' ';
        }

        switch ($command) {
            case 'hi':
                // Standard message response
                fwrite($socket, "PRIVMSG $target :Hello!\n");
                break;
            case 'dice':
                // CTCP message, parsed by client like /me <message>
                $sides = $args ?? 6;
                $result = rand(1, intval($sides) ?: 6);
                fwrite($socket, "PRIVMSG $target :\x01ACTION rolls a $result\x01\n");
                break;
            default:
                fwrite($socket, "PRIVMSG $target :Command not found: $command\n");
        }
    }
}
