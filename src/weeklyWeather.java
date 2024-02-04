import java.util.ArrayList;
import java.util.Scanner;

public class weeklyWeather {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> weekDays = new ArrayList<>();
        ArrayList<Double> dayTemps = new ArrayList<>();
        for (int i=0; i<7; i++){
            System.out.print("Please enter what week day it is: ");
            String weekDay = scanner.nextLine();
            System.out.print("What was the average temp on " + weekDay + "? ");
            double weekDayTemp = scanner.nextDouble();
            scanner.nextLine();
            weekDays.add(weekDay);
            dayTemps.add(weekDayTemp);
        }
        while (true){
            System.out.print("Please enter which day you would like an average for: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("week")) {

                double weeklyAverage = calculateWeeklyAverage(dayTemps);
                System.out.println("The Average Temp for the week was " + weeklyAverage + " degrees.");
            } else if (weekDays.contains(userInput)) {

                int dayCount = weekDays.indexOf(userInput);
                double temperature = dayTemps.get(dayCount);
                System.out.println("Temperature for " + userInput + " was " + temperature + " degrees.");
            } else {
                System.out.println("Enter 'Sunday' - 'Saturday' or 'week'.");
            }
            System.out.print("Press 1 to quit.");
            String userResponse = scanner.nextLine();
            if (!userResponse.equalsIgnoreCase("1")){
                break;
            }
        }
        scanner.close();
    }
    private static double calculateWeeklyAverage(ArrayList<Double> temps){
        double sum = 0;
        for (double temperature : temps){
            sum += temperature;
        }
        return Math.round(sum / temps.size());
    }

}

