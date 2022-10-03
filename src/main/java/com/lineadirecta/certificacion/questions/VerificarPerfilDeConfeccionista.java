package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiMenuPrincipal.LBL_CONFECCIONES;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarPerfilDeConfeccionista implements Question<Boolean> {

    private final String mensaje;

    public VerificarPerfilDeConfeccionista(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarPerfilDeConfeccionista enLineaDirecta(String mensaje){
        return new VerificarPerfilDeConfeccionista(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_CONFECCIONES,isVisible()).forNoMoreThan(10).seconds()

        );
        return mensaje.equals(Text.of(LBL_CONFECCIONES).viewedBy(actor).asString());
    }
}