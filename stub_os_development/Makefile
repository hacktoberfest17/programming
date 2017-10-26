notarget: bochsrc
	nasm bootloader/bootloader.asm -f bin -o bootloader.bin
	mv bootloader.bin ./os.img
	dd bs=512 count=131032 if=/dev/zero >> ./os.img
	chown `logname`:`logname` os.img
	export PATH="`pwd`/tools/bin:${PATH}" && i386-elf-gcc -ffreestanding -mpreferred-stack-boundary=2 "kernel/stub.c" -nostdlib -static-libgcc -lgcc -Xlinker --oformat=binary -T kernel/linker.ld -o kernel.bin
	echfs-tools/echfs-utils os.img format
	echfs-tools/echfs-utils os.img import kernel.bin kernel.bin
	rm kernel.bin

fstools: bochsrc
	mkdir echfs-tools &> /dev/null || true
	wget https://raw.githubusercontent.com/echidnaOS/echidnaOS/master/echidnafs/echfs-utils.c -O ./echfs-tools/echfs-utils.c
	cd echfs-tools && gcc echfs-utils.c -o echfs-utils
