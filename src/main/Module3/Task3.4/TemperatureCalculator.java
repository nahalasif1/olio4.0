import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TemperatureCalculator {

    public static void main(String[] args) {
        try {
            System.out.println("Calculating average temperature...");

            URL url = new URL("https://users.metropolia.fi/~jarkkov/temploki.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            double sum = 0.0;
            int count = 0;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(";");
                String timestamp = columns[0];
                String temperatureString = columns[1];

                String temperatureFormatted = temperatureString.replace(',', '.');

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
                Date date = dateFormat.parse(timestamp);

                if (isFirstDayOfJanuary2023(date)) {
                    sum += Double.parseDouble(temperatureFormatted);
                    count++;
                }
            }

            if (count > 0) {
                double averageTemperature = sum / count;
                System.out.println("Average Temperature on the 1st day of January 2023: " + averageTemperature);
            } else {
                System.out.println("No data found for the 1st day of January 2023.");
            }

            reader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private static boolean isFirstDayOfJanuary2023(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateStr = dateFormat.format(date);
        return dateStr.equals("01.01.2023");
    }
}
