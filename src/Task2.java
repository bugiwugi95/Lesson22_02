import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        //2.Пользователь вводит массив чисел. Найдите первое четное число
        Scanner sc = new Scanner(System.in);
        int[] arrInput = new int[10];
        for (int i = 0; i < arrInput.length; i++) {
            arrInput[i] = sc.nextInt();
            int num = arrInput[i];
            if (num % 2 == 0) {
                System.out.println("Найдите первое четное число " + num);
                break;
            }


        }


    }
}