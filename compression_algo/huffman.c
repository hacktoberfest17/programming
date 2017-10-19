#include<stdio.h>
#include<string.h>

#define SYMBOLS 256

typedef struct huff
{
	char data;
	int freq;
	struct huff *left, *right;
} huff;

huff *getnode(char , int );

void write_into_file(char *, char [][100]);

void build_heap(huff *[], int);
void build_huffman_tree(huff *[]);
void get_code(huff *, int [], char [][100], int);

void insert_heap(huff *[], int, huff *);
huff *del_heap(huff *[], int);

int heap_size;

int main(int argc, char* argv[])
{
	if (argc != 2)
    {
        printf("Incorrect Usage\n");
        return 1;
    }
	
	FILE *fp = fopen(argv[1], "r");
    
    int freq[SYMBOLS] = {0};
    char a[SYMBOLS],c;
    int i=0,j,k ,n=0;
    int total_chars=0;
    
    while( (c = fgetc(fp)) != EOF )
    {
    	freq[(int)c]++;
    	total_chars++;
    }
    
    fclose(fp);
    
    // print out non-zero frequencies    
    for (i = 0; i < 256; i++)
    	if (freq[i] != 0)
    		a[n++] = i;
	
	huff *nodes[n];
	huff *ptr;
	
	for(i=0; i<n; i++)
	{
		huff *new_node = getnode(a[i], freq[a[i]]);
		nodes[i] =  new_node;
	}
	
	heap_size = n;
	
	int store[100];
	
	char codes[SYMBOLS][100];
	
	build_heap(nodes,n);
	build_huffman_tree(nodes);
	get_code(nodes[0], store, codes, 0);
	
	
	int huffman_bits=0;
	
	printf("   chars | freq. | Huffman Codes\n");
	printf("   -----------------------------\n");
	for(i=0; i<256; i++)
		for(j=0; j<n; j++)
		{
			if(i == a[j])
			{
				if(i==32)
					printf("    \" \"  | %5d | %s\n", freq[i], codes[i]);
				else if(i==10)
					printf("     \\n  | %5d | %s\n", freq[i], codes[i]);
				else
					printf("      %c  | %5d | %s\n", a[j], freq[i], codes[i]);
				
				huffman_bits += freq[a[j]] * strlen(codes[i]);
			}				
		}
	
	printf("\n\n	Total characters in \"%s\" file = %d\n", argv[1], total_chars);
	printf("	   Without compression size is = %f KB\n", (float)(total_chars*8)/(1024*1024));
	printf("	     After compression size is = %.4f KB\n", (float)huffman_bits/(1024*1024));
	printf("	 	    compression = %.2f%%\n\n", (((float)(total_chars*8)/(1024*1024) - (float)huffman_bits/(1024*1024))/((float)(total_chars*8)/(1024*1024)))*100);

	
	write_into_file(argv[1], codes);
	
}

huff *getnode(char ch, int freq)
{
	huff* new = (huff*)malloc(sizeof(huff));
	new -> data = ch;
	new -> freq = freq;
	new -> left = new -> right = NULL;
	
	return new;
}

void build_huffman_tree(huff *nodes[])
{
	while(heap_size != 1)
	{
		huff* min1 = del_heap(nodes, heap_size-1);
		huff* min2 = del_heap(nodes, heap_size-2);
		heap_size-=2;
	
		huff* new_node = getnode('@', min1->freq + min2->freq);
		new_node -> left = min1;
		new_node -> right = min2;
		
		insert_heap(nodes, heap_size-1, new_node);
		heap_size++;
	}
	
}

void get_code(huff *root, int a[], char codes[][100], int index)
{
	if(root->left)
	{
		a[index] = 0;
		get_code(root->left, a, codes, index+1);
	}
	
	if(root->right)
	{
		a[index] = 1;
		get_code(root->right, a, codes, index+1);
	}
	
	if(root->right == NULL && root->left == NULL)
	{
		int i;
		
		for(i=0; i<index; i++)
			codes[root->data][i] = a[i]+'0';
		codes[root->data][i] = '\0';
	}
}

void build_heap(huff *nodes[], int n)
{
	int item, i;
	
	for(i=0; i<n-1; i++)
		insert_heap(nodes, i, nodes[i+1]);
}

void insert_heap(huff *tree[], int n, huff *node)
{
	int ptr, par;
	n++;
	ptr = n;
	
	while(ptr > 0)
	{
		par = (ptr-1)/2;
		if(node->freq >= tree[par]->freq)
		{
			tree[ptr] = node;
			return;
		}
		
		tree[ptr] = tree[par];
		ptr = par;
	}
	
	tree[0] = node;
}

huff *del_heap(huff *tree[], int n)
{
	int ptr, left, right;
	
	huff *temp = tree[0];
	huff *last = tree[n];
	
	ptr=0; left=1; right=2;
	
	while(right <= n)
	{
		if(last->freq <= tree[left]->freq && last->freq <= tree[right]->freq)
		{
			tree[ptr] = last;
			return temp;
		}
		
		if(tree[right]->freq <=  tree[left]->freq)
		{
			tree[ptr] = tree[right];
			ptr = right;
		}
		else
		{
			tree[ptr] = tree[left];
			ptr = left;
		}
		
		left = 2*ptr + 1;
		right = left + 1;
	}
	
	if(left == n-1 && last->freq > tree[left]->freq)
	{
		tree[ptr] = tree[left];
		ptr = left;
	}
	
	tree[ptr] = last;
	return temp;
}

void write_into_file(char *file, char codes[][100])
{
	FILE *fp = fopen(file, "r");
	FILE *fw = fopen("compress.txt", "w");
	
	char ch;
	
	while((ch = fgetc(fp)) != EOF)
		fprintf(fw, "%s", codes[ch]);	
}













