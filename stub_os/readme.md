# A stub operating system
It doesn't use multiboot, it uses its own bootloader.  
It uses the echidnaFS filesystem.  
Get its tools by using `make fstools`  
  
To compile this repo you need a cross GCC compiler.  
Get it [here](https://void.cat/4b805439f0a5c2200e811237675ecd7f49f803e7&v)  

## Compiling
1. Get the cross compiler  
2. Use `make fstools` to make echidnaFS'es tools  
3. Use `make` to compile the OS  

## Running it
The image `os.img` is QEMU bootable out-of-the-box, so just use
```
qemu-system-i386 os.img
```
I also included a `bochsrc` if you need a debugger.  
