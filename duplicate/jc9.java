import java.util.*;
class jc9
{
public static void main(String args[])
{
String arr[];
int n,i,j;
Scanner obj=new Scanner(System.in);
System.out.println("Enter size of array ");
n=obj.nextInt();
arr=new String[n];
System.out.println("Enter any "+n+" String");
for(i=0;i<n;i++)
arr[i]=obj.nextLine();
for(i=0;i<n;i++)
 {
 for(j=i+1;j<n;j++)
  if(arr[i].equals(arr[j]))
    System.out.println("String array is Duplicate "+arr[i]);
 }
}
}