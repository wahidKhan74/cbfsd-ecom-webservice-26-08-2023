FROM eclipse-temurin:17-jdk-alpine
COPY ./target/*.jar app.jar
CMD ["java" ,"-jar","app.jar"]
RUN echo "jenkins ALL=(ALL) NOPASSWD: ALL" >> /etc/sudoers