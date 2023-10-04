package Tests.BPetTests;

import Data.Factory.Pet;
import Data.Model.Pet.PetResponse;
import Tests.AABase.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.path.json.JsonPath.from;



public class APetTests extends BaseTest {

    Response response;
    String statusPending ="pending";
    String statusAvailable="available";
    String statusSold="sold";
    @BeforeClass
    public void setUp() { requestSpecification = petRequestSpecification();
    }


    @Test(priority=1)
    @Severity(SeverityLevel.BLOCKER)
    @Description("When get a pet by status, Status Code is 200")
    public void httpStatus200OnGetUserByUsername() {
        response = given()
                .when().queryParam("status",statusAvailable).get("/findByStatus");
        int httpStatus = response.getStatusCode();
        Assert.assertEquals(HttpStatus.SC_OK, httpStatus);
    }

    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Description("Sold Pet´s List")
    public void getASoldPetsList() {
        List<PetResponse> petResponseList = new ArrayList<>();
        String response = given()
                .when().queryParam("status",statusSold).get("/findByStatus")
                .then().extract().body().asString();
        System.out.println(response);
        List<Pet> petList = from(response).getList("", Pet.class);
        for (Pet pet: petList) {
            PetResponse pet1 = new PetResponse(pet.getId(),pet.getName());
            petResponseList.add(pet1);

        }
        System.out.println(petResponseList);
    }


    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Description("Sold Pet´s Quantity")
    public void getASoldPetsQuantityByName() {
        List<PetResponse> petResponseList = new ArrayList<>();
        String response = given()
                .when().queryParam("status",statusSold).get("/findByStatus")
                .then().extract().body().asString();
        System.out.println(response);
        List<Pet> petList = from(response).getList("", Pet.class);
        for (Pet pet: petList) {
            PetResponse pet1 = new PetResponse(pet.getId(), pet.getName());
            petResponseList.add(pet1);
        }
        Map<String,Integer> map = new HashMap<>();
        for (PetResponse pet : petResponseList) {
            if (map.containsKey(pet.getName())) {
                map.put(pet.getName(), map.get(pet.getName()) + 1);
            } else {
                map.put(pet.getName(), 1);
            }
        }
        System.out.println(map);


    }
}
