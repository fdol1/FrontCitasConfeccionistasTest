package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.EditarCitaException;
import com.lineadirecta.certificacion.models.ConsultarCitaMoldel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UIConsultarCita.*;

public class EditarCita implements Task {

    private final ConsultarCitaMoldel consultarCitaMoldel;

    public EditarCita(ConsultarCitaMoldel consultarCitaMoldel) {
        this.consultarCitaMoldel = consultarCitaMoldel;
    }

    public static EditarCita agendada(ConsultarCitaMoldel consultarCitaMoldel) {
        return Tasks.instrumented(EditarCita.class,consultarCitaMoldel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(BTN_EDITAR, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_EDITAR),
                    WaitUntil.the(LBL_CANTIDAD_TOTAL, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Enter.theValue(consultarCitaMoldel.getCantidadConfirmada()).into(LBL_CANTIDAD_TOTAL),
                    Click.on(BTN_GUARDAR),
                    WaitUntil.the(BTN_CONFIRMAR_Y_GUARDAR, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_CONFIRMAR_Y_GUARDAR)
            );
        }catch (RuntimeException ex){
            throw new EditarCitaException(EditarCitaException.Error(),ex);
        }
    }
}