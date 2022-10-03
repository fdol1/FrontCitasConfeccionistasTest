package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.ObtenrNumeroDeCitaException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ObtenerNumeroDeCita implements Interaction {

    private final Target elemento;

    public ObtenerNumeroDeCita(Target elemento) {
        this.elemento = elemento;
    }

    public static ObtenerNumeroDeCita guardadoEnElDocDeTexto(Target elemento) {
        return Tasks.instrumented(ObtenerNumeroDeCita.class,elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            FileReader fileReader = new FileReader("src/test/resources/numerocita.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String numeroCita = bufferedReader.readLine();

            actor.attemptsTo(
                    WaitUntil.the(elemento, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Enter.theValue(numeroCita.substring(3)).into(elemento)
            );
        }catch (RuntimeException | IOException ex){
            throw new ObtenrNumeroDeCitaException(ObtenrNumeroDeCitaException.Error(),ex);
        }
    }
}