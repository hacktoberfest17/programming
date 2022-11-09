@Weston Cannon


@r6 is what will be used to hold subtracted value

.equ SEG_A @ Top
.equ SEG_B,0x40 @ Top Right
.equ SEG_C,0x20 @ Bottom Right
.equ SEG_D,0x08 @ Bottom
.equ SEG_E,0x04 @ Bottom Left
.equ SEG_F,0x02,0x80 @ Middle
.equ SEG_G,0x01 @ Top Left
.equ SEG_P,0x10 @ Decimal


@starting point for code; functions as Reset
mov r0,#4 @set x position
mov r1,#1 @set y position
mov r2,#1000 @set LCD to 1000
swi 0x205 @display integer

Running: @wait for input from buttons and loop
swi 0x202 @detect input from either black button
cmp r0,#0x02 @left black button
beq Reset
cmp r0,#1 @right black button
beq Reset
swi 0x203
cmp r0,#0x01 @won't actually do anything besides display a zero
beq Num0
cmp r0,#1<<1
beq Num1
cmp r0,#1<<2
beq Num2
cmp r0,#1<<3
beq Num3
cmp r0,#1<<4
beq Num4
cmp r0,#1<<5
beq Num5
cmp r0,#1<<6
beq Num6
cmp r0,#1<<7
beq Num7
cmp r0,#1<<8
beq Num8
cmp r0,#1<<9
beq Num9
cmp r0,#1<<10
beq Num10
cmp r0,#1<<11
beq Num11
cmp r0,#1<<12
beq Num12
cmp r0,#1<<13
beq Num13
cmp r0,#1<<14
beq Num14
cmp r0,#1<<15
beq Num15


bal Running



Num0:
ldr r0,=SEG_A|SEG_B|SEG_C|SEG_D|SEG_E|SEG_G @0
swi 0x200
bal Running

Num1:
ldr r0,=SEG_B|SEG_C @1
swi 0x200
sub r6,r2,#1
bal NewTotal

bal Running

Num2:
ldr r0,=SEG_A|SEG_B|SEG_F|SEG_E|SEG_D @2
swi 0x200
sub r6,r2,#2
bal NewTotal

bal Running
Num3:
ldr r0,=SEG_A|SEG_B|SEG_F|SEG_C|SEG_D @3
swi 0x200
sub r6,r2,#3
bal NewTotal

Num4:
ldr r0,=SEG_G|SEG_F|SEG_B|SEG_C @4
swi 0x200
sub r6,r2,#4
bal NewTotal

Num5:
ldr r0,=SEG_A|SEG_G|SEG_F|SEG_C|SEG_D @5
swi 0x200
sub r6,r2,#5
bal NewTotal

Num6:
ldr r0, =SEG_A|SEG_G|SEG_F|SEG_E|SEG_D|SEG_C @6
swi 0x200
sub r6,r2,#6
bal NewTotal

Num7:
ldr r0, =SEG_A|SEG_B|SEG_C @7
swi 0x200
sub r6,r2,#7
bal NewTotal

Num8: 
ldr r0, =SEG_A|SEG_B|SEG_C|SEG_D|SEG_E|SEG_F|SEG_G @8
swi 0x200
sub r6,r2,#8
bal NewTotal

Num9:
ldr r0, =SEG_A|SEG_B|SEG_F|SEG_G|SEG_C @9
swi 0x200
sub r6,r2,#9
bal NewTotal

Num10: @A
ldr r0, =SEG_A|SEG_B|SEG_G|SEG_F|SEG_E|SEG_C @A, the grade you shall bestow upon me! (please)
swi 0x200
sub r6,r2,#10
bal NewTotal

Num11: @B
ldr r0, =SEG_G|SEG_F|SEG_E|SEG_D|SEG_C @B... lower-case
swi 0x200
sub r6,r2,#11
bal NewTotal

Num12: @C
ldr r0, =SEG_A|SEG_G|SEG_E|SEG_D @C
swi 0x200
sub r6,r2,#12
bal NewTotal

Num13: @D
ldr r0, =SEG_B|SEG_F|SEG_E|SEG_E|SEG_D|SEG_C @D, lower-case
swi 0x200
sub r6,r2,#13
bal NewTotal

Num14: @E
ldr r0, =SEG_A|SEG_G|SEG_F|SEG_E|SEG_D @E
swi 0x200
sub r6,r2,#14
bal NewTotal

Num15: @F
ldr r0, =SEG_A|SEG_G|SEG_F|SEG_E @F
swi 0x200
sub r6,r2,#15
bal NewTotal

bal Running

Reset: @default start and action when black button is pressed
swi 0x206
mov r0,#4 @set x position
mov r1,#1 @set y position
mov r2,#1000 @set LCD to 1000
swi 0x205
ldr r0,=0
swi 0x200

bal Running

NewTotal:
swi 0x206 @clear LCD for new num
mov r0,#4
mov r1,#1
cmp r6,#0
blt BelowZero @freeze counter if new value will drop below zero
mov r2,r6
swi 0x205

bal Running

BelowZero:
ldr r2,=KindlyReset @put up a message to reset when answer below zero
swi 0x204
WaitReset: @force user to reset and listen for reset
swi 0x202
cmp r0,#0x02
beq Reset
cmp r0,#1
beq Reset
swi 0x203 @prevents a saved keypad input when returning to "Running" (this is detecting numpad input)
bal WaitReset

KindlyReset: .asciz "Answer below zero! Please, reset." @message when answer is below zero
