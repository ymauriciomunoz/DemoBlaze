package co.com.certificacion.demoblaze.stepdefinitions;


import co.com.certificacion.demoblaze.questions.VerificacionProducto;
import co.com.certificacion.demoblaze.questions.VerificacionUsuario;
import co.com.certificacion.demoblaze.tasks.LogIn;
import co.com.certificacion.demoblaze.tasks.LogInCart;
import co.com.certificacion.demoblaze.tasks.LogInRuta;
import co.com.certificacion.demoblaze.tasks.Registro;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
public class RegistroStepDefinitions {
    @Managed(driver = "chrome")
    WebDriver hisdriver;

    @Before
    public void setThestage(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("alejandro");
    }
    @Dado("^soy un usuario de DemoBlaze sin credenciales$")
    public void soyUnUsuarioDeDemoBlazeSinCredenciales() {
        theActorInTheSpotlight().wasAbleTo(Open.url("https://www.demoblaze.com"));
    }

    @Cuando("^ingreso informacion necesaria para creacion de usuario$")
    public void ingresoInformacionNecesariaParaCreacionDeUsuario() {
        theActorInTheSpotlight().attemptsTo(Registro.registro());
        theActorInTheSpotlight().attemptsTo(LogIn.logIn());
    }

    @Entonces("^se realiza el registro exitoso$")
    public void seRealizaElRegistroExitoso() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerificacionUsuario.verificacionUsuario(), Matchers.is(true)));
    }


    @Dado("^que soy un usuario de DemoBlaze$")
    public void queSoyUnUsuarioDeDemoBlaze() {
        theActorInTheSpotlight().wasAbleTo(Open.url("https://www.demoblaze.com"));
    }

    @Cuando("^agrego un celular al carrito$")
    public void agregoUnCelularAlCarrito() {
        theActorInTheSpotlight().attemptsTo(LogInCart.logInCart());

    }

    @Cuando("^ingreso para verificar carrito$")
    public void ingresoParaVerificarCarrito() {
        theActorInTheSpotlight().attemptsTo(LogInRuta.logInRuta());
    }

    @Entonces("^verifico que se encuentre agregado$")
    public void verificoQueSeEncuentreAgregado() {
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(VerificacionProducto.verificacionProducto(), Matchers.is(true)));

    }
}
