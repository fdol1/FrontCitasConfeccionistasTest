package com.lineadirecta.certificacion.stepsdefinitions;

import com.lineadirecta.certificacion.models.ConsultarCitaMoldel;
import com.lineadirecta.certificacion.questions.VerificarInformaciondeConsulta;
import com.lineadirecta.certificacion.questions.VerificarMensajeDeCitaEditada;
import com.lineadirecta.certificacion.tasks.ConsultarCita;
import com.lineadirecta.certificacion.tasks.EditarCita;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class ConsultarCitaStepDefinition {

    @Before
    public static void asignarElEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("^Que el confeccionista requiere consultar las citas$")
    public void queElConfeccionistaRequiereConsultarLasCitas() {
        theActorInTheSpotlight().attemptsTo(ConsultarCita.generada());
    }

    @Then("^Podra verificar el nit y documento de compra$")
    public void podraVerificarElNitYDocumentoDeCompraHorarioCitasDe(List<ConsultarCitaMoldel> consultarCitaMoldelList) {
        theActorInTheSpotlight().should(seeThat(VerificarInformaciondeConsulta.deCitaAgendada(consultarCitaMoldelList.get(0))));
    }

    @When("^Edita la cita seleccionada$")
    public void editaLaCitaSeleccionada(List<ConsultarCitaMoldel> consultarCitaMoldelList) {
        theActorInTheSpotlight().attemptsTo(EditarCita.agendada(consultarCitaMoldelList.get(0)));
    }

    @Then("^Se podra verificar el mensaje:(.*)$")
    public void sePodraVerificarElMensajeCitaActualizadaExitosamente(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeDeCitaEditada.correctamente(mensaje)));

    }
}