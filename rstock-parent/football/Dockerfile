#stage 1
# Базовый образ, содержащий среду Java времени выполнения
FROM eclipse-temurin:21-alpine as build

# Добавить информацию о владельце
LABEL maintainer="Liza Perederiy"

VOLUME /tmp

# Файл jar приложения
ARG JAR_FILE

# Добавить файл jar приложения в контейнер с именем app.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8081

# Распаковать jar file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

#stage 2
# Та же среда Java времени выполнения
FROM eclipse-temurin:17-jdk-alpine

# Добавить том, ссылающийся на каталог /tmp
VOLUME /tmp

#Скопировать распакованное приложение в новый контейнер
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Запустить приложение
ENTRYPOINT ["java","-cp","app:app/lib/*","com.dolsoft.football.FootballApplication"]
