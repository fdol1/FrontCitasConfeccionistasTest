package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiAgendarCita.LBL_MENSAJE_ADVERTENCIA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarMensajeAgendarSinDatos implements Question<Boolean> {

    private final String mensaje;

    public VerificarMensajeAgendarSinDatos(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeAgendarSinDatos laEntregaDeProducto(String mensaje){
        return new VerificarMensajeAgendarSinDatos(mensaje);
    }


    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_MENSAJE_ADVERTENCIA,isVisible()).forNoMoreThan(10).seconds()

        );
        return mensaje.equals(Text.of(LBL_MENSAJE_ADVERTENCIA).viewedBy(actor).asString());
    }
}