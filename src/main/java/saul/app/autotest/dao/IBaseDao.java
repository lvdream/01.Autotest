package saul.app.autotest.dao;

import saul.app.autotest.utils.AutotestException;
import saul.app.autotest.utils.Page;

import java.util.List;

/**
 * 定义泛型DAO对象,其他接口可以直接继承该对象
 * Created by Saul on 21/01/2017.
 *
 * @param <T> 泛型对象
 * @param <F> 查询条件对象
 */
@SuppressWarnings({"MybatisMapperInXmlInspection", "unused"})
public interface IBaseDao<T, F> {
    /**
     * 保存对象
     *
     * @param object 实体对象
     * @throws AutotestException 项目异常
     */
    int save(T object) throws AutotestException;

    /**
     * 更新对象
     *
     * @param object 实体对象
     * @throws AutotestException 项目异常
     */
    int update(T object) throws AutotestException;

    /**
     * 保存对象,空的属性不进行插入
     *
     * @param object 实体对象
     * @throws AutotestException 项目异常
     */
    int savewithoutNull(T object) throws AutotestException;

    /**
     * 更新对象,空的属性不经更新
     *
     * @param object 实体对象
     * @param find   查找对象
     * @return
     * @throws AutotestException 项目异常
     */
    int updatewithoutNull(T object, F find) throws AutotestException;

    /**
     * 删除对象
     *
     * @param object 查找对象
     * @throws AutotestException 项目异常
     */
    int delete(F object) throws AutotestException;

    /**
     * 获取单个对象
     *
     * @param id 序号对象
     * @return
     * @throws AutotestException 项目异常
     */
    T ReadByID(Integer id) throws AutotestException;

    /**
     * 获取全部对象
     *
     * @param exampleCriteria 查询条件对象
     * @throws AutotestException 项目异常
     */
    List ReadAll(F exampleCriteria) throws AutotestException;

    /**
     * @param exampleCriteria 查询条件对象
     * @throws AutotestException 项目异常
     */
    List ReadAllByOrder(F exampleCriteria) throws AutotestException;

    /**
     * 依据单独属性,获取对象,不分页
     *
     * @param exampleCriteria 查询条件对象
     * @throws AutotestException 项目异常
     */
    List ReadByProperty(F exampleCriteria) throws AutotestException;

    /**
     * 依据单独属性,获取对象,不分页
     *
     * @param exampleCriteria 查询条件对象
     * @throws AutotestException 项目异常
     */
    List ReadByPropertyList(F exampleCriteria) throws AutotestException;

    /**
     * 依据单独属性,获取对象,分页
     *
     * @param exampleCriteria 查询条件对象
     * @param page            分页对象
     * @throws AutotestException 项目异常
     */
    List ReadLimitedByOrder(F exampleCriteria, Page page) throws AutotestException;

    /**
     * 依据属性,获取单独对象
     *
     * @param exampleCriteria
     * @throws AutotestException 项目异常
     * @return
     */
    T ReadSingle(F exampleCriteria) throws AutotestException;

    /**
     * 依据条件,获取统计的条数
     *
     * @param exampleCriteria 查询条件对象
     * @throws AutotestException 项目异常
     */
    int ReadCount(F exampleCriteria) throws AutotestException;
}
