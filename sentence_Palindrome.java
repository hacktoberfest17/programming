/*
     Print the palindrome words present in the sentence and its frequency.
*/


import java.util.*;
class sentence_Palindrome
{
    String str;
    void accept()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a sentence");
        str=sc.nextLine();
        str=str.toUpperCase();
    }

    boolean isPalin(String s)
    {//checks if the word is Palindrome or not
        int l=s.length();
        String rev="";
        for(int i=l-1; i>=0; i--)
        {
            rev=rev+s.charAt(i);
        }
        if(rev.equals(s))
            return true;
        else
            return false;
    }

    void main()
    {
        accept();
        char ch=str.charAt(str.length()-1);
        if(ch=='.' || ch=='!' || ch=='?')
        {            
            int freq=0;
            StringTokenizer st=new StringTokenizer(str," .!?");
            int c=st.countTokens();
            for(int i=1; i<=c; i++)
            {
                String w=st.nextToken();
                boolean r=isPalin(w); 
                if (r==true)
                {
                    System.out.print(w+" ");
                    freq++;
                }
            }
            System.out.println();
            if(freq!=0)
                System.out.println("NUMBER OF PALINDROMIC WORDS =”+ freq);
            else 
                System.out.println("NO PALINDROMIC WORDS");
        }
     }
       else
            System.out.println("INVALID INPUT");
    }
}
© 2020 GitHub, Inc.
