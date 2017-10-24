#define SCREENSIZE 80 * 25 * 2
char* vidptr = (char*)0xB8000;
int ptrpos = 0;

void clrscr(void);
void kputs(char* str);

void kmain(void) {
    clrscr();
    kputs("This is a stub C kernel!");

    return;
}

void clrscr(void) {
    for (int i = 0; i < SCREENSIZE; i += 2) {
        vidptr[i] = ' ';
        vidptr[i+1] = 0x00;
    }
    ptrpos = 0;

    return;
}

void kputs(char* str) {
    for (; *str; str++) {
        vidptr[ptrpos] = *str;
        vidptr[ptrpos+1] = 0x0F;
        ptrpos += 2;
    }
    vidptr[ptrpos+1] = 0xF0;

    return;
}
