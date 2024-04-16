import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        //1.Пользователь вводит 10 слов в массив. Найдите первое слово, в котором есть две гласные буквы подряд
        Scanner sc = new Scanner(System.in);
        String[] arrInput = new String[10];
        for (int i = 0; i < arrInput.length; i++) {
            arrInput[i] = sc.nextLine();
        }
        String result = "";
        char[] arrConsonant = {'а', 'у', 'о', 'ы', 'и', 'э', 'я', 'ю', 'ё', 'е'};
        for (String word : arrInput) {
            int x = 0;
            for (char c : word.toCharArray()) {
                for (char value : arrConsonant) {
                    if (c == value) {
                        if (++x == 2) {
                            result = word;
                            break;
                        }
                    }
                }
            }

        }
        System.out.println("Найдено первое слово,в котором есть две гласные буквы подряд " + result);

    }
}