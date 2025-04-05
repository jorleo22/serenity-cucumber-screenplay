package starter.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target TXT_USERNAME = Target.the("ingresar usuario").locatedBy("//input[@type='text']");
    public static final Target TXT_PASSWORD = Target.the("ingresar password").locatedBy("//input[@type='password']");
    public static final Target BTN_LOGIN = Target.the("clic en el boton de login").locatedBy("//input[@type='submit']");

}
