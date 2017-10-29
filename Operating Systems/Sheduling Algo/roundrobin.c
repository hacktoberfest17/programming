 
#include<stdio.h>
void main()
{
int n,b[100],a[100],w[100],p[100],tq,flag=0,i,k,temp[100],total=0;
printf("enter the no. of processes:");
scanf("%d",&n);
for(i=0;i<n;i++)
{
printf("enter burst time of process%d:",i+1);
scanf("%d",&b[i]);
w[i]=0;               /* Array for storing waiting time of each process*/
p[i]=0;               /*  "previous array" used to store the last value when the process was executed*/

}
printf("enter the time quantum:");
scanf("%d",&tq);
i=0;k=0;
while(1)
{
if(i==n)                 
i=0;
if(flag==n)             /* if flag==n,it means all the processes are completed so break;*/
break;


if(b[i]<=tq && b[i]>0)
{
w[i]+=total-p[i];
flag++;                       /* When ever a process is completed flag is incremented by 1 */

total+=b[i];     
b[i]=0;
 	

}
if(b[i]>tq)
{
w[i]+=total-p[i];
b[i]=b[i]-tq;
total+=tq;
 	
}
p[i]=total;
i++;
}
 
printf("\nWAITING TIME\n");
for(i=0;i<n;i++)
{
printf("%d,",w[i]);
}
float sum=0;

for(i=0;i<n;i++){
	sum=sum+w[i];
}

 float awt=sum/n;
printf("\n Average waiting time %f",awt);


}
