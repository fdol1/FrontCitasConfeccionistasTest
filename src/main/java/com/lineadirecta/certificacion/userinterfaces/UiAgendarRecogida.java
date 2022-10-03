package com.lineadirecta.certificacion.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class UiAgendarRecogida {

    public static final Target BTN_CALENDARIO =
            Target.the("")
                    .locatedBy("//button[@class='react-date-picker__calendar-button react-date-picker__button']");
    public static final Target BTN_DIA =
            Target.the("")
                    .locatedBy("//button[@class='react-calendar__tile react-calendar__month-view__days__day']/abbr[contains(text(),'{0}')]");
    public static final Target BTN_ENVIAR =
            Target.the("")
                    .locatedBy("//span[contains(text(),'Enviar')]");

    public static final Target LBL_MENSAJE_ERROR =
            Target.the("")
                    .locatedBy("//span[@class='lb-label-text subtitle-1'][contains(text(),'Horario citas de 06:00:00 - 17:00:00')]");

    public static final Target LBL_MENSAJE_EXITOSO =
            Target.the("")
                    .locatedBy("(//span[@class='lb-label-text subtitle-1'])[2]");

    public static final Target LBL_NUMERO_CITA =
            Target.the("")
                    .locatedBy("((//table[@class='table ld-table table table-striped table-bordered table-hover'])[6]//tbody//tr//td)[3]");
}