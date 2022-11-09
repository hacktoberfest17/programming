#include "sirah.h"

boolean MemFull()
{
    return (FirstAvail==Nil);
}

void InitTab()
{
    address P;

    for(P=IndexMin; P<IndexMax; P++)
    {
        Next(P)=P+1;
    }

    Next(IndexMax)=Nil;
    FirstAvail=IndexMin;
}

void AllocTab(address *P)
{
    if(MemFull())
    {
        (*P)=Nil;
        printf("Tidak tersedia memori siap pakai.\n");
    }
    else
    {
        (*P)=FirstAvail;
        FirstAvail=Next(FirstAvail);
    }
}

void DeallocTab(address P)
{
    Next(P)=FirstAvail;
    FirstAvail=(P);
}

boolean ListEmpty(List L)
{
    return (First(L)==Nil);
}

void CreateList(List *L)
{
    First(*L)=Nil;
}

address SearchAddressNim (List L, mhs X)
{
    int j,k,m;
    char temp[25];
    address P=First(L);
    while(P!=Nil)
    {
        for (j=0;j<strlen(TabElmt[P].Info.nim);j++)
        {
            for (m=0,k=j;m<strlen(X.nim),k<strlen(X.nim)+j;m++,k++)
            {
                temp[m]=(TabElmt[P].Info.nim[k]);
            }
            temp[strlen(X.nim)]='\0';
            if (strcmp(temp,X.nim)==0)
            {
                goto ending;
            }
        }
        P=Next(P);
    }
    ending:
    return P;
}

address SearchPrec(List L, mhs X)
{
    address P,Prec;

    P=SearchAddressNim(L,X);
    Prec=First(L);
    while(Next(Prec)!=Nil && Next(Prec)!=P)
    {
        Prec=Next(Prec);
    }

    if(Next(Prec)==P)
    {
        return Prec;
    }
    else
    {
        return Nil;
    }
}

void InsVFirst(List *L, mhs X)
{
    address P;

    AllocTab(&P);
    if(P!=Nil)
    {
        Info(P)=X;
        InsertFirst(&(*L),P);
    }
}

void InsVLast(List *L, mhs X)
{
    address P;

    AllocTab(&P);
    if(P!=Nil)
    {
        Info(P)=X;
        InsertLast(&(*L),P);
    }
}

void DelVFirst(List *L, mhs *X)
{
    address P;

    DelFirst(&(*L),&P);
    (*X)=Info(P);
    Next(P)=Nil;
    DeallocTab(P);
}

void DelVLast(List *L, mhs *X)
{
    address P;

    DelLast(&(*L),&P);
    (*X)=Info(P);
    DeallocTab(P);
}

void InsertFirst(List *L, address P)
{
    if(ListEmpty(*L))
    {
        Next(P)=Nil;
        First(*L)=P;
    }
    else
    {
        Next(P)=First(*L);
        First(*L)=P;
    }
}

void InsertAfter(List *L, address P, address Prec)
{
    Next(P)=Next(Prec);
    Next(Prec)=P;
}

void InsertLast(List *L, address P)
{
    address Last;

    if(ListEmpty(*L))
    {
        InsertFirst(&(*L),P);
    }
    else
    {
        Last=First(*L);
        while(Next(Last)!=Nil)
        {
            Last=Next(Last);
        }
        InsertAfter(&(*L),P,Last);
     }
}

void DelFirst(List *L, address *P)
{
    (*P)=First(*L);
    First(*L)=Next(First(*L));
    Next(*P)=Nil;
}

void DelP(List *L, mhs X)
{
    address P,Pp;

    P=SearchAddressNim(*L,X);
    if(P!=Nil)
    {
        if(P==First(*L))
        {
            DelFirst(&(*L),&Pp);
        }
        else
        {
            P=SearchPrec(*L,X);
            DelAfter(&(*L),&Pp,P);
        }
        DeallocTab(Pp);
    }
}

void DelLast(List *L, address *P)
{
    address Last,PrecLast;

    PrecLast=Nil;
    Last=First(*L);
    while(Next(Last)!=Nil)
    {
        PrecLast=Last;
        Last=Next(Last);
    }

    (*P)=Last;
    if(Last==First(*L))
    {
        First(*L)=Nil;
    }
    else
    {
        Next(PrecLast)=Nil;
    }
}

void DelAfter(List *L, address *Pdel, address Prec)
{
    (*Pdel)=Next(Prec);
    Next(Prec)=Next(Next(Prec));
    Next(*Pdel)=Nil;
}

void PrintInfo(List L)
{
    int i;
    if(ListEmpty(L))
    {
        printf("List kosong");
    }
    else
    {
        for (i=1;i<=NbElmt(L);i++)
        {
            printf("\n============================\n");
            printf("NIM = %s\n",TabElmt[i].Info.nim);
            printf("Nama = %s\n",TabElmt[i].Info.nama);
            printf("Prodi = %s\n",TabElmt[i].Info.prodi);
            printf("Angkatan = %d\n",TabElmt[i].Info.angkatan);
            printf("No urut = %ld\n",TabElmt[i].Info.no_urut);
            printf("============================\n");
        }
    }
}

int NbElmt(List L)
{
    int hit=0;
    address P=First(L);

    while(P!=Nil)
    {
        hit++;
        P=Next(P);
    }
    return hit;
}

void tambah_data(List *L, mhs *x)
{
    char a,b,c,d,e,transit[14],i;
    long int jum;
    ulang:
    printf("Masukkan NIM = ");
    scanf("%s",&(*x).nim);
    printf("Masukkan Nama = ");
    fflush(stdin);
    gets((*x).nama);
    cekprodi(&(*x).nim);
    if (strcmp((*x).prodi,"salah")==0)
    {
        printf("Salah memasukkan NIM. Ulang!!\n\n");
        goto ulang;
    }
    else
    {
        printf("Prodi = %s\n",(*x).prodi);
    }
    /**ngecek angkatan**/
    a=UbahAngka((*x).nim[4]);
    b=UbahAngka((*x).nim[5]);
    c=UbahAngka((*x).nim[6]);
    d=UbahAngka((*x).nim[7]);
    jum=(a*1000)+(b*100)+(c*10)+d;
    (*x).angkatan=jum;
    printf("Angkatan = %ld\n",jum);
    /**ngecek no urut**/
    a=UbahAngka((*x).nim[9]);
    b=UbahAngka((*x).nim[10]);
    c=UbahAngka((*x).nim[11]);
    d=UbahAngka((*x).nim[12]);
    e=UbahAngka((*x).nim[13]);
    jum=(a*10000)+(b*1000)+(c*100)+(d*10)+e;
    (*x).no_urut=jum;
    printf("Nomor Urut = %ld",jum);
    printf("\n");
}

void cekprodi (mhs *x)
{
    char a,b,c;
    a=(*x).nim[0];
    b=(*x).nim[1];
    c=(*x).nim[2];

    if ((a=='a' || a=='A') && b=='1' && c=='1')
    {
        strcpy((*x).prodi,"Teknik Informatika");
    }
    else if ((a=='a' || a=='A') && b=='1' && c=='2')
    {
        strcpy((*x).prodi,"Sistem Informasi");
    }
    else if ((a=='a' || a=='A') && b=='1' && c=='3')
    {
        strcpy((*x).prodi,"DKV");
    }
    else if ((a=='b' || a=='B') && b=='2' && c=='1')
    {
        strcpy((*x).prodi,"Ilmu Budaya");
    }
    else if ((a=='b' || a=='B') && b=='2' && c=='2')
    {
        strcpy((*x).prodi,"Akuntansi");
    }
    else if ((a=='b' || a=='B') && b=='2' && c=='3')
    {
        strcpy((*x).prodi,"Ekonomi");
    }
    else
    {
        strcpy((*x).prodi,"salah");
    }
}

int UbahAngka(char CT)
{
    if(CT=='1')
        return 1;
    else if(CT=='2')
        return 2;
    else if(CT=='3')
        return 3;
    else if(CT=='4')
        return 4;
    else if(CT=='5')
        return 5;
    else if(CT=='6')
        return 6;
    else if(CT=='7')
        return 7;
    else if(CT=='8')
        return 8;
    else if(CT=='9')
        return 9;
    else if(CT=='0')
        return 0;
}

void masuk_urut (List *L)
{
    int i,j,makstail;
    int a,b,c,d,e,f,g,h;
    long int k,m;
    mhs temp;
    makstail=NbElmt(*L);
    /** Pengurutan lewat kode prodi Tahun dan No urut */
    for (i=1;i<makstail;i++)
    {
        a=UbahAngka(TabElmt[i].Info.nim[1]);
        b=UbahAngka(TabElmt[i].Info.nim[2]);
        c=UbahAngka(TabElmt[i].Info.nim[6]);
        d=UbahAngka(TabElmt[i].Info.nim[7]);
        e=UbahAngka(TabElmt[i].Info.nim[10]);
        f=UbahAngka(TabElmt[i].Info.nim[11]);
        g=UbahAngka(TabElmt[i].Info.nim[12]);
        h=UbahAngka(TabElmt[i].Info.nim[13]);
        k=(a*10000000)+(b*1000000)+(c*100000)+(d*10000)+(e*1000)+(f*100)+(g*10)+h;
        for (j=i;j<=makstail;j++)
        {
            a=UbahAngka(TabElmt[j].Info.nim[1]);
            b=UbahAngka(TabElmt[j].Info.nim[2]);
            c=UbahAngka(TabElmt[j].Info.nim[6]);
            d=UbahAngka(TabElmt[j].Info.nim[7]);
            e=UbahAngka(TabElmt[j].Info.nim[10]);
            f=UbahAngka(TabElmt[j].Info.nim[11]);
            g=UbahAngka(TabElmt[j].Info.nim[12]);
            h=UbahAngka(TabElmt[j].Info.nim[13]);
            m=(a*10000000)+(b*1000000)+(c*100000)+(d*10000)+(e*1000)+(f*100)+(g*10)+h;
            if (k>m)
            {
                temp=TabElmt[i].Info;
                TabElmt[i].Info=TabElmt[j].Info;
                TabElmt[j].Info=temp;
            }
        }
    }

}

boolean carinim (List L, mhs x)
{
    int j,k,m;
    char temp[25];
    boolean ketemu=false;
    address P=First(L);
    while(P!=Nil)
    {
        for (j=0;j<strlen(TabElmt[P].Info.nim);j++)
        {
            for (m=0,k=j;m<strlen(x.nim),k<strlen(x.nim)+j;m++,k++)
            {
                temp[m]=(TabElmt[P].Info.nim[k]);
            }
            temp[strlen(x.nim)]='\0';
            if (strcmp(temp,x.nim)==0)
            {
                ketemu=true;
            }
        }
        P=Next(P);
    }
    return ketemu;
}

boolean carinama (List L, mhs x)
{
    int j,k,m;
    char temp[25];
    boolean ketemu=false;
    address P=First(L);
    while(P!=Nil)
    {
        for (j=0;j<strlen(TabElmt[P].Info.nama);j++)
        {
            for (m=0,k=j;m<strlen(x.nama),k<strlen(x.nama)+j;m++,k++)
            {
                temp[m]=(TabElmt[P].Info.nama[k]);
            }
            temp[strlen(x.nama)]='\0';
            if (strcmp(temp,x.nama)==0)
            {
                ketemu=true;
            }
        }
        P=Next(P);
    }
    return ketemu;
}

address carinamakirimaddress (List L, mhs x)
{
    int j,k,m;
    char temp[25];
    address P=First(L);
    while(P!=Nil)
    {
        for (j=0;j<strlen(TabElmt[P].Info.nama);j++)
        {
            for (m=0,k=j;m<strlen(x.nama),k<strlen(x.nama)+j;m++,k++)
            {
                temp[m]=(TabElmt[P].Info.nama[k]);
            }
            temp[strlen(x.nama)]='\0';
            if (strcmp(temp,x.nama)==0)
            {
                goto endings;
            }
        }
        P=Next(P);
    }
    endings:
    return P;
}

void edit (List *L, mhs *x, int pilihlagi)
{
    address P,addressnim;
    int angkatanbaru;
    char nimbaru[14], namabaru[25], prodibaru[30];
    long int no_urutbaru;
    if (pilihlagi==1)
    {
        printf("Masukkan NIM yang akan di edit = ");
        scanf("%s",&(*x).nim);
        if (carinim(*L,*x)==true)
        {
            addressnim=SearchAddressNim(*L,*x);
            printf("Data Ketemu !!\n\n");

            printf("Masukkan NIM yang baru \n");
            printf("NIM = ");
            scanf("%s",&nimbaru);
            /**penyalinan Data**/
            strcpy(namabaru,TabElmt[addressnim].Info.nama);
            strcpy(prodibaru,TabElmt[addressnim].Info.prodi);
            angkatanbaru=TabElmt[addressnim].Info.angkatan;
            no_urutbaru=TabElmt[addressnim].Info.no_urut;
            /** end of penyalinan data**/
            DelP(&(*L),*x); /* Delete Data Di List */
            /**Inisialisasi data baru dengan NIM yang berbeda*/
            strcpy((*x).nim,nimbaru);
            strcpy((*x).nama,namabaru);
            strcpy((*x).prodi,prodibaru);
            (*x).angkatan=angkatanbaru;
            (*x).no_urut=no_urutbaru;
            /**end of inisialisasi*/

            if (carinim(*L,*x)==false)
            {
                if (ListEmpty(*L))
                {
                    InsVFirst(&(*L),*x);
                }
                else
                {
                    InsVFirst(&(*L),*x);
                    masuk_urut(&(*L));
                }
                PrintInfo(*L);
            }
            else
            {
                printf("\nNIM Sudah ada !!!\n");
            }
        }
        else
        {
            printf("NIM Tidak Ada !!\n");
        }
    }
    else if (pilihlagi==2)
    {
        printf("Masukkan Nama yang akan di edit = ");
        fflush(stdin);
        gets((*x).nama);
        if (carinama(*L,*x)==true)
        {
            printf("Data Ketemu !!\n\n");
            P=carinamakirimaddress(*L,*x);
            *x=TabElmt[P].Info;
            printf("Masukkan Nama yang baru = ");
            fflush(stdin);
            gets(namabaru);
            /**penyalinan Data**/
            strcpy(nimbaru,(*x).nim);
            strcpy(prodibaru,(*x).prodi);
            angkatanbaru=(*x).angkatan;
            no_urutbaru=(*x).no_urut;
            /** end of penyalinan data**/
            DelP(&(*L),*x); /* Delete Data Di List */
            /**Inisialisasi data baru dengan NIM yang berbeda*/
            strcpy((*x).nim,nimbaru);
            strcpy((*x).nama,namabaru);
            strcpy((*x).prodi,prodibaru);
            (*x).angkatan=angkatanbaru;
            (*x).no_urut=no_urutbaru;
            /**end of inisialisasi*/

            if (carinama(*L,*x)==false)
            {
                if (ListEmpty(*L))
                {
                    InsVFirst(&(*L),*x);
                }
                else
                {
                    InsVFirst(&(*L),*x);
                    masuk_urut(&(*L));
                }
                PrintInfo(*L);
            }
            else
            {
                printf("\nNIM Sudah ada !!!\n");
            }
        }
        else
        {
            printf("Nama Tidak Ditemukan !!\n");
        }
    }
    else
    {
        printf("\nsalah memasukkan pilihan \n");
    }
}

void algoritma_cari (List L, alfabet dicari[], angka pilihan)
{
    int i, j, k, m;
    char temp[25];
    if (pilihan==1)
    {
    for (i=0;i<=NbElmt(L);i++)
    {
        for (j=0;j<strlen(TabElmt[i].Info.nim);j++)
        {
            for (m=0,k=j;m<strlen(dicari),k<strlen(dicari)+j;m++,k++)
            {
                temp[m]=(TabElmt[i].Info.nim[k]);
            }
            temp[strlen(dicari)]='\0';
            if (strcmp(temp,dicari)==0)
            {
                printf("\n 1.) NIM = %.14s\n",TabElmt[i].Info.nim);
                printf(" 2.) Nama = %s\n",TabElmt[i].Info.nama);
                printf(" 3.) Prodi = %s\n",TabElmt[i].Info.prodi);
                printf(" 4.) Angkatan = %d\n",TabElmt[i].Info.angkatan);
                printf(" 5.) No_Urut = %ld\n\n",TabElmt[i].Info.no_urut);
            }
        }
    }
    }
    else if (pilihan==2)
    {
        for (i=0;i<=NbElmt(L);i++)
    {
        for (j=0;j<strlen(TabElmt[i].Info.nama);j++)
        {
            for (m=0,k=j;m<strlen(dicari),k<strlen(dicari)+j;m++,k++)
            {
                temp[m]=(TabElmt[i].Info.nama[k]);
            }
            temp[strlen(dicari)]='\0';
            if (strcmp(temp,dicari)==0)
            {
                printf("\n 1.) NIM = %.14s\n",TabElmt[i].Info.nim);
                printf(" 2.) Nama = %s\n",TabElmt[i].Info.nama);
                printf(" 3.) Prodi = %s\n",TabElmt[i].Info.prodi);
                printf(" 4.) Angkatan = %d\n",TabElmt[i].Info.angkatan);
                printf(" 5.) No_Urut = %ld\n\n",TabElmt[i].Info.no_urut);
            }
        }
    }
    }
}




