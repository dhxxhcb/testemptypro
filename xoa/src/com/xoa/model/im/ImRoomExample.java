package com.xoa.model.im;

import java.util.ArrayList;
import java.util.List;

public class ImRoomExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImRoomExample() {
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

        public Criteria andRidIsNull() {
            addCriterion("RID is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("RID is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(Integer value) {
            addCriterion("RID =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(Integer value) {
            addCriterion("RID <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(Integer value) {
            addCriterion("RID >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RID >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(Integer value) {
            addCriterion("RID <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(Integer value) {
            addCriterion("RID <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<Integer> values) {
            addCriterion("RID in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<Integer> values) {
            addCriterion("RID not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(Integer value1, Integer value2) {
            addCriterion("RID between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(Integer value1, Integer value2) {
            addCriterion("RID not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRnamrIsNull() {
            addCriterion("RNAMR is null");
            return (Criteria) this;
        }

        public Criteria andRnamrIsNotNull() {
            addCriterion("RNAMR is not null");
            return (Criteria) this;
        }

        public Criteria andRnamrEqualTo(String value) {
            addCriterion("RNAMR =", value, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrNotEqualTo(String value) {
            addCriterion("RNAMR <>", value, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrGreaterThan(String value) {
            addCriterion("RNAMR >", value, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrGreaterThanOrEqualTo(String value) {
            addCriterion("RNAMR >=", value, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrLessThan(String value) {
            addCriterion("RNAMR <", value, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrLessThanOrEqualTo(String value) {
            addCriterion("RNAMR <=", value, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrLike(String value) {
            addCriterion("RNAMR like", value, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrNotLike(String value) {
            addCriterion("RNAMR not like", value, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrIn(List<String> values) {
            addCriterion("RNAMR in", values, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrNotIn(List<String> values) {
            addCriterion("RNAMR not in", values, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrBetween(String value1, String value2) {
            addCriterion("RNAMR between", value1, value2, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRnamrNotBetween(String value1, String value2) {
            addCriterion("RNAMR not between", value1, value2, "rnamr");
            return (Criteria) this;
        }

        public Criteria andRsetUidIsNull() {
            addCriterion("RSET_UID is null");
            return (Criteria) this;
        }

        public Criteria andRsetUidIsNotNull() {
            addCriterion("RSET_UID is not null");
            return (Criteria) this;
        }

        public Criteria andRsetUidEqualTo(String value) {
            addCriterion("RSET_UID =", value, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidNotEqualTo(String value) {
            addCriterion("RSET_UID <>", value, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidGreaterThan(String value) {
            addCriterion("RSET_UID >", value, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidGreaterThanOrEqualTo(String value) {
            addCriterion("RSET_UID >=", value, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidLessThan(String value) {
            addCriterion("RSET_UID <", value, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidLessThanOrEqualTo(String value) {
            addCriterion("RSET_UID <=", value, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidLike(String value) {
            addCriterion("RSET_UID like", value, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidNotLike(String value) {
            addCriterion("RSET_UID not like", value, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidIn(List<String> values) {
            addCriterion("RSET_UID in", values, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidNotIn(List<String> values) {
            addCriterion("RSET_UID not in", values, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidBetween(String value1, String value2) {
            addCriterion("RSET_UID between", value1, value2, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetUidNotBetween(String value1, String value2) {
            addCriterion("RSET_UID not between", value1, value2, "rsetUid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidIsNull() {
            addCriterion("RSET_OFID is null");
            return (Criteria) this;
        }

        public Criteria andRsetOfidIsNotNull() {
            addCriterion("RSET_OFID is not null");
            return (Criteria) this;
        }

        public Criteria andRsetOfidEqualTo(String value) {
            addCriterion("RSET_OFID =", value, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidNotEqualTo(String value) {
            addCriterion("RSET_OFID <>", value, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidGreaterThan(String value) {
            addCriterion("RSET_OFID >", value, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidGreaterThanOrEqualTo(String value) {
            addCriterion("RSET_OFID >=", value, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidLessThan(String value) {
            addCriterion("RSET_OFID <", value, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidLessThanOrEqualTo(String value) {
            addCriterion("RSET_OFID <=", value, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidLike(String value) {
            addCriterion("RSET_OFID like", value, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidNotLike(String value) {
            addCriterion("RSET_OFID not like", value, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidIn(List<String> values) {
            addCriterion("RSET_OFID in", values, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidNotIn(List<String> values) {
            addCriterion("RSET_OFID not in", values, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidBetween(String value1, String value2) {
            addCriterion("RSET_OFID between", value1, value2, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRsetOfidNotBetween(String value1, String value2) {
            addCriterion("RSET_OFID not between", value1, value2, "rsetOfid");
            return (Criteria) this;
        }

        public Criteria andRtimeIsNull() {
            addCriterion("RTIME is null");
            return (Criteria) this;
        }

        public Criteria andRtimeIsNotNull() {
            addCriterion("RTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRtimeEqualTo(String value) {
            addCriterion("RTIME =", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotEqualTo(String value) {
            addCriterion("RTIME <>", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeGreaterThan(String value) {
            addCriterion("RTIME >", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeGreaterThanOrEqualTo(String value) {
            addCriterion("RTIME >=", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeLessThan(String value) {
            addCriterion("RTIME <", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeLessThanOrEqualTo(String value) {
            addCriterion("RTIME <=", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeLike(String value) {
            addCriterion("RTIME like", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotLike(String value) {
            addCriterion("RTIME not like", value, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeIn(List<String> values) {
            addCriterion("RTIME in", values, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotIn(List<String> values) {
            addCriterion("RTIME not in", values, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeBetween(String value1, String value2) {
            addCriterion("RTIME between", value1, value2, "rtime");
            return (Criteria) this;
        }

        public Criteria andRtimeNotBetween(String value1, String value2) {
            addCriterion("RTIME not between", value1, value2, "rtime");
            return (Criteria) this;
        }

        public Criteria andRmemberUidIsNull() {
            addCriterion("RMEMBER_UID is null");
            return (Criteria) this;
        }

        public Criteria andRmemberUidIsNotNull() {
            addCriterion("RMEMBER_UID is not null");
            return (Criteria) this;
        }

        public Criteria andRmemberUidEqualTo(String value) {
            addCriterion("RMEMBER_UID =", value, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidNotEqualTo(String value) {
            addCriterion("RMEMBER_UID <>", value, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidGreaterThan(String value) {
            addCriterion("RMEMBER_UID >", value, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidGreaterThanOrEqualTo(String value) {
            addCriterion("RMEMBER_UID >=", value, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidLessThan(String value) {
            addCriterion("RMEMBER_UID <", value, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidLessThanOrEqualTo(String value) {
            addCriterion("RMEMBER_UID <=", value, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidLike(String value) {
            addCriterion("RMEMBER_UID like", value, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidNotLike(String value) {
            addCriterion("RMEMBER_UID not like", value, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidIn(List<String> values) {
            addCriterion("RMEMBER_UID in", values, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidNotIn(List<String> values) {
            addCriterion("RMEMBER_UID not in", values, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidBetween(String value1, String value2) {
            addCriterion("RMEMBER_UID between", value1, value2, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberUidNotBetween(String value1, String value2) {
            addCriterion("RMEMBER_UID not between", value1, value2, "rmemberUid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidIsNull() {
            addCriterion("RMEMBER_OFID is null");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidIsNotNull() {
            addCriterion("RMEMBER_OFID is not null");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidEqualTo(String value) {
            addCriterion("RMEMBER_OFID =", value, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidNotEqualTo(String value) {
            addCriterion("RMEMBER_OFID <>", value, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidGreaterThan(String value) {
            addCriterion("RMEMBER_OFID >", value, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidGreaterThanOrEqualTo(String value) {
            addCriterion("RMEMBER_OFID >=", value, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidLessThan(String value) {
            addCriterion("RMEMBER_OFID <", value, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidLessThanOrEqualTo(String value) {
            addCriterion("RMEMBER_OFID <=", value, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidLike(String value) {
            addCriterion("RMEMBER_OFID like", value, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidNotLike(String value) {
            addCriterion("RMEMBER_OFID not like", value, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidIn(List<String> values) {
            addCriterion("RMEMBER_OFID in", values, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidNotIn(List<String> values) {
            addCriterion("RMEMBER_OFID not in", values, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidBetween(String value1, String value2) {
            addCriterion("RMEMBER_OFID between", value1, value2, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRmemberOfidNotBetween(String value1, String value2) {
            addCriterion("RMEMBER_OFID not between", value1, value2, "rmemberOfid");
            return (Criteria) this;
        }

        public Criteria andRoutUidIsNull() {
            addCriterion("ROUT_UID is null");
            return (Criteria) this;
        }

        public Criteria andRoutUidIsNotNull() {
            addCriterion("ROUT_UID is not null");
            return (Criteria) this;
        }

        public Criteria andRoutUidEqualTo(String value) {
            addCriterion("ROUT_UID =", value, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidNotEqualTo(String value) {
            addCriterion("ROUT_UID <>", value, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidGreaterThan(String value) {
            addCriterion("ROUT_UID >", value, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidGreaterThanOrEqualTo(String value) {
            addCriterion("ROUT_UID >=", value, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidLessThan(String value) {
            addCriterion("ROUT_UID <", value, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidLessThanOrEqualTo(String value) {
            addCriterion("ROUT_UID <=", value, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidLike(String value) {
            addCriterion("ROUT_UID like", value, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidNotLike(String value) {
            addCriterion("ROUT_UID not like", value, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidIn(List<String> values) {
            addCriterion("ROUT_UID in", values, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidNotIn(List<String> values) {
            addCriterion("ROUT_UID not in", values, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidBetween(String value1, String value2) {
            addCriterion("ROUT_UID between", value1, value2, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutUidNotBetween(String value1, String value2) {
            addCriterion("ROUT_UID not between", value1, value2, "routUid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidIsNull() {
            addCriterion("ROUT_OFID is null");
            return (Criteria) this;
        }

        public Criteria andRoutOfidIsNotNull() {
            addCriterion("ROUT_OFID is not null");
            return (Criteria) this;
        }

        public Criteria andRoutOfidEqualTo(String value) {
            addCriterion("ROUT_OFID =", value, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidNotEqualTo(String value) {
            addCriterion("ROUT_OFID <>", value, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidGreaterThan(String value) {
            addCriterion("ROUT_OFID >", value, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidGreaterThanOrEqualTo(String value) {
            addCriterion("ROUT_OFID >=", value, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidLessThan(String value) {
            addCriterion("ROUT_OFID <", value, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidLessThanOrEqualTo(String value) {
            addCriterion("ROUT_OFID <=", value, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidLike(String value) {
            addCriterion("ROUT_OFID like", value, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidNotLike(String value) {
            addCriterion("ROUT_OFID not like", value, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidIn(List<String> values) {
            addCriterion("ROUT_OFID in", values, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidNotIn(List<String> values) {
            addCriterion("ROUT_OFID not in", values, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidBetween(String value1, String value2) {
            addCriterion("ROUT_OFID between", value1, value2, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRoutOfidNotBetween(String value1, String value2) {
            addCriterion("ROUT_OFID not between", value1, value2, "routOfid");
            return (Criteria) this;
        }

        public Criteria andRinviteIsNull() {
            addCriterion("RINVITE is null");
            return (Criteria) this;
        }

        public Criteria andRinviteIsNotNull() {
            addCriterion("RINVITE is not null");
            return (Criteria) this;
        }

        public Criteria andRinviteEqualTo(String value) {
            addCriterion("RINVITE =", value, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteNotEqualTo(String value) {
            addCriterion("RINVITE <>", value, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteGreaterThan(String value) {
            addCriterion("RINVITE >", value, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteGreaterThanOrEqualTo(String value) {
            addCriterion("RINVITE >=", value, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteLessThan(String value) {
            addCriterion("RINVITE <", value, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteLessThanOrEqualTo(String value) {
            addCriterion("RINVITE <=", value, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteLike(String value) {
            addCriterion("RINVITE like", value, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteNotLike(String value) {
            addCriterion("RINVITE not like", value, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteIn(List<String> values) {
            addCriterion("RINVITE in", values, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteNotIn(List<String> values) {
            addCriterion("RINVITE not in", values, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteBetween(String value1, String value2) {
            addCriterion("RINVITE between", value1, value2, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRinviteNotBetween(String value1, String value2) {
            addCriterion("RINVITE not between", value1, value2, "rinvite");
            return (Criteria) this;
        }

        public Criteria andRchangeIsNull() {
            addCriterion("RCHANGE is null");
            return (Criteria) this;
        }

        public Criteria andRchangeIsNotNull() {
            addCriterion("RCHANGE is not null");
            return (Criteria) this;
        }

        public Criteria andRchangeEqualTo(String value) {
            addCriterion("RCHANGE =", value, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeNotEqualTo(String value) {
            addCriterion("RCHANGE <>", value, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeGreaterThan(String value) {
            addCriterion("RCHANGE >", value, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeGreaterThanOrEqualTo(String value) {
            addCriterion("RCHANGE >=", value, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeLessThan(String value) {
            addCriterion("RCHANGE <", value, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeLessThanOrEqualTo(String value) {
            addCriterion("RCHANGE <=", value, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeLike(String value) {
            addCriterion("RCHANGE like", value, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeNotLike(String value) {
            addCriterion("RCHANGE not like", value, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeIn(List<String> values) {
            addCriterion("RCHANGE in", values, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeNotIn(List<String> values) {
            addCriterion("RCHANGE not in", values, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeBetween(String value1, String value2) {
            addCriterion("RCHANGE between", value1, value2, "rchange");
            return (Criteria) this;
        }

        public Criteria andRchangeNotBetween(String value1, String value2) {
            addCriterion("RCHANGE not between", value1, value2, "rchange");
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