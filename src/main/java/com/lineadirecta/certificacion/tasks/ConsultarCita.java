package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.ConsultarCitaException;
import com.lineadirecta.certificacion.interactions.EsperarSpinner;
import com.lineadirecta.certificacion.interactions.ObtenerNumeroDeCita;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiAgendarCita.*;
import static com.lineadirecta.certificacion.userinterfaces.UiMenuPrincipal.BTN_CONSULTAR_CITAS;

public class ConsultarCita implements Task {

    public ConsultarCita() {
    }

    public static ConsultarCita generada() {
        return Tasks.instrumented(ConsultarCita.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_CONSULTAR_CITAS, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_CONSULTAR_CITAS),
                    EsperarSpinner.duranteTransicion(SPN_ESPERA),
                    WaitUntil.the(TXT_BUSCAR_ORDEN, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    ObtenerNumeroDeCita.guardadoEnElDocDeTexto(TXT_BUSCAR_ORDEN),
                    Click.on(CHK_ITEM)
            );
        }catch (RuntimeException ex){
            throw new ConsultarCitaException(ConsultarCitaException.Error(),ex);
        }
    }
}