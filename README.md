## Instrucciones

1. Deberemos tener Maven en nuestro equipo. Puedes descargarlo [aquí](https://maven.apache.org/download.cgi).

2. Ejecutar el siguiente comando para obtener la imagen de Docker de PostgreSQL:

    ```bash
    docker pull postgres
    ```

3. Continuar entrando en el directorio raíz y ejecutando el siguiente comando para iniciar la base de datos:

    ```bash
    docker-compose up -d
    ```

   Esto creará la base de datos con la tabla correspondiente.

4. Ejecutar el siguiente comando para compilar el proyecto:

    ```bash
    mvn clean install
    ```

5. Después, ejecutar el siguiente comando para ejecutar el JAR:

    ```bash
    java -jar cartoon-api-boot/target/cartoon-api-boot-0.0.1-SNAPSHOT.jar
    ```

6. Una vez hecho esto, el proyecto leerá la información de la API y la cargará en la base de datos del contenedor.

7. Realizar la siguiente petición GET:

    ```
    http://localhost:8080/cartoon/api/v1/character/cartoons
    ```

<details>
  <summary>Mostrar JSON de ejemplo</summary>

  ```json
  [
    {
      "name": "Rick Sanchez",
      "status": "Alive"
    },
    {
      "name": "Morty Smith",
      "status": "Alive"
    },
    {
      "name": "Summer Smith",
      "status": "Alive"
    },
    {
      "name": "Beth Smith",
      "status": "Alive"
    },
    {
      "name": "Jerry Smith",
      "status": "Alive"
    },
    {
      "name": "Beta-Seven",
      "status": "Alive"
    }
  ]
</details>