#language: es
@testfeal
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items

  @test
  Escenario: Iniciar sesión
    Dado que me encuentro en la página de login de linio
    Cuando inicio sesión con las credenciales email: "Sumagiar@hotmail.com" y contraseña: "12345/*67"
    Y hago clic en el boton ingresar
      Entonces valido que estoy en la pagina
    Y también valido que  exista un titulo "Tu producto se agregó al carrito"