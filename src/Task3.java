public class Task3 {
    public static void main(String[] args) {
        //3.Найдите первое чётное число в массиве, которое больше 100
        int[] arr = new int[]{123,23,24,111,100,-1456,-234,900};
        for (int num : arr) {
            if (num % 2 == 0 && num > 100) {
                System.out.println("Найдите первое четное число " + num);
                break;
            }


        }


    }
}