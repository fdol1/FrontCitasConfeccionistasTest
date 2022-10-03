package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.GuardarNumeroCitaException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static com.lineadirecta.certificacion.userinterfaces.UiAgendarRecogida.LBL_NUMERO_CITA;

public class GuardarNumeroCita implements Interaction {

    public GuardarNumeroCita() {
    }

    public static GuardarNumeroCita generaConExito() {
        return Tasks.instrumented(GuardarNumeroCita.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            try {
                actor.attemptsTo(
                        WaitUntil.the(LBL_NUMERO_CITA, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds()
                );
                FileWriter numeroCita = new FileWriter("src/test/resources/numerocita.txt");
                PrintWriter dato = new PrintWriter(numeroCita);
                dato.print(Text.of(LBL_NUMERO_CITA).viewedBy(actor).asString());
                numeroCita.close();
            } catch (RuntimeException | IOException ex) {
                throw new GuardarNumeroCitaException(GuardarNumeroCitaException.Error(), ex);
            }
        }catch (RuntimeException ex){
            throw new GuardarNumeroCitaException(GuardarNumeroCitaException.Error(),ex);
        }
    }
}