package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.IniciarSesionException;
import com.lineadirecta.certificacion.models.InicioDeSesionModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UiInicioDeSesion.*;

public class IniciarSesion implements Task {

    private final InicioDeSesionModel inicioDeSesionModel;

    public IniciarSesion(InicioDeSesionModel inicioDeSesionModel) {
        this.inicioDeSesionModel = inicioDeSesionModel;
    }

    public static IniciarSesion conLasCredenciasDelUsuario(InicioDeSesionModel inicioDeSesionModel){
        return Tasks.instrumented(IniciarSesion.class,inicioDeSesionModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(TXT_USUARIO, WebElementStateMatchers.isEnabled()).forNoMoreThan(7).seconds(),
                    Enter.theValue(inicioDeSesionModel.getUsuario()).into(TXT_USUARIO),
                    Enter.theValue(inicioDeSesionModel.getClave()).into(TXT_CLAVE),
                    Click.on(BTN_INICIAR_SESION)
            );
        }catch (RuntimeException ex){
            throw new IniciarSesionException(IniciarSesionException.Error(),ex);
        }
    }
}