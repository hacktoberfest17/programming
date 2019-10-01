import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
		int N=s.nextInt();
		int[] arr=new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=s.nextInt();
		}
		for(int i=0;i<N;i++)
		{int sumeven=0;
		 int sumodd=0;
			while(arr[i]!=0) {
				int r=arr[i]%10;
				arr[i]=arr[i]/10;	
			   if(r%2==0) {
				    sumeven=sumeven+r;
			   }else {
				   sumodd=sumodd+r;			   }
			
			}
			if(sumeven%4==0 || sumodd%3==0) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
			
		}


    }
}
