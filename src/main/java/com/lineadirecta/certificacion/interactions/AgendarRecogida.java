package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.AgendarRecogidaException;
import com.lineadirecta.certificacion.models.AgendarCitaModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiAgendarRecogida.*;

public class AgendarRecogida implements Task {

    private final AgendarCitaModel agendarCitaModel;

    public AgendarRecogida(AgendarCitaModel agendarCitaModel) {
        this.agendarCitaModel = agendarCitaModel;
    }

    public static AgendarRecogida delProducto(AgendarCitaModel agendarCitaModel) {
        return Tasks.instrumented(AgendarRecogida.class,agendarCitaModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_CALENDARIO, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_CALENDARIO),
                    WaitUntil.the(BTN_DIA.of(agendarCitaModel.getDia()), WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_DIA.of(agendarCitaModel.getDia())),
                    Click.on(BTN_ENVIAR)
            );
        }catch (RuntimeException ex){
            throw new AgendarRecogidaException(AgendarRecogidaException.Error(),ex);
        }
    }
}