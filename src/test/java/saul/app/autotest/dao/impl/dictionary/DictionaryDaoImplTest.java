package saul.app.autotest.dao.impl.dictionary;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import saul.app.autotest.dao.dictionary.IDictionaryDAO;
import saul.app.autotest.model.CmtbDictionaryCriteria;
import saul.app.autotest.utils.AutotestException;

/**
 * Created by Saul on 22/01/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class DictionaryDaoImplTest {
    @Autowired
    private IDictionaryDAO dictionaryDao;
    @org.junit.Before
    public void setUp() throws Exception {

    }
    @Test
    public void test() {
        System.out.println(dictionaryDao);
        try {
            CmtbDictionaryCriteria cmtbDictionaryCriteria = new CmtbDictionaryCriteria();
            cmtbDictionaryCriteria.createCriteria().andCdCreatetimeIsNull();
            dictionaryDao.ReadAll(cmtbDictionaryCriteria);
        } catch (AutotestException e) {
            e.printStackTrace();
        }
    }
    @org.junit.After
    public void tearDown() throws Exception {

    }

}