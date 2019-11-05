#include <iostream>
#include <fstream>
using namespace std;
#include <string.h>

int main(){
	ifstream infile;
	infile.open("test.txt",ios::in);
	
	ofstream outfile("temp.cpp");

	char c,data[100];
	char var[100][20];
	int i,s=0,j=0;

	outfile<<"ofstream ofile(\"log.c\");"<<endl;
	do{
		i=0;
		do{
			infile.get(c);
			outfile<<c;
			if(c=='='){
				data[i]='\0';
				strcpy(var[j++],data);
				i=0;
				continue;
			}
			if(c==' '||c==','||c=='{'||c=='}'||c=='('||c==')'){
				i=0;
				continue;
			}
			data[i++]=c;
		}while(c!='\n'&&!infile.eof());
		while(s!=j){
			outfile<<"ofile<<\""<<var[s++]<<" \"<<"<<var[s-1]<<"<<endl;"<<endl;
		}
	}while(!infile.eof());

	for(i=0;i<j;i++)
		cout<<var[i]<<endl;
	
	infile.close();
	outfile.close();
	Sleep(3000);
}