
# This will be our parent image
# it contains alpine linux and openjdk8
FROM openjdk:alpine

# Add the compiled spring project to this container
ADD /target/*.jar app.jar

#run the app
ENTRYPOINT ["sh", "-c", "java -jar app.jar"]
