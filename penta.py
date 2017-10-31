
import math
def primo(n):
	raiz= int(math.sqrt(n))
	check = False
	for x in range(3,raiz+1,2):
		if n%x == 0:
			check = True
	if check or (n%2 == 0 and n!=2):
		return False
	else:
		return True
r = raw_input().split()
num1 = 1
num2 = 1
for x in range(1, int(r[0])+1):
	num1*= x
for x in range(1, int(r[1])+1):
	num2*= x

lista1=[]
lista2=[]
cont=2
print num1,num2
while num1>1:
	if num1%cont == 0 and primo(cont):
		
		while num1%cont == 0:
			lista1.append(cont)
			num1= num1/cont
	cont+=1
cont=2
while num2>1:
	if num2%cont == 0 and primo(cont):
		
		while num2%cont == 0:
			lista2.append(cont)
			num2= num2/cont
	cont+=1
mult=1
conta = 0
while conta<len(lista1):

	if lista2.count(lista1[conta])<= lista1.count(lista1[conta]):
		
		mult*= lista1[conta]**lista2.count(lista1[conta])
	else:
		if lista2.count(lista1[conta])> lista1.count(lista1[conta]):
			mult*= lista1[conta]**lista1.count(lista1[conta])
	conta+=lista1.count(lista1[conta])
print lista1, lista2

print mult