#include <stdio.h>
# define MAX 10

int main(){
	
	float mat[MAX][MAX],super[MAX][MAX];
	int n,i,j,l,k;
	printf("Enter size of array=");
	scanf("%d",&n);
	printf("Enter elements\n");
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			scanf("%f",&mat[i][j]);
			super[i+1][j+1]=mat[i][j];
			mat[i][j]=0;
		}
	}
	for(i=0;i<n+2;i++){
		for(j=0;j<n+2;j++){
			if(i==0){
				if(j==0){
					super[i][j]=super[i+1][j+1];
				}
				else if(j==n+1){
					super[i][j]=super[i+1][j-1];

				}
				else{
					super[i][j]=super[i+1][j];

				}

			}
			else if(i==n+1){
				if(j==0){
					super[i][j]=super[i-1][j+1];
				}
				else if(j==n+1){
					super[i][j]=super[i-1][j-1];

				}
				else{
					super[i][j]=super[i-1][j];

				}

			}
			else if(j==0){
				if(i!=0 && i!=n+1){
					super[i][j]=super[i][j+1];
				}

			}
			else if(j==n+1){
				if(i!=0 && i!=n+1){
					super[i][j]=super[i][j-1];
				}
			}
		}


	}

	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			for(l=0;l<3;l++){
				for(k=0;k<3;k++){

					if(l==1 && k==1){
						mat[i][j]+=(super[i+l][j+k]*8);

					}
					else{
						mat[i][j]+=(super[i+l][j+k]*-1);
					}
				}
			}
			mat[i][j]/=9;
			if(mat[i][j]<0){
				mat[i][j]=0;
			}
		}
	}
	for(i=0;i<n;i++){
		for(j=0;j<n;j++){
			printf("%.2f ",mat[i][j] );
		}
		printf("\n");
	}	
	return 0;
}
