package co.com.certificacion.demoblaze.questions;

import co.com.certificacion.demoblaze.userinterfaces.Cart;
import co.com.certificacion.demoblaze.userinterfaces.Home;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class VerificacionProducto implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean compare= Cart.Producto.resolveFor(actor).getText().contains("Samsung galaxy s6");
        return compare;
    }
    public static VerificacionProducto verificacionProducto(){return new VerificacionProducto();}
}
