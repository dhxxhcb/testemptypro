package com.xoa.model.workflow;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FlowTimerExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public FlowTimerExample() {
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

		protected void addCriterionForJDBCTime(String condition, Date value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value.getTime()),
					property);
		}

		protected void addCriterionForJDBCTime(String condition,
				List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				timeList.add(new java.sql.Time(iter.next().getTime()));
			}
			addCriterion(condition, timeList, property);
		}

		protected void addCriterionForJDBCTime(String condition, Date value1,
				Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Time(value1.getTime()),
					new java.sql.Time(value2.getTime()), property);
		}

		public Criteria andTidIsNull() {
			addCriterion("TID is null");
			return (Criteria) this;
		}

		public Criteria andTidIsNotNull() {
			addCriterion("TID is not null");
			return (Criteria) this;
		}

		public Criteria andTidEqualTo(Integer value) {
			addCriterion("TID =", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidNotEqualTo(Integer value) {
			addCriterion("TID <>", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidGreaterThan(Integer value) {
			addCriterion("TID >", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidGreaterThanOrEqualTo(Integer value) {
			addCriterion("TID >=", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidLessThan(Integer value) {
			addCriterion("TID <", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidLessThanOrEqualTo(Integer value) {
			addCriterion("TID <=", value, "tid");
			return (Criteria) this;
		}

		public Criteria andTidIn(List<Integer> values) {
			addCriterion("TID in", values, "tid");
			return (Criteria) this;
		}

		public Criteria andTidNotIn(List<Integer> values) {
			addCriterion("TID not in", values, "tid");
			return (Criteria) this;
		}

		public Criteria andTidBetween(Integer value1, Integer value2) {
			addCriterion("TID between", value1, value2, "tid");
			return (Criteria) this;
		}

		public Criteria andTidNotBetween(Integer value1, Integer value2) {
			addCriterion("TID not between", value1, value2, "tid");
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

		public Criteria andTypeIsNull() {
			addCriterion("TYPE is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(String value) {
			addCriterion("TYPE =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("TYPE <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("TYPE >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("TYPE >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("TYPE <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("TYPE <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("TYPE like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("TYPE not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("TYPE in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("TYPE not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("TYPE between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("TYPE not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andRemindDateIsNull() {
			addCriterion("REMIND_DATE is null");
			return (Criteria) this;
		}

		public Criteria andRemindDateIsNotNull() {
			addCriterion("REMIND_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andRemindDateEqualTo(String value) {
			addCriterion("REMIND_DATE =", value, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateNotEqualTo(String value) {
			addCriterion("REMIND_DATE <>", value, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateGreaterThan(String value) {
			addCriterion("REMIND_DATE >", value, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateGreaterThanOrEqualTo(String value) {
			addCriterion("REMIND_DATE >=", value, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateLessThan(String value) {
			addCriterion("REMIND_DATE <", value, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateLessThanOrEqualTo(String value) {
			addCriterion("REMIND_DATE <=", value, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateLike(String value) {
			addCriterion("REMIND_DATE like", value, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateNotLike(String value) {
			addCriterion("REMIND_DATE not like", value, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateIn(List<String> values) {
			addCriterion("REMIND_DATE in", values, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateNotIn(List<String> values) {
			addCriterion("REMIND_DATE not in", values, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateBetween(String value1, String value2) {
			addCriterion("REMIND_DATE between", value1, value2, "remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindDateNotBetween(String value1, String value2) {
			addCriterion("REMIND_DATE not between", value1, value2,
					"remindDate");
			return (Criteria) this;
		}

		public Criteria andRemindTimeIsNull() {
			addCriterion("REMIND_TIME is null");
			return (Criteria) this;
		}

		public Criteria andRemindTimeIsNotNull() {
			addCriterion("REMIND_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andRemindTimeEqualTo(Date value) {
			addCriterionForJDBCTime("REMIND_TIME =", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeNotEqualTo(Date value) {
			addCriterionForJDBCTime("REMIND_TIME <>", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeGreaterThan(Date value) {
			addCriterionForJDBCTime("REMIND_TIME >", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCTime("REMIND_TIME >=", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeLessThan(Date value) {
			addCriterionForJDBCTime("REMIND_TIME <", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCTime("REMIND_TIME <=", value, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeIn(List<Date> values) {
			addCriterionForJDBCTime("REMIND_TIME in", values, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeNotIn(List<Date> values) {
			addCriterionForJDBCTime("REMIND_TIME not in", values, "remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCTime("REMIND_TIME between", value1, value2,
					"remindTime");
			return (Criteria) this;
		}

		public Criteria andRemindTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCTime("REMIND_TIME not between", value1, value2,
					"remindTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeIsNull() {
			addCriterion("LAST_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLastTimeIsNotNull() {
			addCriterion("LAST_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLastTimeEqualTo(Date value) {
			addCriterion("LAST_TIME =", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeNotEqualTo(Date value) {
			addCriterion("LAST_TIME <>", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeGreaterThan(Date value) {
			addCriterion("LAST_TIME >", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LAST_TIME >=", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeLessThan(Date value) {
			addCriterion("LAST_TIME <", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeLessThanOrEqualTo(Date value) {
			addCriterion("LAST_TIME <=", value, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeIn(List<Date> values) {
			addCriterion("LAST_TIME in", values, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeNotIn(List<Date> values) {
			addCriterion("LAST_TIME not in", values, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeBetween(Date value1, Date value2) {
			addCriterion("LAST_TIME between", value1, value2, "lastTime");
			return (Criteria) this;
		}

		public Criteria andLastTimeNotBetween(Date value1, Date value2) {
			addCriterion("LAST_TIME not between", value1, value2, "lastTime");
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