package trainTicket.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TrainInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TrainInfoExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceIsNull() {
            addCriterion("departure_place is null");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceIsNotNull() {
            addCriterion("departure_place is not null");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceEqualTo(String value) {
            addCriterion("departure_place =", value, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceNotEqualTo(String value) {
            addCriterion("departure_place <>", value, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceGreaterThan(String value) {
            addCriterion("departure_place >", value, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("departure_place >=", value, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceLessThan(String value) {
            addCriterion("departure_place <", value, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceLessThanOrEqualTo(String value) {
            addCriterion("departure_place <=", value, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceLike(String value) {
            addCriterion("departure_place like", value, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceNotLike(String value) {
            addCriterion("departure_place not like", value, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceIn(List<String> values) {
            addCriterion("departure_place in", values, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceNotIn(List<String> values) {
            addCriterion("departure_place not in", values, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceBetween(String value1, String value2) {
            addCriterion("departure_place between", value1, value2, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDeparturePlaceNotBetween(String value1, String value2) {
            addCriterion("departure_place not between", value1, value2, "departurePlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceIsNull() {
            addCriterion("destination_place is null");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceIsNotNull() {
            addCriterion("destination_place is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceEqualTo(String value) {
            addCriterion("destination_place =", value, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceNotEqualTo(String value) {
            addCriterion("destination_place <>", value, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceGreaterThan(String value) {
            addCriterion("destination_place >", value, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("destination_place >=", value, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceLessThan(String value) {
            addCriterion("destination_place <", value, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceLessThanOrEqualTo(String value) {
            addCriterion("destination_place <=", value, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceLike(String value) {
            addCriterion("destination_place like", value, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceNotLike(String value) {
            addCriterion("destination_place not like", value, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceIn(List<String> values) {
            addCriterion("destination_place in", values, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceNotIn(List<String> values) {
            addCriterion("destination_place not in", values, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceBetween(String value1, String value2) {
            addCriterion("destination_place between", value1, value2, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDestinationPlaceNotBetween(String value1, String value2) {
            addCriterion("destination_place not between", value1, value2, "destinationPlace");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(Integer value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(Integer value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(Integer value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(Integer value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(Integer value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<Integer> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<Integer> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(Integer value1, Integer value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountIsNull() {
            addCriterion("carriage_amount is null");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountIsNotNull() {
            addCriterion("carriage_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountEqualTo(Integer value) {
            addCriterion("carriage_amount =", value, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountNotEqualTo(Integer value) {
            addCriterion("carriage_amount <>", value, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountGreaterThan(Integer value) {
            addCriterion("carriage_amount >", value, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("carriage_amount >=", value, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountLessThan(Integer value) {
            addCriterion("carriage_amount <", value, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountLessThanOrEqualTo(Integer value) {
            addCriterion("carriage_amount <=", value, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountIn(List<Integer> values) {
            addCriterion("carriage_amount in", values, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountNotIn(List<Integer> values) {
            addCriterion("carriage_amount not in", values, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountBetween(Integer value1, Integer value2) {
            addCriterion("carriage_amount between", value1, value2, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andCarriageAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("carriage_amount not between", value1, value2, "carriageAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountIsNull() {
            addCriterion("seat_amount is null");
            return (Criteria) this;
        }

        public Criteria andSeatAmountIsNotNull() {
            addCriterion("seat_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSeatAmountEqualTo(Integer value) {
            addCriterion("seat_amount =", value, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountNotEqualTo(Integer value) {
            addCriterion("seat_amount <>", value, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountGreaterThan(Integer value) {
            addCriterion("seat_amount >", value, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("seat_amount >=", value, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountLessThan(Integer value) {
            addCriterion("seat_amount <", value, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountLessThanOrEqualTo(Integer value) {
            addCriterion("seat_amount <=", value, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountIn(List<Integer> values) {
            addCriterion("seat_amount in", values, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountNotIn(List<Integer> values) {
            addCriterion("seat_amount not in", values, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountBetween(Integer value1, Integer value2) {
            addCriterion("seat_amount between", value1, value2, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andSeatAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("seat_amount not between", value1, value2, "seatAmount");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNull() {
            addCriterion("departure_time is null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIsNotNull() {
            addCriterion("departure_time is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time =", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time <>", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("departure_time >", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time >=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThan(Date value) {
            addCriterionForJDBCTime("departure_time <", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("departure_time <=", value, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeIn(List<Date> values) {
            addCriterionForJDBCTime("departure_time in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("departure_time not in", values, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("departure_time between", value1, value2, "departureTime");
            return (Criteria) this;
        }

        public Criteria andDepartureTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("departure_time not between", value1, value2, "departureTime");
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