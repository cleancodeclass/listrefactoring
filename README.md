# listrefactoring

1. Code Smell 찾아 보기
  - if조건문안의 부정형
  - Magic Number : 의미가 모호한 문자열이나 상수
  - 복잡한 if 조건문
  - 복잡한 구문
  - 여러 기능을 수행하는 함수
  
2. 다음의 방법으로 리팩토링을 수행합니다.
  - 개발팀명을 정합니다. (예.독수리)
  - 개발PL은 개발팀 브랜치를 생성합니다.(예. 독수리_Refactoring_YYYYMMDD)
  - 개발리더 역할자는 다음의 Issue를 등록합니다.
   . 팀명_Magic Number 제거(예.독수리_Magic Number 제거)
   . 팀명_if문 부정형을 긍정형으로 변경
   . 팀명_if문안의 메서드 추출
  - refactoringYYYYMMDD 브랜치를 개인 Repository로 Fork합니다.
  - 개발자1 팀명_Magic Number 제거 feature를 생성합니다.
