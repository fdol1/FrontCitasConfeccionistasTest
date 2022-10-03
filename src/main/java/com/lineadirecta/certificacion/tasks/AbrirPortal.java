package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.AbrirPortalException;
import com.lineadirecta.certificacion.userinterfaces.UiInicioDeSesion;
import com.lineadirecta.certificacion.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;

import java.util.logging.Logger;

public class AbrirPortal implements Task {

    private UiInicioDeSesion inicioDeSesionPage;

    public AbrirPortal(){}

    public static AbrirPortal deParos(){
        return Tasks.instrumented(AbrirPortal.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            GetDriver driver = new GetDriver(actor);
            actor.attemptsTo(
                    Open.browserOn(inicioDeSesionPage)
            );

            driver.webDriver().manage().window().maximize();
            Logger.getAnonymousLogger().info("Se abre la web de paros");

        }catch (RuntimeException ex){
            throw new AbrirPortalException(AbrirPortalException.Error(),ex);
        }
    }
}