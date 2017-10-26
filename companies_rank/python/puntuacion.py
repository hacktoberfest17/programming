import empresa

class Puntuacion:
	def __init__(self,empresas):
		self.empresas=empresas

	def mostrarRanking(self):
		empresasOrdenadas = sorted(self.empresas, key=lambda e: e.puntuacion, reverse=True)
		for empresa in empresasOrdenadas:
          		print ("La empresa " + empresa.nombre + " tiene una puntuacion de: " + str(empresa.puntuacion))
