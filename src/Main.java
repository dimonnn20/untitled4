import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
      int [] [] matrix = {{0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 0},
        {1, 1, 1, 1, 1},
        {0, 0, 0, 1, 0},
    };



        System.out.println("Матрица перед методом");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j<matrix[i].length; j++) {
                System.out.print(matrix [i][j]);
            }
            System.out.println();}


        matrix = removeFullLines(matrix);

        System.out.println("Матрица после метода");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j<matrix[i].length; j++) {
                System.out.print(matrix [i][j]);
            }
            System.out.println();}


    }

    public static int [][] removeFullLines(int [] [] matrix) {
        int height =matrix.length;
        int width = matrix[0].length;

        List<Integer> list = new ArrayList<>();
        int numberOfFull = 0;
        List <Integer> tempList;
        for (int i = 0; i < height; i++) {
             tempList= new ArrayList<>();
            int count = 0;
            for (int j = 0; j < width; j++) {
                Integer temp = matrix[i][j];
                if (temp == 1) {count++;}
                tempList.add(temp);
            }
            if (count != width) {
                list.addAll(tempList);
            } else {numberOfFull++;}

        }
        for (int i = 0; i < numberOfFull*width; i++) {
            list.add(i,0);
        }

        for (int i = 0; i<height; i++) {
            for (int j = 0; j< width; j++) {
                matrix[i][j] = list.get(i*width+j);
            }
        }
        System.out.println("Лист значений перед матрицей");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        return matrix;
    }
}