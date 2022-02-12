package steps;

//import api.model.ApiTestModel;

import api.ApiTestController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.ApiTestModel;
import org.hamcrest.MatcherAssert;

public class ApiSteps extends MatcherAssert {
    ApiTestModel apiTestModel;
    ApiTestController apiTestController;

    @Given("^user set data id as (.*)")
    public void userSetDataIdAsId(Integer id) {
        this.apiTestModel = new ApiTestModel();
        apiTestModel.setId(id);
    }

    @When("user get data with specific id")
    public void userGetDataWithSpecificId() {
        apiTestController = new ApiTestController();
        apiTestController.getDataById(this.apiTestModel);
    }

    @Then("the response should be have valid type data")
    public void theResponseShouldBeHaveValidTypeData() {
        apiTestController.schemaValidatorTest();
    }

    @Given("^user set data title as (.*)")
    public void userSetDataTitleAsTitle(String title) {
        this.apiTestModel = new ApiTestModel();
        apiTestModel.setTitle(title);
    }

    @And("^user set data body as (.*)")
    public void userSetDataBodyAsBody(String body) {
        apiTestModel.setBody(body);
    }

    @And("^user set data userId as (.*)")
    public void userSetDataUserIdAsUserId(Integer userId) {
        apiTestModel.setUserId(userId);
    }

    @When("user add data to api")
    public void userAddDataToApi() {
        apiTestController = new ApiTestController();
        apiTestController.postDataTest(apiTestModel);
    }

    @Then("^the response title should be (.*)")
    public void theResponseTitleShouldBeTitle(String title) {
        apiTestController.postValidateTitleValue(title);
    }

    @And("^the response body should be (.*)")
    public void theResponseBodyShouldBeBody(String body) {
        apiTestController.postValidateBodyValue(body);
    }

    @And("^the response userId should be (.*)")
    public void theResponseUserIdShouldBeUserId(Integer userId) {
        apiTestController.postValidateUserIdValue(userId);
    }


}
