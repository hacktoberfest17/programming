#include <iostream>

using namespace std;

bool isupper(char c){
    return c >= 'A' && c <= 'Z';
}

bool islower(char c){
    return c >= 'a' && c <= 'z';
}

bool isalpha(char c){
    return isupper(c) || islower(c);
}

bool isdigit(char c){
    return c >= '0' && c <= '9';
}

bool isalnum(char c){
    return isalpha(c) || isdigit(c);
}

int main(){
    char mander;
    cout << "Enter a character: ";
    cin >> mander;

    if(isalnum(mander)){
        if(isupper(mander)){
            cout << "It's uppercase";
        }else if(islower(mander)){
            cout << "It's lowercase";
        }else{
            cout << "It's a digit";
        }
    }else{
        cout << "It's some symbol";
    }
    cout << endl;

    return 0;
}