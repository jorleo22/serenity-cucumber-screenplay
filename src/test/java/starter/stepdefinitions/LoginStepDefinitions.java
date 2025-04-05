package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import org.hamcrest.Matchers;
import starter.exceptions.MessageException;
import starter.models.Credentials;
import starter.questions.ValidateTitle;
import starter.tasks.LoginTask;
import starter.utils.Constants;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {

    @Given("^que estoy en la pagina de login$")
    public void navegarLogin() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url("https://sahitest.com/demo/training/login.htm"));
    }

    @When("^ingreso los datos de login$")
    public void ingresarDatosLogin(DataTable datable) {
        List<Map<String, String>> credentialsList = datable.asMaps(String.class, String.class);
        Map<String, String> aCredential = credentialsList.get(0);
        Credentials credentials = new Credentials();
        credentials.setUser(aCredential.get("user"));
        credentials.setPassword(aCredential.get("password"));
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.ingresarCredenciales(credentials));
    }

    @Then("veo el titulo de compra de libros")
    public void validarInicioSesion() {
        OnStage.theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(ValidateTitle.validate(), Matchers.is(Constants.TITLE_CART))
                .orComplainWith(MessageException.class, Constants.MESSAGE_EXCEPTION_TITLE));
    }

}
