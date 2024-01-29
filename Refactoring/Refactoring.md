# REFACTORING
Cambiar el diseño o la estructura del codigo sin que afecte al comportamiento externo del mismo.
Es una transformación del código fuente sin alterar el comportamiento
del sistema
"Hacer más eficiente las cosas"
"Que todo siga funcionando igual"
"Añadir comportamiento NO es refactor"

Razones para hacer refactor:
1)Optimizacion:ej: hacer que un algoritmo vaya más rapido
2)Preparacion para mantenimiento a futuro: restructurar en funcion de pensar que luego se van a añadir nuevas funcionalidades y con el refactor será más sencillo mantener la nueva estructura

### Ventajas de refactor

*)Hacer refactorizacion de codigo sistematicamente hacer que el codigo sea más sencillo y elegante
*)Hacer cambios es menos costos.
*)Depurar y entender el codigo tarda menos.
*)Modificar y añadir codigo es más sencillo.



"No aplica en espol..aún"
💡TDD:
T: Hacer los test de lo que espero que haga mi codigo, todos tienen que fallar
D:Escribir el codigo  necesario para que se pasen los test, no tiene que ser el codigo mas eficiente o el mas estructurado, solo tiene que funcionar. Pasar todos los test
D: Ahora que ya están pasados los test, es momento de hacer el refactor, si uno hace que el test falle entonces no está bien hecho el refactor.