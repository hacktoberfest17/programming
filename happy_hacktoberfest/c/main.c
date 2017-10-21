//fhee was here

#include <ncurses.h>

int main(){
	initscr();
	raw();
	keypad(stdscr, TRUE);
	noecho();
	while(1){
		mvprintw(10, 10, "HAPPY HACKTOBERFEST!");
		char ch = getch();
		if (ch == 'q'){
			break;
		}
	}
	refresh();
	endwin();
	return 0;



}
