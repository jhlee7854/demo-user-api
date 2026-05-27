# demo-user-api

## Java Toolchain

이 프로젝트는 Gradle toolchain의 Java 버전을 `javaVersion` property로 동적으로 설정합니다.
기본값은 Java 25입니다.

- 기본 실행(=Java 25):

```bash
./gradlew test
```

- 명시적으로 Java 25 검증:

```bash
./gradlew test -PjavaVersion=25
```

- 다른 버전으로 검증(예: Java 21):

```bash
./gradlew test -PjavaVersion=21
```
