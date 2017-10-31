;Systen call constants
SYSTEM_EXIT equ 1
SYSTEM_READ equ 3
SYSTEM_WRITE equ 4
SYSTEM_IN equ 0
SYSTEM_OUT equ 1

;macro to output
%macro output 2
    ;do the actual work
    mov edx, %2,                    ;Length of the message
    mov ecx, %1,                    ;Message to display
    mov ebx, SYSTEM_OUT,            ;System call to output
    mov eax, SYSTEM_WRITE           ;System call to write
    int 0x80
%endmacro

;macro to input
%macro input 1
    ;do the actual work
    mov edx, 10,                    ;Length of the message
    mov ecx, %1,                    ;Message to display
    mov ebx, SYSTEM_IN,            ;System call to output
    mov eax, SYSTEM_READ           ;System call to write
    int 0x80
%endmacro

section .bss
    name resb 10

section .data
namePrompt db "Please enter your name: ", 0xA ;Prompt the user for their name
namePromptLength equ $-namePrompt ;Length of namePrompt
userInputResult db "Hello, " ;Say hello
userInputResultLength equ $-userInputResult

section .text
global _start:
    _start:

    ;Prompt the user for their their words
    output namePrompt, namePromptLength
    int 0x80 ;kernel call

    ;Get the input from the user
    input name
    int 0x80 ;Kernel call

    ;Let the user know what they typed in
    output userInputResult, userInputResultLength
    int 0x80

    ;Output the name
    output name, 10
    int 0x80 ;kernel call

    mov eax, SYSTEM_EXIT ;quit the program
    int 0x80 ;kernel call