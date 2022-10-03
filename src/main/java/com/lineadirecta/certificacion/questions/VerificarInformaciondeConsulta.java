package com.lineadirecta.certificacion.questions;

import com.lineadirecta.certificacion.models.ConsultarCitaMoldel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.userinterfaces.UIConsultarCita.LBL_ELEMENTO_INFORMATIVO;

public class VerificarInformaciondeConsulta implements Question<Boolean> {

    private final ConsultarCitaMoldel consultarCitaMoldel;

    public VerificarInformaciondeConsulta(ConsultarCitaMoldel consultarCitaMoldel) {
        this.consultarCitaMoldel = consultarCitaMoldel;
    }

    public static VerificarInformaciondeConsulta deCitaAgendada(ConsultarCitaMoldel consultarCitaMoldel){
        return new VerificarInformaciondeConsulta(consultarCitaMoldel);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_ELEMENTO_INFORMATIVO, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()

        );
        return consultarCitaMoldel.getNit().equals(Text.of(LBL_ELEMENTO_INFORMATIVO).viewedBy(actor).asString());
    }
}