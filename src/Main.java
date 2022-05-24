import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        System.out.println("Выберите пункт меню");
        int userInput = scanner.nextInt();
        int purpose = 10000;

        while (userInput != 0) {
            switch (userInput) {
                case 1: {
                    System.out.println("Введите месяц (где 0 - январь, ..,11 - декабрь)");
                    int month = scanner.nextInt();
                    while (month < 0 | month > 11){
                        System.out.println("Неверный формат ввода данных, повторите ввод месяца");
                        month = scanner.nextInt();
                    }
                    System.out.println("Введите день (от 1 до 30), за который хотите ввести пройденное количество шагов");
                    int day = scanner.nextInt();
                    while (day < 1 | day > 30){
                        System.out.println("Неверный формат ввода данных, повторите ввод дней");
                        day = scanner.nextInt();
                    }
                    System.out.println("Введите пройденное количество шагов");
                    int stepsCompleted = scanner.nextInt();
                    while (stepsCompleted < 0){
                        System.out.println("Неверный формат ввода данных, повторите ввод пройденных шагов");
                        stepsCompleted = scanner.nextInt();
                    }
                    int passedMonthDay = stepTracker.saveCompletedSteps(month, day, stepsCompleted);
                    System.out.println("Введено количество шагов: " + passedMonthDay);
                    break;
                }
                case 2: {
                    System.out.println("Введите месяц (где 0 - январь, ..,11 - декабрь) за который хотите получить статистику");
                    int month = scanner.nextInt();
                    while (month < 0 | month > 11){
                        System.out.println("Неверный формат ввода данных, повторите ввод месяца");
                        month = scanner.nextInt();
                    }
                    stepTracker.statistics(month, purpose);
                    break;
                }
                case 3: {
                    System.out.println("Введите новую цель, текущая цель: " + purpose + " шагов.");
                    purpose = scanner.nextInt();
                    while (purpose < 0){
                        System.out.println("Неверный формат ввода данных, повторите ввод пройденных шагов");
                        purpose = scanner.nextInt();
                    }
                    System.out.println("Цель изменена на : " + purpose + " шагов.");
                    break;
                }
                default:
                    System.out.println("Такого раздела не существует");
            }

            printMenu();
            userInput = scanner.nextInt();
            }
        System.out.println ("Программа завершена");
        }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1. Ввести количество шагов за определённый день;");
        System.out.println("2. Напечатать статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день;");
        System.out.println("0. Выйти из приложения.");
    }

}