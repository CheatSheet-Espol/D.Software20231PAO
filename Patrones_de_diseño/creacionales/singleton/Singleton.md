[Ir al indice](../../PatronesDiseño.md#patrones-de-diseño)

# Singleton
Delimitar a tener una unica instancia de un objeto en nuestro sistema.
Util para presentar un objeto que no vaya a cambiar y para no crear varios objetos y controlar el acceso a recursos compartidos
Sirve para mejorar la performance del sistema
# Partes
SingleObjetc: Un objeto que tiene:
🔺una instancia de si mismo (estatica)
🔺Constructor Privado: Para no tener la posibilidad de crear objetos cuando sea
🔺getInstance(): ESATICO. Si la instancia no existe, la crea   caso contrario la devuelve.
🔺Metodos varios


### Ejemplo:
"Una instancia para conexion a base de datos"