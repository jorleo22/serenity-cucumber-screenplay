@actual
Feature: Iniciar Sesion

  Scenario: Inicio de sesion con credenciales validas
    Given que estoy en la pagina de login
    When ingreso los datos de usuario y password
    Then veo el titulo de compra de libros