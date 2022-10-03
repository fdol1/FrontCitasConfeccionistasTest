package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.AsignarValoresException;
import com.lineadirecta.certificacion.models.AgendarCitaModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiAgendarCita.*;

public class AsignarValores  implements Interaction {

    private final AgendarCitaModel agendarCitaModel;

    public AsignarValores(AgendarCitaModel agendarCitaModel) {
        this.agendarCitaModel = agendarCitaModel;
    }

    public static AsignarValores deLaOrdenAEntregar(AgendarCitaModel agendarCitaModel) {
        return Tasks.instrumented(AsignarValores.class,agendarCitaModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(TXT_CANTIDAD_A_ENTREGAR, WebElementStateMatchers.isClickable()).forNoMoreThan(7).seconds(),
                    Enter.theValue(agendarCitaModel.getCantidadMod1()).into(TXT_CANTIDAD_A_ENTREGAR),
                    Enter.theValue(agendarCitaModel.getTula()).into(TXT_TULAS_M1),
                    Enter.theValue(agendarCitaModel.getCaja()).into(TXT_CAJAS_M1),
                    Enter.theValue(agendarCitaModel.getBolsa()).into(TXT_BOLSAS_M1),
                    Enter.theValue(agendarCitaModel.getObservacion()).into(TXT_OBSERVACION)
            );
        }catch (RuntimeException ex){
            throw new AsignarValoresException(AsignarValoresException.Error(),ex);
        }
    }
}