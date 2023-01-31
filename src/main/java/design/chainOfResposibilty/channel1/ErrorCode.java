package design.chainOfResposibilty.channel1;

import lombok.Getter;

/**
 * @author Mr_chen
 * @date 2023/1/30
 * @Project algorithm
 **/
@Getter
public enum ErrorCode {
    PARAM_NULL_ERROR(100,"非空"),
    PARAM_SKU_NULL_ERROR(200,"id非空"),
    PARAM_PRICE_NULL_ERROR(300,"价格非空"),
    PARAM_STOCK_NULL_ERROR(400,"stock 非空"),
    PARAM_PRICE_ILLEGAL_ERROR(500,"价格非法"),
    PARAM_STOCK_ILLEGAL_ERROR(600,"Stock非法")
    ;


    /**
     * 错误码
     */
    private int code;
    /**
     * 错误消息
     */
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
