words = ["escalator","calling", "fuel", "project", "insane"," day", "apple", "spaceship", "potato", "onion", "water", "misty", "command", "scrawny", "school", "mend", "window", "carrot", "friend", "university"]

debug = 0
puts "\n"
puts "Can You Save Marvin?\n"
puts "Guess letters of the word. If you guess incorrectly five times, you will lose.\n"
myword = words.sample
length = myword.length
gameword = myword.split("")
if debug == 1
  print "the gameword is #{gameword}"
end

myarray = ("_") * length
lives = 5
wins = 0

while true
    puts myarray
    puts "Guess a letter."
    myguess = gets.chomp
    indices = gameword.each_with_index.select { |a,i| a == myguess }.map &:last
    if debug == 1
      puts indices
    end
    if indices.length == 0
        print "That letter is not in the word.\n"
        lives -= 1
        if lives == 0
            print "You ran out of lives. Game over!\n"
            print "The word was #{myword}."
            break
        end
    else
        print "Good guess. There are #{indices.length} #{myguess}-s in the word.\n"
        wins += 1
        indices.each {|num| myarray[num] = gameword[num]}
        if wins == gameword.uniq.length
            print "You won. Good game!\n"
            break
        end
    end
end
