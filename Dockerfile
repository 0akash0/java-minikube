# Use a base image with the Java Runtime Environment (JRE)
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Java application JAR file into the container
COPY HelloWorld.class /app

# Bundle your source code into the Docker image
COPY . .

# Expose the port your application will run on
EXPOSE 8001

# Command to run the Java application
CMD ["java", "HelloWorld"]

