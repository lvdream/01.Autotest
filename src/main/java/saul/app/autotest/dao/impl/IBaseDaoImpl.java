package saul.app.autotest.dao.impl;

import org.springframework.stereotype.Repository;
import saul.app.autotest.dao.IBaseDao;
import saul.app.autotest.dao.IBaseMapper;
import saul.app.autotest.utils.AutotestException;
import saul.app.autotest.utils.Page;

import java.util.List;

/**
 * Created by Saul on 22/01/2017.
 * 通用DAO实现
 *
 * @param <T>
 * @param <F>
 */
@SuppressWarnings("unused")
@Repository("baseDao")
public abstract class IBaseDaoImpl<T, F> implements IBaseDao<T, F> {

    private IBaseMapper<T, F> iBaseMapper;
    private final int returncode = -1;



    public IBaseMapper<T, F> getiBaseMapper() {
        return iBaseMapper;
    }

    public void setiBaseMapper(IBaseMapper<T, F> iBaseMapper) {
        this.iBaseMapper = iBaseMapper;
    }

    @Override
    public int save(T object) throws AutotestException {
        if (object != null) {
            return iBaseMapper.insert(object);
        }
        return returncode;
    }

    @Override
    public int update(T object) throws AutotestException {
        if (object != null) {
            return iBaseMapper.updateByPrimaryKey(object);
        }
        return returncode;
    }

    @Override
    public int savewithoutNull(T object) throws AutotestException {
        if (object != null) {
            return iBaseMapper.insertSelective(object);
        }
        return returncode;
    }

    @Override
    public int updatewithoutNull(T object, F find) throws AutotestException {
        if (object != null) {
            return iBaseMapper.updateByExampleSelective(object, find);
        }
        return returncode;
    }

    @Override
    public int delete(F object) throws AutotestException {
        if (object != null) {
            return iBaseMapper.deleteByExample(object);
        }
        return returncode;
    }

    @Override
    public T ReadSingle(F exampleCriteria) throws AutotestException {
        if (exampleCriteria != null) {
            return iBaseMapper.selectByExample(exampleCriteria).get(0);
        }
        return null;
    }

    @Override
    public List ReadAll(F exampleCriteria) throws AutotestException {
        if (exampleCriteria != null) {
            return iBaseMapper.selectByExample(exampleCriteria);
        }
        return null;
    }

    @Override
    public List ReadAllByOrder(F exampleCriteria) throws AutotestException {
        if (exampleCriteria != null) {
            return iBaseMapper.selectByExample(exampleCriteria);
        }
        return null;
    }

    @Override
    public List ReadByProperty(F exampleCriteria) throws AutotestException {
        if (exampleCriteria != null) {
            return iBaseMapper.selectByExample(exampleCriteria);
        }
        return null;
    }

    @Override
    public List ReadByPropertyList(F exampleCriteria) throws AutotestException {
        if (exampleCriteria != null) {
            return iBaseMapper.selectByExample(exampleCriteria);
        }
        return null;
    }

    @Override
    public List ReadLimitedByOrder(F exampleCriteria, Page page) throws AutotestException {
        if (exampleCriteria != null) {
            return iBaseMapper.selectByExample(exampleCriteria);
        }
        return null;
    }


    @Override
    public int ReadCount(F exampleCriteria) throws AutotestException {
        if (exampleCriteria != null) {
            return iBaseMapper.countByExample(exampleCriteria);
        }
        return returncode;
    }

    @Override
    public T ReadByID(Integer id) throws AutotestException {
        if (id > 0) {
            return iBaseMapper.selectByPrimaryKey(id);
        }
        return null;
    }
}
