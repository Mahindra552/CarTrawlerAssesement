import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;


public class CarTrawler {

    public static void main(String[] args) throws FileNotFoundException {

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(new FileReader("cars.json"));
        JSONObject jsonObject = (JSONObject) obj;

        JSONArray price = (JSONArray) jsonObject.get("Amount");
        System.out.println(price);

        // Creating an iterator
        Iterator cheapestValue = price.iterator();


        // iterating through the iterator
        System.out.println("The iterator values are: ");
        while (cheapestValue.hasNext()) {
            System.out.println(cheapestValue.next());
        }

        public ArrayList<CarTrawler> sortPriceAcending(ArrayList<CarTrawler> price) {

            ArrayList<CarTrawler> sortedPrice = new ArrayList<CarTrawler>();
            CarTrawler temp;

            for (int j = 0; j < price.size() - 1; j++) {

                for (int i = 0; i < price.size() - 1; i++) {
                    CarTrawler price1 = (CarTrawler) price.get(i);
                    CarTrawler price2 = (CarTrawler) price.get(i + 1);
                    if (car.getPrice() > car1.getPrice()) {
                        temp = carTrawler;
                        cars.get(i) = cars.get(i + 1);
                        cars.get(i + 1) = temp;
                        sortedPrice = price;

                    }
                }
            }
            return sortedPrice;
        }



        /*//method to sort by item price and display
        public static void sortPrice(double[] array){
            for (int i = 0; i < array.length; i++){
                System.out.println (array[i]);
            }
        }*/


        String carType = (String) jsonObject.get("VehType");
        System.out.println(carType);

        String corporate = (String) jsonObject.get("CORPORATE");
        System.out.println(corporate);


    }
}

     /*Iterator<String> iterator = price.iterator();
            while(iterator.hasNext())
            {
                System.out.println(iterator.next());
            }*/

        /*for (Iterator<String> i = expirations.iterator(); i.hasNext();) {
            String item = i.next();
            System.out.println(+item);
        }*/

       /* FileReader reader = new FileReader("cars.json");
        //object obj =jsonParser.parse(reader);
    //Object obj = parser.(new FileReader("cars.json"));
    JSONObject jsonObj = new JSONObject(obj);*/


    /*//loop through the json for finding the price
    JSONArray price = (jsonObj) jsonObj.get("@Amount");
    Iterator<String> iterator = price.iterator();
    while(iterator.hasNext())

    {
        //sop(print thins here
        //sort
    }

    //find the name
    JSONArray maxvalue = jsonObj.get("@Maxvalue");
*/


