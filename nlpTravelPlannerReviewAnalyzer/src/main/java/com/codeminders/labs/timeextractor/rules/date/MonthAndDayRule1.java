package com.codeminders.labs.timeextractor.rules.date;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;

import com.codeminders.labs.timeextractor.constants.TemporalConstants;
import com.codeminders.labs.timeextractor.entities.Rule;
import com.codeminders.labs.timeextractor.temporal.entities.Date;
import com.codeminders.labs.timeextractor.temporal.entities.Temporal;
import com.codeminders.labs.timeextractor.temporal.entities.Type;
import com.codeminders.labs.timeextractor.utils.TemporalBasicCaseParser;
import com.codeminders.labs.timeextractor.utils.TemporalObjectGenerator;
import com.codeminders.labs.timeextractor.utils.Utils;

// July the 14th 2014, July 14 2014, July 14

public class MonthAndDayRule1 extends Rule {

    protected Locale locale = Locale.US;
    protected double confidence = 0.8;
    private int priority = 3;
    private String rule = "(\\b(" + TemporalConstants.MONTH_OF_YEAR + "|" + TemporalConstants.MONTH_OF_YEAR_EASY
            + "))[.]?[\\s]*[,]?[\\s]*(the[\\s]*)?((([1-2][0-9]|[3][0-1]|[1-9]))(th|st|nd)?)(of[\\s]*)?([\\s]*[,]?[\\s]*\\b([12][0-9]\\d\\d)\\b)?\\b";

    public MonthAndDayRule1() {

    }

    @Override
    public Type getType() {
        return Type.DATE;
    }

    @Override
    public List<Temporal> getTemporal(String text) {
        Matcher m = Utils.getMatch(rule, text);
        int year = 0;
        int month = TemporalBasicCaseParser.getMonthOfYear(m.group(1)).getValue();
        int day = Integer.parseInt(m.group(7));
        if (m.group(12) != null) {
            year = Integer.parseInt(m.group(12));
        }
        Date date = new Date(year, month, day);
        Temporal temporal = TemporalObjectGenerator.generateTemporalDate(type, date);
        List<Temporal> temporalList = new ArrayList<Temporal>();
        temporalList.add(temporal);

        return temporalList;
    }

    @Override
    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    @Override
    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    @Override
    public int compareTo(Rule o) {
        return super.compare(this, o);
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}