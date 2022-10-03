package com.lineadirecta.certificacion.stepsdefinitions;

import com.lineadirecta.certificacion.models.AgendarCitaModel;
import com.lineadirecta.certificacion.questions.VerificarMensajeAgendarSinDatos;
import com.lineadirecta.certificacion.questions.VerificarMensajeCitaAgendada;
import com.lineadirecta.certificacion.tasks.AgendarCitaSinDatos;
import com.lineadirecta.certificacion.tasks.BuscarNumeroDeOrden;
import com.lineadirecta.certificacion.tasks.IngresarDatos;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AgendarCitaStepDefinition {

    @Before
    public static void asignarElEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("^Que el confeccionista requiere buscar la orden$")
    public void queElConfeccionistaRequiereBuscarLaOrden(List<AgendarCitaModel> agendarCitaModelList) {
        theActorInTheSpotlight().attemptsTo(BuscarNumeroDeOrden.paraEntrega(agendarCitaModelList.get(0)));
    }

    @When("^Ingresa los datos de la entrega para la cita$")
    public void ingresaLosDatosDeLaEntregaParaLaCita(List<AgendarCitaModel> agendarCitaModelList) {
        theActorInTheSpotlight().attemptsTo(IngresarDatos.paraAgendarCitaDeEntrega(agendarCitaModelList.get(0)));
    }

    @Then("^Podra visualizar el mensaje de:(.*)$")
    public void podraVisualizarElMensajeDe(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeCitaAgendada.exitosa(mensaje)));
    }

    @When("^Agenda la cita sin ingresar datos$")
    public void agendaLaCitaSinIngresarDatos() {
        theActorInTheSpotlight().attemptsTo(AgendarCitaSinDatos.paraEntregaDeProductos());
    }

    @Then("^Podra visualizar el mensaje de error:(.*)$")
    public void podraVisualizarElMensajeDeError(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeAgendarSinDatos.laEntregaDeProducto(mensaje)));
    }
}