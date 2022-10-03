package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.BuscarNumeroDeOrdenException;
import com.lineadirecta.certificacion.interactions.EsperarElemento;
import com.lineadirecta.certificacion.interactions.EsperarSpinner;
import com.lineadirecta.certificacion.models.AgendarCitaModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiAgendarCita.*;
import static com.lineadirecta.certificacion.userinterfaces.UiMenuPrincipal.BTN_AGENDAR_CITAS;

public class BuscarNumeroDeOrden implements Task {

    private final AgendarCitaModel agendarCitaModel;

    public BuscarNumeroDeOrden(AgendarCitaModel agendarCitaModel) {
        this.agendarCitaModel = agendarCitaModel;
    }

    public static BuscarNumeroDeOrden paraEntrega(AgendarCitaModel agendarCitaModel) {
       return Tasks.instrumented(BuscarNumeroDeOrden.class, agendarCitaModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    EsperarElemento.duranteTransicion(BTN_AGENDAR_CITAS),
                    WaitUntil.the(BTN_AGENDAR_CITAS, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_AGENDAR_CITAS),
                    EsperarSpinner.duranteTransicion(SPN_ESPERA),
                    WaitUntil.the(TXT_BUSCAR_ORDEN, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Enter.theValue(agendarCitaModel.getNumeroOrden()).into(TXT_BUSCAR_ORDEN),
                    Click.on(CHK_ITEM)
            );
        }catch (RuntimeException ex){
            throw new BuscarNumeroDeOrdenException(BuscarNumeroDeOrdenException.Error(),ex);
        }
    }
}