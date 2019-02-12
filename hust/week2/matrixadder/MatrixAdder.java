import java.util.Scanner;

class MatrixAdder {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Get row and col
    System.out.print("Enter number of row: ");
    int row = input.nextInt();

    System.out.print("Enter number of column: ");
    int col = input.nextInt();

    // Create matrix based on row and col
    int matrix1[][] = new int[row][col];
    int matrix2[][] = new int[row][col];
    int result[][] = new int[row][col];

    int i, j;

    // Input matrix 1
    System.out.println("Matrix 1:");
    for (i = 0; i < row; i++) {
      System.out.print("- Row " + (i + 1) + ": ");
      for (j = 0; j < col; j++) {
        matrix1[i][j] = input.nextInt();
      }
    }

    // Input matrix 2 and calculate result matrix
    System.out.println("\nMatrix 2:");
    for (i = 0; i < row; i++) {
      System.out.print("- Row " + (i + 1) + ": ");
      for (j = 0; j < col; j++) {
        matrix2[i][j] = input.nextInt();
        result[i][j] = matrix1[i][j] + matrix2[i][j];
      }
    }

    // Print result
    System.out.println("\nResult:");
    for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++) {
        System.out.print(result[i][j] + "\t");
      }
      System.out.print("\n");
    }
  }
}
