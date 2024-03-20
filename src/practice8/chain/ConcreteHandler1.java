package practice8.chain;

import com.sun.net.httpserver.Request;

//public class ConcreteHandler1 extends Handler {
//    public ConcreteHandler1(Handler nextHandler) {
//        super(nextHandler);
//    }
//
//    @Override
//    public void handleRequest(Request request) {
//        if (request.getType() == "type1") {
//            System.out.println("ConcreteHandler1 handles request of type 1");
//        } else {
//            getNextHandler().handleRequest(request);
//        }
//    }
//}