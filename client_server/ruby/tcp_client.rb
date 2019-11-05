require 'socket'
server = TCPSocket.new 'localhost', 3000

while line = server.gets
  puts line
end

server.close

