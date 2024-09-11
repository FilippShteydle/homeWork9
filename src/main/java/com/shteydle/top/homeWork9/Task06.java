package com.shteydle.top.homeWork9;

/*Напишите метод, проверяющую правильность расстановки скобок в строке, введенной с клавиатуры. При правильной расстановке выполняются условия:
■ количество открывающих и закрывающих скобок равно;
■ внутри любой пары открывающая–соответствующая закрывающая скобка, скобки расставлены правильно.
В строке могут присутствовать как круглые, так и квадратные скобки (и др. символы). Каждой открывающей
скобке соответствует закрывающая того же типа (круглой – круглая, квадратной – квадратная).*/

import java.util.ArrayList;
import java.util.Arrays;

public class Task06 {

    public static String controlBracket(String string) {

        boolean flag = true;
        char[] arr = string.toCharArray();
        int brack = 0;
        String bracket = "";
        ArrayList<String> arrBracket = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == ')' || arr[i] == '[' || arr[i] == ']') {
                arrBracket.add(String.valueOf(arr[i]));
                count++;
            }
        }
        String[] arr2 = new String[count];
        for (int i = 0; i < arrBracket.size(); i++) {
            arr2[i] = arrBracket.get(i);
        }
        for (int i = 0, j = 0; i < arr2.length / 2; i++, j++) {
            if (arr2[i].equals("(") && arr2[i + 1].equals(")") || arr2[i].equals("[") && arr2[i + 1].equals("]")) {
                i++;
                j--;
                flag = true;
            } else if (arr2[arr2.length - 1 - j].equals(")") && arr2[arr2.length - 2 - j].equals("(") || arr2[arr2.length - 1 - j].equals("]") && arr2[arr2.length - 2 - j].equals("[")) {
                i--;
                j++;
                flag = true;

            } else if (arr2[i].equals("(") && arr2[arr2.length - 1 - j].equals(")") || arr2[i].equals("[") && arr2[arr2.length - 1 - j].equals("]")){
                flag = true;
            } else if (arr2[i].equals("(") && arr2[arr2.length - 1 - j].equals("]") || arr2[i].equals("[") && arr2[arr2.length - 1 - j].equals(")")) {
                if (arr2[i].equals("(")) {
                    flag = false;
                    brack = 2;
                    break;
                } else if (arr2[i].equals("[")) {
                    flag = false;
                    brack = 1;
                    break;
                }
            } else if (arr2.equals("]") || arr2[i].equals(")")) {
                if (arr2[i].equals("]")) {
                    flag = false;
                    brack = 3;
                    break;
                } else {
                    flag = false;
                    brack = 4;
                    break;
                }
            }
            if (!flag) {
                break;
            }
        }
        if (brack == 1) bracket = "]";
        if (brack == 2) bracket = ")";
        if (brack == 3) bracket = "[";
        if (brack == 4) bracket = "(";
        return flag ? "Правильная строка" : "Ошибка, отсутствие " + bracket;
    }
}
