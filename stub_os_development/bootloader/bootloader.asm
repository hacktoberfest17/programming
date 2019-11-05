org 0x7C00                                  ; Bootloader start
bits 16                                     ; Running in real mode

%include 'bootloader/includes/bootloader.inc'

kload:

%include 'bootloader/includes/enter_pmode.inc'

; Setup registers

mov esp, 0xEFFFF0

xor eax, eax
mov al, byte [drive_number]
push eax

xor eax, eax
xor ebx, ebx
xor ecx, ecx
xor edx, edx
xor esi, esi
xor edi, edi
xor ebp, ebp

call 0x100000					; Jump to the kernel

call halt

times 4096-($-$$)           db 0x00                 ; Padding
