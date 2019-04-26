import java.io.IOException;
import java.util.ArrayList;

public class Loader {
    public static void main(String[] args) throws IOException {
        ArrayList<String> meshok = new ArrayList<>();
        for (int i = 0; i < 22; i++) {
            meshok.add("WHITE");
        }
        for (int i = 0; i < 25; i++) {
            meshok.add("BLACK");
        }

        while (meshok.size() > 1) {
            int a = 0; // Начальное значение диапазона - "от"
            int b = meshok.size() - 1; // Конечное значение диапазона - "до"
            System.out.println("ПРОМЕЖУТОК - " + a + " " + b);
            int random_number1 = a + (int) (Math.random() * b); // Генерация 1-го числа
            int random_number2 = a + (int) (Math.random() * b); // Генерация 2-го числа

            if (meshok.size()>2) {
                while (random_number1==random_number2) {
                    random_number2 = a + (int) (Math.random() * b); // Генерация 2-го числа
                }
            } else {
                random_number1 = 0;
                random_number2 = 1;
            }

            String newStr = "";
            System.out.println("В мешке " + meshok.size() + " - " + meshok);
            if (meshok.get(random_number1).contains("BLACK") && meshok.get(random_number2).contains("BLACK")) {
                newStr = "BLACK";
                System.out.println("Достали обе черные. (" + random_number1 + " & " + random_number2 + "). ДОбавляем черную.  ");
            } else if (meshok.get(random_number1).contains("WHITE") && meshok.get(random_number2).contains("WHITE")) {
                newStr = "BLACK";
                System.out.println("Достали обе белые. (" + random_number1 + " & " + random_number2 + "). ДОбавляем черную.  ");
            } else if (meshok.get(random_number1).contains("BLACK") && meshok.get(random_number2).contains("WHITE")) {
                newStr = "WHITE";
                System.out.println("Достали черную " + "(" + random_number1 + ") и белую (" + random_number2 + "). ДОбавляем белую.  ");
            } else if (meshok.get(random_number1).contains("WHITE") && meshok.get(random_number2).contains("BLACK")) {
                newStr = "WHITE";
                System.out.println("Достали белую " + "(" + random_number1 + ") и черную (" + random_number2 + "). ДОбавляем белую.");
            }
            meshok.remove(random_number1);
            if (meshok.size() > 2) {
                meshok.remove(random_number2);
            } else {
                meshok.remove(0);
            }
            meshok.add(newStr);

        }
        System.out.println("В ИТОГЕ ОСТАЕТСЯ " + meshok);
    }
}
