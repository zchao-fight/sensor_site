package cn.ccf.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InAndOutHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InAndOutHistoryExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdIsNull() {
            addCriterion("WORKSHOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdIsNotNull() {
            addCriterion("WORKSHOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdEqualTo(String value) {
            addCriterion("WORKSHOP_ID =", value, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdNotEqualTo(String value) {
            addCriterion("WORKSHOP_ID <>", value, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdGreaterThan(String value) {
            addCriterion("WORKSHOP_ID >", value, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdGreaterThanOrEqualTo(String value) {
            addCriterion("WORKSHOP_ID >=", value, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdLessThan(String value) {
            addCriterion("WORKSHOP_ID <", value, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdLessThanOrEqualTo(String value) {
            addCriterion("WORKSHOP_ID <=", value, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdLike(String value) {
            addCriterion("WORKSHOP_ID like", value, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdNotLike(String value) {
            addCriterion("WORKSHOP_ID not like", value, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdIn(List<String> values) {
            addCriterion("WORKSHOP_ID in", values, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdNotIn(List<String> values) {
            addCriterion("WORKSHOP_ID not in", values, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdBetween(String value1, String value2) {
            addCriterion("WORKSHOP_ID between", value1, value2, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkshopIdNotBetween(String value1, String value2) {
            addCriterion("WORKSHOP_ID not between", value1, value2, "workshopId");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNull() {
            addCriterion("WORK_ID is null");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNotNull() {
            addCriterion("WORK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIdEqualTo(String value) {
            addCriterion("WORK_ID =", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotEqualTo(String value) {
            addCriterion("WORK_ID <>", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThan(String value) {
            addCriterion("WORK_ID >", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_ID >=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThan(String value) {
            addCriterion("WORK_ID <", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThanOrEqualTo(String value) {
            addCriterion("WORK_ID <=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLike(String value) {
            addCriterion("WORK_ID like", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotLike(String value) {
            addCriterion("WORK_ID not like", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdIn(List<String> values) {
            addCriterion("WORK_ID in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotIn(List<String> values) {
            addCriterion("WORK_ID not in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdBetween(String value1, String value2) {
            addCriterion("WORK_ID between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotBetween(String value1, String value2) {
            addCriterion("WORK_ID not between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNull() {
            addCriterion("ENTRY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIsNotNull() {
            addCriterion("ENTRY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andEntryTimeEqualTo(Date value) {
            addCriterion("ENTRY_TIME =", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotEqualTo(Date value) {
            addCriterion("ENTRY_TIME <>", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThan(Date value) {
            addCriterion("ENTRY_TIME >", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ENTRY_TIME >=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThan(Date value) {
            addCriterion("ENTRY_TIME <", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeLessThanOrEqualTo(Date value) {
            addCriterion("ENTRY_TIME <=", value, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeIn(List<Date> values) {
            addCriterion("ENTRY_TIME in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotIn(List<Date> values) {
            addCriterion("ENTRY_TIME not in", values, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeBetween(Date value1, Date value2) {
            addCriterion("ENTRY_TIME between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andEntryTimeNotBetween(Date value1, Date value2) {
            addCriterion("ENTRY_TIME not between", value1, value2, "entryTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNull() {
            addCriterion("DEPARTURE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNotNull() {
            addCriterion("DEPARTURE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeEqualTo(Date value) {
            addCriterion("DEPARTURE_TIME =", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotEqualTo(Date value) {
            addCriterion("DEPARTURE_TIME <>", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThan(Date value) {
            addCriterion("DEPARTURE_TIME >", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DEPARTURE_TIME >=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThan(Date value) {
            addCriterion("DEPARTURE_TIME <", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThanOrEqualTo(Date value) {
            addCriterion("DEPARTURE_TIME <=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIn(List<Date> values) {
            addCriterion("DEPARTURE_TIME in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotIn(List<Date> values) {
            addCriterion("DEPARTURE_TIME not in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeBetween(Date value1, Date value2) {
            addCriterion("DEPARTURE_TIME between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotBetween(Date value1, Date value2) {
            addCriterion("DEPARTURE_TIME not between", value1, value2, "departureTime");
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