# Mower-aut API

## Requirements

For building and running the application you need:

- [JDK 17](https://openjdk.org/projects/jdk/17/)
- [Gradle 7.5.1](https://docs.gradle.org/7.5.1/release-notes.html)
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.seatcode.moweraut.MowerAutApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
./gradlew bootRun
```

## Endpoints

### Creates a mower.
### Request

`POST Mower`

    curl --location --request POST 'http://localhost:8080/moweraut'

    --header 'Content-Type: application/json' \
    --data-raw '
    {
        "position": {
            "axisX": 0,
            "axisY": 0,
            "orientation": "N"
        }
    }'


### Response

    Status: 201 CREATED
    Connection: close
    Content-Type: application/json

        {
            "id": 104,
            "position": {
                "axisX": 0,
                "axisY": 0,
                "orientation": "N"
            }
        }

## Update mower position.

### Request

`PUT /moweraut`

    curl --location --request PUT 'http://localhost:8080/moweraut'
    --header 'Content-Type: application/json' \
    --data-raw '
    {
        "plateau": {
            "axisX": 5,
            "axisY": 5
        },
        "mowerInputs": [
            {
                "mowerId": 453,
                "mowerPosition": {
                    "axisX": 1,
                    "axisY": 2,
                    "orientation": "N"
                },
                "mowerCommand": "LMLMLMLMM"    
            },
            {
                "mowerId": 104,
                "mowerPosition": {
                    "axisX": 3,
                    "axisY": 3,
                    "orientation": "E"
                },
                "mowerCommand": "MMRMMRMRRM"    
            }         
        ]
    }'

### Response

    Status: 200 OK
    Connection: close
    Content-Type: application/json

    {
        "mowers": [
            {
                "axisX": 1,
                "axisY": 3,
                "orientation": "N"
            },
            {
                "axisX": 5,
                "axisY": 1,
                "orientation": "E"
            }
        ]
    }

