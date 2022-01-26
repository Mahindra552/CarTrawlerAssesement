package com.utility;

import io.restassured.response.Response;


import java.util.HashMap;

public class Apiclient {

    private String host;
    private Endpoint endpoint;
    private HashMap<String, String> queryParameters;
    private HashMap<String, String> headers;
    private Object requestbody;
    private Response response;

    //set the request body
    public void setRequestbody(Object requestbody) {
        this.requestbody = requestbody;
    }

    //set the headers for the request
    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    //set the query parameters for the request
    public void setQueryParameters(HashMap<String, String> queryParameters) {
        this.queryParameters = queryParameters;
    }

    //Contains all the request information like end point path/resource and HTTP method like GET,POST etc
    public Endpoint getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }


    //Contains the information regarding the hostname, usually referred as base url
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    /**
     * This method prepares the request by setting all method details and firing the Http request
     * using Rest Assured methods implemented in RestHelper Class
     * We need , baseURL+path,Method type ,headers and query Parameters
     */
    public void triggerRequest() {

        String methodURI = host + this.endpoint.getMethod();
        String requestType = this.endpoint.getRequestType();
        String methodType = this.endpoint.getMethodType();

        //Sending the REST request by using the Rest Selection class helpers
        if (requestType.equalsIgnoreCase("REST")) {
            response = RestSelection.sendRestRequest(methodURI, methodType, this.queryParameters, this.headers, this.requestbody);
        }

    }

    //returns the int of response code eg : 200,201,202
    public int getResponseStatusCode() {
        return this.response.getStatusCode();
    }

    //prints the response json like a alligned json format
    public String getResponseBody() {
        return this.response.getBody().prettyPrint();
    }

}
