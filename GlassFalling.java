/**
 * Glass Falling
 * Zihao Shao
 */
public class GlassFalling {

  // Do not change the parameters!
  public int glassFallingRecur(int floors, int sheets) {
    // Fill in here and change the return
	  if(sheets==1) {
        return floors;
      }

      // if the floors are 1 or 0, then there can only be 1 or 0 trials
      if(floors==0 || floors==1) {
        return floors;
      }

      //set min variable to max_value in order to find proper minimum
      int minimum = Integer.MAX_VALUE;
      int result;

      //there can only be 2 possibilties, either the glass breaks and you have to
      //check the floors below the current floor with one less sheet or it doesn't break
      //and we have to check the floors above
      for(int i=1; i<=floors; i++) {
        result = Math.max((glassFallingRecur(i-1,sheets-1)),(glassFallingRecur(floors-i,sheets)));
        minimum = Math.min(result,minimum);
      }
      //add 1 to the final result because we must include the current floor
      return minimum+1;
  }

  // Optional:
  // Pick whatever parameters you want to, just make sure to return an int.
  public int glassFallingMemoized() {
    // Fill in here and change the return
    return 0;
  }

  // Do not change the parameters!
  public int glassFallingBottomUp(int floors, int sheets) {
	  int sheetFloorDrop[][] = new int [floors+1][sheets+1];
	  int results;
	  for(int i = 1; i <= sheets; i++) {
		  sheetFloorDrop[i][1] = 1;
		  sheetFloorDrop[i][0] = 0;
		  //store 0 for when floor is 0 and 1 when floor is 1
	  }

	  for(int j = 1;j <= floors; j++) {
		  sheetFloorDrop[j][1] = j;
		  //stores the highest floor when we only have 1 sheet because thats the worst case
	  }

	  for(int i = 2; i<= sheets; i++) {
		  for(int j = 2; j <= floors; j++) {
			  sheetFloorDrop[j][i] = Integer.MAX_VALUE;
			  for(int h = 2; h <= j; h++) {
				  results = 1 + Math.max(sheetFloorDrop[h-1][i-1], sheetFloorDrop[j-h][i]);
				  //iterate through each array index using the previous computed indexes to calculate the current floor and sheet count
				  if(results < sheetFloorDrop[j][i]) {
					  sheetFloorDrop[j][i] = results;
				  }
			  }
		  }
	  }
    return sheetFloorDrop[floors][sheets];
  }


  public static void main(String args[]){
      GlassFalling gf = new GlassFalling();

      // Do not touch the below lines of code, and make sure
      // in your final turned-in copy, these are the only things printed
      int minTrials1Recur = gf.glassFallingRecur(27, 2);
      int minTrials1Bottom = gf.glassFallingBottomUp(27, 2);
      int minTrials2Recur = gf.glassFallingRecur(100, 3);
      int minTrials2Bottom = gf.glassFallingBottomUp(100, 3);
      System.out.println(minTrials1Recur + " " + minTrials1Bottom);
      System.out.println(minTrials2Recur + " " + minTrials2Bottom);
  }
}

