#include<stdio.h>
int main()
{
int wt[10],pt[10],arr[10],n,i,w,ben[10][10],m;
printf("\nEnter the no. of objects:");
scanf("%d",&n);
printf("\nEnter the capacity:");
scanf("%d",&m);
printf("\nEnter the weights of all objects:");
for(i=1;i<=n;i++)
{
 scanf("%d",&wt[i]);
}
printf("\nEnter profits of all objects:");
for(i=1;i<=n;i++)
{
 scanf("%d",&pt[i]);
}
for(w=0;w<=m;w++)
{
  ben[0][w]=0;
}
for(i=1;i<=n;i++)
{
  ben[i][0]=0;
}
for(i=1;i<=n;i++)
{
  for(w=0;w<=m;w++)
 {
   if(wt[i]<=w)
   {
    if(pt[i]+ben[i-1][w-wt[i]]>ben[i-1][w])
    {
     ben[i][w]=pt[i]+ben[i-1][w-wt[i]];
    }
    else
    {
     ben[i][w]=ben[i-1][w];
    }
   }
   else
   {
    ben[i][w]=ben[i-1][w];
   }
 }
}
for(i=0;i<=n;i++)
{
  for(w=0;w<=m;w++)
 {
  printf("%d\t",ben[i][w]);
 }
  printf("\n");
}
i=n;
w=m;
while(i>=0)
{
if(ben[i][w]!=ben[i-1][w])
{
 printf("\n Item %d is selected",i);
 i--;
 w=w-wt[i];
}
else
 i=i-1;
}
return 0;
}