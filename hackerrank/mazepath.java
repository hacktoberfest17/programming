package cc;

public class mazepath {

	
	public static int path(int cc,int cr,int ec,int er,int[][] arr){
		if(cc>ec||cr>er){
			return 0;
		}
		if(cc==ec&&cr==er)
			return 1;
		if(arr[cr][cc]!=0)
			return arr[cr][cc];
		
		int ch=path(cc+1, cr, ec, er, arr);
		int cv=path(cc, cr+1, ec, er, arr);
		int count=ch+cv;
		arr[cr][cc]=count;	
		return count;
	}
	public static void main(String[] args) {
		int ec=16,er=16;
		int[][] arr=new int[er+1][er+1];
		System.out.println(path(0, 0, ec, er, arr));
	}

}
