##Escuela Colombiana de Ingeniería
###Arquitecturas de Software

###Laboratorio - Metaprogramación y Reflexividad

####Nota: Ejercicio basado en una rama del proyecto [NanoHTTPD](https://github.com/NanoHttpd/nanohttpd)

En este ejercicio se va a desarrollar una prueba de concepto muy simple, de cómo funcionan frameworks MVC como [Vaadin](https://vaadin.com/home), los cuales generan -de forma dinámica- vistas Web a partir de especificaciones(metadatos) hechos en clases Java.

_NOTA 1: debe abrir una cuenta en GitLab o en BitBucket, crear un repositorio privado, compartirlo con su compañero (si lo tiene) y en el mismo ir llevando el avance del laboratorio. NO USE GITHUB, ya que dejaría sus avances públicos._

_NOTA 2: el uso de GIT NO ES OPCIONAL, el proyecto entregado debe mostrar evidencia de su uso con los históricos de los commits._



###Parte 1.


1. Clone este proyecto, y abra el proyecto Maven que está en la ruta nanohttpd/webserver.
2. Revise la documentación del [API Reflection de Java](https://docs.oracle.com/javase/tutorial/reflect/class/index.html).
3. Con lo anterior, modifique el programa SimpleMetadataReader para que, con el nombre de clase enviado como argumento (asignado a la variable className):
	* Haga introspección de dicha clase, e imprima por pantalla los nombres de los métodos disponibles.
	* Instancie la clase, e invoque sólo aquellos métodos que retornen un objeto String. Imprima por pantalla dicha cadena.
4. Pruebe el funcionamiento de lo antes hecho ejecutando SimpleMetadataReader, pasando como argumento la clase SampleViewMetadata (la cual ya está dentro de los fuentes del proyecto):

	```bash
mvn exec:java -Dexec.mainClass="edu.eci.arsw.viewgen.models.reader.SimpleMetadataReader" -Dexec.args="edu.eci.arsw.viewgen.models.SampleViewMetadata"
```

###Parte 2.

1. Ajuste el programa anterior para que, cuando imprima los nombres de los métodos, indique cuales tienen la anotación @RelativePosition, y qué valor tienen sus propiedades. Puede revisar las características de esta anotación revisando los fuentes de edu.eci.arsw.viewgen.annotations.RelativePosition.
2. Verifique los resultados de la misma manera.

###Parte 3.
Ahora, va a modificar la clase com.example.App, en particular su método 'serve'. Esta clase es parte de la implementación de un servidor HTTP básico, y su objetivo es lograr que en el mismo se interprete y se publique una vista HTML a partir de los metadatos provistos en una clase Java.

1. Verifique el funcionamiento actual del programa (DESDE LA CARPETA webserver) con:

	```bash
mvn exec:java -Dexec.mainClass="com.example.App" -Dexec.args="argumento1"
```
2. Modifique la clase App para que, en lugar de mostrar el 'Hola mundo!' dinámicamente interprete los metadatos provistos por la clase dada como argumento y genere una vista HTML que corresponda a los mismos. Por ahora, haga que sólo se muestre el contenido generado por aquellos métodos que tengan la anotación @RelativePosition, de manera que:
	* Se agregue en la vista el texto generado por el método que tiene la anotación, enmarcado en un recuadro con el ancho, alto y tipo de recuadros descritos como propiedad de dicha anotación [ver ejemplo de posicionamiento relativo con CSS](http://www.w3schools.com/css/tryit.asp?filename=trycss_position_absolute).

3. Verifique que la vista sea generada correctamente.

###Parte 4.

1. Cree dos nuevas anotaciones de tipo AbsolutePosition y FixedPosition, con la cual se puedan marcar aquellas propiedades de la clase que se mostrarán en un recuadro con posición absoluta/fija [(ver ejemplo de w3schools)](http://www.w3schools.com/css/css_positioning.asp), y defina para éstas, las propiedades que sean relevantes.
2. Agregue la funcionalidad de mostrar [listas de elementos HTML](http://www.w3schools.com/html/html_lists.asp) para aquellos métodos que retornen Listas de Cadenas, y que tengan las anotaciones @AbsolutePosition o @RelativePosition.
3. Modifique la clase que tiene los metadatos (SampleViewMetadata) para que ahora incluya algunas propiedades de tipo Cadena o Lista de Cadena, y use las anotaciones @AbsolutePosition/@FixedPosition.
4. Verifique la funcionalidad.

