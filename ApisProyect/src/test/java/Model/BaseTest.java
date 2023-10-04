package Model;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.requestSpecification;

public class BaseTest {



    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();

    }

    public RequestSpecification defaultRequestSpecification(){

        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        filters.add(new AllureRestAssured());


        return new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/")
                .setBasePath("")
                .addFilters(filters)
                .setContentType(ContentType.JSON).build();
    }

    public RequestSpecification userRequestSpecification(){
        return new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/user/")
                .setBasePath("")
                .setContentType(ContentType.JSON).build();
    }

    public RequestSpecification petRequestSpecification(){
        return new RequestSpecBuilder().setBaseUri("https://petstore.swagger.io/v2/pet")
                .setBasePath("")
                .setContentType(ContentType.JSON).build();
    }
}
