FROM openjdk:17
FROM mysql:8.0.41
MAINTAINER addankilingababu@gmail.com
copy target/SBRESTEmployeeCrud-1.0.jar /usr/app/
WORKDIR /usr/app/
ENTRYPOINT ["java","-jar","SBRESTEmployeeCrud-1.0.jar"]
