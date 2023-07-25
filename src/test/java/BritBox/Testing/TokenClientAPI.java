package BritBox.Testing;

import Base.baseClass;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static java.lang.System.out;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class TokenClientAPI extends baseClass {

    RequestSpecification requestSpecification;
    Response response;

    Header partnerID = new Header("partnerId","BRITBOXZA");
    Header partnerPassword = new Header("partnerPassword","Br!tboxPa$$");
    Header authorization = new Header("Authorization","Bearer b6aa5130fe2f4edd87a2ad0c63da5b65bd251d4cb7db4056821148605dd7fd20");
    Header contentType = new Header("Content-Type", "application/json");

    @BeforeClass
    public void beforeClass(){
        Headers headers = new Headers(partnerID, partnerPassword, authorization, contentType);
        requestSpecification = with().
                baseUri("https://integrations-sit.multichoice.com").
                contentType(ContentType.JSON).
                headers(headers).
                log().all();
    }

    @Test
    public void getToken() throws Exception {

        response = requestSpecification.get("/gateway/TokenClientPlatformAPI/1.0/token/8KYX68WTY4").then().log().all().extract().response();

        String correlationID = response.path("correlationId");
        out.println(correlationID);

        //Validation using TestNG
        String AccountNum = response.path("metadata[0].mcgAccountNumber");
        Assert.assertEquals(AccountNum, "28488644");

        //Validation using hamcrest.MatcherAssert
        assertThat(response.path("metadata[0].mcgAccountNumber"), equalTo("28488644"));


        //Launch leanUI
//        launchBrowser("Chrome");
//        WebDriverWait wait = new WebDriverWait(driver, 75);

    }

    @Test
    public void getTokenIncorrectToken(){

        response = requestSpecification.get("gateway/TokenClientPlatformAPI/1.0/token/8KYX68WT").then().log().all().extract().response();
        assertThat(response.statusCode(),is(equalTo(200)));

        //Validation Error message
        String ValidationErrorMsg = response.path("error.description");
        Assert.assertEquals(ValidationErrorMsg, "Token does not exists");


    }
}


