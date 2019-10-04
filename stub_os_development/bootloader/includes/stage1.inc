jmp short code_start                    ; Start of code

times 64-($-$$) db 0x00                 ; EchidnaFS header

; Bootloader start:
code_start:

cli
jmp 0x0000:initialise_cs		; Initialise CS to 0x0000 with a long jump
initialise_cs:
xor ax, ax
mov ds, ax
mov es, ax
mov fs, ax
mov gs, ax
mov ss, ax
mov sp, 0x7BF0
sti

mov byte [drive_number], dl         ; Boot drive

mov si, msgLoading
call bios_print

; Load stage 2/1.5

mov si, msgStage2
call bios_print

mov ax, 1               ; Start from LBA sector 1
mov ebx, 0x7E00         ; Load to offset 0x7E00
mov cx, 7               ; Load 7 sectors
call read_sectors
jc err

mov si, msgDone
call bios_print

jmp 0x7E00              ; Jump to stage 2/1.5

err:
mov si, msgErr
call bios_print

halt:
hlt
jmp halt

; Data

msgLoading      db 0x0D, 0x0A, 'Starting... ', 0x0D, 0x0A, 0x0A, 0x00
msgStage2       db 'Loading stage 2... ', 0x00
msgErr          db 0x0D, 0x0A, 'Error - system halted.', 0x00
msgDone         db 'Done', 0x0D, 0x0A, 0x00

; Includes

%include 'bootloader/includes/bios_print.inc'
%include 'bootloader/includes/disk.inc'

drive_number            db 0x00             ; Drive number

times 510-($-$$)        db 0x00             ; Fill in 512 bytes with 0x00
bios_signature          dw 0xAA55           ; BIOS signature
