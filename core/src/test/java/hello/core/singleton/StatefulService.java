package hello.core.singleton;

public class StatefulService {

    private int price; // 상태를 유지하는 필드

    public void order(String name , int price) {
        System.out.println("name = " + name + "price = " + price);
        this.price = price; // 여기가 문제!
        //return price; // -> 이런식으로 처리르 해야하암
    }

    public int getPrice() {
        return price;
    }


}
