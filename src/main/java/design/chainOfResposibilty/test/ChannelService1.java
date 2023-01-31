package design.chainOfResposibilty.test;
import com.alibaba.fastjson2.JSON;
import design.chainOfResposibilty.channel1.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @author Mr_chen
 * @date 2023/1/30
 * @Project algorithm
 **/
@Service
public class ChannelService1 {
    /**
     * 使用Spring注入:所有继承了AbstractCheckHandler抽象类的Spring Bean都会注入进来。Map的Key对应Bean的name,Value是name对应相应的Bean
     */
    @Resource
    private Map<String, AbstractCheckHandler> handlerMap;

    public Result createProduct(ProductVO param){
        //参数校验，使用责任链模式
        Result paramCheckResult = this.paramCheck(param);
        return paramCheckResult;
    }
    private  Result paramCheck(ProductVO param) {

        //获取处理器配置：通常配置使用统一配置中心存储，支持动态变更
        ProductCheckHandlerConfig handlerConfig = this.getHandlerConfigFile();

        //获取处理器
        AbstractCheckHandler handler = this.getHandler(handlerConfig);

        //责任链：执行处理器链路
        Result executeChainResult = HandlerClient.executeChain(handler, param);
        if (!executeChainResult.isSuccess()) {
            System.out.println("创建商品 失败...");
            return executeChainResult;
        }
        //处理器链路全部成功
        return Result.success();
    }

    private AbstractCheckHandler getHandler(ProductCheckHandlerConfig handlerConfig) {
        //配置检查：没有配置处理器链路，则不执行校验逻辑
        if (Objects.isNull(handlerConfig)) {
            return null;
        }
        //配置错误
        String handler = handlerConfig.getHandler();
        if (handler == null || handler.isEmpty()) {
            return null;
        }
        //配置了不存在的处理器
        AbstractCheckHandler abstractCheckHandler = handlerMap.get(handlerConfig.getHandler());
        if (Objects.isNull(abstractCheckHandler)) {
            return null;
        }

        //处理器设置配置Config
        abstractCheckHandler.setConfig(handlerConfig);

        //递归设置链路处理器
        abstractCheckHandler.setNextHandler(this.getHandler(handlerConfig.getNext()));

        return abstractCheckHandler;
    }

    private ProductCheckHandlerConfig getHandlerConfigFile() {
        //配置中心存储的配置
        String configJson = "{\"handler\":\"nullValueCheckHandler\",\"down\":true,\"next\":{\"handler\":\"priceCheckHandler\",\"next\":{\"handler\":\"stockCheckHandler\",\"next\":null}}}";
        //转成Config对象
        ProductCheckHandlerConfig handlerConfig = JSON.parseObject(configJson, ProductCheckHandlerConfig.class);
        return handlerConfig;
    }



}
