#include<stdio.h>
#include<string.h>

int decimal_value(char* str)
{
 	int n = 0;
 	int size = strlen(str) - 1;
    int count = 0;
    
 	while ( *str != '\0' ) 
	{
  		if ( *str == '1' ) 
      	n = n + pow(2, size - count );
  		count++; 
  		str++;
 	}
 	
	return n;
}

void main()
{
	int i=0;
	
	FILE *fp = fopen("compress.txt","r");
	FILE *fw = fopen("compressed.txt","w");
	
	char ch;
	char temp[9];
	int t;
	
	while((ch=fgetc(fp)) != EOF)
	{	
		if(i == 8)
		{
			temp[i] = '\0';
			t = decimal_value(temp);
			fputc((char)t, fw);
			i=0;
		}
		
		temp[i] = ch;
		i++;
	}
	
	temp[i] = '\0';
	t = decimal_value(temp);
	fputc((char)t, fw);
	
	fclose(fp);
	fclose(fw);
}
