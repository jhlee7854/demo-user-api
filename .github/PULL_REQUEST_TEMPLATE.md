## Summary
- 

## Testing
- 실행 명령: `./gradlew test --tests '*UserControllerSecurityTests' -q`
- 실패 지점: Gradle plugin/dependency resolution 단계
- 실패 원인: 컨테이너의 외부 저장소 접근 제약 또는 프록시 정책
- 미실행 범위: 테스트 클래스 로딩/실행 이전 중단

## Evidence Log (3~5 lines)
```text
<실행 로그에서 핵심 실패 스택 3~5줄을 여기에 첨부>
```

> 주의: `all tests passing` 같은 단정 문구는 사용하지 않습니다.
