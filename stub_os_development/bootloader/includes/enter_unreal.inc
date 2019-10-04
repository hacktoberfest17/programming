enter_unreal:

cli						; Disable interrupts

mov eax, cr0			; Enable bit 0 of cr0 and enter protected mode
or eax, 00000001b
mov cr0, eax

jmp 0x08:.pmode

.pmode:					; Now in protected mode

mov ax, 0x10
mov ds, ax
mov es, ax
mov fs, ax
mov gs, ax
mov ss, ax

mov eax, cr0			; Exit protected mode
and eax, 11111110b
mov cr0, eax

jmp 0x0000:.unreal_mode

.unreal_mode:			; Now in Unreal Mode

xor ax, ax
mov ds, ax
mov es, ax
mov fs, ax
mov gs, ax
mov ss, ax
mov sp, 0x7BF0

sti						; Enable interrupts
