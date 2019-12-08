Feature:  Busqueda de recetario Tottus IE

  Scenario: Como usuario quiero realizar una busqueda en google IE
    Given Dado que estoy en el portal de Google IE
    When Escribo tottus sucursales en el buscador IE
    And Presiono enter IE
    Then Me muestra el resultado de la busqueda IE

  Scenario: Como usuario quiero visualizar las opciones que me de tottus  para ingresar al Nataniel IE
    Given Dado que estoy en la pag de resultados de Google IE
    When Doy clic a el enlace de Tottus nataniel Cox IE
    Then Me muestra en google maps la opcion para ingresar IE

  Scenario: Como usuario quiero ingresar al portal de Tottus desde google maps IE
    Given Dado que estoy en la ficha de nataniel Cox de Maps IE
    When Doy clic al boton sitio web IE
    Then Ingreso al portal de tottus IE

  Scenario: Como usuario quiero ingresar al menu de recetas en tottus IE
    Given Dado que estoy en la pagina de tottus IE
    When Doy clic al boton de recetas IE
    Then Ingreso al portal de recetas de tottus en una nueva ventana IE

  Scenario: Como usuario quiero ingresar a las recetas de nivel alto en tottus IE
    Given Dado que estoy en la pagina de recetas de tottus IE
    When Doy clic al boton de nivel alto y voy al enlace de la receta de  rollitos de canela IE
    Then Estoy en la receta Corona de rollitos de canela IE

  Scenario: Como usuario quiero validar que la receta tiene azucar rubia y canela IE
    Given Dado que estoy en la receta de rollitos e canela IE
    When Busco si existe canela y azucar rubia IE
    And Cierro Receta IE
    Then Me quedo en la pagina principal de tottus IE