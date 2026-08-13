# p-14054-2

`sb_2024_02_22`를 현재 코프링 기준으로 다시 만드는 강의용 후속 저장소입니다.

## 기준 버전

- Java 25 LTS
- Kotlin 2.4.10
- Spring Boot 4.1.0
- Gradle 9.5.0
- MySQL + Redis Session

운영 프로필은 `mysql-1-service`, `redis-1-service`를 사용하며 비밀번호는 환경변수로만 받습니다.

## 로컬 확인

```bash
./gradlew test
./gradlew bootRun
curl http://localhost:8080/
```
