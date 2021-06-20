import java.util.ArrayList;

interface Display
{
    abstract void display();
    abstract void update(double temperature, double humidity, double pressure);
}

class WeatherData
{   
    ArrayList<Display> subDisplayList;

    private double getTemperature() {
        return 1;
    }

    private double getHumidity() {
        return 1;
    }
    private double getPressure() {
        return 1;
    }

    void measurementsChanged() {

        double temperature = getTemperature();
        double humidity = getHumidity();
        double pressure = getPressure();

        for (Display display : subDisplayList) {
            
            display.update(temperature, humidity, pressure);
        }

    }

    public void requestRemoveDisplay(Display display) {

        removeDisplay(display);
    }

    private void removeDisplay(Display display) {

        subDisplayList.remove(display);
    }

    public void requestAddDisplay(Display display) {

        addDisplay(display);
    }
    
    private void addDisplay(Display display) {

        subDisplayList.add(display);
    }
}


public class WeatherApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
