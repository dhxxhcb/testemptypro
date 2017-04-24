package com.xoa.model.im;

import java.util.ArrayList;
import java.util.List;

public class ImMessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImMessageExample() {
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

        public Criteria andImidIsNull() {
            addCriterion("IMID is null");
            return (Criteria) this;
        }

        public Criteria andImidIsNotNull() {
            addCriterion("IMID is not null");
            return (Criteria) this;
        }

        public Criteria andImidEqualTo(Integer value) {
            addCriterion("IMID =", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidNotEqualTo(Integer value) {
            addCriterion("IMID <>", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidGreaterThan(Integer value) {
            addCriterion("IMID >", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidGreaterThanOrEqualTo(Integer value) {
            addCriterion("IMID >=", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidLessThan(Integer value) {
            addCriterion("IMID <", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidLessThanOrEqualTo(Integer value) {
            addCriterion("IMID <=", value, "imid");
            return (Criteria) this;
        }

        public Criteria andImidIn(List<Integer> values) {
            addCriterion("IMID in", values, "imid");
            return (Criteria) this;
        }

        public Criteria andImidNotIn(List<Integer> values) {
            addCriterion("IMID not in", values, "imid");
            return (Criteria) this;
        }

        public Criteria andImidBetween(Integer value1, Integer value2) {
            addCriterion("IMID between", value1, value2, "imid");
            return (Criteria) this;
        }

        public Criteria andImidNotBetween(Integer value1, Integer value2) {
            addCriterion("IMID not between", value1, value2, "imid");
            return (Criteria) this;
        }

        public Criteria andFromUidIsNull() {
            addCriterion("FROM_UID is null");
            return (Criteria) this;
        }

        public Criteria andFromUidIsNotNull() {
            addCriterion("FROM_UID is not null");
            return (Criteria) this;
        }

        public Criteria andFromUidEqualTo(String value) {
            addCriterion("FROM_UID =", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotEqualTo(String value) {
            addCriterion("FROM_UID <>", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidGreaterThan(String value) {
            addCriterion("FROM_UID >", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidGreaterThanOrEqualTo(String value) {
            addCriterion("FROM_UID >=", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLessThan(String value) {
            addCriterion("FROM_UID <", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLessThanOrEqualTo(String value) {
            addCriterion("FROM_UID <=", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLike(String value) {
            addCriterion("FROM_UID like", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotLike(String value) {
            addCriterion("FROM_UID not like", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidIn(List<String> values) {
            addCriterion("FROM_UID in", values, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotIn(List<String> values) {
            addCriterion("FROM_UID not in", values, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidBetween(String value1, String value2) {
            addCriterion("FROM_UID between", value1, value2, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotBetween(String value1, String value2) {
            addCriterion("FROM_UID not between", value1, value2, "fromUid");
            return (Criteria) this;
        }

        public Criteria andToUidIsNull() {
            addCriterion("TO_UID is null");
            return (Criteria) this;
        }

        public Criteria andToUidIsNotNull() {
            addCriterion("TO_UID is not null");
            return (Criteria) this;
        }

        public Criteria andToUidEqualTo(String value) {
            addCriterion("TO_UID =", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotEqualTo(String value) {
            addCriterion("TO_UID <>", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThan(String value) {
            addCriterion("TO_UID >", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThanOrEqualTo(String value) {
            addCriterion("TO_UID >=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThan(String value) {
            addCriterion("TO_UID <", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThanOrEqualTo(String value) {
            addCriterion("TO_UID <=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLike(String value) {
            addCriterion("TO_UID like", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotLike(String value) {
            addCriterion("TO_UID not like", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidIn(List<String> values) {
            addCriterion("TO_UID in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotIn(List<String> values) {
            addCriterion("TO_UID not in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidBetween(String value1, String value2) {
            addCriterion("TO_UID between", value1, value2, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotBetween(String value1, String value2) {
            addCriterion("TO_UID not between", value1, value2, "toUid");
            return (Criteria) this;
        }

        public Criteria andOfFromIsNull() {
            addCriterion("OF_FROM is null");
            return (Criteria) this;
        }

        public Criteria andOfFromIsNotNull() {
            addCriterion("OF_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andOfFromEqualTo(String value) {
            addCriterion("OF_FROM =", value, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromNotEqualTo(String value) {
            addCriterion("OF_FROM <>", value, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromGreaterThan(String value) {
            addCriterion("OF_FROM >", value, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromGreaterThanOrEqualTo(String value) {
            addCriterion("OF_FROM >=", value, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromLessThan(String value) {
            addCriterion("OF_FROM <", value, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromLessThanOrEqualTo(String value) {
            addCriterion("OF_FROM <=", value, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromLike(String value) {
            addCriterion("OF_FROM like", value, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromNotLike(String value) {
            addCriterion("OF_FROM not like", value, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromIn(List<String> values) {
            addCriterion("OF_FROM in", values, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromNotIn(List<String> values) {
            addCriterion("OF_FROM not in", values, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromBetween(String value1, String value2) {
            addCriterion("OF_FROM between", value1, value2, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfFromNotBetween(String value1, String value2) {
            addCriterion("OF_FROM not between", value1, value2, "ofFrom");
            return (Criteria) this;
        }

        public Criteria andOfToIsNull() {
            addCriterion("OF_TO is null");
            return (Criteria) this;
        }

        public Criteria andOfToIsNotNull() {
            addCriterion("OF_TO is not null");
            return (Criteria) this;
        }

        public Criteria andOfToEqualTo(String value) {
            addCriterion("OF_TO =", value, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToNotEqualTo(String value) {
            addCriterion("OF_TO <>", value, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToGreaterThan(String value) {
            addCriterion("OF_TO >", value, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToGreaterThanOrEqualTo(String value) {
            addCriterion("OF_TO >=", value, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToLessThan(String value) {
            addCriterion("OF_TO <", value, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToLessThanOrEqualTo(String value) {
            addCriterion("OF_TO <=", value, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToLike(String value) {
            addCriterion("OF_TO like", value, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToNotLike(String value) {
            addCriterion("OF_TO not like", value, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToIn(List<String> values) {
            addCriterion("OF_TO in", values, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToNotIn(List<String> values) {
            addCriterion("OF_TO not in", values, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToBetween(String value1, String value2) {
            addCriterion("OF_TO between", value1, value2, "ofTo");
            return (Criteria) this;
        }

        public Criteria andOfToNotBetween(String value1, String value2) {
            addCriterion("OF_TO not between", value1, value2, "ofTo");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlIsNull() {
            addCriterion("THUMBNAIL_URL is null");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlIsNotNull() {
            addCriterion("THUMBNAIL_URL is not null");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlEqualTo(String value) {
            addCriterion("THUMBNAIL_URL =", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotEqualTo(String value) {
            addCriterion("THUMBNAIL_URL <>", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlGreaterThan(String value) {
            addCriterion("THUMBNAIL_URL >", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("THUMBNAIL_URL >=", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlLessThan(String value) {
            addCriterion("THUMBNAIL_URL <", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlLessThanOrEqualTo(String value) {
            addCriterion("THUMBNAIL_URL <=", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlLike(String value) {
            addCriterion("THUMBNAIL_URL like", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotLike(String value) {
            addCriterion("THUMBNAIL_URL not like", value, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlIn(List<String> values) {
            addCriterion("THUMBNAIL_URL in", values, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotIn(List<String> values) {
            addCriterion("THUMBNAIL_URL not in", values, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlBetween(String value1, String value2) {
            addCriterion("THUMBNAIL_URL between", value1, value2, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andThumbnailUrlNotBetween(String value1, String value2) {
            addCriterion("THUMBNAIL_URL not between", value1, value2, "thumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andStimeIsNull() {
            addCriterion("STIME is null");
            return (Criteria) this;
        }

        public Criteria andStimeIsNotNull() {
            addCriterion("STIME is not null");
            return (Criteria) this;
        }

        public Criteria andStimeEqualTo(String value) {
            addCriterion("STIME =", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotEqualTo(String value) {
            addCriterion("STIME <>", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThan(String value) {
            addCriterion("STIME >", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeGreaterThanOrEqualTo(String value) {
            addCriterion("STIME >=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThan(String value) {
            addCriterion("STIME <", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLessThanOrEqualTo(String value) {
            addCriterion("STIME <=", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeLike(String value) {
            addCriterion("STIME like", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotLike(String value) {
            addCriterion("STIME not like", value, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeIn(List<String> values) {
            addCriterion("STIME in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotIn(List<String> values) {
            addCriterion("STIME not in", values, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeBetween(String value1, String value2) {
            addCriterion("STIME between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andStimeNotBetween(String value1, String value2) {
            addCriterion("STIME not between", value1, value2, "stime");
            return (Criteria) this;
        }

        public Criteria andAtimeIsNull() {
            addCriterion("ATIME is null");
            return (Criteria) this;
        }

        public Criteria andAtimeIsNotNull() {
            addCriterion("ATIME is not null");
            return (Criteria) this;
        }

        public Criteria andAtimeEqualTo(Integer value) {
            addCriterion("ATIME =", value, "atime");
            return (Criteria) this;
        }

        public Criteria andAtimeNotEqualTo(Integer value) {
            addCriterion("ATIME <>", value, "atime");
            return (Criteria) this;
        }

        public Criteria andAtimeGreaterThan(Integer value) {
            addCriterion("ATIME >", value, "atime");
            return (Criteria) this;
        }

        public Criteria andAtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ATIME >=", value, "atime");
            return (Criteria) this;
        }

        public Criteria andAtimeLessThan(Integer value) {
            addCriterion("ATIME <", value, "atime");
            return (Criteria) this;
        }

        public Criteria andAtimeLessThanOrEqualTo(Integer value) {
            addCriterion("ATIME <=", value, "atime");
            return (Criteria) this;
        }

        public Criteria andAtimeIn(List<Integer> values) {
            addCriterion("ATIME in", values, "atime");
            return (Criteria) this;
        }

        public Criteria andAtimeNotIn(List<Integer> values) {
            addCriterion("ATIME not in", values, "atime");
            return (Criteria) this;
        }

        public Criteria andAtimeBetween(Integer value1, Integer value2) {
            addCriterion("ATIME between", value1, value2, "atime");
            return (Criteria) this;
        }

        public Criteria andAtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("ATIME not between", value1, value2, "atime");
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

        public Criteria andDflagIsNull() {
            addCriterion("DFLAG is null");
            return (Criteria) this;
        }

        public Criteria andDflagIsNotNull() {
            addCriterion("DFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDflagEqualTo(String value) {
            addCriterion("DFLAG =", value, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagNotEqualTo(String value) {
            addCriterion("DFLAG <>", value, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagGreaterThan(String value) {
            addCriterion("DFLAG >", value, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagGreaterThanOrEqualTo(String value) {
            addCriterion("DFLAG >=", value, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagLessThan(String value) {
            addCriterion("DFLAG <", value, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagLessThanOrEqualTo(String value) {
            addCriterion("DFLAG <=", value, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagLike(String value) {
            addCriterion("DFLAG like", value, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagNotLike(String value) {
            addCriterion("DFLAG not like", value, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagIn(List<String> values) {
            addCriterion("DFLAG in", values, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagNotIn(List<String> values) {
            addCriterion("DFLAG not in", values, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagBetween(String value1, String value2) {
            addCriterion("DFLAG between", value1, value2, "dflag");
            return (Criteria) this;
        }

        public Criteria andDflagNotBetween(String value1, String value2) {
            addCriterion("DFLAG not between", value1, value2, "dflag");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNull() {
            addCriterion("MSG_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIsNotNull() {
            addCriterion("MSG_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andMsgTypeEqualTo(String value) {
            addCriterion("MSG_TYPE =", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotEqualTo(String value) {
            addCriterion("MSG_TYPE <>", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThan(String value) {
            addCriterion("MSG_TYPE >", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("MSG_TYPE >=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThan(String value) {
            addCriterion("MSG_TYPE <", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLessThanOrEqualTo(String value) {
            addCriterion("MSG_TYPE <=", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeLike(String value) {
            addCriterion("MSG_TYPE like", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotLike(String value) {
            addCriterion("MSG_TYPE not like", value, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeIn(List<String> values) {
            addCriterion("MSG_TYPE in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotIn(List<String> values) {
            addCriterion("MSG_TYPE not in", values, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeBetween(String value1, String value2) {
            addCriterion("MSG_TYPE between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andMsgTypeNotBetween(String value1, String value2) {
            addCriterion("MSG_TYPE not between", value1, value2, "msgType");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
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