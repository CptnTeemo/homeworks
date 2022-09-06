public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов
        int min = 32;
        int max = 40;
        
        float[] patientsTemperatures = new float[patientsCount];
        for (int i = 0; i < patientsTemperatures.length; i++){
            patientsTemperatures[i] =  (float) Math.round(((Math.random()*(max-min))+min)*10)/10;
        }

        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        float sum = 0.0f;
        int countOfHealthy = 0;
        String listOfTemperatures = "";
        for (int i = 0; i < temperatureData.length; i++){
            listOfTemperatures += temperatureData[i] + " ";
            sum += temperatureData[i];
            if (temperatureData[i] > 36.2 && temperatureData[i] < 37.0){
                countOfHealthy++;
            }
        }
        float average = sum / temperatureData.length;

        String report =
                "Температуры пациентов: " + listOfTemperatures.trim() +
                        "\nСредняя температура: " + Math.round(average * 100) / 100D +
                        "\nКоличество здоровых: " + countOfHealthy;

        return report;
    }
}
