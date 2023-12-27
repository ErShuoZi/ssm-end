package service;

import com.bean.Furn;
import com.service.FurnService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class FurnServiceTest {
    private ApplicationContext ioc;
//    从spring容器中，获取的是FurnService接口类型对象，也是代理对象
    private FurnService furnService;
    @Before
    public void init() {
        ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        furnService = ioc.getBean(FurnService.class);
        System.out.println("haha ----" + furnService.getClass());
    }

    @Test
    public void save() {
        Furn furn = new Furn(null, "北欧风格沙发~", "顺平家居~",
                new BigDecimal(180), 666, 7,
                "assets/images/product-image/1.jpg");
        furnService.save(furn);
        System.out.println("save ok ~");
    }

    @Test
    public void findAll() {
        List<Furn> all = furnService.findAll();
        for (Furn furn : all) {
            System.out.println(furn);
        }
    }

    @Test
    public void update() {
        Furn furn = new Furn();
        furn.setId(30);
        furn.setName("hahah");
        furn.setMaker("大象");
        furn.setImgPath(null);
        furnService.update(furn);
        System.out.println("修改成功");
    }

    @Test
    public void delete() {
        furnService.delete(1);
        System.out.println("删除成功");
    }


    @Test
    public void findByCondition() {
        List<Furn> furns = furnService.findByCondition("灯");
        System.out.println(furns);

    }

}
