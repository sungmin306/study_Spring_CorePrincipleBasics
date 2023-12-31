package hello.core.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
//       connect();
//       call("초기화 연결 메세지");

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비브 시작 시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + "message = " + message );
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        connect();
//        call("초기화 연결 메세지");
//    }
//
//    @Override
//    public void destroy() throws Exception {
//        disconnect();
//    }



    @PostConstruct
    public void init() {  // 의존관계 호출이 끝나면
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연겲 메세지");

    }
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }


}
