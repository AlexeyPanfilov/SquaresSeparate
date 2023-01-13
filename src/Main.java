import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {

        int width = 604_000_000;
        int length = 1_066_800_100;
        Instant start = Instant.now();
        for (int i = width; i > 1; i--) {
            if ((width % i == 0) && (length % i == 0)) {
                System.out.println("сторона квадрата пошаговым способом = " + i);
                break;
            }
        }
        Instant finish = Instant.now();
        long elapsed = Duration.between(start, finish).toMillis();
        System.out.println("Время выполнения пошагово: " + elapsed);

        int newWidth = width;
        //Instant start2 = Instant.now();
        while (true) {
            if ((length % newWidth == 0)) {
                System.out.println("Сторона квадрата 2 способ = " + newWidth);
                break;
            }
            newWidth = length % width;
            length = width;
            width = newWidth;
        }
        Instant finish2 = Instant.now();
        long elapsedTotal = Duration.between(start, finish2).toMillis();
        System.out.println("общее время выполнения программы: " + elapsedTotal);
        System.out.println("Сторона квадрата рекурсивным методом: " + recursiveSquare(length, width));
        Instant finish3 = Instant.now();
        long elapsedRecursive = Duration.between(start, finish3).toMillis();
        System.out.println("Общее время выполнения программы: " + elapsedRecursive);
    }

    static int recursiveSquare (int length, int width) {
        int newWidht;
        if (length % width == 0) {
            return width;
        } else {
            newWidht = length % width;
            width = newWidht;
            return recursiveSquare(width, newWidht);
        }
    }
}