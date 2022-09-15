#language: en
@testfeature
Feature: Linio Web
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items

  Scenario: Login a Linio
    Given estoy en en login
    When ingreso con el usuario "jeanmistic08@gmail.com"
    And ingreso la clave "#Persona16JB*"
    And clic en Iniciar Sesion
    Then que el nombre de mi usuario "Jaen" figure

  Scenario: Agregar producto a carrito
    Given estoy en la url
    When doy click en Productos Internacionales
    And selecciono el primero producto
    And agregar al carrito
    Then debe mostrar un span con mensaje "Tu producto se agrego al carrito"