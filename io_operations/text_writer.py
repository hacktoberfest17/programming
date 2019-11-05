
#Filename should be ending with txt
def write_text_to_file(filename,text):

    file = open(filename,"w")
    file.write(text)
    file.close()


if __name__ == "__main__":
    write_text_to_file("test.txt","Hello World!")