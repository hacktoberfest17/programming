def desloca(lista, origem, destino):
    trocou = True
    elemento = lista[origem]

    while lista[destino] != elemento:
            for i in range(len(lista)-1):
                if lista[i] == elemento and i != destino:
                    for i in range(len(lista)-1):
                        if i != destino and lista[i] == elemento:
                            lista[i],lista[i+1] = lista[i+1], lista[i]

    return lista
