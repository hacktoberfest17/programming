#include <stdio.h>

#ifdef _WIN32
#include<conio.h>
#endif

int main()
{
	#ifdef _WIN32
	clrscr(); //this will clear the screen for fresh output & erase the previous output
	#endif
	int i, n;
	unsigned long long t1 = 0, t2 = 1, nextTerm;

	printf("Enter the number of terms: ");
	scanf("%d", &n);

	printf("Fibonacci Series: \n");

    // loop for printing fibonacci series
	for (i = 1; i <= n; ++i) {
		printf("%03d: %llu\n", i, t1);
		nextTerm = t1 + t2;

        // check for overflow
		if (nextTerm < t1 || nextTerm < t2) {
			printf("OVERFLOW!\nending...\n");
			break;
		}
		t1 = t2;
		t2 = nextTerm;
	}
	return 0;
}
