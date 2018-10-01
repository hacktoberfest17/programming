import ctypes
import platform

if platform.system() == 'Windows':
	kernel32 = ctypes.windll.kernel32
	kernel32.SetConsoleMode(kernel32.GetStdHandle(-11), 7)

for i in range(30, 38):
	print(f'\033[{i}m{i:^20}\033[0;{i+10}m{i+10:^20}\033[0m')
	print(f'\033[{i};1m{str(i)+";1":^20}\033[0;{i+70}m{i+70:^20}\033[0m')
