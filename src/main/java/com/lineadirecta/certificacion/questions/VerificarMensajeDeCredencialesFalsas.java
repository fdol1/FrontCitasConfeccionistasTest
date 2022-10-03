package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiInicioDeSesion.LBL_MENSAJE_ERROR_CREDENCIALES;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarMensajeDeCredencialesFalsas implements Question<Boolean> {

    private final String mensaje;

    public VerificarMensajeDeCredencialesFalsas(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeDeCredencialesFalsas enInicioDeSesion(String mensaje){
        return new VerificarMensajeDeCredencialesFalsas(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_MENSAJE_ERROR_CREDENCIALES.of(mensaje),isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(Text.of(LBL_MENSAJE_ERROR_CREDENCIALES.of(mensaje)).viewedBy(actor).asString());
    }
}