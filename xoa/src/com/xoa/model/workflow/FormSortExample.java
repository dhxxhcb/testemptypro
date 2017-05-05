package com.xoa.model.workflow;

import java.util.ArrayList;
import java.util.List;

public class FormSortExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FormSortExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
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

        public Criteria andSortIdIsNull() {
            addCriterion("SORT_ID is null");
            return (Criteria) this;
        }

        public Criteria andSortIdIsNotNull() {
            addCriterion("SORT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSortIdEqualTo(Integer value) {
            addCriterion("SORT_ID =", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotEqualTo(Integer value) {
            addCriterion("SORT_ID <>", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThan(Integer value) {
            addCriterion("SORT_ID >", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT_ID >=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThan(Integer value) {
            addCriterion("SORT_ID <", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdLessThanOrEqualTo(Integer value) {
            addCriterion("SORT_ID <=", value, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdIn(List<Integer> values) {
            addCriterion("SORT_ID in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotIn(List<Integer> values) {
            addCriterion("SORT_ID not in", values, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdBetween(Integer value1, Integer value2) {
            addCriterion("SORT_ID between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortIdNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT_ID not between", value1, value2, "sortId");
            return (Criteria) this;
        }

        public Criteria andSortNoIsNull() {
            addCriterion("SORT_NO is null");
            return (Criteria) this;
        }

        public Criteria andSortNoIsNotNull() {
            addCriterion("SORT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSortNoEqualTo(Integer value) {
            addCriterion("SORT_NO =", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoNotEqualTo(Integer value) {
            addCriterion("SORT_NO <>", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoGreaterThan(Integer value) {
            addCriterion("SORT_NO >", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT_NO >=", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoLessThan(Integer value) {
            addCriterion("SORT_NO <", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoLessThanOrEqualTo(Integer value) {
            addCriterion("SORT_NO <=", value, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoIn(List<Integer> values) {
            addCriterion("SORT_NO in", values, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoNotIn(List<Integer> values) {
            addCriterion("SORT_NO not in", values, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoBetween(Integer value1, Integer value2) {
            addCriterion("SORT_NO between", value1, value2, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNoNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT_NO not between", value1, value2, "sortNo");
            return (Criteria) this;
        }

        public Criteria andSortNameIsNull() {
            addCriterion("SORT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSortNameIsNotNull() {
            addCriterion("SORT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSortNameEqualTo(String value) {
            addCriterion("SORT_NAME =", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotEqualTo(String value) {
            addCriterion("SORT_NAME <>", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameGreaterThan(String value) {
            addCriterion("SORT_NAME >", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameGreaterThanOrEqualTo(String value) {
            addCriterion("SORT_NAME >=", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameLessThan(String value) {
            addCriterion("SORT_NAME <", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameLessThanOrEqualTo(String value) {
            addCriterion("SORT_NAME <=", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameLike(String value) {
            addCriterion("SORT_NAME like", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotLike(String value) {
            addCriterion("SORT_NAME not like", value, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameIn(List<String> values) {
            addCriterion("SORT_NAME in", values, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotIn(List<String> values) {
            addCriterion("SORT_NAME not in", values, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameBetween(String value1, String value2) {
            addCriterion("SORT_NAME between", value1, value2, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortNameNotBetween(String value1, String value2) {
            addCriterion("SORT_NAME not between", value1, value2, "sortName");
            return (Criteria) this;
        }

        public Criteria andSortParentIsNull() {
            addCriterion("SORT_PARENT is null");
            return (Criteria) this;
        }

        public Criteria andSortParentIsNotNull() {
            addCriterion("SORT_PARENT is not null");
            return (Criteria) this;
        }

        public Criteria andSortParentEqualTo(Integer value) {
            addCriterion("SORT_PARENT =", value, "sortParent");
            return (Criteria) this;
        }

        public Criteria andSortParentNotEqualTo(Integer value) {
            addCriterion("SORT_PARENT <>", value, "sortParent");
            return (Criteria) this;
        }

        public Criteria andSortParentGreaterThan(Integer value) {
            addCriterion("SORT_PARENT >", value, "sortParent");
            return (Criteria) this;
        }

        public Criteria andSortParentGreaterThanOrEqualTo(Integer value) {
            addCriterion("SORT_PARENT >=", value, "sortParent");
            return (Criteria) this;
        }

        public Criteria andSortParentLessThan(Integer value) {
            addCriterion("SORT_PARENT <", value, "sortParent");
            return (Criteria) this;
        }

        public Criteria andSortParentLessThanOrEqualTo(Integer value) {
            addCriterion("SORT_PARENT <=", value, "sortParent");
            return (Criteria) this;
        }

        public Criteria andSortParentIn(List<Integer> values) {
            addCriterion("SORT_PARENT in", values, "sortParent");
            return (Criteria) this;
        }

        public Criteria andSortParentNotIn(List<Integer> values) {
            addCriterion("SORT_PARENT not in", values, "sortParent");
            return (Criteria) this;
        }

        public Criteria andSortParentBetween(Integer value1, Integer value2) {
            addCriterion("SORT_PARENT between", value1, value2, "sortParent");
            return (Criteria) this;
        }

        public Criteria andSortParentNotBetween(Integer value1, Integer value2) {
            addCriterion("SORT_PARENT not between", value1, value2, "sortParent");
            return (Criteria) this;
        }

        public Criteria andHaveChildIsNull() {
            addCriterion("HAVE_CHILD is null");
            return (Criteria) this;
        }

        public Criteria andHaveChildIsNotNull() {
            addCriterion("HAVE_CHILD is not null");
            return (Criteria) this;
        }

        public Criteria andHaveChildEqualTo(String value) {
            addCriterion("HAVE_CHILD =", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildNotEqualTo(String value) {
            addCriterion("HAVE_CHILD <>", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildGreaterThan(String value) {
            addCriterion("HAVE_CHILD >", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildGreaterThanOrEqualTo(String value) {
            addCriterion("HAVE_CHILD >=", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildLessThan(String value) {
            addCriterion("HAVE_CHILD <", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildLessThanOrEqualTo(String value) {
            addCriterion("HAVE_CHILD <=", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildLike(String value) {
            addCriterion("HAVE_CHILD like", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildNotLike(String value) {
            addCriterion("HAVE_CHILD not like", value, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildIn(List<String> values) {
            addCriterion("HAVE_CHILD in", values, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildNotIn(List<String> values) {
            addCriterion("HAVE_CHILD not in", values, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildBetween(String value1, String value2) {
            addCriterion("HAVE_CHILD between", value1, value2, "haveChild");
            return (Criteria) this;
        }

        public Criteria andHaveChildNotBetween(String value1, String value2) {
            addCriterion("HAVE_CHILD not between", value1, value2, "haveChild");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNull() {
            addCriterion("DEPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andDeptIdIsNotNull() {
            addCriterion("DEPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDeptIdEqualTo(Integer value) {
            addCriterion("DEPT_ID =", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotEqualTo(Integer value) {
            addCriterion("DEPT_ID <>", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThan(Integer value) {
            addCriterion("DEPT_ID >", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID >=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThan(Integer value) {
            addCriterion("DEPT_ID <", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdLessThanOrEqualTo(Integer value) {
            addCriterion("DEPT_ID <=", value, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdIn(List<Integer> values) {
            addCriterion("DEPT_ID in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotIn(List<Integer> values) {
            addCriterion("DEPT_ID not in", values, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID between", value1, value2, "deptId");
            return (Criteria) this;
        }

        public Criteria andDeptIdNotBetween(Integer value1, Integer value2) {
            addCriterion("DEPT_ID not between", value1, value2, "deptId");
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
    }
}