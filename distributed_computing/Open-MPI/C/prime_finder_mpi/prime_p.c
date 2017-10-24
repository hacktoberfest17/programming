#include <stdio.h>
#include <stdlib.h>
#include <primesieve.h>
#include "mpi.h"

int main(int argc, char** argv) {
	int sum=0,sum_total=0,N;
	int upperbound,lowerbound;
	int rank,size;
	double ta,tt;
	MPI_Init(&argc, &argv);							//MPI Activation/Initialization
	MPI_Comm_rank(MPI_COMM_WORLD, &rank);			// Find the rank of your node
	MPI_Comm_size(MPI_COMM_WORLD, &size);           // Number of nodes
	if(argc<2){
		if(rank==0){
			printf("\n Please give N: ");
			scanf("%d", &N);
		}
	}else{
		N=atoi(argv[1]);
	}
	ta=MPI_Wtime();                                // Timer start
	MPI_Bcast(&N,1,MPI_INT,0,MPI_COMM_WORLD);      // Broadcast N by Master
	if(rank!=0){
		upperbound=(N/(size-1))*rank;
		lowerbound=(upperbound-(N/(size-1)))+1;
		//printf("\nUpperbound: %d\nLowerbound:%d", upperbound,lowerbound); //Check if the upperbound and lowerbound numbers are correct
		sum=primesieve_count_primes(lowerbound,upperbound);
		//printf("\nPrime count: %d", sum);					//Sum check
		//printf("\nWorker number:%d\n\n", rank);		//Rank check
	}
	MPI_Reduce(&sum,&sum_total,1,MPI_INT,MPI_SUM,0,MPI_COMM_WORLD);
	tt=MPI_Wtime();
	if(rank==0){
		printf("\n\n Prime numbers found:%d\n", sum_total);
		printf("\n\n Time = %6f\n\n", tt-ta);
	}
	MPI_Finalize();
	return 0;
}
