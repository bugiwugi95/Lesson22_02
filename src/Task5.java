public class Task5 {
    public static void main(String[] args) {
        //5.Выводите числа от 1 до того момента, как сумма всех цифр в числе не будет равна 20 (пример такого числа -875)
        for (int i = 1; i <= 10000; i++) {
            int x = i % 10;
            int y = i / 10;
            int sum = x + y;
            if (sum != 20) {
                System.out.println(i++);
            } else {
                System.out.println(i);
                System.out.println(x + " + " + y + "= " + sum);
                break;
            }
        }


    }
}