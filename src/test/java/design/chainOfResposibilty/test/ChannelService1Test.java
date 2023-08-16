package design.chainOfResposibilty.test;

import design.chainOfResposibilty.channel1.ProductVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author Mr_chen
 * @date 2023/1/30
 * @Project algorithm
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
class ChannelService1Test {
    @Resource
    private ChannelService1 channelService1;

    @Test
    void createProduct() {
        ProductVO param = ProductVO.builder()
                .skuId(null).skuName("华为手机").Path("http://...")
                .price(new BigDecimal(1))
                .stock(1)
                .build();
        System.out.println(channelService1.createProduct(param));

    }
}