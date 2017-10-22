require 'socket'
server = TCPServer.new 3000

while session = server.accept
  session.puts "Hello world!"
  session.close
end
