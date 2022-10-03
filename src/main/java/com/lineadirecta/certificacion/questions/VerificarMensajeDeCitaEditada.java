package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UIConsultarCita.LBL_MENSAJE_CITA_EDITADA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarMensajeDeCitaEditada implements Question<Boolean> {

    private final String mensaje;

    public VerificarMensajeDeCitaEditada(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeDeCitaEditada correctamente(String mensaje){
        return new VerificarMensajeDeCitaEditada(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_MENSAJE_CITA_EDITADA,isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(Text.of(LBL_MENSAJE_CITA_EDITADA).viewedBy(actor).asString());
    }
}