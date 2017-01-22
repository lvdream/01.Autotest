package saul.app.autotest.dao.dictionary;

import org.springframework.stereotype.Component;
import saul.app.autotest.dao.IBaseMapper;
import saul.app.autotest.model.CmtbDictionary;
import saul.app.autotest.model.CmtbDictionaryCriteria;
@Component("cmtbDictionary")
public interface CmtbDictionaryMapper extends IBaseMapper<CmtbDictionary, CmtbDictionaryCriteria> {
}