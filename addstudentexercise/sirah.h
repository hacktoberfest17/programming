#ifndef SIRAH_H_INCLUDED
#define SIRAH_H_INCLUDED

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define true 1
#define false 0
#define boolean unsigned char

#define IndexMin 1
#define IndexMax 200
#define Nil NULL

typedef int angka;
typedef char alfabet;
typedef struct
{
    alfabet nim[15];
    alfabet nama[25];
    alfabet prodi[30];
    angka angkatan;
    long int no_urut;
}mhs;

typedef int infotype;
typedef int address;
typedef struct
{
    mhs Info;
    address Next;
}ElmtList;

typedef struct
{
    address First;
}List;

ElmtList TabElmt[IndexMax+1];
address FirstAvail;

#define First(L) (L).First
#define Next(P) TabElmt[P].Next
#define Info(P) TabElmt[P].Info

boolean MemFull();

void InitTab();

void AllocTab(address *P);

void DeallocTab(address P);

boolean ListEmpty(List L);

void CreateList(List *L);

address SearchAddressNim(List L, mhs X);

address SearchPrec(List L, mhs X);

void InsVFirst(List *L, mhs X);

void InsVLast(List *L, mhs X);

void DelVFirst(List *L, mhs *X);

void DelVLast(List *L, mhs *X);

void InsertFirst(List *L, address P);

void InsertAfter(List *L, address P, address Prec);

void InsertLast(List *L, address P);

void DelFirst(List *L, address *P);

void DelP(List *L, mhs X);

void DelLast(List *L, address *P);

void DelAfter(List *L, address *Pdel, address Prec);

void PrintInfo(List L);

int NbElmt(List L);

void masuk_urut (List *L);

void edit (List *L, mhs *x, int pilihlagi);
void tambah_data(List *L, mhs *x);
void cekprodi (mhs *x);
int UbahAngka(char CT);
boolean carinim (List L, mhs x);
boolean carinama (List L, mhs x);
address carinamakirimaddress (List L, mhs x);
void algoritma_cari (List L, alfabet dicari[], angka pilihan);

//////////////////////

#endif // SIRAH_H_INCLUDED
