import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static final BigDecimal MathPi = new BigDecimal("3.14159265358979323846"); // doxuya decimal points
    public static final BigDecimal lessPi = new BigDecimal("3.141592653589793"); // 15 decimal points
    public static final BigDecimal stupidPi = new BigDecimal("3.14");

    public static void main(String[] args) {
        driver();
    }

    public static void driver() {
        System.out.println("Enter distance: ");  // 134 AU or 228 KM
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        while (true) {
            String userInput = scanner.nextLine();  // Read user input
            if (userInput.toLowerCase().contains("au") == true) {
                logic(auToKm(parser(userInput)));
                break;
            } else if (userInput.toLowerCase().contains("km") == true) {
                logic(parser(userInput));
                break;
            } else {
                System.out.println("*** RETYPE:");
            }
        }
    }

    public static String auToKm(String distanceWithoutLetters) {
        BigDecimal distance = new BigDecimal(distanceWithoutLetters)
                .multiply(
                        new BigDecimal("149597871")
                );  // converts AU --> KM
        String diString = String.valueOf(distance);
        return diString;
    }

    public static String parser(String text) {
        String numberOnly = text.replaceAll("[^0-9]", "");
        return numberOnly;
    } // takes only a number [0-9] from String

    public static void logic(String dist) {
        BigDecimal distanceFinalBigDecimal = new BigDecimal(dist);
        BigDecimal diam = distanceFinalBigDecimal
                .multiply(
                        new BigDecimal("2")
                );

        BigDecimal circMyPi = diam.multiply(lessPi);
        BigDecimal circ3_14 = diam.multiply(stupidPi);
        BigDecimal diff1 = circMyPi.subtract(circ3_14);

        BigDecimal circMathPi = diam.multiply(MathPi);
        BigDecimal diff2 = circMathPi.subtract(circMyPi);

        System.out.println("Разница в траектории между случаями использования lessPi и stupidPi:" + "\n" + diff1 + " km");
        System.out.println("Разница в траектории между случаями использования MathPi и lessPi:" + "\n" + diff2 + " km");

        // KM --> mm
        BigDecimal diff2_1 = diff2
                .multiply(
                        new BigDecimal("1000000")
                );

        System.out.println("Разница в траектории между случаями использования MathPi и lessPi в МИЛЛИМЕТРАХ:"
                + "\n" + diff2_1 + " mm");
    }
}