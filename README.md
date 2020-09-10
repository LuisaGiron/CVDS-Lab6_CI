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