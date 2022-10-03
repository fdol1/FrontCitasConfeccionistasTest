package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UiMenuPrincipal {

    public static final Target LBL_NOMBRE_USUARIO =
            Target.the("")
                    .locatedBy("//span[contains(text(), '{0}')]");

    public static final Target LBL_CONFECCIONES =
            Target.the("")
                    .locatedBy("//h2[contains(text(),'Confecciones')]");

    public static final Target BTN_CONSULTAR_CITAS =
            Target.the("")
                    .locatedBy("//span[@class='lb-label-text subtitle-3'][contains(text(), 'Consultar Citas')]");

    public static final Target BTN_AGENDAR_CITAS =
            Target.the("Boton para ingresar a angedar citas para entregas de")
                    .locatedBy("//span[@class='lb-label-text subtitle-3'][contains(text(), 'Agendar Citas')]");
}