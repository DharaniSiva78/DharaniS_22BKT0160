# BFHL Java – Spring Boot Autoposter 

This app follows the assignment:

- On startup, POST to generate a webhook & get an `accessToken`.
- Store the final SQL query locally.
- POST the final SQL to the returned webhook URL (or fallback test endpoint) using the JWT token from step 1.

#Software you need

- JDK 17+
- Maven 3.9+
- Git (to push to GitHub)
- An IDE like IntelliJ IDEA / VS Code / Spring Tool Suite

## How to run

```bash
# from this folder
mvn -q -DskipTests spring-boot:run
```

Or build a jar:

```bash
mvn -q -DskipTests clean package
java -jar target/bfh-java-0.0.1-SNAPSHOT.jar
```

## Configure your details


```yaml
bfh:
  name: "Dharani S"
  reg-no: "22BKT0160"
  email: "dharanisiva701@gmail.com"
  solution:
    final-query: "YOUR_FINAL_SQL_QUERY_HERE"
```


## Notes

- The app uses **WebClient**.
- No controllers/REST endpoints are exposed; everything runs on startup.
- Authorization header is set to the returned `accessToken` **as-is** (no Bearer prefix), per the paper.
- If the `webhook` URL is missing from the response, the app falls back to `https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA`.
