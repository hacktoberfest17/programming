#include <stdio.h>

#define MAX 10
#define INF 999

int optimalBST(int keys[], int freq[], int n)
{
    int cost[MAX][MAX], sum, k;
    int i, j;
    for (i = 0; i < n; i++)
        cost[i][i] = freq[i];
    for (int j = 2; j <= n; j++){
        for (i = 0; i <= n-j+1; i++){
            int j = i+j-1;
            cost[i][j] = INF;
            printf("%d %d %d\n", i, j, cost[i][j]);
            for (int r = i; r <= j; r++){
            	sum = 0;
            	for(int k = i; k <= j; k++)sum += freq[k];	
               	int c = ((r > i)?cost[i][r-1]:0) + ((r < j)?cost[r+1][j]:0) + sum;
               	if (c < cost[i][j])
                	cost[i][j] = c;
            }
        }
    }
    return cost[0][n-1];
}

int main()
{
	int i;
	int keys[MAX], freq[MAX], n;
	printf("Enter the number of nodes: ");
	scanf("%d", &n);
	printf("Enter the keys of nodes and its frequency:\n");
	for(i = 0; i < n; i++)
		scanf("%d %d", &keys[i], &freq[i]);
	printf("Cost of Optimal Binary Search Tree: %d\n", optimalBST(keys, freq, n));
	return 0;
}