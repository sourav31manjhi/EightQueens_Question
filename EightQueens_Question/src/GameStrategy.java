public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// WRITE YOUR LOGIC HERE...................................		
		int column = cellId%8;
		System.out.println("The cell id is :"+cellId);
		System.out.println("The column is"+column);
		return column;	// just for the heck of it
	}
	
	private int getRow(int cellId) {
		// WRITE YOUR LOGIC HERE....................................
		int row = (cellId/8);
		System.out.println("The row is"+row);
		return row;	// just for the heck of it
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		// for checking rows and columns
		for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(placedQueens[i][j]==true)
                {
                    if(col==j||row==i)
                    {
//                        System.out.println("Already present");
                        isValid=false;
                    }
                }
            }
        }
		//for checking diagonal
		if(isValid==true) {
			for(int p=0;p<8;p++){
		        for(int q=0;q<8;q++){
		        	
		            if((placedQueens[p][q] == true ) && ((p+q == row+col) || (p-q == row-col))){
		                isValid = false;
		            }
		        }
		    }
		}
		
		
			//WRITE YOUR LOGIC HERE...............................
		 if(isValid==true)
	        {
	            numQueens++;
	            placedQueens[row][col]=true;
	        }
	     return isValid;
	}
}














