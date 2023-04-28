# java-practice
다양한 프로그래밍 연습을 위한 저장소

## 요구사항 1 - 클래스 정보 출력
- [x] src/test/java > next.reflection > ReflectionTest의 showClass() 메소드를 구현해 Question 클래스의 모든 필드, 생성자, 메소드에 대한 정보를 출력한다.

## 요구사항 2 - test로 시작하는 메소드 실행
- [x] Junit3에서는 test로 시작하는 메소드를 자동으로 실행한다. 이와 같이 Junit3Test 클래스에서 test로 시작하는 메소드만 Java Reflection을 활용해 실행하도록 구현한다.
  - 구현은 `src/test/java` > `next.reflection` > `Junit3Runner` 클래스의 `runner()` 메소드에 한다.
