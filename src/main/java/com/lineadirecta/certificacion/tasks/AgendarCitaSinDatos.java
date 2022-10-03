package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.AgendarCitaSinDatosException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.lineadirecta.certificacion.userinterfaces.UiAgendarCita.BTN_AGENDAR;
import static com.lineadirecta.certificacion.userinterfaces.UiAgendarCita.BTN_CATEGORIA_1;

public class AgendarCitaSinDatos implements Task {

    public AgendarCitaSinDatos() {
    }

    public static AgendarCitaSinDatos paraEntregaDeProductos() {
        return Tasks.instrumented(AgendarCitaSinDatos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(BTN_CATEGORIA_1),
                    Click.on(BTN_AGENDAR)
            );
        }catch (RuntimeException ex){
            throw new AgendarCitaSinDatosException(AgendarCitaSinDatosException.Error(),ex);
        }
    }
}