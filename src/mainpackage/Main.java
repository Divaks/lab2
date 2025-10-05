package mainpackage;

import carpackage.Car;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car[] cars = createCarsArray();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Програма для пошуку автомобілів (з валідацією) ---");

        String modelA = getValidatedStringInput(scanner, "\na) Введіть модель автомобіля для пошуку: ");
        System.out.println("Список автомобілів моделі " + modelA + ":");
        printCarsByModel(cars, modelA);

        String modelB = getValidatedStringInput(scanner, "\nb) Введіть модель автомобіля для пошуку за роками експлуатації: ");
        int yearsB = getValidatedIntInput(scanner, "Введіть мінімальну кількість років експлуатації (ціле число): ");

        System.out.println("Список автомобілів моделі " + modelB + ", які експлуатуються більше " + yearsB + " років:");
        printCarsByModelAndAge(cars, modelB, yearsB);

        int yearC = getValidatedIntInput(scanner, "\nc) Введіть рік випуску автомобілів для пошуку (ціле число): ");
        double minPriceC = getValidatedDoubleInput(scanner, "Введіть мінімальну ціну (число, можна з копійками): ");

        System.out.println("Список автомобілів " + yearC + " року випуску з ціною понад " + minPriceC + ":");
        printCarsByYearAndPrice(cars, yearC, minPriceC);

        scanner.close();
    }

    private static String getValidatedStringInput(Scanner scanner, String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Помилка: Модель не може бути порожньою. Спробуйте ще раз.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static int getValidatedIntInput(Scanner scanner, String prompt) {
        int value = -1;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();

                if (value < 0) {
                    System.out.println("Помилка: Число не може бути від'ємним. Спробуйте ще раз.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Помилка: Невірний формат вводу. Будь ласка, введіть ціле число.");
            } finally {
                scanner.nextLine();
            }
        }
        return value;
    }

    private static double getValidatedDoubleInput(Scanner scanner, String prompt) {
        double value = -1.0;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextDouble();
                if (value < 0) {
                    System.out.println("Помилка: Ціна не може бути від'ємною. Спробуйте ще раз.");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Помилка: Невірний формат вводу. Будь ласка, введіть число (використовуйте кому або крапку відповідно до локалі).");
            } finally {
                scanner.nextLine();
            }
        }
        return value;
    }

    public static Car[] createCarsArray() {
        return new Car[] {
                new Car(1, "Toyota", 2018, 25000.00, "AA1234BB"),
                new Car(2, "BMW", 2015, 28000.50, "BB5678CC"),
                new Car(3, "BMW", 2021, 40000.00, "CC1111DD"),
                new Car(4, "Audi", 2020, 35000.99, "DD2222EE"),
                new Car(5, "Toyota", 2020, 32000.00, "EE3333FF")
        };
    }

    // a) список автомобілів заданої моделі
    public static void printCarsByModel(Car[] cars, String model) {
        boolean found = false;
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model)) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Автомобілів моделі " + model + " не знайдено.");
        }
    }

    // b) список автомобілів заданої моделі, які експлуатуються більше n років
    public static void printCarsByModelAndAge(Car[] cars, String model, int years) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        boolean found = false;
        for (Car car : cars) {
            int carAge = currentYear - car.getYear();
            if (car.getModel().equalsIgnoreCase(model) && carAge > years) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Автомобілів, що відповідають критеріям, не знайдено.");
        }
    }

    // c) список автомобілів заданого року випуску, ціна яких більше вказаної
    public static void printCarsByYearAndPrice(Car[] cars, int year, double minPrice) {
        boolean found = false;
        for (Car car : cars) {
            if (car.getYear() == year && car.getPrice() > minPrice) {
                System.out.println(car);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Автомобілів, що відповідають критеріям, не знайдено.");
        }
    }
}