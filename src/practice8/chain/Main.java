package practice8.chain;

import com.sun.net.httpserver.Request;

public class Main {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);
        Handler handler3 = new ConcreteHandler3(handler2);
        Request request1 = new Request("type1");
        Request request2 = new Request("type2");
        Request request3 = new Request("type3");
        handler3.handleRequest(request1);
        handler3.handleRequest(request2);
        handler3.handleRequest(request3);
    }
}
