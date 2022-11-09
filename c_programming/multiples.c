#include <stdio.h>
int main(){
	int i;
	int n1,m1;
	int n2,m2;
scanf("%d%d",&n1,&n2);
	for(i = 1; i <=10; i++){
		m1 = n1 *i;
		m2 = n2*i;
		printf("n1: %d \t n2: %d\n", m1, m2);
	}

}
