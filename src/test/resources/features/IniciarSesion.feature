# Autor: lpinedau@choucairtesting.com

@EjecutarTodo
Feature: Realizar el inicio de sesion en el portal web
  Como confeccionista quiero iniciar sesion por medio de
  una autenticacion con mis credenciales


  @IniciarSesion
  Scenario Outline: Intento de inicio de sesion, caso exitoso
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario   | clave   |
      | <usuario> | <clave> |
    Then Podra verificar su numbre de usuario:LAIS MILENA TATIS MADRID
    Examples:
      | usuario  | clave    |
      | 32143181 | 32143181 |

  @IniciarSesionCredencialesFalsas
  Scenario Outline: Intento de inicio de sesion, caso fallido
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario   | clave   |
      | <usuario> | <clave> |
    Then Podra ver un mensaje:Usuario y contraseña incorrectos
    Examples:
      | usuario  | clave    |
      | 32143100 | 32143100 |

  @IniciarSesionConPerfilGestorDeParos
  Scenario Outline: Intento de inicio de sesion, Perfil Gestor de paros
    Given que el Gestor de paros quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario   | clave   |
      | <usuario> | <clave> |
    Then Podra ver el menu principal el mensaje:Confecciones
    Examples:
      | usuario  | clave    |
      | 32143181 | 32143181 |