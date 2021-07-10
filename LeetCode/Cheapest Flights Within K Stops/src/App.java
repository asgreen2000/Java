import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class City {

    int id;
    int stopsCount;
    int value;
    City(int id) {

        this.id = id;
        stopsCount = 0;
        value = 0;
    }

    City(int id, int stops, int value) {
        this.id = id;
        this.stopsCount = stops;
        this.value = value;
    }
}

class FlightManager {

    int countAt[];
    int nFlights;
    int [][] matrixMap;
    final int MAX = 1000000;
    FlightMnager(int [][] flights, int n)
    {
        this.nFlights = n;
        matrixMap = new int[n][n];
        countAt = new int[n];
        Arrays.fill(countAt, MAX);
        for (int i = 0; i < flights.length; i++) {

            int u = flights[i][0];
            int v = flights[i][1];
            int weight = flights[i][2];
            matrixMap[u][v] = weight;
        }
    }


    int findCheapestPrice(int src, int dst, int k)
    {
        int maxCities = k + 1;

        PriorityQueue<City> queue = new PriorityQueue<>(new Comparator<City>(){

            @Override
            public int compare(City o1, City o2) {
                
                return o2.value - o1.value;
            }
            
        });


        queue.add(new City(src));

        while (!queue.isEmpty())
        {
            int u = queue.peek().id;
            int stops = queue.peek().stopsCount;
            int cost = queue.peek().value;
            queue.remove();

            if (u == dst)
            {
                return cost;
            }

            countAt[]


        }


        return -1;
    }
}



public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
