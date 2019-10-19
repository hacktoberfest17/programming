//Horspool algorithm to fing the occurence of a substring

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
char str[500],srch[500];
int shift[128];
void table()
{
    int i;
    for(i=0;i<128;i++)
        shift[i]=strlen(srch);
    for(i=0;i<strlen(srch)-1;i++)
        shift[srch[i]]=strlen(srch)-i-1;
}
int horspool()
{
    int i,k;
    table();
    i=strlen(srch)-1;
    while(i<strlen(str))
    {
        k=0;
        while(k<strlen(srch) && srch[strlen(srch)-k-1]==str[i-k])
            k++;
        if(k==strlen(srch))
            return i-strlen(srch)+2;
        else
            i+=shift[str[i]];
    }
    return -1;
}
void main()
{
    int pos=0;
    printf("Enter a string: \n");
    gets(str);

    printf("Enter the string to search for: \n");
    gets(srch);
    pos=horspool();
    if(pos==-1)
        printf("Not found\n");
    else
        printf("Found at %d position\n",pos);
    

}
