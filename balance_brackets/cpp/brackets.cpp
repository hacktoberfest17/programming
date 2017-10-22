#include <iostream>
#include <stack>

using namespace std;

int main() {
    //read input string
    string input;
    cin>>input;

    //check if it's balanced
    stack<char> bracketStack;   //we store opening brackets here
    for(char symbol : input){
        if(symbol == '(' || symbol == '{' || symbol =='['){
            bracketStack.push(symbol);
        }
        else if(symbol == ')'){
            //check if respective opening symbol is present on ToS.
            if(bracketStack.top() == '('){
                bracketStack.pop();
                //remember that in C++, pop() only removes the ToS,while top() return it
            } else{
                cout<<"non matching brackets\n";
                return -1;
            }
        }
        else if (symbol == '}') {
            if (bracketStack.top() == '{') {
                bracketStack.pop();
            } else {
                cout << "non matching brackets\n";
                return -1;
            }
        }
        else if (symbol == ']') {
            if (bracketStack.top() == '[') {
                bracketStack.pop();
            } else {
                cout << "non matching brackets\n";
                return -1;
            }
        }
        else {
            cout<<"invalid character\n";
            return -1;
        }
    }
    if(bracketStack.empty()){
        cout<<"brackets are balanced\n";
        return 0;
    } else {
        cout<<"brackets are not balanced\n";
        return -1;
    }
}
