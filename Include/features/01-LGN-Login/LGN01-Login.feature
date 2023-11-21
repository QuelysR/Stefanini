Feature: Acceso a la a pagina

  Background: 
    Given Como un usuario

  @loginHC
  Scenario: Acceder a la pagina con credenciales validas
    When Ingreso mi nombre y apellido
    And Ingreso mi email
    And Ingreso mi password
    Then Verifico registro de usuario creado

  @login_nombre_Incompleto
  Scenario: Acceder a la pagina con nombre Incompleto
    When Ingreso mi nombre icorrecto
    And Ingreso mi email
    And Ingreso mi password
    Then Verifico error en nombre

  @login_email_incorrecto
  Scenario: Acceder a la pagina con email incorrecto
    When Ingreso mi nombre y apellido
    And Ingreso mi email incorrecto
    And Ingreso mi password
    Then Verifico error en el email

  @login_password_incorrecto
  Scenario: Acceder a la pagina con password incorrecto
    When Ingreso mi nombre y apellido
    And Ingreso mi email
    And Ingreso mi password incorrecto
    Then Verifico error en el password
