package design.chainOfResposibilty.channel1;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Mr_chen
 * @date 2023/1/30
 * @Project algorithm
 **/
@Component
public class PriceCheckHandler extends AbstractCheckHandler{
    @Override
    public Result handle(ProductVO param) {
        System.out.println("价格校验 Handler 开始...");

        //非法价格校验
        boolean illegalPrice =  param.getPrice().compareTo(BigDecimal.ZERO) <= 0;
        if (illegalPrice) {
            return Result.failure(ErrorCode.PARAM_PRICE_ILLEGAL_ERROR);
        }
        //其他校验逻辑...

        System.out.println("价格校验 Handler 通过...");

        //执行下一个处理器
        return super.next(param);
    }

}
