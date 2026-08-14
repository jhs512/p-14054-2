# p-14054-2

`sb_2024_02_22`를 현재 코프링 기준으로 다시 만드는 강의용 후속 저장소입니다.

## 기준 버전

- Java 25 LTS
- Kotlin 2.4.10
- Spring Boot 4.1.0
- Gradle 9.5.0
- MySQL + Redis Session

운영 프로필은 `mysql-1-service`, `redis-1-service`를 사용하며 비밀번호는 환경변수로만 받습니다.

`main`에 push하면 GitHub Actions가 테스트한 뒤 GHCR에 `sha-<commit>`과 `latest` 태그를 발행합니다.

Actuator의 readiness/liveness probe와 Spring Boot graceful shutdown을 활성화합니다.

최초 배포는 `kubernetes/p-14054-2.yaml`의 Secret 값을 교체한 뒤 `kubectl apply`로 수행합니다.

GitHub Actions secret `KUBE_CONFIG`와 variable `ENABLE_K8S_DEPLOY=true`를 등록하면 이미지 발행 후 `kubectl set image`와 rollout 확인까지 자동으로 수행합니다.

## 운영 구성

- 비밀번호와 kubeconfig를 소스나 이미지에 넣지 않습니다.
- Deployment는 `maxUnavailable: 0`, `maxSurge: 1`로 두 파드를 롤링 업데이트합니다.
- GHCR 이미지는 변경 불가능한 `sha-<commit>` 태그로 배포하고 `latest`는 편의용으로만 발행합니다.
- `/gen`은 세 노드에 마운트된 `/share/p-14054-2/gen`과 연결합니다.

## Kubernetes 최초 배포

1. GHCR 패키지를 읽을 `github-registry-secret`을 생성합니다.
2. `kubernetes/p-14054-2.yaml`의 `CHANGE_ME`를 실제 값으로 교체하거나 별도 Secret을 먼저 만듭니다.
3. `kubectl apply -f kubernetes/p-14054-2.yaml`을 실행합니다.
4. GitHub Actions secret `KUBE_CONFIG`를 등록합니다.
5. GitHub Actions variable `ENABLE_K8S_DEPLOY`를 `true`로 등록합니다.

`/` 응답의 `hostname`을 새로고침하면 요청을 처리한 파드를 확인할 수 있습니다.

## 로컬 확인

```bash
./gradlew test
./gradlew bootRun
curl http://localhost:8080/
```
