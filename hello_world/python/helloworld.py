
def main():
    import os
    import re
    import subprocess

    pattern = re.compile("[Hh][Ee][Ll][Ll][Oo]_*[wW][Oo][Rr][Ll][Dd]+\.py")
    a = os.listdir(".")
    for i in  a:
        if pattern.match(i) and  i != str(os.path.basename(__file__)):
            subprocess.call(["python", i])
            break
        else:
            print "Hello World!"
            exit(0)

if __name__ == "__main__":
    main()
