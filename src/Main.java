import java.math.BigDecimal;

public class Main {
    public static final BigDecimal MathPi = new BigDecimal("3.14159265358979323846"); // doxuya decimal points
    public static final BigDecimal lessPi = new BigDecimal("3.141592653589793"); // 15 decimal points
    public static final BigDecimal stupidPi = new BigDecimal("3.14");

    public static void main(String[] args) {
        test("134");  // distance in AU
    }

    public static void test(String dist) {
        BigDecimal distKm = new BigDecimal(dist)
                .multiply(
                        new BigDecimal("149597871")
                );

        BigDecimal diam = distKm
                .multiply(
                        new BigDecimal("2")
                );

        BigDecimal circMyPi = diam.multiply(lessPi);
        BigDecimal circ3_14 = diam.multiply(stupidPi);
        BigDecimal diff1 = circMyPi.subtract(circ3_14);

        BigDecimal circMathPi = diam.multiply(MathPi);
        BigDecimal diff2 = circMathPi.subtract(circMyPi);

        System.out.println("Разница в траектории между случаями использования lessPi и stupidPi это = " + diff1);
        System.out.println("Разница в траектории между случаями использования MathPi и lessPi это = " + diff2);

        // KM --> mm
        BigDecimal diff2_1 = diff2
                .multiply(
                        new BigDecimal("1000000")
                );

        System.out.println("Разница в траектории между случаями использования MathPi и lessPi в МИЛЛИМЕТРАХ это = "
                + diff2_1);
    }
}