package cc;

 class s {

	public static void main(String[] args) {

		

		int count = 1;
		long n1 = 0, n2 = 1, n3=0;
		
			while (n3 <1000000007 ) {

				n3 = n1 + n2;
				n1 = n2;
				n2 = n3;

				++count;
			}
			System.out.println(count);	
			
	}

}
