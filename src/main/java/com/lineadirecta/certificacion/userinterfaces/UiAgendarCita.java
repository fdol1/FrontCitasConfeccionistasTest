package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UiAgendarCita {

    public static final Target TXT_BUSCAR_ORDEN =
            Target.the("Campo donde se ingresará el numero de la orden")
                    .locatedBy("//input[@class='ld-input-control form-control']");

    public static final Target SPN_ESPERA =
            Target.the("Spiner de espera mientras carga la tabla")
                    .locatedBy("//div[@class='spinner-border']");

    public static final Target CHK_ITEM =
            Target.the("Check para seleccionar la orden")
                    .locatedBy("//input[@class='form-check-input']");

    public static final Target BTN_CATEGORIA_1 =
            Target.the("Primera categoria ")
                    .locatedBy("(//h2[@class='accordion-header'])[1]");

    public static final Target BTN_CATEGORIA_2 =
            Target.the("Segunda categoria")
                    .locatedBy("(//h2[@class='accordion-header'])[2]");

    public static final Target TXT_CANTIDAD_A_ENTREGAR =
            Target.the("ingresa la cantidad a entregar el confeccionista")
                    .locatedBy("(//div[@class='input-group has-validation']//input)[1]");

    public static final Target TXT_TULAS_M1 =
            Target.the("")
                    .locatedBy("(//div[@class='input-group has-validation']//input)[4]");

    public static final Target TXT_CAJAS_M1 =
            Target.the("")
                    .locatedBy("(//div[@class='input-group has-validation']//input)[5]");

    public static final Target TXT_BOLSAS_M1 =
            Target.the("")
                    .locatedBy("(//div[@class='input-group has-validation']//input)[6]");

    public static final Target TXT_OBSERVACION =
            Target.the("")
                    .locatedBy("(//div[@class='input-group has-validation']//textarea)[1]");

    public static final Target BTN_AGENDAR =
            Target.the("")
                    .locatedBy("//button[@class='ld-btn   ld-btn-primary btn btn-primary']");

    public static final Target LBL_MENSAJE_ADVERTENCIA =
            Target.the("")
                    .locatedBy("//div[@class='fade toast ld-toast error right top show']");
}