import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Įveskite šešiaženklį loterijos bilieto numerį:");
        int number = Integer.parseInt(System.console().readLine());


        if (arLaimingas(number)) {
            System.out.println("Jūsų bilietas yra laimingas!");
        } else {
            System.out.println("Jūsų bilietas nėra laimingas.");


            int kiek = 0;
            int luckyNumber;
            do {
                luckyNumber = generavimas();
                System.out.println( luckyNumber);
                kiek++;
            } while (!arLaimingas(luckyNumber));


            rezultatas(kiek, luckyNumber);
        }
    }


    static boolean arLaimingas(int number) {
        int[] arr = new int[6];


        for (int i = 5; i >= 0; i--) {
            arr[i] = number % 10;
            number /= 10;
        }


        if (!arSkaitmenysUnikalus(arr)) {
            return false;
        }


        int pirmuSuma = arr[0] + arr[1] + arr[2];
        int paskutiniuSuma = arr[3] + arr[4] + arr[5];
        return pirmuSuma == paskutiniuSuma;
    }


    static boolean arSkaitmenysUnikalus(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int skaitmuo : arr) {
            if (set.contains(skaitmuo)) {
                return false;
            }
            set.add(skaitmuo);
        }
        return true;
    }


    static int generavimas() {
        return (int) (Math.random() * 900000 + 100000); 


    static void rezultatas(int kiek, int number) {
        System.out.println("Laimingas bilietas: " + number);
        System.out.println("Bendras bandymų skaičius: " + kiek);
    }
}
