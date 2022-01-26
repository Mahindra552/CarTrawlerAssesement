import com.utility.Apiclient;
import com.utility.Booking;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ApiClientTest {

    private String host = "https://www.cartrawler.com/ct/";
    private TestEndpoint endpoint = new TestEndpoint();
    Apiclient apiClient = new Apiclient();
    HashMap<String, String> parameters = new HashMap<>();
    HashMap<String, String> headers = new HashMap<>();

    @Test
    public void testGETPrice() {
        endpoint.setMethod("price");
        endpoint.setMethodType("GET");
        endpoint.setRequestType("REST");

        parameters.put("", "");
        headers.put("", "");

        apiClient.setEndpoint(endpoint);
        apiClient.setHost(host);
        apiClient.setQueryParameters(parameters);
        apiClient.setHeaders(headers);

        apiClient.triggerRequest();

        System.out.println(apiClient.getResponseStatusCode());
        apiClient.getResponseBody();

        //Validate the response code is 200
        Assert.assertEquals(apiClient.getResponseStatusCode(), 200);

        //Validate the price value in response i.e is greater than Zero
        JsonPath jsonPath = JsonPath.given(apiClient.getResponseBody());
        int price_Room = jsonPath.get("price");
        Assert.assertTrue(price_Room > 0);


    }

    @Test
    public void testPOSTCheapestCarType() {
        endpoint.setMethod("/CheapestCarType");
        endpoint.setMethodType("POST");
        endpoint.setRequestType("REST");

        Booking book = new Booking();
        book.setCheckInDate("2021-09-18");
        book.setNumofDays(3);

        //Params and Headers are not set as its not required.
        parameters.put("", "");
        headers.put("", "");

        apiClient.setEndpoint(endpoint);
        apiClient.setHost(host);
        apiClient.setQueryParameters(parameters);
        apiClient.setHeaders(headers);
        apiClient.setRequestbody(book);

        apiClient.triggerRequest();

        System.out.println(apiClient.getResponseStatusCode());
        apiClient.getResponseBody();

        //Validate the response code is 200
        Assert.assertEquals(apiClient.getResponseStatusCode(), 200);
        JsonPath jsonPath = JsonPath.given(apiClient.getResponseBody());
        int price_Room = jsonPath.get("price");
        Assert.assertTrue(price_Room > 0);


    }
}
