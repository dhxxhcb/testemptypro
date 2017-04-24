package com.xoa.model.im;

import java.util.ArrayList;
import java.util.List;

public class ImChatListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ImChatListExample() {
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

        public Criteria andListIdIsNull() {
            addCriterion("LIST_ID is null");
            return (Criteria) this;
        }

        public Criteria andListIdIsNotNull() {
            addCriterion("LIST_ID is not null");
            return (Criteria) this;
        }

        public Criteria andListIdEqualTo(Integer value) {
            addCriterion("LIST_ID =", value, "listId");
            return (Criteria) this;
        }

        public Criteria andListIdNotEqualTo(Integer value) {
            addCriterion("LIST_ID <>", value, "listId");
            return (Criteria) this;
        }

        public Criteria andListIdGreaterThan(Integer value) {
            addCriterion("LIST_ID >", value, "listId");
            return (Criteria) this;
        }

        public Criteria andListIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("LIST_ID >=", value, "listId");
            return (Criteria) this;
        }

        public Criteria andListIdLessThan(Integer value) {
            addCriterion("LIST_ID <", value, "listId");
            return (Criteria) this;
        }

        public Criteria andListIdLessThanOrEqualTo(Integer value) {
            addCriterion("LIST_ID <=", value, "listId");
            return (Criteria) this;
        }

        public Criteria andListIdIn(List<Integer> values) {
            addCriterion("LIST_ID in", values, "listId");
            return (Criteria) this;
        }

        public Criteria andListIdNotIn(List<Integer> values) {
            addCriterion("LIST_ID not in", values, "listId");
            return (Criteria) this;
        }

        public Criteria andListIdBetween(Integer value1, Integer value2) {
            addCriterion("LIST_ID between", value1, value2, "listId");
            return (Criteria) this;
        }

        public Criteria andListIdNotBetween(Integer value1, Integer value2) {
            addCriterion("LIST_ID not between", value1, value2, "listId");
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

        public Criteria andLastTimeIsNull() {
            addCriterion("LAST_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastTimeIsNotNull() {
            addCriterion("LAST_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastTimeEqualTo(String value) {
            addCriterion("LAST_TIME =", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotEqualTo(String value) {
            addCriterion("LAST_TIME <>", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThan(String value) {
            addCriterion("LAST_TIME >", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_TIME >=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThan(String value) {
            addCriterion("LAST_TIME <", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLessThanOrEqualTo(String value) {
            addCriterion("LAST_TIME <=", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeLike(String value) {
            addCriterion("LAST_TIME like", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotLike(String value) {
            addCriterion("LAST_TIME not like", value, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeIn(List<String> values) {
            addCriterion("LAST_TIME in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotIn(List<String> values) {
            addCriterion("LAST_TIME not in", values, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeBetween(String value1, String value2) {
            addCriterion("LAST_TIME between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastTimeNotBetween(String value1, String value2) {
            addCriterion("LAST_TIME not between", value1, value2, "lastTime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeIsNull() {
            addCriterion("LAST_ATIME is null");
            return (Criteria) this;
        }

        public Criteria andLastAtimeIsNotNull() {
            addCriterion("LAST_ATIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastAtimeEqualTo(Integer value) {
            addCriterion("LAST_ATIME =", value, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeNotEqualTo(Integer value) {
            addCriterion("LAST_ATIME <>", value, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeGreaterThan(Integer value) {
            addCriterion("LAST_ATIME >", value, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("LAST_ATIME >=", value, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeLessThan(Integer value) {
            addCriterion("LAST_ATIME <", value, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeLessThanOrEqualTo(Integer value) {
            addCriterion("LAST_ATIME <=", value, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeIn(List<Integer> values) {
            addCriterion("LAST_ATIME in", values, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeNotIn(List<Integer> values) {
            addCriterion("LAST_ATIME not in", values, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeBetween(Integer value1, Integer value2) {
            addCriterion("LAST_ATIME between", value1, value2, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastAtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("LAST_ATIME not between", value1, value2, "lastAtime");
            return (Criteria) this;
        }

        public Criteria andLastFileIdIsNull() {
            addCriterion("LAST_FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andLastFileIdIsNotNull() {
            addCriterion("LAST_FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLastFileIdEqualTo(String value) {
            addCriterion("LAST_FILE_ID =", value, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdNotEqualTo(String value) {
            addCriterion("LAST_FILE_ID <>", value, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdGreaterThan(String value) {
            addCriterion("LAST_FILE_ID >", value, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_FILE_ID >=", value, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdLessThan(String value) {
            addCriterion("LAST_FILE_ID <", value, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdLessThanOrEqualTo(String value) {
            addCriterion("LAST_FILE_ID <=", value, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdLike(String value) {
            addCriterion("LAST_FILE_ID like", value, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdNotLike(String value) {
            addCriterion("LAST_FILE_ID not like", value, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdIn(List<String> values) {
            addCriterion("LAST_FILE_ID in", values, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdNotIn(List<String> values) {
            addCriterion("LAST_FILE_ID not in", values, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdBetween(String value1, String value2) {
            addCriterion("LAST_FILE_ID between", value1, value2, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileIdNotBetween(String value1, String value2) {
            addCriterion("LAST_FILE_ID not between", value1, value2, "lastFileId");
            return (Criteria) this;
        }

        public Criteria andLastFileNameIsNull() {
            addCriterion("LAST_FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andLastFileNameIsNotNull() {
            addCriterion("LAST_FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andLastFileNameEqualTo(String value) {
            addCriterion("LAST_FILE_NAME =", value, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameNotEqualTo(String value) {
            addCriterion("LAST_FILE_NAME <>", value, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameGreaterThan(String value) {
            addCriterion("LAST_FILE_NAME >", value, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_FILE_NAME >=", value, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameLessThan(String value) {
            addCriterion("LAST_FILE_NAME <", value, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameLessThanOrEqualTo(String value) {
            addCriterion("LAST_FILE_NAME <=", value, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameLike(String value) {
            addCriterion("LAST_FILE_NAME like", value, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameNotLike(String value) {
            addCriterion("LAST_FILE_NAME not like", value, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameIn(List<String> values) {
            addCriterion("LAST_FILE_NAME in", values, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameNotIn(List<String> values) {
            addCriterion("LAST_FILE_NAME not in", values, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameBetween(String value1, String value2) {
            addCriterion("LAST_FILE_NAME between", value1, value2, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastFileNameNotBetween(String value1, String value2) {
            addCriterion("LAST_FILE_NAME not between", value1, value2, "lastFileName");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlIsNull() {
            addCriterion("LAST_THUMBNAIL_URL is null");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlIsNotNull() {
            addCriterion("LAST_THUMBNAIL_URL is not null");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlEqualTo(String value) {
            addCriterion("LAST_THUMBNAIL_URL =", value, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlNotEqualTo(String value) {
            addCriterion("LAST_THUMBNAIL_URL <>", value, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlGreaterThan(String value) {
            addCriterion("LAST_THUMBNAIL_URL >", value, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_THUMBNAIL_URL >=", value, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlLessThan(String value) {
            addCriterion("LAST_THUMBNAIL_URL <", value, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlLessThanOrEqualTo(String value) {
            addCriterion("LAST_THUMBNAIL_URL <=", value, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlLike(String value) {
            addCriterion("LAST_THUMBNAIL_URL like", value, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlNotLike(String value) {
            addCriterion("LAST_THUMBNAIL_URL not like", value, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlIn(List<String> values) {
            addCriterion("LAST_THUMBNAIL_URL in", values, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlNotIn(List<String> values) {
            addCriterion("LAST_THUMBNAIL_URL not in", values, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlBetween(String value1, String value2) {
            addCriterion("LAST_THUMBNAIL_URL between", value1, value2, "lastThumbnailUrl");
            return (Criteria) this;
        }

        public Criteria andLastThumbnailUrlNotBetween(String value1, String value2) {
            addCriterion("LAST_THUMBNAIL_URL not between", value1, value2, "lastThumbnailUrl");
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