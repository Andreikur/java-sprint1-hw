public class StepTracker {
    int[][] passedMonthDay;    //создание массива 12 месяце по 30 дней для хранения пройденных шагов
    int passed;                 //пройденный путь за день, промежуточная переменная;
    int sumSteps;
    int maxSteps;
    int bestSeries;         //лучшая серия;
    int series;

    StepTracker() {
        passedMonthDay = new int[12][30];
    }

    int saveCompletedSteps(int month, int day, int stepsCompleted) {
            passedMonthDay[month][day - 1] = stepsCompleted;
            passed = passedMonthDay[month][day - 1];
            return passed;
    }

    void statistics(int month, int purpose) {
        Converter converter = new Converter();
        bestSeries = 0;
        sumSteps = 0;
        for (int i = 0; i < passedMonthDay[month].length; i++) {
            System.out.print(i + 1 + "день: " + passedMonthDay[month][i] + ", ");
            sumSteps = sumSteps + passedMonthDay[month][i];
            if (maxSteps < passedMonthDay[month][i]){
                maxSteps = passedMonthDay[month][i];
            }
            if (passedMonthDay[month][i] > purpose) {
                 series++;
              }
            else {
                series = 0;
            }
            if (series > bestSeries) {
                bestSeries = series;
            }
        }

        System.out.println(" ");
        System.out.println("Пройдено шагов за месяц: " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце: " + maxSteps);
        System.out.println("Среднее колличество шагов за месяц: " + sumSteps / 30);
        System.out.println("Пройденная дистанция (в км): " + converter.translatingStepsIntoKilometers(sumSteps));
        System.out.println("Количество сожженных килокалорий: " + converter.lostKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + bestSeries);
    }
}