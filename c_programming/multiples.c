#include <stdio.h>

#define MAX 1000
#define THREE 3
#define FIVE 5

int main(){
	int i;
	int multiples_of_3;
	int multiples_of_5;
	

	for(i = 1; i < 10; i++){
		multiples_of_3 = 3 * i;
		multiples_of_5 = 5 * i;
		printf("3: %d \t 5: %d\n", multiples_of_3, multiples_of_5);
	}
 return 0;
}
