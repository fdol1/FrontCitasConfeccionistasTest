# Autor: lpinedau@choucairtesting.com

@EjecutarTodo
Feature: El confeccionista requiere ingresar a la platafor
  y agendar una cita para la entrega de los productos terminados o daños
  que tenga bajo su responsabilidad

  Background: Se Inicia sesion en la app
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario   | clave    |
      | 900686800 | dgyaqrig |

  @consultarCitaAgendada
  Scenario Outline: Consultar una entrega agendada, Caso exitoso
    Given Que el confeccionista requiere consultar las citas
    Then Podra verificar el nit y documento de compra
      | nit   |
      | <nit> |
    Examples:
      | nit       |
      | 900686800 |

  @editarCitaAgendada
  Scenario Outline: Editar una cita agendada, Caso exitoso
    Given Que el confeccionista requiere consultar las citas
    When Edita la cita seleccionada
      | cantidadConfirmada   |
      | <cantidadConfirmada> |
    Then Se podra verificar el mensaje:Cita actualizada exitosamente
    Examples:
      | cantidadConfirmada |
      | 2                  |