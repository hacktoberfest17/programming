#importing modules
from tkinter import *
from tkinter import messagebox as tm
import base64

#initialize window
root = Tk()
root.geometry('500x300')
root.resizable(0,0)

#title of the window
root.title("Morse Code-Message Encode and Decode")



#label

Label(root, text ='ENCODE DECODE', font = 'arial 20 bold').pack()
Label(root, text ='Morse Code', font = 'arial 20 bold').pack(side =BOTTOM)

MORSE_CODE_DICT = {
    'A':'.-',
    'B':'-...',
    'C':'-.-.',
    'D':'-..',
    'E':'.',
    'F':'..-.',
    'G':'--.',
    'H':'....',
    'I':'..',
    'J':'.---',
    'K':'-.-',
    'L':'.-..',
    'M':'--',
    'N':'-.',
    'O':'---',
    'P':'.--.',
    'Q':'--.-',
    'R':'.-.',
    'S':'...',
    'T':'-',
    'U':'..-',
    'V':'...-',
    'W':'.--',
    'X':'-..-',
    'Y':'-.--',
    'Z':'--..',
    '1':'.----',
    '2':'..---',
    '3':'...--',
    '4':'....-',
    '5':'.....',
    '6':'-....',
    '7':'--...',
    '8':'---..',
    '9':'----.',
    '0':'-----',
}

string=StringVar()
mode=StringVar()
result=StringVar()

def encryptor(string):
    encrypted_text=""
    for letters in string:
        if letters != " ":
            sum=str(MORSE_CODE_DICT.get(letters))+" "
            encrypted_text+=sum
        else:
            encrypted_text+=" "
    return encrypted_text
    #print(encrypted_text)
def decryptor(string):
    string+=" "
    key_list=list(MORSE_CODE_DICT.keys())
    val_list=list(MORSE_CODE_DICT.values())
    morse=""
    normal=""
    for letters in string:
        if letters !=" ":
            morse+=letters
            space_found=0
        else:
            space_found+=1
            if space_found==2:
                normal+=" "
            else:
                normal+=key_list[val_list.index(morse)]
                morse=""
    return normal
    #print(normal)
def Mode():
    if mode.get()=='e' or mode.get()=='E':
        result.set(encryptor(string.get().upper()))
    else:
        result.set(decryptor(string.get().upper()))
def Reset():
    string.set("")
    mode.set("")
    result.set("")
def Exit():
    choice=tm.askquestion("Exit","Are you sure that you want to exit?")
    if choice=="yes":
        root.destroy()
#Message
Label(root, font= 'arial 12 bold', text='MESSAGE').place(x= 60,y=60)
Entry(root, font = 'arial 10', textvariable = string, bg = 'ghost white').place(x=290, y = 60)

#key
"""Label(root, font = 'arial 12 bold', text ='KEY').place(x=60, y = 90)
Entry(root, font = 'arial 10', textvariable = private_key , bg ='ghost white').place(x=290, y = 90)"""


#mode
Label(root, font = 'arial 12 bold', text ='MODE(e-encrypt, d-decrypt)').place(x=60, y = 90)
Entry(root, font = 'arial 10', textvariable = mode , bg= 'ghost white').place(x=290, y = 90)



#result
Label(root, font = 'arial 12 bold', text ='RESULT').place(x=60, y = 120)
Entry(root, font = 'arial 10 bold', textvariable = result, bg ='ghost white').place(x=290, y = 120)

#result button
Button(root, font = 'arial 10 bold', text = 'RESULT'  ,padx =2,bg ='yellow' ,command = Mode).place(x=300, y = 190)


#reset button
Button(root, font = 'arial 10 bold' ,text ='RESET' ,width =6, command = Reset,bg = 'LimeGreen', padx=2).place(x=100, y = 190)

#exit button
Button(root, font = 'arial 10 bold',text= 'EXIT' , width = 6, command = Exit,bg = 'OrangeRed', padx=2, pady=2).place(x=200, y = 190)
root.mainloop()

