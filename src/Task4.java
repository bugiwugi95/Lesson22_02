public class Task4 {
    public static void main(String[] args) {
        //4.Найдите последнее слово в массиве, которое написано ЗаБоРчИкОм
        // (что б узнать, заглавная ли буква, используйте Character.isUpperCase(letter) )
        String[] arrInput = {"слово", "массив", "мир", "игра", "ЗаБоРчИкОм", "HelLoO"};
        for (String s : arrInput) {
            int x = 0;
            for (char c : s.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    if (++x == 3) {
                        System.out.println(s);
                        break;
                    }

                }
            }
        }


    }
}