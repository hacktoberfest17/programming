#include<stdio.h>
#include<unistd.h>
#include<string.h>
#include<stdlib.h>
int n;
struct details
{
	char name[20];
	int price;
	int qty;
	int id;
	char type[20];
};
struct details items[50];
void Display();
void Insert();
void Update();
void UpToDtb(); //For Linux Users
void main()
{	
	
	printf("\n\t\t\t WELCOME TO INVENTORY \t");
	printf("\n");
	printf("\t\t\t ---------------------");
	printf("\n");
	sleep(1);
	printf("\n\t\t\tPress 1 to Insert Values");
	sleep(1.5);
	printf("\n");
	printf("\n\t\t\tPress 2 to Display Values");
	printf("\n");
	sleep(1.5);
	printf("\n\t\t\tPress 3 to Update");
	printf("\n");
	sleep(1.5);	
	printf("\n\t\t\tPress 4 to FlushDatabase");
	printf("\n");	
	sleep(1.5);
	printf("\n\t\t\tEnter Your Option :-");
	int Option;
	scanf("\n\t\t\t%d",&Option);
	switch(Option)
	{
		case 1:Insert();
		break;
		case 2:Display();
		break;
		case 3:Update();
		break;
		case 4:UpToDtb();
		break;
		default:printf("\t Invalid Entry");
	}
}
void Insert()
{
		int i;
		printf("\n");
		printf("\t\t\tEnter No. of Items :-");
		scanf("%d",&n);
		for(i=0;i<n;i++)
		{	
			printf("\n");
			printf("\t\t\t\tProduct %d",i+1);
			printf("\n\t\t\t\t----------");
			printf("\n\t\t\tItem name :-");
			scanf("%s",items[i].name);
			printf("\t\t\t    Price :-");
			scanf("%d",&items[i].price);
			printf("\t\t\t Quantity :-");
			scanf("%d",&items[i].qty);
			printf("t\t         Enter Product ID :-");
			scanf("%d",&items[i].id);
			printf("\t\t     Product Type :-");
			scanf("%s",items[i].type);
		}
	
	char Opt[10];
	printf("\n\t\t\t Return to Main Menu :-");
	scanf("%s",Opt);
		if(Opt=="y")
			Display();
			
		else
			main();
	
		
}

void Display()
{
	int k;
	printf("\n\tProduct ID\tName\t Price\t Quantity\t Product type");
	printf("\n\t*************************************************************");
		for(k=0;k<n;k++)
		{
			 printf("\n\t\t%d\t%s\t   %d\t    %d\t\t   %s",items[k].id,items[k].name,items[k].price,items[k].qty,items[k].type);
		}
	char Opt[10];
	printf("\n\t\t\t Return to Main Menu :-");
	scanf("%s",Opt);
		if(Opt=="y")
			Display();
			
		else
			main();
}

void Update()
{

	int udt,k,udtid,stock,amount,data,sop,mrp;
	printf("\n\t\t\tNOTE:-You need Product ID to Update Products ");
	printf("\n\t\t\t-------------------------------------------- ");
	printf("\n\t\t\tPress 1 to get Product ID of every Product");
	printf("\n");
	printf("\n\t\t\tPress 2 to enter Product ID");
	printf("\n");
	printf("\n\t\t\tEnter Your Option");
	scanf("%d",&udt);
	if(udt==1)
	{	
		printf("\n\t\t\tYour Data");

		printf("\n\tProduct ID\tName\t Price\t Quantity\t Product type");
		printf("\n\t*************************************************************");
		for(k=0;k<n;k++)
		{
			 printf("\n\t\t%d\t%s\t   %d\t    %d\t\t   %s",items[k].id,items[k].name,items[k].price,items[k].qty,items[k].type);
		}
		Update();
		sleep(10);
	}
	else if(udt==2)
	{
		printf("\n\t\t\tEnter ID to Update :-");
		scanf("%d",&udtid);		
		for(k=0;k<n;k++)
		{
			if(udtid==items[k].id)
			{
				printf("\n\t\t\tWhat You Want to Update ?");
				printf("\n\t\t\t1 for Price\n\t\t\t2 for Stock");
				printf("\n\t\t\tEnter Your Option :-");
				scanf("%d",&sop);
				if(sop==1)
				{
					printf("\n\t\t\tEnter New Price of This Product"):-;
					scanf("%d",&mrp);
					items[k].price=mrp;
				}
				else if(sop==2)
				{
				        printf("\n\t\t\tWhat you want to Do ?");
					printf("\n\t\t\tPress 1 To Add stock ");
					printf("\n\t\t\tPress 2 to Sold  Stock");
					scanf("%d",&stock);
					printf("\n\t\t\tEnter quantity");
					scanf("%d",&amount); 
					if(stock==1)
					{
						items[k].qty+=amount;
					}
					else if(stock==2)
					{
						items[k].qty-=amount;
					}
					else
						printf("\n\t\t\tInvalid Entry");
				}
				else
					printf("\n\t\t\tInvalid Entry");
			}
//			else
//				printf("\n\t\t\tProduct Not Found");
		}
	}
	else
		printf("\n\t\t\tInvalid Entry");

	char Opt[10];
	printf("\n\t\t\t Return to Main Menu :-");
	scanf("%s",Opt);
		if(Opt=="y")
			Display();
			
		else
			main();
	
}

void UpToDtb() //Open Inventory Data using LibreOffice Linux
{
		FILE *fptr;
		fptr=fopen("qty.csv","w");
		//fprintf(fptr,"\t WELCOME TO INVENTORY \t\n");
		fprintf(fptr,"Id,Name,Price,Quantity,Product Type\n");
		int i;		
		for(i=0;i<n;i++)
		{	
			fprintf(fptr,"%d, %s, %d, %d, %s\n",items[i].id,items[i].name,items[i].price,items[i].qty,items[i].type);
		}
		fclose(fptr);
		printf("\n\t\t\tUpdating to Excel");
		sleep(2);
		printf("\n\t\t\tFlushing Data to Excel");
		system("libreoffice qty.csv");
		
}	
