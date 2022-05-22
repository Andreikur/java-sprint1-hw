public class StepTracker {


    int[][] passedMonthDay;    //создание массива 12 месяце по 30 дней для хранения пройденных шагов
    int[][] purposeDay;       //создание массива 12 месяце по 30 дней для хранения целей
    int passed;                 //пройденный путь за день, промежуточная переменная;
    int sumSteps = 0;
    int purpose;
    int bestSeries;         //лучшая серия;


    StepTracker() {
        passedMonthDay = new int[12][30];
        purposeDay = new int[12][30];

    }


    int saveCompletedSteps(int month, int day, int stepsCompleted) {
        if (month < 12 & day <= 30 & month >= 0 & day > 0) {
            passedMonthDay[month][day - 1] = stepsCompleted;
            passed = passedMonthDay[month][day - 1];

            return passed;
        } else {
            passed = -1;
            return passed;
        }
    }

    int enteringNewPurpose (int month, int day, int purposeNew) {
        if (month < 12 & day <= 30 & month >= 0 & day > 0) {
            purposeDay[month][day-1] = purposeNew;
            purpose = purposeDay[month][day-1];

            return purpose;
        } else {
            purpose = -1;
            return purpose;
        }
    }


    void statistics(int month) {

        Converter converter = new Converter();
        bestSeries = 0;
        sumSteps = 0;
        for (int i = 0; i < passedMonthDay[month].length; i++) {
            System.out.print(i + 1 + "день: " + passedMonthDay[month][i] + ", ");
            sumSteps = sumSteps + passedMonthDay[month][i];

          if (passedMonthDay[month][i] > purposeDay[month][i]) {
                 bestSeries++;
              }
        }
        System.out.println(" ");
        System.out.println("Пройдено шагов за месяц: " + sumSteps);
        System.out.println("Среднее колличество шагов за месяц: " + sumSteps / 30);
        System.out.println("Пройденная дистанция (в км): " + converter.translatingStepsIntoKilometers(sumSteps));
        System.out.println("Количество сожженных килокалорий: " + converter.lostKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + bestSeries);
    }

   void fillPurposeDay() {                                    // заполнение массива с целью значениями в 10000 шагов;
        for (int j = 0; j < purposeDay.length; j++) {
           for (int k = 0; k < purposeDay[j].length; k++) {
                purposeDay[j][k] = 10000;
            }
        }
    }



}