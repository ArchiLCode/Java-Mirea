//package practice8.chain;
//
//import com.sun.net.httpserver.Request;
//
//public class ConcreteHandler2 extends Handler {
//    public ConcreteHandler2(Handler nextHandler) {
//        super(nextHandler);
//    }
//
//    @Override
//    public void handleRequest(Request request) {
//        if (request.getType() == "type2") {
//            System.out.println("ConcreteHandler2 handles request of type 2");
//        } else {
//            getNextHandler().handleRequest(request);
//        }
//    }
//}