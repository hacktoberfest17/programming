class Empresa:
	def __init__(self,nombre):
		self.nombre = nombre
		self.puntuacion = 0
		self.puntuadores = []

	def setNombre(self,nombre):
		self.nombre=nombre

	def getNombre(self):
		return self.nombre

	def getPuntuaciones(self):
		for puntuador in self.puntuadores:
			print ("Nombre Puntuador: " + puntuador[0] + " - puntuacion: "  + str(puntuador[1]))

	def setPuntuacion(self):
		suma = 0
		for puntuador in self.puntuadores:
			suma += puntuador[1]
		self.puntuacion = suma/len(self.puntuadores)

	def getPuntuacion(self):
		return self.puntuacion
	
	def puntuar(self,nombrePuntuador,puntuacion):
		puntuado = False
		for puntuador in self.puntuadores:
			if puntuador[1] == nombrePuntuador:
				print ("Ya puntuaste este empresa anteriormente")
				puntuado=True

		if not puntuado:
			punt = [nombrePuntuador,puntuacion]
			self.puntuadores.append(punt)
			self.setPuntuacion()

	def eliminarPuntuacion(self,nombrePuntuador):
		for puntuador in self.puntuadores:
			if puntuador[0] == nombrePuntuador:
				self.puntuadores.remove(puntuador)
		self.setPuntuacion()
