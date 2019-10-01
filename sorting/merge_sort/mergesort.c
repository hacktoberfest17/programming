#include <stdio.h>
#define begin 0
#define end 5

void merge(int *vector, int begin, int middle, int end){
	int size1, size2, i, j;

	size1 = middle - begin + 1;
	size2 = end - middle;

	int e[size1], d[size2];

	for(i=0;i<size1;i++){
		e[i] = vector[begin + i];
	}

	for(j=0;j<size2;j++){
		d[j] = vector[middle+1+j];
	}
	int k = begin;
	i = 0;
	j = 0;

	while(i<size1 && j<size2){
		if(e[i]<=d[j]){
			vector[k] = e[i];
			i++;
		}
		else{
			vector[k] = d[j];
			j++;
		}
		k++;
	}
	
	while(i<size1){
		vector[k] = e[i];
		k++;
		i++;
	}
	
	while(j<size2){
		vector[k] = d[j];
		j++;
		k++;
	}
}

void merge_sort(int *vector, int begin, int end){
	
	int middle = begin + (end - begin)/2;
	
	if(begin < end){
		merge_sort(vector,begin, middle);
		merge_sort(vector,middle+1, end);
		merge(vector,begin, middle, end);
	}
}

