package saul.app.autotest.dao;

import org.apache.ibatis.annotations.Param;
import saul.app.autotest.model.CmtbDictionary;
import saul.app.autotest.model.CmtbDictionaryCriteria;

import java.util.List;

public interface CmtbDictionaryMapper {
    int countByExample(CmtbDictionaryCriteria example);

    int deleteByExample(CmtbDictionaryCriteria example);

    int deleteByPrimaryKey(Integer cdId);

    int insert(CmtbDictionary record);

    int insertSelective(CmtbDictionary record);

    List<CmtbDictionary> selectByExample(CmtbDictionaryCriteria example);

    CmtbDictionary selectByPrimaryKey(Integer cdId);

    int updateByExampleSelective(@Param("record") CmtbDictionary record, @Param("example") CmtbDictionaryCriteria example);

    int updateByExample(@Param("record") CmtbDictionary record, @Param("example") CmtbDictionaryCriteria example);

    int updateByPrimaryKeySelective(CmtbDictionary record);

    int updateByPrimaryKey(CmtbDictionary record);
}