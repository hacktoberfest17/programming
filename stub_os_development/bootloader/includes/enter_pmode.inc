enter_pmode:

cli						; Disable interrupts

mov eax, cr0			; enter pmode
or eax, 0x00000001
mov cr0, eax

jmp 0x18:.pmode

bits 32

.pmode:					; Now in protected mode

mov ax, 0x20
mov ds, ax
mov es, ax
mov fs, ax
mov gs, ax
mov ss, ax
