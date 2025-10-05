package carpackage;

// 4.carpackage.Car: id, Модель, Рік випуску, Ціна, Реєстраційний номер.
// Скласти масив об'єктів. Вивести:
// a) список автомобілів заданої моделі;
// b) список автомобілів заданої моделі, які експлуатуються більше n років;
// c) список автомобілів заданого року випуску, ціна яких більше вказаної.

public class Car {
    private int id;
    private String model;
    private int year;
    private double price;
    private String registerNumber;

    public Car(int id, String model, int year, double price, String registerNumber) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.price = price;
        this.registerNumber = registerNumber;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registerNumber;
    }
    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    @Override
    public String toString() {
        return "carpackage.Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", registrationNumber='" + registerNumber + '\'' +
                '}';
    }
}