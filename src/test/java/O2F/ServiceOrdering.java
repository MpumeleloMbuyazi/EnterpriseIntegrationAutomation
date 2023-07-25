package O2F;

import Base.baseClass;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.with;

public class ServiceOrdering extends baseClass {

    RequestSpecification requestSpecification;
    Response response;

    Header authorization = new Header("Authorization","Bearer 6f7425c18aa04e78b538669d64caa1973f3601fe4d4e423ca205711ccf5e230e");
    Header contentType = new Header("Content-Type", "application/json");

    @BeforeClass
    public void beforeClass(){
        Headers headers = new Headers(authorization, contentType);
        requestSpecification = with().
                baseUri("https://integrations-sit.multichoice.com").
                headers(headers).
                log().all();
    }

    @Test
    public void post_createServiceorder_OpenServe() throws Exception {

        String payload = "{\n" +
                "    \"relatedParty\": [\n" +
                "        {\n" +
                "            \"id\": \"132807304\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceOrderItem\": [\n" +
                "        {\n" +
                "            \"id\": \"MC_OFF_SIMPLE_DSTV_INTERNET_FIBRE_OS_40_20\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        response = requestSpecification.given().body(payload).post("/gateway/ServiceOrderingPlatformAPI/serviceOrder").then().log().all().extract().response();

        String CorrelationID = response.path("createServiceOrderResponse.correlationId");
        System.out.println(CorrelationID);

        launchBrowser("Chrome");



    }





}
