import com.web.dao.ProblemDAO;
import com.web.dao.SubmitDAO;
import com.web.entity.BasicVo;
import com.web.entity.Problem;
import com.web.entity.Submit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by TongYiMing on 2017/6/1.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:config/spring-MVC.xml"
        ,"classpath:config/spring-mybatis.xml"})
public class SubmitTest {

    @Autowired
    private SubmitDAO submitDAO;

    @Test
    public void saveTest() {

        Submit submit = new Submit(1,2,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        int pos = submitDAO.save(submit);
        System.out.println(pos);
    }
    @Test
    public void saveBatchTest() {

        Submit submit1 = new Submit(1,2,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        Submit submit2 = new Submit(1,2,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        Submit submit3 = new Submit(1,2,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        Submit submit4 = new Submit(1,2,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        Submit submit5 = new Submit(1,2,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        Submit submit6 = new Submit(1,2,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        List<BasicVo> submits = new ArrayList<BasicVo>();
        submits.add(submit1);
        submits.add(submit2);
        submits.add(submit3);
        submits.add(submit4);
        submits.add(submit5);
        submits.add(submit6);

        int pos = submitDAO.saveBatch(submits);
        System.out.println(pos);
    }

    @Test
    public void removeTest(){
        int pos = submitDAO.remove(1);
        System.out.println(pos);
    }

    @Test
    public void removeBatchTest(){
        int a[] = {2,3};
        int pos = submitDAO.removeBatch(a);
        System.out.println(pos);
    }

    @Test
    public void updateTest(){
        Submit submit1 = new Submit(1,12313,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        int pos = submitDAO.update(submit1);
        System.out.println(pos);
    }

    @Test
    public void updateBatch(){
        List<BasicVo> submits = new ArrayList<BasicVo>();
        Submit submit1 = new Submit(1,2,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        Submit submit2 = new Submit(1,2,new Date(),12,23,1,"fsasdasd",1,"adasdasdas",21);
        submits.add(submit1);
        submits.add(submit2);
        int pos = submitDAO.updateBatch(submits);
        System.out.println(pos);
    }

    @Test
    public void get()
    {
        Submit submit=(Submit) submitDAO.getEntityById(4);
        System.out.println(submit.getLanguage()+" "+submit.getCode());
    }

    @Test
    public void countAll()
    {
        int count=submitDAO.countAll();
        System.out.println(count);
    }

}