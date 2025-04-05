package starter.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import starter.ui.CartPage;

public class ValidateTitle implements Question {
    @Override
    public Object answeredBy(Actor actor) {
        return actor.asksFor(Text.of(CartPage.LBL_TITLE));
    }

    public static ValidateTitle validate(){
        return new ValidateTitle();
    }

}
