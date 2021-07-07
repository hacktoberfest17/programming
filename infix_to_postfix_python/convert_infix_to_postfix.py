class Stack:
    def __init__(self):
        self.stkList=[]
    def isEmpty(self):
        return self.stkList==[]
    def length(self):
        return len(self.stkList)
    def push(self,items):
        self.stkList.append(items)
    def pop(self):
        return self.stkList.pop()
    def peek(self):
        return (len(self.stkList)-1)
    
class convertor:
    
    def infix_to_postfix(self,infix_input):

        stak=Stack()
        operator_list=['+','-','/','*']
        operand_list=['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','0','1','2','3','4','5','6','7','8','9']
        output_list=[]
        
        for token in infix_input:
            if token in operand_list:
                output_list.append(token)
        
                if len(output_list)>0 and len(output_list)%2==0:
                    output_list.append(stak.pop())
                
            elif token in operator_list:
                stak.push(token)
                
        print output_list

obj=convertor()

while True:
    obj.infix_to_postfix(infix_input=list(raw_input('Enter your infix expresion-:')))
