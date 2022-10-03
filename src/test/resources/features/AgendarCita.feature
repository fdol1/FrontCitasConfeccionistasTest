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

  @agendarCita
  Scenario Outline: Agendar una entrega en un horario no permitido
    Given Que el confeccionista requiere buscar la orden
      | numeroOrden   |
      | <numeroOrden> |
    When Ingresa los datos de la entrega para la cita
      | cantidadMod1   | observacion   | tula   | caja   | bolsa   | mes   | dia   |
      | <cantidadMod1> | <observacion> | <tula> | <caja> | <bolsa> | <mes> | <dia> |
    Then Podra visualizar el mensaje de:Enviado con éxito
    Examples:
      | numeroOrden | cantidadMod1 | observacion                     | tula | caja | bolsa | mes        | dia |
      | 5100571136  | 2            | Esto es una prueba automatizada | 1    | 0    | 0     | septiembre | 9   |


  @agendarEntregaSinDatos
  Scenario Outline: Agendar una entrega, Caso errado
    Given Que el confeccionista requiere buscar la orden
      | numeroOrden   |
      | <numeroOrden> |
    When Agenda la cita sin ingresar datos
    Then Podra visualizar el mensaje de error:El total a entregar y las unidades de manipulación deben ser mayores a cero.
    Examples:
      | numeroOrden |
      | 5100571136  |