package cucumber.steps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import com.example.springbdd.controller.ProductController;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@CucumberContextConfiguration
public class StoreProductsSteps {
    @Given("I have more than {int} products in my store")
    public void iHaveMoreThanProductsInMyStore(int productNumber) {
        ProductController products = new ProductController();

        assertTrue("I have more than {int} products in my store",
                products.getAllProducts().size() > productNumber);
    }

    @And("one of these products is a cell phone")
    public void oneOfTheseProductsIsACellPhone() {
        ProductController products = new ProductController();

        assertTrue("one of these products is a cell phone",
                products.getAllProducts().contains("CellPhone"));
    }

    @Then("all product must be returned successfully")
    public void allProductMustBeReturnedSuccessfully() {
        // Arrange
        List<String> productsToBeverified = new ArrayList<String>();

        productsToBeverified.add("Mouse");
        productsToBeverified.add("Screen");
        productsToBeverified.add("Keyboard");
        productsToBeverified.add("Pen");
        productsToBeverified.add("CellPhone");

        // Act
        ProductController products = new ProductController();

        // Assert
        assertTrue("all product must be returned successfully",
                products.getAllProducts().containsAll(productsToBeverified));
    }
}
