package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.IngresarDatosException;
import com.lineadirecta.certificacion.interactions.AgendarRecogida;
import com.lineadirecta.certificacion.interactions.AsignarValores;
import com.lineadirecta.certificacion.interactions.FalsaEspera;
import com.lineadirecta.certificacion.interactions.GuardarNumeroCita;
import com.lineadirecta.certificacion.models.AgendarCitaModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.lineadirecta.certificacion.userinterfaces.UiAgendarCita.BTN_AGENDAR;
import static com.lineadirecta.certificacion.userinterfaces.UiAgendarCita.BTN_CATEGORIA_1;

public class IngresarDatos implements Task {

    private final AgendarCitaModel agendarCitaModel;

    public IngresarDatos(AgendarCitaModel agendarCitaModel) {
        this.agendarCitaModel = agendarCitaModel;
    }

    public static IngresarDatos paraAgendarCitaDeEntrega(AgendarCitaModel agendarCitaModel) {
        return Tasks.instrumented(IngresarDatos.class,agendarCitaModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    Click.on(BTN_CATEGORIA_1),
                    AsignarValores.deLaOrdenAEntregar(agendarCitaModel),
                    Click.on(BTN_AGENDAR),
                    AgendarRecogida.delProducto(agendarCitaModel),
                    FalsaEspera.enPantalla(5000),
                    GuardarNumeroCita.generaConExito()
            );
        }catch (RuntimeException ex){
            throw new IngresarDatosException(IngresarDatosException.Error(),ex);
        }
    }
}