package design.chainOfResposibilty.channel1;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Mr_chen
 * @date 2023/1/30
 * @Project algorithm
 **/
@Data
@Builder
public class ProductVO {
    /**
     * 商品SKU，唯一
     */
    private Long skuId;

    /**
     * 商品名称
     */
    private String skuName;

    /**
     * 商品图片路径
     */
    private String Path;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 库存
     */
    private Integer stock;
}
