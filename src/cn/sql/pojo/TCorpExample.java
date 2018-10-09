package cn.sql.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TCorpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCorpExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andOrgIsNull() {
            addCriterion("ORG is null");
            return (Criteria) this;
        }

        public Criteria andOrgIsNotNull() {
            addCriterion("ORG is not null");
            return (Criteria) this;
        }

        public Criteria andOrgEqualTo(String value) {
            addCriterion("ORG =", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgNotEqualTo(String value) {
            addCriterion("ORG <>", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgGreaterThan(String value) {
            addCriterion("ORG >", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgGreaterThanOrEqualTo(String value) {
            addCriterion("ORG >=", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgLessThan(String value) {
            addCriterion("ORG <", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgLessThanOrEqualTo(String value) {
            addCriterion("ORG <=", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgLike(String value) {
            addCriterion("ORG like", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgNotLike(String value) {
            addCriterion("ORG not like", value, "org");
            return (Criteria) this;
        }

        public Criteria andOrgIn(List<String> values) {
            addCriterion("ORG in", values, "org");
            return (Criteria) this;
        }

        public Criteria andOrgNotIn(List<String> values) {
            addCriterion("ORG not in", values, "org");
            return (Criteria) this;
        }

        public Criteria andOrgBetween(String value1, String value2) {
            addCriterion("ORG between", value1, value2, "org");
            return (Criteria) this;
        }

        public Criteria andOrgNotBetween(String value1, String value2) {
            addCriterion("ORG not between", value1, value2, "org");
            return (Criteria) this;
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

        public Criteria andSeqIdIsNull() {
            addCriterion("SEQ_ID is null");
            return (Criteria) this;
        }

        public Criteria andSeqIdIsNotNull() {
            addCriterion("SEQ_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSeqIdEqualTo(String value) {
            addCriterion("SEQ_ID =", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotEqualTo(String value) {
            addCriterion("SEQ_ID <>", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThan(String value) {
            addCriterion("SEQ_ID >", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdGreaterThanOrEqualTo(String value) {
            addCriterion("SEQ_ID >=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThan(String value) {
            addCriterion("SEQ_ID <", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLessThanOrEqualTo(String value) {
            addCriterion("SEQ_ID <=", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdLike(String value) {
            addCriterion("SEQ_ID like", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotLike(String value) {
            addCriterion("SEQ_ID not like", value, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdIn(List<String> values) {
            addCriterion("SEQ_ID in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotIn(List<String> values) {
            addCriterion("SEQ_ID not in", values, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdBetween(String value1, String value2) {
            addCriterion("SEQ_ID between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andSeqIdNotBetween(String value1, String value2) {
            addCriterion("SEQ_ID not between", value1, value2, "seqId");
            return (Criteria) this;
        }

        public Criteria andIdTCorpIsNull() {
            addCriterion("id_T_CORP is null");
            return (Criteria) this;
        }

        public Criteria andIdTCorpIsNotNull() {
            addCriterion("id_T_CORP is not null");
            return (Criteria) this;
        }

        public Criteria andIdTCorpEqualTo(Integer value) {
            addCriterion("id_T_CORP =", value, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andIdTCorpNotEqualTo(Integer value) {
            addCriterion("id_T_CORP <>", value, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andIdTCorpGreaterThan(Integer value) {
            addCriterion("id_T_CORP >", value, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andIdTCorpGreaterThanOrEqualTo(Integer value) {
            addCriterion("id_T_CORP >=", value, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andIdTCorpLessThan(Integer value) {
            addCriterion("id_T_CORP <", value, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andIdTCorpLessThanOrEqualTo(Integer value) {
            addCriterion("id_T_CORP <=", value, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andIdTCorpIn(List<Integer> values) {
            addCriterion("id_T_CORP in", values, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andIdTCorpNotIn(List<Integer> values) {
            addCriterion("id_T_CORP not in", values, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andIdTCorpBetween(Integer value1, Integer value2) {
            addCriterion("id_T_CORP between", value1, value2, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andIdTCorpNotBetween(Integer value1, Integer value2) {
            addCriterion("id_T_CORP not between", value1, value2, "idTCorp");
            return (Criteria) this;
        }

        public Criteria andRegNoIsNull() {
            addCriterion("REG_NO is null");
            return (Criteria) this;
        }

        public Criteria andRegNoIsNotNull() {
            addCriterion("REG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRegNoEqualTo(String value) {
            addCriterion("REG_NO =", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoNotEqualTo(String value) {
            addCriterion("REG_NO <>", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoGreaterThan(String value) {
            addCriterion("REG_NO >", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoGreaterThanOrEqualTo(String value) {
            addCriterion("REG_NO >=", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoLessThan(String value) {
            addCriterion("REG_NO <", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoLessThanOrEqualTo(String value) {
            addCriterion("REG_NO <=", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoLike(String value) {
            addCriterion("REG_NO like", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoNotLike(String value) {
            addCriterion("REG_NO not like", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoIn(List<String> values) {
            addCriterion("REG_NO in", values, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoNotIn(List<String> values) {
            addCriterion("REG_NO not in", values, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoBetween(String value1, String value2) {
            addCriterion("REG_NO between", value1, value2, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoNotBetween(String value1, String value2) {
            addCriterion("REG_NO not between", value1, value2, "regNo");
            return (Criteria) this;
        }

        public Criteria andCorpNameIsNull() {
            addCriterion("CORP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCorpNameIsNotNull() {
            addCriterion("CORP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCorpNameEqualTo(String value) {
            addCriterion("CORP_NAME =", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotEqualTo(String value) {
            addCriterion("CORP_NAME <>", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameGreaterThan(String value) {
            addCriterion("CORP_NAME >", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameGreaterThanOrEqualTo(String value) {
            addCriterion("CORP_NAME >=", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLessThan(String value) {
            addCriterion("CORP_NAME <", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLessThanOrEqualTo(String value) {
            addCriterion("CORP_NAME <=", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameLike(String value) {
            addCriterion("CORP_NAME like", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotLike(String value) {
            addCriterion("CORP_NAME not like", value, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameIn(List<String> values) {
            addCriterion("CORP_NAME in", values, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotIn(List<String> values) {
            addCriterion("CORP_NAME not in", values, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameBetween(String value1, String value2) {
            addCriterion("CORP_NAME between", value1, value2, "corpName");
            return (Criteria) this;
        }

        public Criteria andCorpNameNotBetween(String value1, String value2) {
            addCriterion("CORP_NAME not between", value1, value2, "corpName");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("ADDR is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("ADDR =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("ADDR <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("ADDR >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ADDR >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("ADDR <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("ADDR <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("ADDR like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("ADDR not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("ADDR in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("ADDR not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("ADDR between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("ADDR not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andBelongOrgIsNull() {
            addCriterion("BELONG_ORG is null");
            return (Criteria) this;
        }

        public Criteria andBelongOrgIsNotNull() {
            addCriterion("BELONG_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andBelongOrgEqualTo(String value) {
            addCriterion("BELONG_ORG =", value, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgNotEqualTo(String value) {
            addCriterion("BELONG_ORG <>", value, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgGreaterThan(String value) {
            addCriterion("BELONG_ORG >", value, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgGreaterThanOrEqualTo(String value) {
            addCriterion("BELONG_ORG >=", value, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgLessThan(String value) {
            addCriterion("BELONG_ORG <", value, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgLessThanOrEqualTo(String value) {
            addCriterion("BELONG_ORG <=", value, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgLike(String value) {
            addCriterion("BELONG_ORG like", value, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgNotLike(String value) {
            addCriterion("BELONG_ORG not like", value, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgIn(List<String> values) {
            addCriterion("BELONG_ORG in", values, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgNotIn(List<String> values) {
            addCriterion("BELONG_ORG not in", values, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgBetween(String value1, String value2) {
            addCriterion("BELONG_ORG between", value1, value2, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongOrgNotBetween(String value1, String value2) {
            addCriterion("BELONG_ORG not between", value1, value2, "belongOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgIsNull() {
            addCriterion("BELONG_DIST_ORG is null");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgIsNotNull() {
            addCriterion("BELONG_DIST_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgEqualTo(String value) {
            addCriterion("BELONG_DIST_ORG =", value, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgNotEqualTo(String value) {
            addCriterion("BELONG_DIST_ORG <>", value, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgGreaterThan(String value) {
            addCriterion("BELONG_DIST_ORG >", value, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgGreaterThanOrEqualTo(String value) {
            addCriterion("BELONG_DIST_ORG >=", value, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgLessThan(String value) {
            addCriterion("BELONG_DIST_ORG <", value, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgLessThanOrEqualTo(String value) {
            addCriterion("BELONG_DIST_ORG <=", value, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgLike(String value) {
            addCriterion("BELONG_DIST_ORG like", value, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgNotLike(String value) {
            addCriterion("BELONG_DIST_ORG not like", value, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgIn(List<String> values) {
            addCriterion("BELONG_DIST_ORG in", values, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgNotIn(List<String> values) {
            addCriterion("BELONG_DIST_ORG not in", values, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgBetween(String value1, String value2) {
            addCriterion("BELONG_DIST_ORG between", value1, value2, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongDistOrgNotBetween(String value1, String value2) {
            addCriterion("BELONG_DIST_ORG not between", value1, value2, "belongDistOrg");
            return (Criteria) this;
        }

        public Criteria andBelongTradeIsNull() {
            addCriterion("BELONG_TRADE is null");
            return (Criteria) this;
        }

        public Criteria andBelongTradeIsNotNull() {
            addCriterion("BELONG_TRADE is not null");
            return (Criteria) this;
        }

        public Criteria andBelongTradeEqualTo(String value) {
            addCriterion("BELONG_TRADE =", value, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeNotEqualTo(String value) {
            addCriterion("BELONG_TRADE <>", value, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeGreaterThan(String value) {
            addCriterion("BELONG_TRADE >", value, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeGreaterThanOrEqualTo(String value) {
            addCriterion("BELONG_TRADE >=", value, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeLessThan(String value) {
            addCriterion("BELONG_TRADE <", value, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeLessThanOrEqualTo(String value) {
            addCriterion("BELONG_TRADE <=", value, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeLike(String value) {
            addCriterion("BELONG_TRADE like", value, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeNotLike(String value) {
            addCriterion("BELONG_TRADE not like", value, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeIn(List<String> values) {
            addCriterion("BELONG_TRADE in", values, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeNotIn(List<String> values) {
            addCriterion("BELONG_TRADE not in", values, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeBetween(String value1, String value2) {
            addCriterion("BELONG_TRADE between", value1, value2, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andBelongTradeNotBetween(String value1, String value2) {
            addCriterion("BELONG_TRADE not between", value1, value2, "belongTrade");
            return (Criteria) this;
        }

        public Criteria andEconKindIsNull() {
            addCriterion("ECON_KIND is null");
            return (Criteria) this;
        }

        public Criteria andEconKindIsNotNull() {
            addCriterion("ECON_KIND is not null");
            return (Criteria) this;
        }

        public Criteria andEconKindEqualTo(String value) {
            addCriterion("ECON_KIND =", value, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindNotEqualTo(String value) {
            addCriterion("ECON_KIND <>", value, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindGreaterThan(String value) {
            addCriterion("ECON_KIND >", value, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindGreaterThanOrEqualTo(String value) {
            addCriterion("ECON_KIND >=", value, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindLessThan(String value) {
            addCriterion("ECON_KIND <", value, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindLessThanOrEqualTo(String value) {
            addCriterion("ECON_KIND <=", value, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindLike(String value) {
            addCriterion("ECON_KIND like", value, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindNotLike(String value) {
            addCriterion("ECON_KIND not like", value, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindIn(List<String> values) {
            addCriterion("ECON_KIND in", values, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindNotIn(List<String> values) {
            addCriterion("ECON_KIND not in", values, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindBetween(String value1, String value2) {
            addCriterion("ECON_KIND between", value1, value2, "econKind");
            return (Criteria) this;
        }

        public Criteria andEconKindNotBetween(String value1, String value2) {
            addCriterion("ECON_KIND not between", value1, value2, "econKind");
            return (Criteria) this;
        }

        public Criteria andAdmitMainIsNull() {
            addCriterion("ADMIT_MAIN is null");
            return (Criteria) this;
        }

        public Criteria andAdmitMainIsNotNull() {
            addCriterion("ADMIT_MAIN is not null");
            return (Criteria) this;
        }

        public Criteria andAdmitMainEqualTo(String value) {
            addCriterion("ADMIT_MAIN =", value, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainNotEqualTo(String value) {
            addCriterion("ADMIT_MAIN <>", value, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainGreaterThan(String value) {
            addCriterion("ADMIT_MAIN >", value, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainGreaterThanOrEqualTo(String value) {
            addCriterion("ADMIT_MAIN >=", value, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainLessThan(String value) {
            addCriterion("ADMIT_MAIN <", value, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainLessThanOrEqualTo(String value) {
            addCriterion("ADMIT_MAIN <=", value, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainLike(String value) {
            addCriterion("ADMIT_MAIN like", value, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainNotLike(String value) {
            addCriterion("ADMIT_MAIN not like", value, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainIn(List<String> values) {
            addCriterion("ADMIT_MAIN in", values, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainNotIn(List<String> values) {
            addCriterion("ADMIT_MAIN not in", values, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainBetween(String value1, String value2) {
            addCriterion("ADMIT_MAIN between", value1, value2, "admitMain");
            return (Criteria) this;
        }

        public Criteria andAdmitMainNotBetween(String value1, String value2) {
            addCriterion("ADMIT_MAIN not between", value1, value2, "admitMain");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNull() {
            addCriterion("START_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStartDateIsNotNull() {
            addCriterion("START_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStartDateEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE =", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE <>", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThan(Date value) {
            addCriterionForJDBCDate("START_DATE >", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE >=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThan(Date value) {
            addCriterionForJDBCDate("START_DATE <", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("START_DATE <=", value, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateIn(List<Date> values) {
            addCriterionForJDBCDate("START_DATE in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("START_DATE not in", values, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("START_DATE between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andStartDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("START_DATE not between", value1, value2, "startDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNull() {
            addCriterion("CHECK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCheckDateIsNotNull() {
            addCriterion("CHECK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCheckDateEqualTo(Date value) {
            addCriterionForJDBCDate("CHECK_DATE =", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CHECK_DATE <>", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CHECK_DATE >", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CHECK_DATE >=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThan(Date value) {
            addCriterionForJDBCDate("CHECK_DATE <", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CHECK_DATE <=", value, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateIn(List<Date> values) {
            addCriterionForJDBCDate("CHECK_DATE in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CHECK_DATE not in", values, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CHECK_DATE between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andCheckDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CHECK_DATE not between", value1, value2, "checkDate");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoIsNull() {
            addCriterion("OPER_MAN_IDENT_NO is null");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoIsNotNull() {
            addCriterion("OPER_MAN_IDENT_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoEqualTo(String value) {
            addCriterion("OPER_MAN_IDENT_NO =", value, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoNotEqualTo(String value) {
            addCriterion("OPER_MAN_IDENT_NO <>", value, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoGreaterThan(String value) {
            addCriterion("OPER_MAN_IDENT_NO >", value, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_MAN_IDENT_NO >=", value, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoLessThan(String value) {
            addCriterion("OPER_MAN_IDENT_NO <", value, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoLessThanOrEqualTo(String value) {
            addCriterion("OPER_MAN_IDENT_NO <=", value, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoLike(String value) {
            addCriterion("OPER_MAN_IDENT_NO like", value, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoNotLike(String value) {
            addCriterion("OPER_MAN_IDENT_NO not like", value, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoIn(List<String> values) {
            addCriterion("OPER_MAN_IDENT_NO in", values, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoNotIn(List<String> values) {
            addCriterion("OPER_MAN_IDENT_NO not in", values, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoBetween(String value1, String value2) {
            addCriterion("OPER_MAN_IDENT_NO between", value1, value2, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManIdentNoNotBetween(String value1, String value2) {
            addCriterion("OPER_MAN_IDENT_NO not between", value1, value2, "operManIdentNo");
            return (Criteria) this;
        }

        public Criteria andOperManNameIsNull() {
            addCriterion("OPER_MAN_NAME is null");
            return (Criteria) this;
        }

        public Criteria andOperManNameIsNotNull() {
            addCriterion("OPER_MAN_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andOperManNameEqualTo(String value) {
            addCriterion("OPER_MAN_NAME =", value, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameNotEqualTo(String value) {
            addCriterion("OPER_MAN_NAME <>", value, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameGreaterThan(String value) {
            addCriterion("OPER_MAN_NAME >", value, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameGreaterThanOrEqualTo(String value) {
            addCriterion("OPER_MAN_NAME >=", value, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameLessThan(String value) {
            addCriterion("OPER_MAN_NAME <", value, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameLessThanOrEqualTo(String value) {
            addCriterion("OPER_MAN_NAME <=", value, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameLike(String value) {
            addCriterion("OPER_MAN_NAME like", value, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameNotLike(String value) {
            addCriterion("OPER_MAN_NAME not like", value, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameIn(List<String> values) {
            addCriterion("OPER_MAN_NAME in", values, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameNotIn(List<String> values) {
            addCriterion("OPER_MAN_NAME not in", values, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameBetween(String value1, String value2) {
            addCriterion("OPER_MAN_NAME between", value1, value2, "operManName");
            return (Criteria) this;
        }

        public Criteria andOperManNameNotBetween(String value1, String value2) {
            addCriterion("OPER_MAN_NAME not between", value1, value2, "operManName");
            return (Criteria) this;
        }

        public Criteria andCorpStatusIsNull() {
            addCriterion("CORP_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andCorpStatusIsNotNull() {
            addCriterion("CORP_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andCorpStatusEqualTo(String value) {
            addCriterion("CORP_STATUS =", value, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusNotEqualTo(String value) {
            addCriterion("CORP_STATUS <>", value, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusGreaterThan(String value) {
            addCriterion("CORP_STATUS >", value, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusGreaterThanOrEqualTo(String value) {
            addCriterion("CORP_STATUS >=", value, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusLessThan(String value) {
            addCriterion("CORP_STATUS <", value, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusLessThanOrEqualTo(String value) {
            addCriterion("CORP_STATUS <=", value, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusLike(String value) {
            addCriterion("CORP_STATUS like", value, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusNotLike(String value) {
            addCriterion("CORP_STATUS not like", value, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusIn(List<String> values) {
            addCriterion("CORP_STATUS in", values, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusNotIn(List<String> values) {
            addCriterion("CORP_STATUS not in", values, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusBetween(String value1, String value2) {
            addCriterion("CORP_STATUS between", value1, value2, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andCorpStatusNotBetween(String value1, String value2) {
            addCriterion("CORP_STATUS not between", value1, value2, "corpStatus");
            return (Criteria) this;
        }

        public Criteria andRegCapiIsNull() {
            addCriterion("REG_CAPI is null");
            return (Criteria) this;
        }

        public Criteria andRegCapiIsNotNull() {
            addCriterion("REG_CAPI is not null");
            return (Criteria) this;
        }

        public Criteria andRegCapiEqualTo(String value) {
            addCriterion("REG_CAPI =", value, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiNotEqualTo(String value) {
            addCriterion("REG_CAPI <>", value, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiGreaterThan(String value) {
            addCriterion("REG_CAPI >", value, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiGreaterThanOrEqualTo(String value) {
            addCriterion("REG_CAPI >=", value, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiLessThan(String value) {
            addCriterion("REG_CAPI <", value, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiLessThanOrEqualTo(String value) {
            addCriterion("REG_CAPI <=", value, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiLike(String value) {
            addCriterion("REG_CAPI like", value, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiNotLike(String value) {
            addCriterion("REG_CAPI not like", value, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiIn(List<String> values) {
            addCriterion("REG_CAPI in", values, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiNotIn(List<String> values) {
            addCriterion("REG_CAPI not in", values, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiBetween(String value1, String value2) {
            addCriterion("REG_CAPI between", value1, value2, "regCapi");
            return (Criteria) this;
        }

        public Criteria andRegCapiNotBetween(String value1, String value2) {
            addCriterion("REG_CAPI not between", value1, value2, "regCapi");
            return (Criteria) this;
        }

        public Criteria andFareTermStartIsNull() {
            addCriterion("FARE_TERM_START is null");
            return (Criteria) this;
        }

        public Criteria andFareTermStartIsNotNull() {
            addCriterion("FARE_TERM_START is not null");
            return (Criteria) this;
        }

        public Criteria andFareTermStartEqualTo(Date value) {
            addCriterionForJDBCDate("FARE_TERM_START =", value, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermStartNotEqualTo(Date value) {
            addCriterionForJDBCDate("FARE_TERM_START <>", value, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermStartGreaterThan(Date value) {
            addCriterionForJDBCDate("FARE_TERM_START >", value, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermStartGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FARE_TERM_START >=", value, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermStartLessThan(Date value) {
            addCriterionForJDBCDate("FARE_TERM_START <", value, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermStartLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("FARE_TERM_START <=", value, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermStartIn(List<Date> values) {
            addCriterionForJDBCDate("FARE_TERM_START in", values, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermStartNotIn(List<Date> values) {
            addCriterionForJDBCDate("FARE_TERM_START not in", values, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermStartBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FARE_TERM_START between", value1, value2, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermStartNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("FARE_TERM_START not between", value1, value2, "fareTermStart");
            return (Criteria) this;
        }

        public Criteria andFareTermEndIsNull() {
            addCriterion("FARE_TERM_END is null");
            return (Criteria) this;
        }

        public Criteria andFareTermEndIsNotNull() {
            addCriterion("FARE_TERM_END is not null");
            return (Criteria) this;
        }

        public Criteria andFareTermEndEqualTo(String value) {
            addCriterion("FARE_TERM_END =", value, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndNotEqualTo(String value) {
            addCriterion("FARE_TERM_END <>", value, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndGreaterThan(String value) {
            addCriterion("FARE_TERM_END >", value, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndGreaterThanOrEqualTo(String value) {
            addCriterion("FARE_TERM_END >=", value, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndLessThan(String value) {
            addCriterion("FARE_TERM_END <", value, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndLessThanOrEqualTo(String value) {
            addCriterion("FARE_TERM_END <=", value, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndLike(String value) {
            addCriterion("FARE_TERM_END like", value, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndNotLike(String value) {
            addCriterion("FARE_TERM_END not like", value, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndIn(List<String> values) {
            addCriterion("FARE_TERM_END in", values, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndNotIn(List<String> values) {
            addCriterion("FARE_TERM_END not in", values, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndBetween(String value1, String value2) {
            addCriterion("FARE_TERM_END between", value1, value2, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareTermEndNotBetween(String value1, String value2) {
            addCriterion("FARE_TERM_END not between", value1, value2, "fareTermEnd");
            return (Criteria) this;
        }

        public Criteria andFareScopeIsNull() {
            addCriterion("FARE_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andFareScopeIsNotNull() {
            addCriterion("FARE_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andFareScopeEqualTo(String value) {
            addCriterion("FARE_SCOPE =", value, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeNotEqualTo(String value) {
            addCriterion("FARE_SCOPE <>", value, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeGreaterThan(String value) {
            addCriterion("FARE_SCOPE >", value, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeGreaterThanOrEqualTo(String value) {
            addCriterion("FARE_SCOPE >=", value, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeLessThan(String value) {
            addCriterion("FARE_SCOPE <", value, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeLessThanOrEqualTo(String value) {
            addCriterion("FARE_SCOPE <=", value, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeLike(String value) {
            addCriterion("FARE_SCOPE like", value, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeNotLike(String value) {
            addCriterion("FARE_SCOPE not like", value, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeIn(List<String> values) {
            addCriterion("FARE_SCOPE in", values, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeNotIn(List<String> values) {
            addCriterion("FARE_SCOPE not in", values, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeBetween(String value1, String value2) {
            addCriterion("FARE_SCOPE between", value1, value2, "fareScope");
            return (Criteria) this;
        }

        public Criteria andFareScopeNotBetween(String value1, String value2) {
            addCriterion("FARE_SCOPE not between", value1, value2, "fareScope");
            return (Criteria) this;
        }

        public Criteria andUniScidIsNull() {
            addCriterion("UNI_SCID is null");
            return (Criteria) this;
        }

        public Criteria andUniScidIsNotNull() {
            addCriterion("UNI_SCID is not null");
            return (Criteria) this;
        }

        public Criteria andUniScidEqualTo(String value) {
            addCriterion("UNI_SCID =", value, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidNotEqualTo(String value) {
            addCriterion("UNI_SCID <>", value, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidGreaterThan(String value) {
            addCriterion("UNI_SCID >", value, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidGreaterThanOrEqualTo(String value) {
            addCriterion("UNI_SCID >=", value, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidLessThan(String value) {
            addCriterion("UNI_SCID <", value, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidLessThanOrEqualTo(String value) {
            addCriterion("UNI_SCID <=", value, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidLike(String value) {
            addCriterion("UNI_SCID like", value, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidNotLike(String value) {
            addCriterion("UNI_SCID not like", value, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidIn(List<String> values) {
            addCriterion("UNI_SCID in", values, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidNotIn(List<String> values) {
            addCriterion("UNI_SCID not in", values, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidBetween(String value1, String value2) {
            addCriterion("UNI_SCID between", value1, value2, "uniScid");
            return (Criteria) this;
        }

        public Criteria andUniScidNotBetween(String value1, String value2) {
            addCriterion("UNI_SCID not between", value1, value2, "uniScid");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("TEL is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("TEL is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("TEL =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("TEL <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("TEL >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("TEL >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("TEL <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("TEL <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("TEL like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("TEL not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("TEL in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("TEL not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("TEL between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("TEL not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNull() {
            addCriterion("WEB_URL is null");
            return (Criteria) this;
        }

        public Criteria andWebUrlIsNotNull() {
            addCriterion("WEB_URL is not null");
            return (Criteria) this;
        }

        public Criteria andWebUrlEqualTo(String value) {
            addCriterion("WEB_URL =", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotEqualTo(String value) {
            addCriterion("WEB_URL <>", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThan(String value) {
            addCriterion("WEB_URL >", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_URL >=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThan(String value) {
            addCriterion("WEB_URL <", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLessThanOrEqualTo(String value) {
            addCriterion("WEB_URL <=", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlLike(String value) {
            addCriterion("WEB_URL like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotLike(String value) {
            addCriterion("WEB_URL not like", value, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlIn(List<String> values) {
            addCriterion("WEB_URL in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotIn(List<String> values) {
            addCriterion("WEB_URL not in", values, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlBetween(String value1, String value2) {
            addCriterion("WEB_URL between", value1, value2, "webUrl");
            return (Criteria) this;
        }

        public Criteria andWebUrlNotBetween(String value1, String value2) {
            addCriterion("WEB_URL not between", value1, value2, "webUrl");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumIsNull() {
            addCriterion("PRAC_PERSON_NUM is null");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumIsNotNull() {
            addCriterion("PRAC_PERSON_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumEqualTo(String value) {
            addCriterion("PRAC_PERSON_NUM =", value, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumNotEqualTo(String value) {
            addCriterion("PRAC_PERSON_NUM <>", value, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumGreaterThan(String value) {
            addCriterion("PRAC_PERSON_NUM >", value, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumGreaterThanOrEqualTo(String value) {
            addCriterion("PRAC_PERSON_NUM >=", value, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumLessThan(String value) {
            addCriterion("PRAC_PERSON_NUM <", value, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumLessThanOrEqualTo(String value) {
            addCriterion("PRAC_PERSON_NUM <=", value, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumLike(String value) {
            addCriterion("PRAC_PERSON_NUM like", value, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumNotLike(String value) {
            addCriterion("PRAC_PERSON_NUM not like", value, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumIn(List<String> values) {
            addCriterion("PRAC_PERSON_NUM in", values, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumNotIn(List<String> values) {
            addCriterion("PRAC_PERSON_NUM not in", values, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumBetween(String value1, String value2) {
            addCriterion("PRAC_PERSON_NUM between", value1, value2, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andPracPersonNumNotBetween(String value1, String value2) {
            addCriterion("PRAC_PERSON_NUM not between", value1, value2, "pracPersonNum");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeIsNull() {
            addCriterion("ORG_INST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeIsNotNull() {
            addCriterion("ORG_INST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeEqualTo(String value) {
            addCriterion("ORG_INST_CODE =", value, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeNotEqualTo(String value) {
            addCriterion("ORG_INST_CODE <>", value, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeGreaterThan(String value) {
            addCriterion("ORG_INST_CODE >", value, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_INST_CODE >=", value, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeLessThan(String value) {
            addCriterion("ORG_INST_CODE <", value, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeLessThanOrEqualTo(String value) {
            addCriterion("ORG_INST_CODE <=", value, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeLike(String value) {
            addCriterion("ORG_INST_CODE like", value, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeNotLike(String value) {
            addCriterion("ORG_INST_CODE not like", value, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeIn(List<String> values) {
            addCriterion("ORG_INST_CODE in", values, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeNotIn(List<String> values) {
            addCriterion("ORG_INST_CODE not in", values, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeBetween(String value1, String value2) {
            addCriterion("ORG_INST_CODE between", value1, value2, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andOrgInstCodeNotBetween(String value1, String value2) {
            addCriterion("ORG_INST_CODE not between", value1, value2, "orgInstCode");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumIsNull() {
            addCriterion("TAXPAY_NUM is null");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumIsNotNull() {
            addCriterion("TAXPAY_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumEqualTo(String value) {
            addCriterion("TAXPAY_NUM =", value, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumNotEqualTo(String value) {
            addCriterion("TAXPAY_NUM <>", value, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumGreaterThan(String value) {
            addCriterion("TAXPAY_NUM >", value, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumGreaterThanOrEqualTo(String value) {
            addCriterion("TAXPAY_NUM >=", value, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumLessThan(String value) {
            addCriterion("TAXPAY_NUM <", value, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumLessThanOrEqualTo(String value) {
            addCriterion("TAXPAY_NUM <=", value, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumLike(String value) {
            addCriterion("TAXPAY_NUM like", value, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumNotLike(String value) {
            addCriterion("TAXPAY_NUM not like", value, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumIn(List<String> values) {
            addCriterion("TAXPAY_NUM in", values, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumNotIn(List<String> values) {
            addCriterion("TAXPAY_NUM not in", values, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumBetween(String value1, String value2) {
            addCriterion("TAXPAY_NUM between", value1, value2, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andTaxpayNumNotBetween(String value1, String value2) {
            addCriterion("TAXPAY_NUM not between", value1, value2, "taxpayNum");
            return (Criteria) this;
        }

        public Criteria andStaffSizeIsNull() {
            addCriterion("STAFF_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andStaffSizeIsNotNull() {
            addCriterion("STAFF_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andStaffSizeEqualTo(String value) {
            addCriterion("STAFF_SIZE =", value, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeNotEqualTo(String value) {
            addCriterion("STAFF_SIZE <>", value, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeGreaterThan(String value) {
            addCriterion("STAFF_SIZE >", value, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeGreaterThanOrEqualTo(String value) {
            addCriterion("STAFF_SIZE >=", value, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeLessThan(String value) {
            addCriterion("STAFF_SIZE <", value, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeLessThanOrEqualTo(String value) {
            addCriterion("STAFF_SIZE <=", value, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeLike(String value) {
            addCriterion("STAFF_SIZE like", value, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeNotLike(String value) {
            addCriterion("STAFF_SIZE not like", value, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeIn(List<String> values) {
            addCriterion("STAFF_SIZE in", values, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeNotIn(List<String> values) {
            addCriterion("STAFF_SIZE not in", values, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeBetween(String value1, String value2) {
            addCriterion("STAFF_SIZE between", value1, value2, "staffSize");
            return (Criteria) this;
        }

        public Criteria andStaffSizeNotBetween(String value1, String value2) {
            addCriterion("STAFF_SIZE not between", value1, value2, "staffSize");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("ENGLISH_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("ENGLISH_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("ENGLISH_NAME =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("ENGLISH_NAME <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("ENGLISH_NAME >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENGLISH_NAME >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("ENGLISH_NAME <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("ENGLISH_NAME <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("ENGLISH_NAME like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("ENGLISH_NAME not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("ENGLISH_NAME in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("ENGLISH_NAME not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("ENGLISH_NAME between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("ENGLISH_NAME not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andFormerNameIsNull() {
            addCriterion("FORMER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFormerNameIsNotNull() {
            addCriterion("FORMER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFormerNameEqualTo(String value) {
            addCriterion("FORMER_NAME =", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameNotEqualTo(String value) {
            addCriterion("FORMER_NAME <>", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameGreaterThan(String value) {
            addCriterion("FORMER_NAME >", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameGreaterThanOrEqualTo(String value) {
            addCriterion("FORMER_NAME >=", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameLessThan(String value) {
            addCriterion("FORMER_NAME <", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameLessThanOrEqualTo(String value) {
            addCriterion("FORMER_NAME <=", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameLike(String value) {
            addCriterion("FORMER_NAME like", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameNotLike(String value) {
            addCriterion("FORMER_NAME not like", value, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameIn(List<String> values) {
            addCriterion("FORMER_NAME in", values, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameNotIn(List<String> values) {
            addCriterion("FORMER_NAME not in", values, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameBetween(String value1, String value2) {
            addCriterion("FORMER_NAME between", value1, value2, "formerName");
            return (Criteria) this;
        }

        public Criteria andFormerNameNotBetween(String value1, String value2) {
            addCriterion("FORMER_NAME not between", value1, value2, "formerName");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateOrgIsNull() {
            addCriterion("CREATE_ORG is null");
            return (Criteria) this;
        }

        public Criteria andCreateOrgIsNotNull() {
            addCriterion("CREATE_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andCreateOrgEqualTo(String value) {
            addCriterion("CREATE_ORG =", value, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgNotEqualTo(String value) {
            addCriterion("CREATE_ORG <>", value, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgGreaterThan(String value) {
            addCriterion("CREATE_ORG >", value, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_ORG >=", value, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgLessThan(String value) {
            addCriterion("CREATE_ORG <", value, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgLessThanOrEqualTo(String value) {
            addCriterion("CREATE_ORG <=", value, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgLike(String value) {
            addCriterion("CREATE_ORG like", value, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgNotLike(String value) {
            addCriterion("CREATE_ORG not like", value, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgIn(List<String> values) {
            addCriterion("CREATE_ORG in", values, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgNotIn(List<String> values) {
            addCriterion("CREATE_ORG not in", values, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgBetween(String value1, String value2) {
            addCriterion("CREATE_ORG between", value1, value2, "createOrg");
            return (Criteria) this;
        }

        public Criteria andCreateOrgNotBetween(String value1, String value2) {
            addCriterion("CREATE_ORG not between", value1, value2, "createOrg");
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