FROM eclipse-temurin:23-jdk AS builder

ARG COMPILE_DIR=/code_folder

WORKDIR ${COMPILE_DIR}

# Copy all necessary files for Maven build
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Copy the source code
COPY src src

# Build the project with Maven, skipping the tests
RUN ./mvnw clean package -Dmaven.test.skip=true

# Expose the server port as an environment variable
ENV SERVER_PORT=3000

# Expose the port for external access
EXPOSE ${SERVER_PORT}

# Entrypoint to run the application
ENTRYPOINT ["java",  "-jar", "target/vttp5-ssf-day19l-0.0.1-SNAPSHOT.jar"]

# Stage 2: Production stage
FROM eclipse-temurin:23-jdk

# Argument for the directory where the final JAR will be deployed
ARG DEPLOY_DIR=/APP

# Set the working directory for the final stage
WORKDIR ${DEPLOY_DIR}

# Copy the build JAR file from the build stage to the production stage
COPY --from=builder /code_folder/target/vttp5-ssf-day19l-0.0.1-SNAPSHOT.jar vttp5-day19l.jar

# Expose the server port as an environment variable
ENV SERVER_PORT=3000

# Expose the port for external access
EXPOSE ${SERVER_PORT}

# Entrypoint to run the final applicatiom
ENTRYPOINT ["java", "-jar",  "vttp5-day19l.jar"]
CMD ["--server.port=3000"]


# FROM openjdk:23-jdk-oracle AS compiler

# ARG COMPILE_DIR=/code_folder

# WORKDIR ${COMPILE_DIR}

# COPY pom.xml .
# COPY mvnw .
# COPY mvnw.cmd .
# COPY src src
# COPY .mvn .mvn

# # RUN chmod a+x ./mvnw
# RUN ./mvnw clean package -Dmaven.skip.tests=true

# ENV SERVER_PORT=3000

# EXPOSE ${SERVER_PORT}

# # ENTRYPOINT ./mvnw spring-boot:RUN
# ENTRYPOINT ["java", "-jar", "target/vttp5-ssf-day19l-0.0.1-SNAPSHOT.jar"]

# # stage 2
# FROM openjdk:23-jdk-oracle

# ARG DEPLOY_DIR=/app

# WORKDIR ${DEPLOY_DIR}

# COPY --from=compiler /code_folder/target/vttp5-ssf-day18l-0.0.1-SNAPSHOT.jar vttp5-day19l.jar

# ENV SERVER_PORT=3000

# EXPOSE ${SERVER_PORT}

# # HEALTHCHECK --interval=30s --timeout=30s --start-period=5s --retries=3 CMD curl -s -f http://localhost:3000/demo/health || exit 1

# ENTRYPOINT ["java", "-jar", "vttp5-day19l.jar"]