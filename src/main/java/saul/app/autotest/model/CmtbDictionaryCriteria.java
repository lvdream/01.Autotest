package saul.app.autotest.model;

import saul.app.autotest.utils.Page;

import java.util.ArrayList;
import java.util.List;

public class CmtbDictionaryCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public CmtbDictionaryCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andCdIdIsNull() {
            addCriterion("cd_id is null");
            return (Criteria) this;
        }

        public Criteria andCdIdIsNotNull() {
            addCriterion("cd_id is not null");
            return (Criteria) this;
        }

        public Criteria andCdIdEqualTo(Integer value) {
            addCriterion("cd_id =", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdNotEqualTo(Integer value) {
            addCriterion("cd_id <>", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdGreaterThan(Integer value) {
            addCriterion("cd_id >", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cd_id >=", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdLessThan(Integer value) {
            addCriterion("cd_id <", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdLessThanOrEqualTo(Integer value) {
            addCriterion("cd_id <=", value, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdIn(List<Integer> values) {
            addCriterion("cd_id in", values, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdNotIn(List<Integer> values) {
            addCriterion("cd_id not in", values, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdBetween(Integer value1, Integer value2) {
            addCriterion("cd_id between", value1, value2, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cd_id not between", value1, value2, "cdId");
            return (Criteria) this;
        }

        public Criteria andCdNameIsNull() {
            addCriterion("cd_name is null");
            return (Criteria) this;
        }

        public Criteria andCdNameIsNotNull() {
            addCriterion("cd_name is not null");
            return (Criteria) this;
        }

        public Criteria andCdNameEqualTo(String value) {
            addCriterion("cd_name =", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameNotEqualTo(String value) {
            addCriterion("cd_name <>", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameGreaterThan(String value) {
            addCriterion("cd_name >", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameGreaterThanOrEqualTo(String value) {
            addCriterion("cd_name >=", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameLessThan(String value) {
            addCriterion("cd_name <", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameLessThanOrEqualTo(String value) {
            addCriterion("cd_name <=", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameLike(String value) {
            addCriterion("cd_name like", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameNotLike(String value) {
            addCriterion("cd_name not like", value, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameIn(List<String> values) {
            addCriterion("cd_name in", values, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameNotIn(List<String> values) {
            addCriterion("cd_name not in", values, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameBetween(String value1, String value2) {
            addCriterion("cd_name between", value1, value2, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdNameNotBetween(String value1, String value2) {
            addCriterion("cd_name not between", value1, value2, "cdName");
            return (Criteria) this;
        }

        public Criteria andCdTypeIsNull() {
            addCriterion("cd_type is null");
            return (Criteria) this;
        }

        public Criteria andCdTypeIsNotNull() {
            addCriterion("cd_type is not null");
            return (Criteria) this;
        }

        public Criteria andCdTypeEqualTo(String value) {
            addCriterion("cd_type =", value, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeNotEqualTo(String value) {
            addCriterion("cd_type <>", value, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeGreaterThan(String value) {
            addCriterion("cd_type >", value, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeGreaterThanOrEqualTo(String value) {
            addCriterion("cd_type >=", value, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeLessThan(String value) {
            addCriterion("cd_type <", value, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeLessThanOrEqualTo(String value) {
            addCriterion("cd_type <=", value, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeLike(String value) {
            addCriterion("cd_type like", value, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeNotLike(String value) {
            addCriterion("cd_type not like", value, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeIn(List<String> values) {
            addCriterion("cd_type in", values, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeNotIn(List<String> values) {
            addCriterion("cd_type not in", values, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeBetween(String value1, String value2) {
            addCriterion("cd_type between", value1, value2, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdTypeNotBetween(String value1, String value2) {
            addCriterion("cd_type not between", value1, value2, "cdType");
            return (Criteria) this;
        }

        public Criteria andCdFIdsIsNull() {
            addCriterion("cd_f_ids is null");
            return (Criteria) this;
        }

        public Criteria andCdFIdsIsNotNull() {
            addCriterion("cd_f_ids is not null");
            return (Criteria) this;
        }

        public Criteria andCdFIdsEqualTo(String value) {
            addCriterion("cd_f_ids =", value, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsNotEqualTo(String value) {
            addCriterion("cd_f_ids <>", value, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsGreaterThan(String value) {
            addCriterion("cd_f_ids >", value, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsGreaterThanOrEqualTo(String value) {
            addCriterion("cd_f_ids >=", value, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsLessThan(String value) {
            addCriterion("cd_f_ids <", value, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsLessThanOrEqualTo(String value) {
            addCriterion("cd_f_ids <=", value, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsLike(String value) {
            addCriterion("cd_f_ids like", value, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsNotLike(String value) {
            addCriterion("cd_f_ids not like", value, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsIn(List<String> values) {
            addCriterion("cd_f_ids in", values, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsNotIn(List<String> values) {
            addCriterion("cd_f_ids not in", values, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsBetween(String value1, String value2) {
            addCriterion("cd_f_ids between", value1, value2, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdFIdsNotBetween(String value1, String value2) {
            addCriterion("cd_f_ids not between", value1, value2, "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdValueIsNull() {
            addCriterion("cd_value is null");
            return (Criteria) this;
        }

        public Criteria andCdValueIsNotNull() {
            addCriterion("cd_value is not null");
            return (Criteria) this;
        }

        public Criteria andCdValueEqualTo(String value) {
            addCriterion("cd_value =", value, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueNotEqualTo(String value) {
            addCriterion("cd_value <>", value, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueGreaterThan(String value) {
            addCriterion("cd_value >", value, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueGreaterThanOrEqualTo(String value) {
            addCriterion("cd_value >=", value, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueLessThan(String value) {
            addCriterion("cd_value <", value, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueLessThanOrEqualTo(String value) {
            addCriterion("cd_value <=", value, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueLike(String value) {
            addCriterion("cd_value like", value, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueNotLike(String value) {
            addCriterion("cd_value not like", value, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueIn(List<String> values) {
            addCriterion("cd_value in", values, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueNotIn(List<String> values) {
            addCriterion("cd_value not in", values, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueBetween(String value1, String value2) {
            addCriterion("cd_value between", value1, value2, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdValueNotBetween(String value1, String value2) {
            addCriterion("cd_value not between", value1, value2, "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdTextIsNull() {
            addCriterion("cd_text is null");
            return (Criteria) this;
        }

        public Criteria andCdTextIsNotNull() {
            addCriterion("cd_text is not null");
            return (Criteria) this;
        }

        public Criteria andCdTextEqualTo(String value) {
            addCriterion("cd_text =", value, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextNotEqualTo(String value) {
            addCriterion("cd_text <>", value, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextGreaterThan(String value) {
            addCriterion("cd_text >", value, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextGreaterThanOrEqualTo(String value) {
            addCriterion("cd_text >=", value, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextLessThan(String value) {
            addCriterion("cd_text <", value, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextLessThanOrEqualTo(String value) {
            addCriterion("cd_text <=", value, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextLike(String value) {
            addCriterion("cd_text like", value, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextNotLike(String value) {
            addCriterion("cd_text not like", value, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextIn(List<String> values) {
            addCriterion("cd_text in", values, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextNotIn(List<String> values) {
            addCriterion("cd_text not in", values, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextBetween(String value1, String value2) {
            addCriterion("cd_text between", value1, value2, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdTextNotBetween(String value1, String value2) {
            addCriterion("cd_text not between", value1, value2, "cdText");
            return (Criteria) this;
        }

        public Criteria andCdStatusIsNull() {
            addCriterion("cd_status is null");
            return (Criteria) this;
        }

        public Criteria andCdStatusIsNotNull() {
            addCriterion("cd_status is not null");
            return (Criteria) this;
        }

        public Criteria andCdStatusEqualTo(String value) {
            addCriterion("cd_status =", value, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusNotEqualTo(String value) {
            addCriterion("cd_status <>", value, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusGreaterThan(String value) {
            addCriterion("cd_status >", value, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusGreaterThanOrEqualTo(String value) {
            addCriterion("cd_status >=", value, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusLessThan(String value) {
            addCriterion("cd_status <", value, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusLessThanOrEqualTo(String value) {
            addCriterion("cd_status <=", value, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusLike(String value) {
            addCriterion("cd_status like", value, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusNotLike(String value) {
            addCriterion("cd_status not like", value, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusIn(List<String> values) {
            addCriterion("cd_status in", values, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusNotIn(List<String> values) {
            addCriterion("cd_status not in", values, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusBetween(String value1, String value2) {
            addCriterion("cd_status between", value1, value2, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdStatusNotBetween(String value1, String value2) {
            addCriterion("cd_status not between", value1, value2, "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeIsNull() {
            addCriterion("cd_createtime is null");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeIsNotNull() {
            addCriterion("cd_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeEqualTo(String value) {
            addCriterion("cd_createtime =", value, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeNotEqualTo(String value) {
            addCriterion("cd_createtime <>", value, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeGreaterThan(String value) {
            addCriterion("cd_createtime >", value, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("cd_createtime >=", value, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeLessThan(String value) {
            addCriterion("cd_createtime <", value, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("cd_createtime <=", value, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeLike(String value) {
            addCriterion("cd_createtime like", value, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeNotLike(String value) {
            addCriterion("cd_createtime not like", value, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeIn(List<String> values) {
            addCriterion("cd_createtime in", values, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeNotIn(List<String> values) {
            addCriterion("cd_createtime not in", values, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeBetween(String value1, String value2) {
            addCriterion("cd_createtime between", value1, value2, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeNotBetween(String value1, String value2) {
            addCriterion("cd_createtime not between", value1, value2, "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserIsNull() {
            addCriterion("cd_createuser is null");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserIsNotNull() {
            addCriterion("cd_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserEqualTo(String value) {
            addCriterion("cd_createuser =", value, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserNotEqualTo(String value) {
            addCriterion("cd_createuser <>", value, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserGreaterThan(String value) {
            addCriterion("cd_createuser >", value, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("cd_createuser >=", value, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserLessThan(String value) {
            addCriterion("cd_createuser <", value, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserLessThanOrEqualTo(String value) {
            addCriterion("cd_createuser <=", value, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserLike(String value) {
            addCriterion("cd_createuser like", value, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserNotLike(String value) {
            addCriterion("cd_createuser not like", value, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserIn(List<String> values) {
            addCriterion("cd_createuser in", values, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserNotIn(List<String> values) {
            addCriterion("cd_createuser not in", values, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserBetween(String value1, String value2) {
            addCriterion("cd_createuser between", value1, value2, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserNotBetween(String value1, String value2) {
            addCriterion("cd_createuser not between", value1, value2, "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeIsNull() {
            addCriterion("cd_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeIsNotNull() {
            addCriterion("cd_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeEqualTo(String value) {
            addCriterion("cd_updatetime =", value, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeNotEqualTo(String value) {
            addCriterion("cd_updatetime <>", value, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeGreaterThan(String value) {
            addCriterion("cd_updatetime >", value, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("cd_updatetime >=", value, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeLessThan(String value) {
            addCriterion("cd_updatetime <", value, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("cd_updatetime <=", value, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeLike(String value) {
            addCriterion("cd_updatetime like", value, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeNotLike(String value) {
            addCriterion("cd_updatetime not like", value, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeIn(List<String> values) {
            addCriterion("cd_updatetime in", values, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeNotIn(List<String> values) {
            addCriterion("cd_updatetime not in", values, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeBetween(String value1, String value2) {
            addCriterion("cd_updatetime between", value1, value2, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("cd_updatetime not between", value1, value2, "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserIsNull() {
            addCriterion("cd_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserIsNotNull() {
            addCriterion("cd_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserEqualTo(String value) {
            addCriterion("cd_updateuser =", value, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserNotEqualTo(String value) {
            addCriterion("cd_updateuser <>", value, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserGreaterThan(String value) {
            addCriterion("cd_updateuser >", value, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("cd_updateuser >=", value, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserLessThan(String value) {
            addCriterion("cd_updateuser <", value, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("cd_updateuser <=", value, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserLike(String value) {
            addCriterion("cd_updateuser like", value, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserNotLike(String value) {
            addCriterion("cd_updateuser not like", value, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserIn(List<String> values) {
            addCriterion("cd_updateuser in", values, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserNotIn(List<String> values) {
            addCriterion("cd_updateuser not in", values, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserBetween(String value1, String value2) {
            addCriterion("cd_updateuser between", value1, value2, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserNotBetween(String value1, String value2) {
            addCriterion("cd_updateuser not between", value1, value2, "cdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andCdNameLikeInsensitive(String value) {
            addCriterion("upper(cd_name) like", value.toUpperCase(), "cdName");
            return (Criteria) this;
        }

        public Criteria andCdTypeLikeInsensitive(String value) {
            addCriterion("upper(cd_type) like", value.toUpperCase(), "cdType");
            return (Criteria) this;
        }

        public Criteria andCdFIdsLikeInsensitive(String value) {
            addCriterion("upper(cd_f_ids) like", value.toUpperCase(), "cdFIds");
            return (Criteria) this;
        }

        public Criteria andCdValueLikeInsensitive(String value) {
            addCriterion("upper(cd_value) like", value.toUpperCase(), "cdValue");
            return (Criteria) this;
        }

        public Criteria andCdTextLikeInsensitive(String value) {
            addCriterion("upper(cd_text) like", value.toUpperCase(), "cdText");
            return (Criteria) this;
        }

        public Criteria andCdStatusLikeInsensitive(String value) {
            addCriterion("upper(cd_status) like", value.toUpperCase(), "cdStatus");
            return (Criteria) this;
        }

        public Criteria andCdCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(cd_createtime) like", value.toUpperCase(), "cdCreatetime");
            return (Criteria) this;
        }

        public Criteria andCdCreateuserLikeInsensitive(String value) {
            addCriterion("upper(cd_createuser) like", value.toUpperCase(), "cdCreateuser");
            return (Criteria) this;
        }

        public Criteria andCdUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(cd_updatetime) like", value.toUpperCase(), "cdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andCdUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(cd_updateuser) like", value.toUpperCase(), "cdUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }
    }
}