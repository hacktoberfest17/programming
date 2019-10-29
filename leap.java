class Test 
{ 
    static boolean checkYear(int y) 
    { 
        
        if (y % 400 == 0) 
            return true; 
      
       
        if (y % 100 == 0) 
            return false; 
      
        
        if (y % 4 == 0) 
            return true; 
        return false; 
    } 
          
    public static void main(String[] args)  
    { 
        int y = 2000; 
        System.out.println( checkYear(2000)? "Leap Year" : 
                           "Not a Leap Year" ); 
    } 
} 
