org 0x1000
bits 16

main:
    ; Set up segments and stack
    cli
    xor ax, ax
    mov ds, ax
    mov es, ax
    mov ax, 0x9000
    mov ss, ax
    mov sp, 0xFFFF
    sti

    mov si, msgLoaded
    call bios_print

    mov si, msgA20Enable
    call bios_print

    call enable_a20

    mov si, msgLoaded
    call bios_print

    ; Set up GDT
    mov si, msgLoadGDT
    call bios_print

    call LoadGDT

    mov si, msgLoaded
    call bios_print

    mov si, msgPmode
    call bios_print

    ; Go to pmode (32-bit)
    cli
    mov eax, cr0            ; Set bit 0 in cr0, entering pmode
    or eax, 1
    mov cr0, eax

    jmp 0x08:Stage3

halt:
    hlt
    jmp halt

; Data

msgLoaded    db   'Done', 0x0d, 0x0a, 0x00
msgLoadGDT   db   'Loading GDT... ', 0x00
msgPmode     db   'Entering Stage 3... ', 0x00
msgA20Enable db   'Enabling A20... ', 0x00

; Includes

%include 'includes/bios_print.inc'
%include 'includes/gdt.inc'
%include 'includes/a20_enabler.inc'

; ******************************
;             STAGE 3          
; ******************************

bits 32

Stage3:
    ; Set registers
    mov ax, 0x10
    mov ds, ax
    mov ss, ax
    mov es, ax
    mov esp, 0x90000

    call halt               ; Halt the CPU
