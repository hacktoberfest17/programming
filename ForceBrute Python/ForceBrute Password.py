import string

#Otimize subistituindo o 'valor' de paswd por uma senha real + implementos url.
name = input ('Digite seu nome ')
paswd = input('Insira a senha: ')

def Brute (paswd):
    print ("[+][+] Iniciando Força Bruta...")
    charset = list(string.ascii_letters + string.digits + string.punctuation)
    result = " "

    x = 0

    while x <= len(paswd)-1:
        for char in charset:
            pchar = paswd[x]
            if char == pchar:
                
                print ("[+][+] Encontrado! (", char, ")")
                result += char

                print ("[+][+] Current:",result)
                x += 1
                break

            else:
                print ("[+] Tentando...",char)



    print ("[+][+] Fim da procura - Password encontrado! ", result)
    print (" ")
    print ('Entao ' + (name) + " acertei  ")
Brute(paswd)

    
