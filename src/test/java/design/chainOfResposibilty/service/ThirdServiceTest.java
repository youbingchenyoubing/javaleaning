package design.chainOfResposibilty.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

/**
 * @author Mr_chen
 * @date 2023/8/16
 * @Project javaleaning
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
class ThirdServiceTest {
    @MockBean
    private ThirdService thirdService;

    @Test
    public void makeMoney() {
        Long expectResult = 100L;
        given(thirdService.getMoney()).willReturn(expectResult);
    }
}