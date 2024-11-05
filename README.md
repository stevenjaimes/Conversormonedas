Conversor de Monedas 🌎💸

Descripción 📖
Conversor de Monedas es una aplicación en Java que se conecta a la API ExchangeRate-API para obtener tasas de cambio en tiempo real. Permite la conversión de varias divisas, como USD, COP, ARS, y BRL. Este proyecto es ideal para quienes desean una forma rápida y precisa de calcular la conversión de monedas, manteniendo un enfoque en la simplicidad y precisión.

Funcionalidades ✨
Conversión de USD a COP, ARS, y BRL y viceversa.
Conexión a una API para obtener las tasas de cambio actualizadas.
Manejo de errores específicos, como problemas de conexión o URI inválidas.
Redondeo de resultados a dos decimales para una mejor presentación.
Presentación amigable de los resultados en consola.
Requisitos 🛠️
Para ejecutar este proyecto necesitas tener instalado:

Java 11 o superior
Maven para gestionar las dependencias (opcional pero recomendado)
Conexión a internet para conectarse a la API de tasas de cambio.


Instalación 🚀
1- Clona este repositorio:

```bash
git clone https://github.com/stevenjaimes/Conversormonedas.git
```

2- Navega hasta la carpeta del proyecto:

```bash
cd Conversormonedas
```

3- Importa el proyecto en tu IDE favorito o compílalo desde la línea de comandos.

Configuración ⚙️
Este proyecto se conecta a la API ExchangeRate-API, usando una clave de API. Por defecto, la clave de API se establece en el código, pero puedes actualizarla en el archivo ServicioDivisas.java:

```bash
private static final String API_KEY = "TU_API_KEY_AQUI";
```
Reemplaza "TU_API_KEY_AQUI" con tu clave de API.

Uso 📈
Ejecuta el archivo principal Main.java o el método main del proyecto.
Elige una de las opciones del menú para convertir entre las divisas disponibles.
Ingresa el monto que deseas convertir, y el programa te mostrará el resultado.
Ejemplo de salida:
```bash
El valor de 100 [USD] corresponde al valor final de =>> 425000 [COP]
```

Código Ejemplo 🧩
A continuación, un fragmento de código que muestra cómo se conectan las funcionalidades:
// Obtener tasas de cambio de la API
Map<String, Double> tasasCambio = new ServicioDivisas().obtenerTasasDeCambio();

// Conversión de USD a COP
double cantidad = 100;
double result = cantidad * tasasCambio.get("COP");
System.out.printf("El valor de %.2f [USD] corresponde al valor final de =>> %.2f [COP]%n", cantidad, result);


Manejo de Errores 🔍
Este programa incluye manejo de errores para:

URI Inválida: Si la URI es incorrecta, el programa notificará al usuario.
Tiempo de conexión agotado: Notifica si no se pudo establecer conexión con la API.
Respuesta no JSON: Muestra un mensaje si la respuesta de la API no es válida

```bash
catch (HttpConnectTimeoutException e) {
    System.out.println("Error: Tiempo de conexión agotado al intentar conectar con la API.");
} catch (HttpTimeoutException e) {
    System.out.println("Error: Tiempo de espera agotado al recibir la respuesta de la API.");
} catch (IllegalArgumentException e) {
    System.out.println("Error: La URI proporcionada es inválida.");
}
```

Contribuciones 🤝
¡Las contribuciones son bienvenidas! Si deseas contribuir a este proyecto:

Haz un fork del repositorio.
Crea una nueva rama para tu funcionalidad: git checkout -b feature/NuevaFuncionalidad.
Realiza tus cambios y crea un commit: git commit -m 'Añadida nueva funcionalidad'.
Envía tus cambios al repositorio remoto: git push origin feature/NuevaFuncionalidad.
Abre un Pull Request en GitHub.

Licencia 📜
Este proyecto está bajo la licencia MIT. Puedes ver más detalles en el archivo LICENSE.

Contacto 📬
GitHub: @stevenjaimes
LinkedIn: Steven Jaimes
