
%include 'bootloader/includes/stage1.inc'

; Stage 2/1.5, whatever you want to call it.

; Enable A20
mov si, msgA20
call bios_print

call enable_a20
jc err

mov si, msgDone
call bios_print

; Unreal mode
mov si, msgUnreal
call bios_print

lgdt [GDT]                              ; Load the GDT

%include 'bootloader/includes/enter_unreal.inc'     ; Enter unreal mode

mov si, msgDone
call bios_print

; Kernel

mov si, msgKernel
call bios_print

mov esi, kernel_name
mov ebx, 0x100000
call load_file
jc err

mov si, msgDone
call bios_print

jmp kload

; Data

kernel_name         db 'kernel.bin', 0x00
msgA20              db 'Enabling A20... ', 0x00
msgUnreal           db 'Entering Unreal Mode... ', 0x00
msgKernel           db 'Loading kernel...', 0x00

; Includes

%include 'bootloader/includes/echfs.inc'
%include 'bootloader/includes/disk2.inc'
%include 'bootloader/includes/a20_enabler.inc'
%include 'bootloader/includes/gdt.inc'
