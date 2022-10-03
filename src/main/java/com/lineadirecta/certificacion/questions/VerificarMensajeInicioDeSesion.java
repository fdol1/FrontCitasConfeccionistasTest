package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiMenuPrincipal.LBL_NOMBRE_USUARIO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarMensajeInicioDeSesion implements Question<Boolean> {

    private final String mensaje;

    public VerificarMensajeInicioDeSesion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeInicioDeSesion exitoso(String mensaje){
        return new VerificarMensajeInicioDeSesion(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_NOMBRE_USUARIO.of(mensaje),isVisible()).forNoMoreThan(10).seconds()

        );
        return mensaje.equals(Text.of(LBL_NOMBRE_USUARIO.of(mensaje)).viewedBy(actor).asString());
    }
}