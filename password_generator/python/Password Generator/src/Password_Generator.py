import string
import random
from tkinter import Button,Label,Entry,Tk,messagebox
import re


class GUI():



    def __init__(self,master):


        
        master.title('Password Generator')
        master.geometry('840x500')

        self.label=Label(text="Password Generator",fg='darkmagenta',font='elephant 35 underline bold')
        self.label.grid(row=0,column=0,columnspan=3)

        self.blank_label1=Label(text="")
        self.blank_label1.grid(row=1,column=0,columnspan=2)

        
        self.blank_label2=Label(text="")
        self.blank_label2.grid(row=2,column=0,columnspan=2)

        
        self.blank_label3=Label(text="")
        self.blank_label3.grid(row=3,column=0)

        
        self.blank_label4=Label(text="")
        self.blank_label4.grid(row=4,column=0)


        self.user=Label(text="Enter the name of the user:",font='times 25 bold italic')
        self.user.grid(row=5,column=0)

        self.textfield=Entry(font='times 20',bd=6,relief='ridge')
        self.textfield.grid(row=5,column=1)
        self.textfield.focus_set()

        
        self.blank_label3=Label(text="")
        self.blank_label3.grid(row=6,column=0)

        self.length=Label(text="Enter the length:",font='times 25 bold italic')
        self.length.grid(row=7,column=0)

        self.length_textfield=Entry(font='times 20',bd=6,relief='groove')
        self.length_textfield.grid(row=7,column=1)

        
        self.blank_label4=Label(text="")
        self.blank_label4.grid(row=8,column=0)

        self.generated_password=Label(text="Generated Password:",font='times 25 bold italic')
        self.generated_password.grid(row=9,column=0)

        self.generated_password_textfield=Entry(font='times 20',bd=6,relief='groove',fg='darkgreen')
        self.generated_password_textfield.grid(row=9,column=1)
        #self.generated_password_textfield.configure(state='readonly')

        
        self.blank_label5=Label(text="")
        self.blank_label5.grid(row=10,column=0)

        
        self.blank_label6=Label(text="")
        self.blank_label6.grid(row=11,column=0)

        self.generate=Button(text="Generate Password",bd=4,relief='solid',padx=1,pady=1,font='forte 25 bold',fg='maroon',bg='limegreen',command=self.generate_pass)
        self.generate.grid(row=12,column=0)


        self.reset=Button(text="Reset",bd=4,relief='solid',padx=1,pady=1,font='forte 25 bold',fg='darkblue',bg='red',command=self.reset_fields)
        self.reset.grid(row=12,column=2)


  
    

    def generate_pass(self):
         upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
         lower = "abcdefghijklmnopqrstuvwxyz"
         chars = "@#%&()\"?!"
         numbers = "1234567890"
         upper = list(upper)
         lower = list(lower)
         chars = list(chars)
         numbers = list(numbers)
         name=self.textfield.get()
         leng=self.length_textfield.get()

         if name=="":
             messagebox.showerror("Oops","Name field can't be empty!")
             return
         
         if name.isalpha()==False:
             messagebox.showinfo("Warning","Name must be a string!")
             self.textfield.delete(0,25)
             return

         if leng.isalpha()==True:
            messagebox.showwarning("Warning","Length must be an interger >= 6!")
            self.length_textfield.delete(0,25)
            return
             
         if leng=='':
             self.blank_label2.configure(text="Length field cannot be empty!",font='times 20 bold',fg='blue')
             self.blank_label1.configure(text="")
             return
         else:
             self.blank_label2.configure(text="")
         length=int(leng)  
         
         if length<6:
              self.blank_label1.configure(text="Password must be atleast 6 characters long!!!",font='times 20 italic',fg='green')
              self.blank_label2.configure(text="")
              return
         else:
              self.blank_label1.configure(text="")
    

         
         self.generated_password_textfield.delete(0,length)
    
         u = random.randint(1, length-3)
         l = random.randint(1, length-2-u)
         c = random.randint(1, length-1-u-l)
         n = length-u-l-c
         password = random.sample(upper,u)+random.sample(lower,l)+random.sample(chars,c)+random.sample(numbers,n)
         random.shuffle(password)
         gen_passwd="".join(password)
         self.generated_password_textfield.insert(0,gen_passwd)
         

     
    def reset_fields(self):
        self.textfield.delete(0,25)
        self.length_textfield.delete(0,25)
        self.generated_password_textfield.delete(0,25)
        


if __name__=='__main__':
     root=Tk()
     pass_gen=GUI(root)
     root.mainloop()
