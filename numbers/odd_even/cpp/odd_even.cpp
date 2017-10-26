#include <iostream>
using namespace std;

int main(){
    int n;
    cout << "Enter an integer (0 exits): ";
    cin >> n;

    while (n != 0){
        if (n > 0){
            if (n % 2 == 0){
                cout << "It's even\n";
            }else{
                cout << "It's odd\n";
            }
        }

        cout << "Enter another integer (0 exits): ";
        cin >> n;
    }
    
    return 0;
}
