// Created in borland C++ 5

#include "iostream.h"
#include "conio.h"
#include "windows.h"

char mn;
int i,bolehmasuk,r_dua[6],r_empat[6];

menu();
parkiran();
operasi();

case_1();
case_2();
case_3();
case_4();

jeda_animasi();

main()
{
	for(i=0;i<=5;i++)
	{
		r_dua[i]=0;
		r_empat[i]=0;
	}

	menu();
	cout<<endl<<endl<<endl<<endl<<endl<<endl<<endl<<endl; // kayaknya gak kepakai
	parkiran();
	do{
		gotoxy(20,7);
		mn=getch();
		cout<<mn;
		operasi();
	}while(mn != '5');
}

menu()
{
	gotoxy(18,1); cout<<"                   Menu";
	gotoxy(18,2); cout<<"=============================================";
	gotoxy(18,3); cout<<"1. Parkir Roda-2 \t 3. Parkir Roda-4";
	gotoxy(18,4); cout<<"2. Keluarkan Roda-2 \t 4. Keluarkan Roda-4";
	gotoxy(18,5); cout<<"5. Exit";
	gotoxy(18,7); cout<<"> ";
}

parkiran()
{
	gotoxy(24,13); cout<<"     \272    \272    \272    \272    \272";
	gotoxy(24,14); cout<<"     \272    \272    \272    \272    \272";
	gotoxy(24,15); cout<<"\315\315\315\315\315\316\315\315\315\315\316\315\315\315\315\316\315\315\315\315\316\315\315\315\315\316\315\315\315\315\315";
	gotoxy(24,16); cout<<"     \272    \272    \272    \272    \272";
	gotoxy(24,17); cout<<"     \272    \272    \272    \272    \272";
}

operasi()
{
	switch(mn)
	{
		case '1':
			case_1();
			break;
		case '2':
			case_2();
			break;
		case '3':
			case_3();
			break;
		case '4':
			case_4();
			break;
		default:
			gotoxy(20,7);
			cout<<" ";
	}
}

case_1()
{
	gotoxy(28,11);
	cout<<"                        ";

	if(r_dua[0] == 0) // 0
	{
		for(i=1;i<=26;i++) // ke kanan (mendatar)
		{
			gotoxy(i,11);
			cout<<"R2";
			gotoxy(i-1,11);
			cout<<" ";
			jeda_animasi();
		}
		for(i=11;i<=14;i++) // ke r_empat (turun)
		{
			gotoxy(26,i);
			cout<<"R2";
			gotoxy(26,i-1);
			cout << "  ";
			jeda_animasi();
		}
		r_dua[0]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else if(r_dua[1] == 0) // 1
	{
		for(i=1;i<=31;i++) // ke kanan (mendatar)
		{
			gotoxy(i,11);
			cout<<"R2";
			gotoxy(i-1,11);
			cout<<" ";
			jeda_animasi();
		}
		for(i=11;i<=14;i++) // ke r_empat (turun)
		{
			gotoxy(31,i);
			cout<<"R2";
			gotoxy(31,i-1);
			cout << "  ";
			jeda_animasi();
		}
		r_dua[1]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else if(r_dua[2] == 0)
	{
		for(i=1;i<=36;i++) // ke kanan (mendatar)
		{
			gotoxy(i,11);
			cout<<"R2";
			gotoxy(i-1,11);
			cout<<" ";
			jeda_animasi();
		}
		for(i=11;i<=14;i++) // ke r_empat (turun)
		{
			gotoxy(36,i);
			cout<<"R2";
			gotoxy(36,i-1);
			cout << "  ";
			jeda_animasi();
		}
		r_dua[2]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else if(r_dua[3] == 0)
	{
		for(i=1;i<=41;i++) // ke kanan (mendatar)
		{
			gotoxy(i,11);
			cout<<"R2";
			gotoxy(i-1,11);
			cout<<" ";
			jeda_animasi();
		}
		for(i=11;i<=14;i++) // ke r_empat (turun)
		{
			gotoxy(41,i);
			cout<<"R2";
			gotoxy(41,i-1);
			cout << "  ";
			jeda_animasi();
		}
		r_dua[3]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else if(r_dua[4] == 0)
	{
		for(i=1;i<=46;i++) // ke kanan (mendatar)
		{
			gotoxy(i,11);
			cout<<"R2";
			gotoxy(i-1,11);
			cout<<" ";
			jeda_animasi();
		}
		for(i=11;i<=14;i++) // ke r_empat (turun)
		{
			gotoxy(46,i);
			cout<<"R2";
			gotoxy(46,i-1);
			cout << "  ";
			jeda_animasi();
		}
		r_dua[4]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else if(r_dua[5] == 0)
	{
		for(i=1;i<=51;i++) // ke kanan (mendatar)
		{
			gotoxy(i,11);
			cout<<"R2";
			gotoxy(i-1,11);
			cout<<" ";
			jeda_animasi();
		}
		for(i=11;i<=14;i++) // ke r_empat (turun)
		{
			gotoxy(51,i);
			cout<<"R2";
			gotoxy(51,i-1);
			cout << "  ";
			jeda_animasi();
		}
		r_dua[5]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else
	{
		gotoxy(28,11);
		cout<<"                        ";
		Sleep(50);
		gotoxy(28,11);
		cout<<"Antrian Roda Dua penuh!";
		Sleep(100);
		gotoxy(28,11);
		cout<<"                        ";
		Sleep(400);
		gotoxy(28,11);
		cout<<"Antrian Roda Dua penuh!";
		gotoxy(20,7);
		cout<<" ";
	}
}

case_2()
{
	gotoxy(28,11);
	cout<<"                        ";

	// 0
	if(r_dua[0] == 1)
	{
		for(i=14;i>=11;i--) // ke atas (naik)
		{
			gotoxy(26,i);
			cout<<"R2";
			if(i == 14)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(26,i+1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=26;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,11);
				cout<<"R";
			}
			else
			{
				gotoxy(i,11);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,11);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,11);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_dua[0]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 1
	else if(r_dua[1] == 1)
	{
		for(i=14;i>=11;i--) // ke atas (naik)
		{
			gotoxy(31,i);
			cout<<"R2";
			if(i == 14)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(31,i+1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=31;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,11);
				cout<<"R";
			}
			else
			{
				gotoxy(i,11);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,11);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,11);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_dua[1]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 2
	else if(r_dua[2] == 1)
	{
		for(i=14;i>=11;i--) // ke atas (naik)
		{
			gotoxy(36,i);
			cout<<"R2";
			if(i == 14)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(36,i+1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=36;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,11);
				cout<<"R";
			}
			else
			{
				gotoxy(i,11);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,11);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,11);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_dua[2]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 3
	else if(r_dua[3] == 1)
	{
		for(i=14;i>=11;i--) // ke atas (naik)
		{
			gotoxy(41,i);
			cout<<"R2";
			if(i == 14)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(41,i+1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=41;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,11);
				cout<<"R";
			}
			else
			{
				gotoxy(i,11);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,11);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,11);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_dua[3]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 4
	else if(r_dua[4] == 1)
	{
		for(i=14;i>=11;i--) // ke atas (naik)
		{
			gotoxy(46,i);
			cout<<"R2";
			if(i == 14)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(46,i+1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=46;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,11);
				cout<<"R";
			}
			else
			{
				gotoxy(i,11);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,11);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,11);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_dua[4]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 5
	else if(r_dua[5] == 1)
	{
		for(i=14;i>=11;i--) // ke atas (naik)
		{
			gotoxy(51,i);
			cout<<"R2";
			if(i == 14)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(51,i+1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=51;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,11);
				cout<<"R";
			}
			else
			{
				gotoxy(i,11);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,11);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,11);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_dua[5]=0;
		gotoxy(20,7);
		cout<<" ";
	}
	else
	{
		gotoxy(28,11);
		cout<<"                        ";
		Sleep(50);
		gotoxy(28,11);
		cout<<"Antrian Roda Dua kosong!";
		Sleep(100);
		gotoxy(28,11);
		cout<<"                        ";
		Sleep(400);
		gotoxy(28,11);
		cout<<"Antrian Roda Dua kosong!";
		gotoxy(20,7);
		cout<<" ";
	}
}

case_3()
{
	gotoxy(27,19);
	cout<<"                          ";

	// 0
	if(r_empat[0] == 0)
	{
		for(i=1;i<=26;i++) // ke kanan (mendatar)
		{
			gotoxy(i,19);
			cout<<"R4";
			gotoxy(i-1,19);
			cout<<" ";
			jeda_animasi();
		}
		for(i=19;i>=16;i--)
		{
			gotoxy(26,i);
			cout<<"R4";
			gotoxy(26,i+1);
			cout << "  ";
			jeda_animasi();
		}
		r_empat[0]=1;
		gotoxy(20,7);
		cout<<" ";
	}

	// 1
	else if(r_empat[1] == 0)
	{
		for(i=1;i<=31;i++) // ke kanan (mendatar)
		{
			gotoxy(i,19);
			cout<<"R4";
			gotoxy(i-1,19);
			cout<<" ";
			jeda_animasi();
		}
		for(i=19;i>=16;i--)
		{
			gotoxy(31,i);
			cout<<"R4";
			gotoxy(31,i+1);
			cout << "  ";
			jeda_animasi();
		}
		r_empat[1]=1;
		gotoxy(20,7);
		cout<<" ";
	}

	// 2
	else if(r_empat[2] == 0)
	{
		for(i=1;i<=36;i++) // ke kanan (mendatar)
		{
			gotoxy(i,19);
			cout<<"R4";
			gotoxy(i-1,19);
			cout<<" ";
			jeda_animasi();
		}
		for(i=19;i>=16;i--)
		{
			gotoxy(36,i);
			cout<<"R4";
			gotoxy(36,i+1);
			cout << "  ";
			jeda_animasi();
		}
		r_empat[2]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else if(r_empat[3] == 0) // 3
	{
		for(i=1;i<=41;i++) // ke kanan (mendatar)
		{
			gotoxy(i,19);
			cout<<"R4";
			gotoxy(i-1,19);
			cout<<" ";
			jeda_animasi();
		}
		for(i=19;i>=16;i--)
		{
			gotoxy(41,i);
			cout<<"R4";
			gotoxy(41,i+1);
			cout << "  ";
			jeda_animasi();
		}
		r_empat[3]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else if(r_empat[4] == 0) // 4
	{
		for(i=1;i<=46;i++) // ke kanan (mendatar)
		{
			gotoxy(i,19);
			cout<<"R4";
			gotoxy(i-1,19);
			cout<<" ";
			jeda_animasi();
		}
		for(i=19;i>=16;i--)
		{
			gotoxy(46,i);
			cout<<"R4";
			gotoxy(46,i+1);
			cout << "  ";
			jeda_animasi();
		}
		r_empat[4]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else if(r_empat[5] == 0) // 5
	{
		for(i=1;i<=51;i++) // ke kanan (mendatar)
		{
			gotoxy(i,19);
			cout<<"R4";
			gotoxy(i-1,19);
			cout<<" ";
			jeda_animasi();
		}
		for(i=19;i>=16;i--)
		{
			gotoxy(51,i);
			cout<<"R4";
			gotoxy(51,i+1);
			cout << "  ";
			jeda_animasi();
		}
		r_empat[5]=1;
		gotoxy(20,7);
		cout<<" ";
	}
	else
	{
		gotoxy(27,19);
		cout<<"                          ";
		Sleep(50);
		gotoxy(27,19);
		cout<<"Antrian Roda Empat penuh!";
		Sleep(100);
		gotoxy(27,19);
		cout<<"                          ";
		Sleep(400);
		gotoxy(27,19);
		cout<<"Antrian Roda Empat penuh!";
		gotoxy(20,7);
		cout<<" ";
	}
}

case_4()
{
	gotoxy(27,19);
	cout<<"                          ";

	// 0
	if(r_empat[0] == 1)
	{
		for(i=16;i<=19;i++) // ke bawah (turun)
		{
			gotoxy(26,i);
			cout<<"R2";
			if(i == 16)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(26,i-1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=26;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,19);
				cout<<"R";
			}
			else
			{
				gotoxy(i,19);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,19);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,19);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_empat[0]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 1
	else if(r_empat[1] == 1)
	{
		for(i=16;i<=19;i++) // ke bawah (turun)
		{
			gotoxy(31,i);
			cout<<"R2";
			if(i == 16)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(31,i-1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=31;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,19);
				cout<<"R";
			}
			else
			{
				gotoxy(i,19);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,19);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,19);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_empat[1]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 2
	else if(r_empat[2] == 1)
	{
		for(i=16;i<=19;i++) // ke bawah (turun)
		{
			gotoxy(36,i);
			cout<<"R2";
			if(i == 16)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(36,i-1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=36;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,19);
				cout<<"R";
			}
			else
			{
				gotoxy(i,19);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,19);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,19);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_empat[2]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 3
	else if(r_empat[3] == 1)
	{
		for(i=16;i<=19;i++) // ke bawah (turun)
		{
			gotoxy(41,i);
			cout<<"R2";
			if(i == 16)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(41,i-1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=41;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,19);
				cout<<"R";
			}
			else
			{
				gotoxy(i,19);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,19);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,19);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_empat[3]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 4
	else if(r_empat[4] == 1)
	{
		for(i=16;i<=19;i++) // ke bawah (turun)
		{
			gotoxy(46,i);
			cout<<"R2";
			if(i == 16)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(46,i-1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=46;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,19);
				cout<<"R";
			}
			else
			{
				gotoxy(i,19);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,19);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,19);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_empat[4]=0;
		gotoxy(20,7);
		cout<<" ";
	}

	// 5
	else if(r_empat[5] == 1)
	{
		for(i=16;i<=19;i++) // ke atas (naik)
		{
			gotoxy(51,i);
			cout<<"R2";
			if(i == 16)
			{
				// kosongi saja
			}
			else
			{
				gotoxy(51,i-1);
				cout <<"  ";
			}
			jeda_animasi();
		}
		for(i=51;i<=80;i++) // ke kanan (mendatar)
		{
			if(i == 80)
			{
				gotoxy(i,19);
				cout<<"R";
			}
			else
			{
				gotoxy(i,19);
				cout<<"R2";
			}
			// // //
			if(i == 80)
			{
				gotoxy(i-1,19);
				cout<<"  "; // 2 spasi
			}
			else
			{
				gotoxy(i-1,19);
				cout<<" "; // 1 spasi
			}
			jeda_animasi();
		}
		r_empat[5]=0;
		gotoxy(20,7);
		cout<<" ";
	}
	else
	{
		gotoxy(27,19);
		cout<<"                           ";
		Sleep(50);
		gotoxy(27,19);
		cout<<"Antrian Roda Empat kosong!";
		Sleep(100);
		gotoxy(27,19);
		cout<<"                           ";
		Sleep(400);
		gotoxy(27,19);
		cout<<"Antrian Roda Empat kosong!";
		gotoxy(20,7);
		cout<<" ";
	}
}

jeda_animasi()
{
	Sleep(40);
}
