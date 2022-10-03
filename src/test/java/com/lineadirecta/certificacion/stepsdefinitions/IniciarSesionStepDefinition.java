package com.lineadirecta.certificacion.stepsdefinitions;

import com.lineadirecta.certificacion.models.InicioDeSesionModel;
import com.lineadirecta.certificacion.questions.VerificarMensajeDeCredencialesFalsas;
import com.lineadirecta.certificacion.questions.VerificarMensajeInicioDeSesion;
import com.lineadirecta.certificacion.questions.VerificarPerfilDeConfeccionista;
import com.lineadirecta.certificacion.tasks.AbrirPortal;
import com.lineadirecta.certificacion.tasks.IniciarSesion;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IniciarSesionStepDefinition {

    @Before
    public static void asignarElEscenario(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^que el (.*) quiere iniciar sesion$")
    public void queElConfeccionistaQuiereIniciarSesion(String actor) {
        theActorCalled(actor).wasAbleTo(AbrirPortal.deParos());
    }

    @When("^Ingresa sus credenciales de autenticacion$")
    public void ingresaSusCredencialesDeAutenticacion(List<InicioDeSesionModel> inicioDeSesionModels) {
        theActorInTheSpotlight().attemptsTo(IniciarSesion.conLasCredenciasDelUsuario(inicioDeSesionModels.get(0)));
    }

    @Then("^Podra verificar su numbre de usuario:(.*)$")
    public void podraVerificarSuNombreDeUsuario(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeInicioDeSesion.exitoso(mensaje)));
    }

    @Then("^Podra ver un mensaje:(.*)$")
    public void podraVerUnMensajeUsuarioYClaveIncorrectos(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeDeCredencialesFalsas.enInicioDeSesion(mensaje)));
    }
    @Then("^Podra ver el menu principal el mensaje:(.*)$")
    public void podraVerElMenuPrincipalElMensajeConfecciones(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarPerfilDeConfeccionista.enLineaDirecta(mensaje)));
    }
}