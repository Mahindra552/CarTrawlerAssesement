package com.utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class RestSelection {

    /**
     * @param methodType: Takes methodURL,methodtyoe,Params,headers,payload to send the request
     */

    static Response sendRestRequest(String methodUri, String methodType, HashMap<String, String> params, Map<String, String> headers, Object payloadBody) {
        Response responsetoSend = null;

        RequestSpecification specification = RestAssured.given().relaxedHTTPSValidation().headers(headers);
        switch (methodType) {
            case "GET":
                if (params != null)
                    responsetoSend = specification.params(params).get(methodUri);
                else
                    responsetoSend = specification.get(methodUri);
                break;
            case "POST":
                responsetoSend = specification.body(payloadBody).post(methodUri);
                break;
            case "PUT":
                responsetoSend = specification.body(payloadBody).put(methodUri);
                break;
            case "DELETE":
                responsetoSend = specification.body(payloadBody).delete(methodUri);
        }

        return responsetoSend;
    }

}
