<?php
$host = "127.0.0.1";
$port = 9998;
set_time_limit(0);
$socket = socket_create(AF_INET, SOCK_STREAM, 0) or die("Could not create socket\n");
$result = socket_bind($socket, $host, $port) or die("Could not bind to socket\n");
$result = socket_listen($socket, 3) or die("Could not set up socket listener\n");

while(True){
    $spawn = socket_accept($socket) or die("Could not accept incoming connection\n");
    $input = socket_read($spawn, 1024) or die("Could not read input\n");
    $input = trim($input);
    echo "Echo: ".$input.PHP_EOL;
    $output = strrev($input) . PHP_EOL;
    socket_write($spawn, $output, strlen ($output)) or die("Could not write output\n");
}
socket_close($spawn);
socket_close($socket);
