def kadane(lista,n):
	max_atual = 0
	max_total = -1
	for i in range(n):
		max_atual = max_atual + lista[i]
		if max_atual < 0:
			max_atual = 0
		if max_atual > max_total:
			max_total = max_atual
	return max_total
lista = [1,-2,3,4,1,7,-9,3,5,1,-2,5]
print(kadane(lista,len(lista)))
