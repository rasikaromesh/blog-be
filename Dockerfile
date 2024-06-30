FROM maven:3.9.8 AS build
#RUN apt-get update && \
#    apt-get install -y maven && \
#    rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

RUN mv target/blog-be-0.0.1-SNAPSHOT.jar blog-be-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "blog-be-0.0.1-SNAPSHOT.jar"]