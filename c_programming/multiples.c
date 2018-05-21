#include <stdio.h>

#define THREE 3
#define FIVE 5

int main(){
	int multiplesof3;
	int multiplesof5;

	printf("\nTable showing multiples of 3 and 5:\n");
	printf("   x3\t x5\n");
	for(int i = 0; i < 10; i++){
		multiplesof3 = THREE * i;
		multiplesof5 = FIVE * i;
		printf("  %3d\t%3d\n", multiplesof3, multiplesof5);
	}
}
