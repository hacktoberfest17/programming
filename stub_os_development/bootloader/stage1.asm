org     0x7c00              ; We are loaded by BIOS at 0x0:0x7C00
bits    16                  ; We are still in 16 bit Real Mode

jmp short loader
times 64-($-$$) db 0x00

loader:
    cli
    jmp 0x0:.cs_fix
    .cs_fix:
        xor ax, ax
        mov ds, ax
        mov es, ax
        mov ss, ax
        mov sp, 0x7bf0
    sti

    mov eax, 1
    mov ebx, 0x7e00
    mov ecx, 7
    call read_sectors

;    xor ax, ax
;    mov ds, ax
;    mov es, ax
;    mov ss, ax
;    mov sp, 0xfff0

; Data

%include 'includes/disk.inc'
%include 'includes/bios_print.inc'

times 510 - ($-$$) db 0 ; 512 bytes
dw 0xAA55               ; Boot Signature

    mov si, msgA20Enable
    call bios_print

    call enable_a20

    ; Set up GDT
    mov si, msgLoadGDT
    call bios_print

    call LoadGDT

    mov si, msgUrmode
    call bios_print

    call halt

halt:
    hlt
    jmp halt

; Data

msgLoadGDT   db   'Loading GDT... ', 0x0d, 0x0a, 0x00
msgUrmode    db   'Entering unreal mode... ', 0x0d, 0x0a, 0x00
msgA20Enable db   'Enabling A20... ', 0x0d, 0x0a, 0x00

; Includes

%include 'includes/gdt.inc'
%include 'includes/a20_enabler.inc'
%include 'includes/disk2.inc'
%include 'includes/echfs.inc'

times (512*8)-($-$$) db 0
