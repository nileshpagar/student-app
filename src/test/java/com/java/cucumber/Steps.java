package com.java.cucumber;

import com.java.controller.StudentController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(StudentController.class)
@AutoConfigureWebMvc
public class Steps extends SpringIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @When("The student is registered in class (.*)")
    public void register() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/students")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"firstName\": \"Nilesh\",\n" +
                        "    \"lastName\": \"Pagar\",\n" +
                        "    \"className\" : \"1A\",\n" +
                        "    \"nationality\": \"Indian\"\n" +
                        "}")).andReturn();
        mvcResult.getResponse().getContentAsString();
    }
    @Then("Query student registered by first-name '(.*)' and last-name '(.*)'")
    public void queryStudent(String firstName, String lastName) {

    }

    @And("Update student class name to '(.*)'")
    public void updateStudent(String className) {

    }

    @And("delete the student by first-name '(.*)' and last-name '(.*)'")
    public void deleteStudent(String firstName, String lastName) {

    }
}
