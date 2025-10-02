import java.util.ArrayList;
import java.util.Scanner;

public class PascalTri {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nMax = 0;

        do {
            System.out.println("Please enter a max for your triangle");
            nMax = scanner.nextInt();
        } while (nMax < 1);

        ArrayList<int[]> triangle = new ArrayList<int[]>();

        for (int row = 0; row < nMax; row++) {
            int[] line = new int[row + 1];
            int[] prevline = null;
            triangle.add(line);
            if (row != 0) {
                prevline = triangle.get(row - 1);
            }
            for (int col = 0; col <= row; col++) {
                if (col == 0 || col == row ) {
                    line[col] = 1;
                } else if (prevline != null){
                    line[col] = prevline[col - 1] + prevline[col];
                }else {
                   System.out.println("Error!");
                }
            }
        }

        for (int[] line: triangle) {
            for(int el: line) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }


}