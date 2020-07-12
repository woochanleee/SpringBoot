package com.woochanleee.boardcrud;

import com.woochanleee.boardcrud.listener.StartListener;
import com.woochanleee.boardcrud.listener.StartedListener;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication; // SpringApplication 객체는 Spring 어플리케이션을 편리하게 구동하기 위한 클래스
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화를 위해 Application에서 @EnableJpaAuditing 어노테이션을 추가해준다.
@SpringBootApplication // 한번에 Spring Boot Application을 실행할수 있는 어노테이션
public class BoardCrudApplication {

    //	public static void main(String[] args) throws ClassNotFoundException { // 3
    public static void main(String[] args) {
        // 1번째 방법
        // SpringApplication.run(BoardCrudApplication.class, args);
        // args는 command line argument라고 프로세르를 실행할때 전달하는 인자인데 국룰로 넣어준다.

        // 2번째 방법
        /*
            내부 코드를 뜯어보면 SpringApplication의 static run 메서드는
            [overloading] return run(new Class<?>[] { primarySource }, args);
            [overloading] return new SpringApplication(primarySources).run(args);
            처럼 이루어져 있는데 1번째 방법과 똑같은 기능을 수행한다.
        */
        /*
            Class.class 는 자바에서 사용되는 클래스들에 대한 구조를 가지고 있는 Class 타입을 리턴한다.
            클래스의 구조 자체를 하나의 클래스로 표현해놓은 클래스 이다.
            Class.forName("패키지 전체 경로") or 클래스이름.class 로 둘다 가능하다.
        */
        // SpringApplication app = new SpringApplication(Class.forName("com.woochanleee.boardcrud.BoardCrudApplication")); // 3 주석으로 교체해야 함
        SpringApplication app = new SpringApplication(BoardCrudApplication.class);

        app.addListeners(new StartListener(), new StartedListener()); // 리스너 등록
        app.setBannerMode(Banner.Mode.OFF); // Customizing SpringApplication, 배너 끄기

        app.run(args);
    }
}
