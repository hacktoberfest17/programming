package cc;

import java.util.Scanner;

public class MinimumSwap {

	
	public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
int n = scan.nextInt();
int[] arr =new int[n+1];

for(int i=1;i<=n;++i) {
	arr[i]=scan.nextInt();
}
int i=0,temp,swaps=0;

while(i<=n) {
	if(arr[i]==i) {
		++i;
	}else {
		temp=arr[i];
		arr[i]=arr[temp];
		arr[temp]=temp;
		++swaps;
		
	}
	
}

//for(int x:arr) {
//	System.out.print(x+" ");
//}

System.out.println("swaps=" + swaps);

scan.close();

	}

}
