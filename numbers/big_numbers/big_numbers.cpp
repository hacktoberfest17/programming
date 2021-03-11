#include <iostream>
#include <cstring>

using namespace std;

class Nr_Mari
{
    private:
        int nr[10000];

    public:
        friend ostream& operator<<(ostream& fout, const Nr_Mari& num)
        {
            for(int i=num.nr[0]; i>0; i--)
                fout << num.nr[i];
            return fout;
        }

        friend istream& operator>>(istream& fin, Nr_Mari& num)
        {
            string numar;
            fin >> numar;
            num.nr[0] = numar.length();
            for(int i=1; i<=num.nr[0]; i++)
                num.nr[i] = int(numar[num.nr[0]-i] - '0');
            return fin;
        }

        Nr_Mari operator+(Nr_Mari num)
        {

            Nr_Mari rezultat;
            int rem = 0, i;

            rezultat.nr[0] = max(num.nr[0], this->nr[0]);

            for(i=1; i<=rezultat.nr[0]; i++)
            {
                if(num.nr[i] + this->nr[i] + rem >= 10)
                {
                    rezultat.nr[i] = (num.nr[i] + this->nr[i] + rem)%10;
                    rem = 1;
                }
                else
                {
                    rezultat.nr[i] = (num.nr[i] + this->nr[i] + rem)%10;
                    rem = 0;
                }
            }

            if(rem==1)
            {
                rezultat.nr[0]++;
                rezultat.nr[i] = 1;
            }

            return rezultat;
        }

};


int main()
{
    Nr_Mari a, b, c;
    cin>>a>>b;
    c = a + b;
    cout<<c;
    return 0;
}
