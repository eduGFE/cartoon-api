- (Deberemos tener maven en nuestro equipo)
- https://maven.apache.org/download.cgi
- docker pull postgres
- Continuamos entrando en el directorio raiz y ejecutando el siguiente comando 
  -   docker-compose up -d
    - (Esto creara la base de datos con la tabla correspondiente)
- Lo primero que tenemos que hacer es ejecutar el comando 
  -    mvn clean install (para poder compilar el proyecto.)
- Despues ejecutamos el .jar:
  -    java -jar cartoon-api-boot/target/cartoon-api-boot-0.0.1-SNAPSHOT.jar
- Una vez hecho esto,  el proyecto leera la info de la api y la cargara en la base de datos del contenedor
- A continuacion deberemos  realizar la siguiente peticion get
-  http://localhost:8080/cartoon/api/v1/cartoons



