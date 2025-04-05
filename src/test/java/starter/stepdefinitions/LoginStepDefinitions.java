package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import starter.questions.ValidateTitle;
import starter.tasks.LoginTask;

public class LoginStepDefinitions {

    @Given("que estoy en la pagina de login")
    public void navegarLogin(){
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://sahitest.com/demo/training/login.htm"));
    }

    @When("ingreso los datos de usuario y password")
    public void ingresarDatosLogin(){
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.ingresarCredenciales());
    }

    @Then("veo el titulo de compra de libros")
    public void validarInicioSesion(){
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateTitle.validate(), Matchers.is("All available books")));
    }

}
