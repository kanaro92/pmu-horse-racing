# pmu-horse-racing

## Description
Microservice responsable du cycle de vie d’une course et de ses partants (chevaux)

## Requirements
- Java 21
- Docker
- Docker Compose

## Execution de l'application

1. Build app:
    ```sh
    ./mvnw clean install
    ```

2. Lancer l'app en utilisant Docker Compose:
    ```sh
    docker-compose up --build
    ```

3. Accèss API:
    - Créer course: `POST /api/v1/pmu-horse-racing/courses`
    - Example payload:
        ```json
        {
            "date": "2023-01-29",
            "numero": 1,
            "nom": "Prix d'Amérique",
            "partants": [
                {
                    "numero": 1,
                    "nom": "HORSY DREAM"
                },
                {
                    "numero": 2,
                    "nom": "HOOKER BERRY"
                },
                {
                    "numero": 3,
                    "nom": "FLAMME DU GOUTIER"
                },
                {
                    "numero": 4,
                    "nom": "IDAO DE TILLARD"
                }
            ]
        }
        ```

## Lancer les Tests
```sh
./mvnw test
