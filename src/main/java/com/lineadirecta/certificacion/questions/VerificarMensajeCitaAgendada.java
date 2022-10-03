package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiAgendarRecogida.LBL_MENSAJE_EXITOSO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarMensajeCitaAgendada implements Question<Boolean> {

    private final String mensaje;

    public VerificarMensajeCitaAgendada(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeCitaAgendada exitosa(String mensaje){
        return new VerificarMensajeCitaAgendada(mensaje);
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_MENSAJE_EXITOSO,isVisible()).forNoMoreThan(10).seconds()

        );
        return mensaje.equals(Text.of(LBL_MENSAJE_EXITOSO).viewedBy(actor).asString());
    }
}