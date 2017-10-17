#include <stdio.h>
 
void towerOfHanoi(int top, char start, char via, char end)
{
    if (top == 1)
    {
        printf("Move disk 1 from rod %c to rod %c\n", start, end);
        return;
    }
    towerOfHanoi(top-1, start,end, via);
    printf("Move disk %d from rod %c to rod %c\n", top, start, end);
    towerOfHanoi(top-1, via, start, end);
}
 
int main()
{
    int n;
    printf("%s\n","Enter number of disks" );
    scanf("%d",&n);
    towerOfHanoi(n, 'A', 'C', 'B');  // A, B and C are names of rods
    return 0;
}
