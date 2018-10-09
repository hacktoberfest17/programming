import java.util.*;
public class OEP
{
	public static void main(String[] args)
	{
		StringBuilder sb1;
		String str1,str2;
		String[] str = new String [30];
		int i =0;
		System.out.println("160410107013");
    System.out.println("Given string is : Oh my god ,there is a dog");
		StringTokenizer st = new StringTokenizer("Oh my god ,there is a dog"," ");
		int count=0;
		while(st.hasMoreTokens())
		{
			count++;
			str[i++] = st.nextToken();
		}
		Scanner scan = new Scanner(System.in);
		int j;
		for(i=0;i<=count-1;i++)
		{
			sb1 = new StringBuilder(str[i]);
			String temp = sb1.reverse().toString();
			for(j=i+1;j<count;j++)
			{
				if(temp.equalsIgnoreCase(str[j]))
				{
					System.out.println(str[i]+ " is rotation of "+str[j]);
				}
			}
		}
	}
}
