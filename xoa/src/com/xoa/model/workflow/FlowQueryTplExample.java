package com.xoa.model.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FlowQueryTplExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public FlowQueryTplExample() {
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andSeqIdIsNull() {
			addCriterion("SEQ_ID is null");
			return (Criteria) this;
		}

		public Criteria andSeqIdIsNotNull() {
			addCriterion("SEQ_ID is not null");
			return (Criteria) this;
		}

		public Criteria andSeqIdEqualTo(Integer value) {
			addCriterion("SEQ_ID =", value, "seqId");
			return (Criteria) this;
		}

		public Criteria andSeqIdNotEqualTo(Integer value) {
			addCriterion("SEQ_ID <>", value, "seqId");
			return (Criteria) this;
		}

		public Criteria andSeqIdGreaterThan(Integer value) {
			addCriterion("SEQ_ID >", value, "seqId");
			return (Criteria) this;
		}

		public Criteria andSeqIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("SEQ_ID >=", value, "seqId");
			return (Criteria) this;
		}

		public Criteria andSeqIdLessThan(Integer value) {
			addCriterion("SEQ_ID <", value, "seqId");
			return (Criteria) this;
		}

		public Criteria andSeqIdLessThanOrEqualTo(Integer value) {
			addCriterion("SEQ_ID <=", value, "seqId");
			return (Criteria) this;
		}

		public Criteria andSeqIdIn(List<Integer> values) {
			addCriterion("SEQ_ID in", values, "seqId");
			return (Criteria) this;
		}

		public Criteria andSeqIdNotIn(List<Integer> values) {
			addCriterion("SEQ_ID not in", values, "seqId");
			return (Criteria) this;
		}

		public Criteria andSeqIdBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_ID between", value1, value2, "seqId");
			return (Criteria) this;
		}

		public Criteria andSeqIdNotBetween(Integer value1, Integer value2) {
			addCriterion("SEQ_ID not between", value1, value2, "seqId");
			return (Criteria) this;
		}

		public Criteria andTplNameIsNull() {
			addCriterion("TPL_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTplNameIsNotNull() {
			addCriterion("TPL_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTplNameEqualTo(String value) {
			addCriterion("TPL_NAME =", value, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameNotEqualTo(String value) {
			addCriterion("TPL_NAME <>", value, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameGreaterThan(String value) {
			addCriterion("TPL_NAME >", value, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameGreaterThanOrEqualTo(String value) {
			addCriterion("TPL_NAME >=", value, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameLessThan(String value) {
			addCriterion("TPL_NAME <", value, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameLessThanOrEqualTo(String value) {
			addCriterion("TPL_NAME <=", value, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameLike(String value) {
			addCriterion("TPL_NAME like", value, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameNotLike(String value) {
			addCriterion("TPL_NAME not like", value, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameIn(List<String> values) {
			addCriterion("TPL_NAME in", values, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameNotIn(List<String> values) {
			addCriterion("TPL_NAME not in", values, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameBetween(String value1, String value2) {
			addCriterion("TPL_NAME between", value1, value2, "tplName");
			return (Criteria) this;
		}

		public Criteria andTplNameNotBetween(String value1, String value2) {
			addCriterion("TPL_NAME not between", value1, value2, "tplName");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(String value) {
			addCriterion("USER_ID =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(String value) {
			addCriterion("USER_ID <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(String value) {
			addCriterion("USER_ID >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(String value) {
			addCriterion("USER_ID >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(String value) {
			addCriterion("USER_ID <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(String value) {
			addCriterion("USER_ID <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLike(String value) {
			addCriterion("USER_ID like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotLike(String value) {
			addCriterion("USER_ID not like", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<String> values) {
			addCriterion("USER_ID in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<String> values) {
			addCriterion("USER_ID not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(String value1, String value2) {
			addCriterion("USER_ID between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(String value1, String value2) {
			addCriterion("USER_ID not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andFlowIdIsNull() {
			addCriterion("FLOW_ID is null");
			return (Criteria) this;
		}

		public Criteria andFlowIdIsNotNull() {
			addCriterion("FLOW_ID is not null");
			return (Criteria) this;
		}

		public Criteria andFlowIdEqualTo(Integer value) {
			addCriterion("FLOW_ID =", value, "flowId");
			return (Criteria) this;
		}

		public Criteria andFlowIdNotEqualTo(Integer value) {
			addCriterion("FLOW_ID <>", value, "flowId");
			return (Criteria) this;
		}

		public Criteria andFlowIdGreaterThan(Integer value) {
			addCriterion("FLOW_ID >", value, "flowId");
			return (Criteria) this;
		}

		public Criteria andFlowIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("FLOW_ID >=", value, "flowId");
			return (Criteria) this;
		}

		public Criteria andFlowIdLessThan(Integer value) {
			addCriterion("FLOW_ID <", value, "flowId");
			return (Criteria) this;
		}

		public Criteria andFlowIdLessThanOrEqualTo(Integer value) {
			addCriterion("FLOW_ID <=", value, "flowId");
			return (Criteria) this;
		}

		public Criteria andFlowIdIn(List<Integer> values) {
			addCriterion("FLOW_ID in", values, "flowId");
			return (Criteria) this;
		}

		public Criteria andFlowIdNotIn(List<Integer> values) {
			addCriterion("FLOW_ID not in", values, "flowId");
			return (Criteria) this;
		}

		public Criteria andFlowIdBetween(Integer value1, Integer value2) {
			addCriterion("FLOW_ID between", value1, value2, "flowId");
			return (Criteria) this;
		}

		public Criteria andFlowIdNotBetween(Integer value1, Integer value2) {
			addCriterion("FLOW_ID not between", value1, value2, "flowId");
			return (Criteria) this;
		}

		public Criteria andCondFormulaIsNull() {
			addCriterion("COND_FORMULA is null");
			return (Criteria) this;
		}

		public Criteria andCondFormulaIsNotNull() {
			addCriterion("COND_FORMULA is not null");
			return (Criteria) this;
		}

		public Criteria andCondFormulaEqualTo(String value) {
			addCriterion("COND_FORMULA =", value, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaNotEqualTo(String value) {
			addCriterion("COND_FORMULA <>", value, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaGreaterThan(String value) {
			addCriterion("COND_FORMULA >", value, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaGreaterThanOrEqualTo(String value) {
			addCriterion("COND_FORMULA >=", value, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaLessThan(String value) {
			addCriterion("COND_FORMULA <", value, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaLessThanOrEqualTo(String value) {
			addCriterion("COND_FORMULA <=", value, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaLike(String value) {
			addCriterion("COND_FORMULA like", value, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaNotLike(String value) {
			addCriterion("COND_FORMULA not like", value, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaIn(List<String> values) {
			addCriterion("COND_FORMULA in", values, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaNotIn(List<String> values) {
			addCriterion("COND_FORMULA not in", values, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaBetween(String value1, String value2) {
			addCriterion("COND_FORMULA between", value1, value2, "condFormula");
			return (Criteria) this;
		}

		public Criteria andCondFormulaNotBetween(String value1, String value2) {
			addCriterion("COND_FORMULA not between", value1, value2,
					"condFormula");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("CREATE_TIME is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("CREATE_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("CREATE_TIME =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("CREATE_TIME <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("CREATE_TIME >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("CREATE_TIME <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("CREATE_TIME <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("CREATE_TIME in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("CREATE_TIME not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("CREATE_TIME not between", value1, value2,
					"createTime");
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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