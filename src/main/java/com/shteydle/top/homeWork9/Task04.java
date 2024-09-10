package com.shteydle.top.homeWork9;

/*
На рисунке показан пример треугольника из чисел.
Написать метод:
■ выводящий значения треугольника на консоль в таком виде как на рисунке;
■ вычисляющий наибольшую сумму чисел, через которые проходит путь, начинающийся на вершине и заканчивающийся где-то на основании.
1. Каждый шаг может идти диагонально вниз-направо или диагонально вниз-налево.
2. Количество строк в треугольнике >1, но <100.
3. Числа в треугольнике все целые от 0 до 99 включительно (генерируются случайным образом).
В примере, описанном выше, это путь 7, 3, 8, 7, 5, дающий максимальную сумму 30.
Программа должна выводить на экран треугольник и путь, который даст максимальный результат. Для текущего
примера он будет такой – влево, влево, вправо, влево.
*/

import java.util.Arrays;
import java.util.Random;

public class Task04 {

    public static int[][] matrix;

    // Создание матрицы
    public static int[][] getMatrix(int size) {
        int a = size;
        int b = size * 2 - 1;
        matrix = new int[a][b];
        Random random = new Random();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                if (j != b / 2) {
                    matrix[i][j] = 0;
                } else {
                    if (i % 2 == 0) {
                        matrix[i][j] = random.nextInt(1, 10);
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }
            for (int k = 1; k <= i; k += 2) {
                if (i % 2 == 0) {
                    matrix[i][(b / 2) - k - 1] = random.nextInt(1, 10);
                    matrix[i][(b / 2) + k + 1] = random.nextInt(1, 10);
                } else {
                    matrix[i][(b / 2) - k] = random.nextInt(1, 10);
                    matrix[i][(b / 2) + k] = random.nextInt(1, 10);
                }
            }
        }
        return matrix;
    }

    // Вычисление пути
    public static void getDirection (int[][] matrix) {
        int a = 0;
        int num = matrix.length - 1;
        int[] sum = new int[matrix.length - 1];
        int result = matrix[0][matrix.length - 1];

        for (int i = 0; i < matrix.length - 1; i++) {
            boolean flag = false;
            for (int j = num; j < matrix.length * 2 - 2; j++) {
               if (j < num + 2 && j > num - 2) {
                   if (matrix[i][j] + matrix[i + 1][j - 1] > matrix[i][j] + matrix[i + 1][j + 1]) {
                       sum[a] = matrix[i + 1][j - 1];
                       flag = true;
                       num = j - 1;
                       break;
                   } else {
                       sum[a] = matrix[i + 1][j + 1];
                       flag = false;
                       num = j + 1;
                       break;
                   }
               }
               else {
                   break;
               }
            }
            result += sum[a];
            a++;
            System.out.println(flag ? "Влево" : "Вправо");
        }
        System.out.println(Arrays.toString(sum));
        System.out.println(result);
    }

    // печать матрицы
    public static void printMatrix (int[][] matrix) {
       for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix.length * 2 - 1; j++) {
               if (matrix[i][j] == 0) {
                   System.out.print(" ");
               }
               else {
                   System.out.print(matrix[i][j]);
               }
           }
           System.out.println();
       }
    }
}
