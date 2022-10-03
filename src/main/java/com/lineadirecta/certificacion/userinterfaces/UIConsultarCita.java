package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UIConsultarCita {

    public static final Target TXT_USUARIO =
            Target.the("Campo para ingresar el usuario")
                    .locatedBy("//input[@placeholder = 'Digite su usuario']");

    public static final Target LBL_ELEMENTO_INFORMATIVO =
            Target.the("Campo informativo en pantalla")
                    .locatedBy("(//span[@class='lb-label-text body-1']//b)[1]");

    public static final Target BTN_EDITAR =
            Target.the("Boton para editar informacion")
                    .locatedBy("//button[@class='ld-btn   ld-btn-primary btn btn-primary']");

    public static final Target BTN_GUARDAR =
            Target.the("Boton para guardar la edicion")
                    .locatedBy("//span[contains(text(),'Guardar')]");

    public static final Target BTN_CONFIRMAR_Y_GUARDAR =
            Target.the("Boton para confirmar el cambio")
                    .locatedBy("//button[@class = 'ld-btn   ld-btn-primary btn btn-primary']//span[contains(text(),'Guardar')]");

    public static final Target LBL_MENSAJE_CITA_EDITADA =
            Target.the("Mensaje de cita editada")
                    .locatedBy("//span[contains(text(),'Cita actualizada exitosamente')]");

    public static final Target LBL_CANTIDAD_TOTAL =
            Target.the("")
                    .locatedBy("(//input[@class='ld-field-control form-control'])[1]");

    public static final Target LBL_TULAS =
            Target.the("")
                    .locatedBy("(//input[@class='ld-field-control form-control'])[4]");

    public static final Target LBL_CAJAS =
            Target.the("")
                    .locatedBy("(//input[@class='ld-field-control form-control'])[5]");

    public static final Target LBL_BOLSAS_ =
            Target.the("")
                    .locatedBy("(//input[@class='ld-field-control form-control'])[6]");

    public static final Target LBL_TULAS_VACIAS =
            Target.the("")
                    .locatedBy("(//input[@class='ld-field-control form-control'])[7]");
}