#include "sirah.h"

/** Nama = Ahmad Farhan Ghifari
    NIM = A11.2013.07396
    kelompok = A11.4301U
**/

int main()
{
    mhs x;
    address alamat;
    List L;
    InitTab();
    CreateList(&L);
    int pilih, pilihlagi, pilih3;

    do
    {
        printf("=====================================================\n");
        printf("================= Selamat Datang ====================\n");
        printf("=====================================================\n");
        printf("Daftar Kode Prodi = \n");
        printf(" - Teknik Informatika = a11 \t - Ilmu Budaya = b21\n");
        printf(" - Sistem Informasi   = a12 \t - Akuntansi   = b22 \n");
        printf(" - DKV                = a13 \t - Ekonomi     = b23\n");
        printf("=====================================================\n\n");
        printf("========= MENU =========\n");
        printf("1. Tambah Data\n");
        printf("2. Edit\n");
        printf("3. Cari\n");
        printf("4. Selesai\n");
        printf("masukkan pilihan anda = ");
        scanf("%d",&pilih);

        if (pilih==1)
        {
            tambah_data(&L,&x);
            if (carinim(L,x)==false)
            {
                if (ListEmpty(L))
                {
                    InsVFirst(&L,x);
                }
                else
                {
                    InsVFirst(&L,x);
                    masuk_urut(&L);
                }
                PrintInfo(L);
            }
            else
            {
                printf("\nNIM Sudah ada !!!\n");
            }
        }
        else if (pilih==2)
        {
            printf("Edit Cari dengan Nama atau NIM ? [1=NIM , 2=Nama]\n");
            printf("pilihan anda = ");
            scanf("%d",&pilihlagi);
            edit(&L,&x,pilihlagi);
        }
        else if (pilih==3)
        {
            printf("Cari dengan Nama atau NIM ? [1=NIM , 2=Nama]\n");
            printf("pilihan anda = ");
            scanf("%d",&pilih3);
            if (pilih3==1)
            {
                printf("Masukkan NIM yang akan dicari = ");
                scanf("%s",&x.nim);
                if (carinim(L,x)==true)
                {
                    algoritma_cari(L,x.nim,pilih3);
                }
                else
                {
                    printf("Data Tidak Ditemukan !!\n");
                }
            }
            else if (pilih3==2)
            {
                printf("Masukkan Nama yang akan dicari = ");
                fflush(stdin);
                gets(x.nama);
                if (carinama(L,x)==true)
                {
                    algoritma_cari(L,x.nama,pilih3);
                }
                else
                {
                    printf("Data Tidak Ditemukan !!\n");
                }
            }
            else
            {
                printf("\nsalah memasukkan pilihan \n");
            }
        }
        else if (pilih==4)
        {
            printf("terimakasih sudah menggunakan jasa kami\n");
            printf("Oleh : \n");
            printf("Nama     = Ahmad Farhan Ghifari\n");
            printf("NIM      = A11.2013.07396\n");
            printf("Kelompok = A11.4301U\n");
        }
        else
        {
            printf("salah input\n");
        }
        getch();
        system("cls");
    }while (pilih!=4);

    return 0;
}
