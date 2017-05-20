package com.xoa.model.workflow;

import java.util.ArrayList;
import java.util.List;

public class FlowPrivExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public FlowPrivExample() {
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

		public Criteria andIdIsNull() {
			addCriterion("ID is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("ID is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("ID =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("ID <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("ID >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("ID >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("ID <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("ID <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("ID in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("ID not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("ID between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("ID not between", value1, value2, "id");
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

		public Criteria andPrivTypeIsNull() {
			addCriterion("PRIV_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andPrivTypeIsNotNull() {
			addCriterion("PRIV_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andPrivTypeEqualTo(Integer value) {
			addCriterion("PRIV_TYPE =", value, "privType");
			return (Criteria) this;
		}

		public Criteria andPrivTypeNotEqualTo(Integer value) {
			addCriterion("PRIV_TYPE <>", value, "privType");
			return (Criteria) this;
		}

		public Criteria andPrivTypeGreaterThan(Integer value) {
			addCriterion("PRIV_TYPE >", value, "privType");
			return (Criteria) this;
		}

		public Criteria andPrivTypeGreaterThanOrEqualTo(Integer value) {
			addCriterion("PRIV_TYPE >=", value, "privType");
			return (Criteria) this;
		}

		public Criteria andPrivTypeLessThan(Integer value) {
			addCriterion("PRIV_TYPE <", value, "privType");
			return (Criteria) this;
		}

		public Criteria andPrivTypeLessThanOrEqualTo(Integer value) {
			addCriterion("PRIV_TYPE <=", value, "privType");
			return (Criteria) this;
		}

		public Criteria andPrivTypeIn(List<Integer> values) {
			addCriterion("PRIV_TYPE in", values, "privType");
			return (Criteria) this;
		}

		public Criteria andPrivTypeNotIn(List<Integer> values) {
			addCriterion("PRIV_TYPE not in", values, "privType");
			return (Criteria) this;
		}

		public Criteria andPrivTypeBetween(Integer value1, Integer value2) {
			addCriterion("PRIV_TYPE between", value1, value2, "privType");
			return (Criteria) this;
		}

		public Criteria andPrivTypeNotBetween(Integer value1, Integer value2) {
			addCriterion("PRIV_TYPE not between", value1, value2, "privType");
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