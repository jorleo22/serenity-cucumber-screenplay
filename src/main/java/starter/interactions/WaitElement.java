package starter.interactions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

/*
 * Uses
 * actor.attemptsTo(WaitElement.on(LoginPage.BTN_LOGIN, "Visible"));
 * */
public class WaitElement implements Interaction {

    private final Target target;
    private final String state;

    public WaitElement(Target target, String state) {
        this.target = target;
        this.state = state;
    }

    @Override
    @Step("{0} waits the #target until be #state")
    public <T extends Actor> void performAs(T actor) {
        switch (state) {
            case "Visible":
                actor.attemptsTo(
                        WaitUntil.the(target, isVisible()).forNoMoreThan(10).seconds()
                );
                break;
            case "Invisible":
                actor.attemptsTo(
                        WaitUntil.the(target, isNotVisible()).forNoMoreThan(10).seconds()
                );
                break;
            case "Enabled":
                actor.attemptsTo(
                        WaitUntil.the(target, isEnabled()).forNoMoreThan(10).seconds()
                );
                break;
            default:
                throw new IllegalArgumentException("Estado no soportado: " + state);
        }
    }

    public static WaitElement on(Target target, String state) {
        return new WaitElement(target, state);
    }

}
