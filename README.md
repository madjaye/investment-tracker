# investment-tracker

Periodically input investments in order to track progress towards goals.

## Project setup

### Prerequisites

- Java 17
- Docker

### Database

Add a `.env` file to the route of the project to store DB credentials. Since this file contains credentials it **should
not** be checked into version control. You may pick any value you wish as your credentials. Contents should resemble:

```
POSTGRES_USER=my-postgres-user
POSTGRES_PASSWORD=mypostgrespassword
```

### Flyway

Add a `flyway.conf` file to the route of the project to store DB URL and credentials. Since this file contains
credentials it **should not** be checked into version control. Please use the `flyway.url` in the example below.
The `flyway.user` and `flyway.password`
should match those present in the `.env` file. See above.

```shell
flyway.url=jdbc:postgresql://localhost:5432/investment-tracker
flyway.user=compose-postgres
flyway.password=myspecialpasswordwhoop
```

## Test

To run tests: `./gradlew test`

To run tests + checkstyle: `gradlew check`

## Build and deploy locally

Run the following command to build, containerise and run the app (and database) locally:

```shell
./gradlew clean deployLocal && ./gradlew cU
```

This will set up the app to run on http://localhost:8080.

## Swagger

Once the app is running locally, you may visit http://localhost:8080/swagger-ui.html to see the swagger API
documentation.