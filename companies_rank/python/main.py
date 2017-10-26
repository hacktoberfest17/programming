import puntuacion as p
import empresa as e

primeraEmpresa = e.Empresa("Mapfre")
primeraEmpresa.puntuar("Juanfran",16)


segundaEmpresa = e.Empresa("Honda")
segundaEmpresa.puntuar("Willliam",5)
segundaEmpresa.puntuar("Filipe Luis",20)

terceraEmpresa = e.Empresa("Yamaha")
terceraEmpresa.puntuar("Carrasco",17)


ejemplo = p.Puntuacion([primeraEmpresa,segundaEmpresa,terceraEmpresa])
ejemplo.mostrarRanking()
