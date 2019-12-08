Feature: Busqueda de recetario Tottus

   Scenario: Como usuario quiero realizar una busqueda en google
    Given Dado que estoy en el portal de Google
    When Escribo tottus sucursales en el buscador
    And Presiono enter
    Then Me muestra el resultado de la busqueda


  Scenario: Como usuario quiero visualizar las opciones que me de tottus  para ingresar al Nataniel
    Given Dado que estoy en la pag de resultados de Google
    When Doy clic a el enlace de Tottus nataniel Cox
    Then Me muestra en google maps la opcion para ingresar


  Scenario: Como usuario quiero ingresar al portal de Tottus desde google maps
    Given Dado que estoy en la ficha de nataniel Cox de Maps
    When Doy clic al boton sitio web
    Then Ingreso al portal de tottus

  Scenario: Como usuario quiero ingresar al menu de recetas en tottus
    Given Dado que estoy en la pagina de tottus
    When Doy clic al boton de recetas
    Then Ingreso al portal de recetas de tottus en una nueva ventana

  Scenario: Como usuario quiero ingresar a las recetas de nivel alto en tottus
    Given Dado que estoy en la pagina de recetas de tottus
    When Doy clic al boton de nivel alto y voy al enlace de la receta de  rollitos de canela
    Then Estoy en la receta Corona de rollitos de canela

  Scenario: Como usuario quiero validar que la receta tiene azucar rubia y canela
    Given Dado que estoy en la receta de rollitos e canela
    When Busco si existe canela y azucar rubia
    And Cierro Receta
    Then Me quedo en la pagina principal de tottus

