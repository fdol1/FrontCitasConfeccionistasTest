package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class UiInicioDeSesion extends PageObject {

    public static final Target TXT_USUARIO =
            Target.the("Campo para ingresar el usuario")
                    .locatedBy("//input[@placeholder = 'Digite su usuario']");

    public static final Target TXT_CLAVE =
            Target.the("Campo para ingresar clave")
                    .locatedBy("//input[@placeholder = 'Clave de acceso']");

    public static final Target CKBX_NO_SOY_UN_ROBOT =
            Target.the("Check box para marcar que no soy un robot")
                    .locatedBy("");

    public static final Target BTN_INICIAR_SESION =
            Target.the("Botón para iniciar sesion en la plataforma")
                    .locatedBy("//button[@class = 'undefined primary nb-btn nb-btn-primary']");

    public static final Target LBL_MENSAJE_ERROR_CREDENCIALES =
            Target.the("Mensaje de error de credenciales")
                    .locatedBy("//div[@class='fade alert alert-danger show']");
}