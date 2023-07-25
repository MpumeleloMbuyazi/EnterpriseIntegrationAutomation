package BritBox.Testing;

import static io.restassured.RestAssured.*;
import static java.lang.System.out;

import Base.baseClass;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TMF641_CreateServiceOrder extends baseClass {

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
    public void post_CreateServiceOrder() throws Exception {
        String payload = "{\n" +
                "    \"id\": \"71709244\",\n" +
                "    \"priority\": \"1\",\n" +
                "    \"description\": \"Service order for BritBox\",\n" +
                "    \"category\": \"OTT Order\",\n" +
                "    \"state\": \"New Service Order\",\n" +
                "    \"completionDate\": \"\",\n" +
                "    \"requestedStartDate\": null,\n" +
                "    \"startDate\": \"2023-06-06T12:09:52.56Z\",\n" +
                "    \"@type\": \"ServiceOrder\",\n" +
                "    \"relatedParty\": [\n" +
                "        {\n" +
                "            \"id\": \"133199987\",\n" +
                "            \"name\": \"MPUMELELO DUBE\",\n" +
                "            \"role\": \"requester\",\n" +
                "            \"@referredType\": \"Individual\",\n" +
                "            \"href\": \"http://ICX.com\"\n" +
                "        }\n" +
                "    ],\n" +
                "    \"serviceOrderItem\": [\n" +
                "        {\n" +
                "            \"id\": \"496\",\n" +
                "            \"quantity\": 1,\n" +
                "            \"state\": \"InProgress\",\n" +
                "            \"service\": {\n" +
                "                \"@type\": \"Service\",\n" +
                "                \"state\": \"Active\",\n" +
                "                \"serviceType\": \"Add On\"\n" +
                "            },\n" +
                "            \"@type\": \"ServiceOrderItem\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        response = requestSpecification.given().body(payload).post("/gateway/ServiceOrderingPlatformAPI/serviceOrder").then().log().all().extract().response();

        String CorrelationNumber = response.path("correlationId");
        //out.println(CorrelationNumber);

        launchBrowser("Chrome");
        WebDriverWait wait = new WebDriverWait(driver, 75);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body:nth-child(1) app-navbar:nth-child(1) mat-toolbar.mat-toolbar.mat-primary.mat-toolbar-single-row div.nav-items:nth-child(2) > a:nth-child(1)")));

        driver.findElement(By.cssSelector("body:nth-child(1) app-navbar:nth-child(1) mat-toolbar.mat-toolbar.mat-primary.mat-toolbar-single-row div.nav-items:nth-child(2) > a:nth-child(1)")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-audit.ng-star-inserted:nth-child(2) div.page-container div.actions-toolbar div:nth-child(1) mat-form-field.mat-form-field.ng-tns-c79-1.mat-primary.mat-form-field-type-mat-input.mat-form-field-appearance-outline.mat-form-field-can-float.mat-form-field-has-label.ng-star-inserted.mat-form-field-hide-placeholder:nth-child(2) div.mat-form-field-wrapper.ng-tns-c79-1 div.mat-form-field-flex.ng-tns-c79-1 > div.mat-form-field-infix.ng-tns-c79-1:nth-child(3)")));
        driver.findElement(By.cssSelector("app-audit.ng-star-inserted:nth-child(2) div.page-container div.actions-toolbar div:nth-child(1) mat-form-field.mat-form-field.ng-tns-c79-1.mat-primary.mat-form-field-type-mat-input.mat-form-field-appearance-outline.mat-form-field-can-float.mat-form-field-has-label.ng-star-inserted.mat-form-field-hide-placeholder:nth-child(2) div.mat-form-field-wrapper.ng-tns-c79-1 div.mat-form-field-flex.ng-tns-c79-1 > div.mat-form-field-infix.ng-tns-c79-1:nth-child(3)")).click();
        driver.findElement(By.cssSelector("#mat-input-0")).sendKeys(CorrelationNumber);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-audit.ng-star-inserted:nth-child(2) div.page-container mat-card.mat-card.mat-focus-indicator.mat-table-card-wrapper table.mat-table.cdk-table.mat-sort tbody:nth-child(2) tr.mat-row.cdk-row.ng-star-inserted:nth-child(1) td.mat-cell.cdk-cell.cdk-column-payload.mat-column-payload.ng-star-inserted:nth-child(10) > mat-icon.mat-icon.notranslate.inspect-payload.material-icons-outlined.mat-icon-no-color.ng-star-inserted")));
        driver.findElement(By.cssSelector("app-audit.ng-star-inserted:nth-child(2) div.page-container mat-card.mat-card.mat-focus-indicator.mat-table-card-wrapper table.mat-table.cdk-table.mat-sort tbody:nth-child(2) tr.mat-row.cdk-row.ng-star-inserted:nth-child(1) td.mat-cell.cdk-cell.cdk-column-payload.mat-column-payload.ng-star-inserted:nth-child(10) > mat-icon.mat-icon.notranslate.inspect-payload.material-icons-outlined.mat-icon-no-color.ng-star-inserted")).click();

        //String t;
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        WebElement t = driver.findElement(By.xpath("//body[1]/div[3]/div[2]/div[1]/mat-dialog-container[1]/app-payload[1]/div[1]/div[1]/div[1]/div[2]/textarea[1]"));
        String ele = (String) jsExecutor.executeScript("return arguments[0].value;", t);

        Assert.assertEquals(ele, "There is no data found for this corelationId.");

        out.println(ele);


    }
}
