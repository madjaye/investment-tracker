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

To run tests + checkstyle: `./gradlew check`

## Build and deploy locally

Run the following command to build, containerise and run the app (and database) locally:

```shell
./gradlew clean deployLocal && ./gradlew cU
```

This will set up the app to run on http://localhost:8080.

It will also run Sonarqube on http://localhost:9000.

## Swagger

Once the app is running locally, you may visit http://localhost:8080/swagger-ui.html to see the swagger API
documentation.

## Sonarqube

You can run `./gradlew cU` to get Sonarqube to run at http://localhost:9000 via docker-compose. Once up and running
visit the url and create a new project. Define a project name e.g. `Investment Tracker`. This will automatically
populate for you a project key e.g. `Investment-Tracker`. Then generate a login token.

You should then set your global gradle properties accordingly:

`~/.gradle/gradle.properties`:

```shell
systemProp.sonar.projectKey=Investment-Tracker
systemProp.sonar.login=yourlogintokengoeshere
```

You can then run `./gradlew sonarqube` to run static code analysis. Once complete the SonarQube UI will update with the
results.