package cn.ccf.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
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

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("ORG_ID like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("ORG_ID not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("ORG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("ORG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("ORG_NAME =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("ORG_NAME <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("ORG_NAME >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_NAME >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("ORG_NAME <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("ORG_NAME <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("ORG_NAME like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("ORG_NAME not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("ORG_NAME in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("ORG_NAME not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("ORG_NAME between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("ORG_NAME not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNull() {
            addCriterion("DEP_ID is null");
            return (Criteria) this;
        }

        public Criteria andDepIdIsNotNull() {
            addCriterion("DEP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andDepIdEqualTo(String value) {
            addCriterion("DEP_ID =", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotEqualTo(String value) {
            addCriterion("DEP_ID <>", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThan(String value) {
            addCriterion("DEP_ID >", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdGreaterThanOrEqualTo(String value) {
            addCriterion("DEP_ID >=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThan(String value) {
            addCriterion("DEP_ID <", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLessThanOrEqualTo(String value) {
            addCriterion("DEP_ID <=", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdLike(String value) {
            addCriterion("DEP_ID like", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotLike(String value) {
            addCriterion("DEP_ID not like", value, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdIn(List<String> values) {
            addCriterion("DEP_ID in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotIn(List<String> values) {
            addCriterion("DEP_ID not in", values, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdBetween(String value1, String value2) {
            addCriterion("DEP_ID between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepIdNotBetween(String value1, String value2) {
            addCriterion("DEP_ID not between", value1, value2, "depId");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNull() {
            addCriterion("DEP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNotNull() {
            addCriterion("DEP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDepNameEqualTo(String value) {
            addCriterion("DEP_NAME =", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotEqualTo(String value) {
            addCriterion("DEP_NAME <>", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThan(String value) {
            addCriterion("DEP_NAME >", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEP_NAME >=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThan(String value) {
            addCriterion("DEP_NAME <", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThanOrEqualTo(String value) {
            addCriterion("DEP_NAME <=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLike(String value) {
            addCriterion("DEP_NAME like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotLike(String value) {
            addCriterion("DEP_NAME not like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameIn(List<String> values) {
            addCriterion("DEP_NAME in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotIn(List<String> values) {
            addCriterion("DEP_NAME not in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameBetween(String value1, String value2) {
            addCriterion("DEP_NAME between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotBetween(String value1, String value2) {
            addCriterion("DEP_NAME not between", value1, value2, "depName");
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

        public Criteria andEchoWorkIdIsNull() {
            addCriterion("ECHO_WORK_ID is null");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdIsNotNull() {
            addCriterion("ECHO_WORK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdEqualTo(String value) {
            addCriterion("ECHO_WORK_ID =", value, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdNotEqualTo(String value) {
            addCriterion("ECHO_WORK_ID <>", value, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdGreaterThan(String value) {
            addCriterion("ECHO_WORK_ID >", value, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdGreaterThanOrEqualTo(String value) {
            addCriterion("ECHO_WORK_ID >=", value, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdLessThan(String value) {
            addCriterion("ECHO_WORK_ID <", value, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdLessThanOrEqualTo(String value) {
            addCriterion("ECHO_WORK_ID <=", value, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdLike(String value) {
            addCriterion("ECHO_WORK_ID like", value, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdNotLike(String value) {
            addCriterion("ECHO_WORK_ID not like", value, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdIn(List<String> values) {
            addCriterion("ECHO_WORK_ID in", values, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdNotIn(List<String> values) {
            addCriterion("ECHO_WORK_ID not in", values, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdBetween(String value1, String value2) {
            addCriterion("ECHO_WORK_ID between", value1, value2, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andEchoWorkIdNotBetween(String value1, String value2) {
            addCriterion("ECHO_WORK_ID not between", value1, value2, "echoWorkId");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNull() {
            addCriterion("USERNAME is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("USERNAME is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("USERNAME =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("USERNAME <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("USERNAME >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("USERNAME >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("USERNAME <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("USERNAME <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("USERNAME like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("USERNAME not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("USERNAME in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("USERNAME not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("USERNAME between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("USERNAME not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRoleIsNull() {
            addCriterion("ROLE is null");
            return (Criteria) this;
        }

        public Criteria andRoleIsNotNull() {
            addCriterion("ROLE is not null");
            return (Criteria) this;
        }

        public Criteria andRoleEqualTo(String value) {
            addCriterion("ROLE =", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotEqualTo(String value) {
            addCriterion("ROLE <>", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThan(String value) {
            addCriterion("ROLE >", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleGreaterThanOrEqualTo(String value) {
            addCriterion("ROLE >=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThan(String value) {
            addCriterion("ROLE <", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLessThanOrEqualTo(String value) {
            addCriterion("ROLE <=", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleLike(String value) {
            addCriterion("ROLE like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotLike(String value) {
            addCriterion("ROLE not like", value, "role");
            return (Criteria) this;
        }

        public Criteria andRoleIn(List<String> values) {
            addCriterion("ROLE in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotIn(List<String> values) {
            addCriterion("ROLE not in", values, "role");
            return (Criteria) this;
        }

        public Criteria andRoleBetween(String value1, String value2) {
            addCriterion("ROLE between", value1, value2, "role");
            return (Criteria) this;
        }

        public Criteria andRoleNotBetween(String value1, String value2) {
            addCriterion("ROLE not between", value1, value2, "role");
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