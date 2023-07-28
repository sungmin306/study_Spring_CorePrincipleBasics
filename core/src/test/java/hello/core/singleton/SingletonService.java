package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); // 자기자신을 내부에 private로 가지고 있음(static)
    // 자기자신을 생성한 후 인스턴스의 참조를 넣어놓는다.

    public static SingletonService getInstance() {
        return instance;  // 참조를 꺼낼 수 있는 놈은 얘밖에없음 더 이상 생성도 못함
    }
    // 생성자를 private으로 선언해서 외부에서 new 키워드를 사용한 객체 생성을 못하게 막는다.
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
