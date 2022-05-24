public class Converter {
    double kilometers;
    int caloriesStep=50;
    int kilocalories;

    double translatingStepsIntoKilometers (int sumSteps){
        kilometers = (double) sumSteps * 75 / 100000;
        return kilometers;
    }

    int lostKilocalories (int sumSteps) {
        kilocalories = sumSteps * caloriesStep/1000;
        return kilocalories;
    }
}
