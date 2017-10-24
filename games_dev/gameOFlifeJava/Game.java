import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.lang.*;

public class Game {

	public static void main(String[] args) {
		

		boolean[][] field;		// char[row] [column]
		
		
		field = creatField();
		toString(field);
		System.out.print("\n");
		System.out.print("__________________________________________________________________________________________\n");
		
		
		for(int i = 0; i < 100; i++){
			field = life(field);
			toString(field);
			try {
			    Thread.sleep(1000);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.print("\n");
			System.out.print("__________________________________________________________________________________________\n");
		}
		
	}

	private static boolean[][] life(boolean[][] field) {
		boolean[][] field2 = new boolean[100][100];
		
		for(int row = 1; row < (field.length-1); row++){
			
			for(int column = 1; column < (field[row].length-1); column++){
				
				field2[row][column] = decision(field, row, column);
				
			}
		}
		
		return field2;
	}

	
	private static boolean decision(boolean[][] field, int row, int column) {
		int count = 0;
		boolean life = false;
		if(field[row][column+1]) count++; //east
		if(field[row][column-1]) count++; //west
		if(field[row+1][column]) count++; //north
		if(field[row-1][column]) count++; //south
		if(field[row+1][column+1]) count++; //northeast
		if(field[row-1][column+1]) count++; //southeast
		if(field[row-1][column-1]) count++; //southwest
		if(field[row+1][column-1]) count++; //northwest
		
		switch(count){
		case 0:		life = false;
					break;
		case 1:		life = false;
					break;
		case 2:		
					break;
		case 3:		life = true;
					break;
		case 4:		life = false;
					break;
		case 5:		life = false;
					break;
		case 6:		life = false;
					break;
		case 7:		life = false;
					break;
		case 8:		life = false;
					break;
		default:		
					break;
	
	}
		
		
		return life;
	}

	private static void toString(boolean[][] field) {
		for(int row = 0; row < field.length; row++){
			
			for(int column = 0; column < field[row].length; column++){
				
				if(field[row][column]){
					System.out.print('#');
				}else{
					System.out.print(' ');
				}
			}
			System.out.print('\n');
		}
		
	}

	private static boolean[][] creatField() {
		boolean[][] field = new boolean[100][100];				
		
		
		for(int row = 0; row < field.length; row++){
			
			for(int column = 0; column < field[row].length; column++){
				
				
				Random random = new Random();
				if((random.nextBoolean())) field[row][column] = true; ;
			}
		}
		for(int row = 0; row < field.length; row++){
			field[row][0]= false;
			field[row][field[0].length-1] = false;
		}
		for(int column = 0; column < field.length; column++){
			field[0][column]= false;
			field[field.length-1][column] = false;
		}
		return field;
	}

}
