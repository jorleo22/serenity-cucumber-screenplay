package starter.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.models.Credentials;
import starter.userinterfaces.LoginPage;

public class LoginTask implements Task {

    Credentials credentials;

    public LoginTask(Credentials credentials){
        this.credentials = credentials;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(credentials.getUser()).into(LoginPage.TXT_USERNAME));
        actor.attemptsTo(Enter.theValue(credentials.getPassword()).into(LoginPage.TXT_PASSWORD));
        actor.attemptsTo(Click.on(LoginPage.BTN_LOGIN));
    }

    public static LoginTask ingresarCredenciales(Credentials credentials){
        return Tasks.instrumented(LoginTask.class, credentials);
    }
}
