#include<stdio.h>
#include<conio.h>
#include<time.h>

void main ()
{

   time_t rawtime;
   struct tm *info;
   int x=0;   //add by how many hours your location differs from gmt
   clrscr();
   time(&rawtime);

   info = gmtime(&rawtime );

   printf("Current world clock:\n");
   printf("%2d:%02d\n", (info->tm_hour+x)%24, info->tm_min);

   getch();
}