package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)  // TYPE은 클래스 래밸에 붙음

@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {

}
