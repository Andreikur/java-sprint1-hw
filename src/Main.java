import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        System.out.println("Выберите пункт меню");
        int userInput = scanner.nextInt();
        stepTracker.fillPurposeDay();           //вызов функции заполнения массива целей значением 10000;

        while (userInput != 0) {
            switch (userInput) {
                case 1: {
                    System.out.println("Введите месяц (где 0 - январь, ..,11 - декабрь)");
                    int month = scanner.nextInt();
                    System.out.println("Введите день (от 1 до 30), за который хотите ввести пройденное количество шагов");
                    int day = scanner.nextInt();
                    System.out.println("Введите пройденное количество шагов");
                    int stepsCompleted = scanner.nextInt();
                    int passedMonthDay = stepTracker.saveCompletedSteps(month, day, stepsCompleted);

                    if (passedMonthDay >= 0) {
                        System.out.println("Введено количество шагов: " + passedMonthDay);
                    }
                    else
                    {
                        System.out.println("Неверный формат ввода данных");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Введите месяц (от 0 до 11) за который хотите получить статистику");
                    int month = scanner.nextInt();
                    stepTracker.statistics(month);

                    break;
                }
                case 3: {
                    System.out.println("Введите месяц (от 0 до 11) и день (от 1 до 30)(через Enter) за который хотите изменить цель");
                    int month = scanner.nextInt();
                    int day = scanner.nextInt();
                    System.out.println("Введите новую цель");
                    int purposeNew = scanner.nextInt();
                    int purpose = stepTracker.enteringNewPurpose(month, day, purposeNew);

                    if (purpose >= 0) {
                        System.out.println("Введена новая цель " + purpose);
                    }
                    else
                    {
                        System.out.println("Неверный формат ввода данных");
                    }

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