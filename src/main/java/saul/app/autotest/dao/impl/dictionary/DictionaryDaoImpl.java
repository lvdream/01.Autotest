package saul.app.autotest.dao.impl.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import saul.app.autotest.dao.dictionary.CmtbDictionaryMapper;
import saul.app.autotest.dao.dictionary.IDictionaryDAO;
import saul.app.autotest.dao.impl.IBaseDaoImpl;
import saul.app.autotest.model.CmtbDictionary;
import saul.app.autotest.model.CmtbDictionaryCriteria;

/**
 * Created by Saul on 22/01/2017.
 */
@Repository("dictionaryDao")
public class DictionaryDaoImpl extends IBaseDaoImpl<CmtbDictionary, CmtbDictionaryCriteria> implements IDictionaryDAO {
    @Autowired
    public void setiBaseMapper(CmtbDictionaryMapper cmtbDictionary) {
        super.setiBaseMapper(cmtbDictionary);
    }

}
