package co.com.certificacion.demoblaze.tasks;

import co.com.certificacion.demoblaze.userinterfaces.Home;
import co.com.certificacion.demoblaze.utils.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LogInRuta implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(Home.Cart)
        );

    }
    public static LogInRuta logInRuta(){ return instrumented(LogInRuta.class);}
}
