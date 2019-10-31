//
//  tic-tac-toe.cpp
//  college
//
//  Created by Tanishq Chamola on 03/08/19.
//  Copyright © 2019 Tanishq Chamola. All rights reserved.
//

#include <iostream>
#include <time.h>
#define randMax 10
using namespace std;
/*
void print(unsigned short int arr[3][3])
{
    for (int i=0; i<3; i++)
    {
        for (int j=0; j<3; j++)
        {
            cout<<arr[i][j]<<" | ";
        }
        cout<<"\n------------\n";
    }
}

int check(unsigned short int arr[3][3],bool stop)
{
    
    if (arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2] && arr[0][0] != 0)
    {
        stop = true;
        cout<<"case 1";
    }
    else if (arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0] && arr[0][0] != 0)
    {
        stop = true;
        cout<<"case 2";
    }
    else if (arr[1][1] == arr[1][0] && arr[1][1] == arr[1][2] && arr[1][1] != 0)
    {
        stop = true;
        cout<<"case 3";
    }
    else if (arr[1][1] == arr[0][1] && arr[1][1] == arr[2][1] && arr[1][1] != 0)
    {
        stop = true;
        cout<<"case 4";
    }
    else if (arr[2][2] == arr[2][0] && arr[2][2] == arr[2][1] && arr[2][2] != 0)
    {
        stop = true;
        cout<<"case 5";
    }
    else if (arr[2][2] == arr[1][2] && arr[2][2] == arr[0][2] && arr[2][2] != 0)
    {
        stop = true;
        cout<<"case 6";
    }
    else if (arr[2][0] == arr[1][1] && arr[2][0] == arr[0][2] && arr[2][0] != 0)
    {
        stop = true;
        cout<<"case 7";
    }
    else if (arr[0][0] == arr[1][1] && arr[0][0] == arr[2][2] && arr[0][0] != 0)
    {
        stop = true;
        cout<<"case 8";
    }
    else{
        stop = false;
    }
    
    return stop;
}

int main()
{
    unsigned short int arr[3][3];
    bool stop = false;
    srand(time(0));
    
    for (int i=0; i<3; i++)
    {
        for (int j=0; j<3; j++)
        {
            arr[i][j]=0;
        }
    }
    
    while (1)
    {
        int X,O;
        unsigned short int a,b;
        
        cout<<"Your move: ";
        cin>>X;
        a = (X-1)/3;
        b = (X-1)%3;
        arr[a][b] = 1;
        
        //cout<<X<<"\n"<<a<<"\n"<<b<<"\n";
        stop = check(arr,stop);
        if(stop == true)
        {
            cout<<"YOU WIN!\n";
            break;
        }
        
    random:
        O = rand() % randMax;
        if (O == 0)
        {
            goto random;
        }
        a = (O-1)/3;
        b = (O-1)%3;
        //cout<<"\n"<<O<<"\n"<<a<<"\n"<<b<<"\n";
        cout<<"Computer move: "<<O<<"\n";
        if (arr[a][b] == 0)
        {
            arr[a][b] = 2;
        }
        else{
            goto random;
        }
        //cout<<arr[a][b]<<"\n";
        stop = check(arr,stop);
        if(stop == true)
        {
            cout<<"COMPUTER WIN!\n";
            break;
        }
        
        print(arr);
        
    }
    print(arr);
    
    return 0;
}
*/
