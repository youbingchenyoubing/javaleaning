package design.chainOfResposibilty.channel1;

/**
 * @author Mr_chen
 * @date 2023/1/30
 * @Project algorithm
 **/
public class HandlerClient {
    public static Result executeChain(AbstractCheckHandler handler, ProductVO param) {
        //执行处理器
        Result handlerResult = handler.handle(param);
        if (!handlerResult.isSuccess()) {
            System.out.println("HandlerClient 责任链执行失败返回：" +handlerResult.getMessage());
            return handlerResult;
        }
        return Result.success();
    }
}
