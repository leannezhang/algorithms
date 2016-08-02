package ArrayList;

public class spiralMatrix {
  public static void main(String[] args) {
    
    //Given a 2D array (matrix) named M, print all items of M in a spiral order, clockwise.
    // For example:

    // M  =  1   2   3   4   5
    //        6   7   8   9  10
    //       11  12  13  14  15
    //       16  17  18  19  20

    // The clockwise spiral print is:  1 2 3 4 5 10 15 20 19 18 17 16 11 6 7 8 9 14 13 12

    int row = 4;
    int col = 5;
    int v = 1;

    int[][] matrix = new int[row][col];
    
    for (int i=0; i <row; i++) {
      for (int j=0; j<col; j++) {
        matrix[i][j] = v++;
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
    

    System.out.println("Result");
    printSpiral(matrix, row, col);
    
  }
  
  public static void printSpiral(int[][] matrix, 
                                int row,
                                int col) {
    int startrow=0;
    int startcol=0;
    int endrow = row-1;
    int endcol = col-1;

    
    while (startrow <= endrow && startcol <= endcol) {
        printBox(matrix, startrow,endrow,startcol,endcol);
        startrow++;
        endrow--;
        startcol++;
        endcol--;
    }

    
  }
  
  public static void printBox(int[][] matrix,
                              int startrow,
                              int endrow,
                              int startcol,
                              int endcol) {

    // middle
    if (startrow == endcol) {
      System.out.print(matrix[startrow][endcol] + " ");
      return ;
    }
    
    //top
    for (int j=startcol; j <= endcol; j++) {
      System.out.print(matrix[startrow][j] + " ");
    }
    
    //right
    for (int i=startrow+1; i<=endrow; i++) {
      System.out.print(matrix[i][endcol] + " ");
    }
    
    //bottom
    for (int j=endcol-1; startrow != endrow && j>=startcol; j--) {
      System.out.print(matrix[endrow][j] + " ");
    }
    
    //left
    for (int i=endrow-1; startcol != endcol && i>=startrow+1; i--) {
      System.out.print(matrix[i][startcol] + " ");
    }
    
    

  }
}
