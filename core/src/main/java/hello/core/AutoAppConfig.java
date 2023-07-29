package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration // 설정정보
// 자동으로 스프링 빈 등록
@ComponentScan( // 참고로 어노테이션은 메타정보임
        //지정하지 않으면 해당 클래스가 있는 패키지 부터 시작(이친구부터 하위 패키지까지)
        basePackages = "hello.core.member", // 모든 클래스를 다 뒤지는건 너무 오래걸리기때문에 basePackages를 통해서 패키지 서치 시작점을 지정할 수 있음
        basePackageClasses = AutoAppConfig.class, // AutoAppConfig가 있는 클래스에 패키지부터 시작
    excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //Configuration 어노테이션 사용한 부분도 자동으로 빈으로 등록되기때문에 위 코드를 사용해서 기존에 만들었건거 등록 안되게끔 방지함
)
public class AutoAppConfig {

}
