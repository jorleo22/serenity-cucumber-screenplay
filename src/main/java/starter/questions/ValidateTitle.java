package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import starter.userinterfaces.CartPage;

public class ValidateTitle implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(Text.of(CartPage.LBL_TITLE));
    }

    public static ValidateTitle validate(){
        return new ValidateTitle();
    }

}
