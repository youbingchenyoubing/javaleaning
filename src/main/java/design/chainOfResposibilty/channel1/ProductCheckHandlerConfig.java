package design.chainOfResposibilty.channel1;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Mr_chen
 * @date 2023/1/30
 * @Project algorithm
 **/
@AllArgsConstructor
@Data
public class ProductCheckHandlerConfig {
    /**
     * 处理器Bean名称
     */
    private String handler;
    /**
     * 下一个处理器
     */
    private ProductCheckHandlerConfig next;
    /**
     * 是否降级
     */
    private Boolean down = Boolean.FALSE;
}
