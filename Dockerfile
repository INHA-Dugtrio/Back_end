# 빌드 단계
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# 프로젝트 소스 복사
COPY . .

# Gradle 빌드 실행
RUN ./gradlew bootJar

# 런타임 단계
FROM eclipse-temurin:17-jre
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=builder /app/build/libs/Dugtrio-0.0.1-SNAPSHOT.jar app.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
