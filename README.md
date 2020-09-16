# **CVDS-Lab5_MCVPrimefaces**


#### Integrantes
+ Eduard Arias
+ Felipe Marin



## **Parte I. - Jugando a ser un cliente HTTP**

1. Utilizar el comando `telnet www.escuelaing.edu.co 80` para comenzar una conexión TCP/IP.
2. Revisar el protocolo de transferencia HTTP.
	+ Comando: `GET <Dominio>/<Recurso> HTTP/<1.1|1.0>`
3. Revise el resultado obtenido. ¿Qué codigo de error sale?, revise el significado del mismo en la lista de códigos de estado HTTP.
	+ El resultado es:

	![./img/telnet1.PNG](./img/telnet1.PNG)

	+ El error significa que el recurso existe en la máquina pero que la URI utilizada es incorrecta.
4. ¿Qué otros códigos de error existen?, ¿En qué caso se manejarán?
	+ Existen los siguientes códigos de manera general:

	```
	1xx Informational response
	2xx Success
	3xx Redirection
	4xx Client errors
	5xx Server errors
	```

	+ Los errores de tipo 4xx y 3xx se pueden manejar en la petición o en la máquina cliente. Los errores de servidor (5xx) usualmente están fueran de alcance.
5. Realice una nueva conexión con telnet, esta vez a:
	+ Host: www.httpbin.org
	+ Puerto: 80
	+ Versión HTTP: 1.1

	![./img/telnet2.PNG](./img/telnet2.PNG)

6. ¿Cuál es la diferencia entre los verbos GET y POST? ¿Qué otros tipos de peticiones existen?
	+ La diferencia entre GET y POST es que POST oculta los datos al enviarlos, mientras que GET muestra las peticiones en texto plano.
	+ Las peticiones HTTP son:
		* GET: solicita una representación de un recurso específico. Las peticiones que usan el método GET sólo deben recuperar datos.
		* HEAD: pide una respuesta idéntica a la de una petición GET, pero sin el cuerpo de la respuesta.
		* POST: se utiliza para enviar una entidad a un recurso en específico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.
		* PUT: reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición.
		* DELETE: borra un recurso en específico.
		* CONNECT: establece un túnel hacia el servidor identificado por el recurso.
		* OPTIONS: es utilizado para describir las opciones de comunicación para el recurso de destino.
		* TRACE: realiza una prueba de bucle de retorno de mensaje a lo largo de la ruta al recurso de destino.
		* PATCH: es utilizado para aplicar modificaciones parciales a un recurso.
7. Utilizar ``curl [-v | -i]`. ¿Cuáles son las diferencias con los diferentes parámetros?
	+ Los resultados están en [curl1][1] y [curl2][2]
	+ La diferencia entre -i y -v es que `curl -i` muestra los protocoloes de cabecera usados en la petición.


## **Parte II. - Haciendo una aplicación Web dinámica a bajo nivel**
1. Para la creación del proyecto con el arquetipo 'webapp', se utilizó:
	```mvn archetype:generate -DgroupId=com.primefaces.web -DartifactId=Primefaces -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false```

2. El resultado de ejecutar `mvn tomcat7:run` y abrir la dirección *http://localhost:8080/helloServlet* es este:
	
![./img/helloServlet1.PNG](./img/helloServlet1.PNG)


3. El resultado de la petición **GET** es:

![./img/helloServlet2.PNG](./img/helloServlet2.PNG)


4. La dirección [json][3] nos muestra lo que parece ser un generador *Lorem-Ipsum* (texto aleatorio). Los números cambian el parámetro llamado 'id'.

5. Para la ejecución del servidor tomcat, definimos nuestro servlet *OutServlet* que responde a la url */servlet*

6. Ejecuciones:

![./img/ourServlet1.PNG](./img/ourServlet1.PNG)
![./img/ourServlet2.PNG](./img/ourServlet2.PNG)
![./img/ourServlet3.PNG](./img/ourServlet3.PNG)
![./img/ourServlet4.PNG](./img/ourServlet4.PNG)












[1]: ./curl1.txt
[2]: ./curl2.txt
[3]: https://jsonplaceholder.typicode.com/todos/1