package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.EsperarSpenerException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

import java.util.logging.Logger;

public class EsperarElemento implements Interaction {

    private final Target elementoAEsperar;

    public EsperarElemento(Target elementoAEsperar) {
        this.elementoAEsperar = elementoAEsperar;
    }

    public static EsperarElemento duranteTransicion(Target elementoAEsperar){
        return Tasks.instrumented(EsperarElemento.class, elementoAEsperar);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            do {
                break;
            }while (!elementoAEsperar.resolveFor(actor).isClickable());
            Logger.getAnonymousLogger().info("Fin del elemento");
        }catch (RuntimeException ex){
            throw new EsperarSpenerException(EsperarSpenerException.Error(),ex);
        }
    }
}