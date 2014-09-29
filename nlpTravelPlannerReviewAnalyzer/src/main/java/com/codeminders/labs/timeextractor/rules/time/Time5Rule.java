package com.codeminders.labs.timeextractor.rules.time;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;

import com.codeminders.labs.timeextractor.constants.TemporalConstants;
import com.codeminders.labs.timeextractor.entities.Rule;
import com.codeminders.labs.timeextractor.temporal.entities.Temporal;
import com.codeminders.labs.timeextractor.temporal.entities.Time;
import com.codeminders.labs.timeextractor.temporal.entities.Type;
import com.codeminders.labs.timeextractor.utils.TemporalBasicCaseParser;
import com.codeminders.labs.timeextractor.utils.TemporalObjectGenerator;
import com.codeminders.labs.timeextractor.utils.Utils;

// 2100 CET

public class Time5Rule extends Rule {
    private TemporalBasicCaseParser parser = new TemporalBasicCaseParser();
    protected Locale locale = Locale.US;
    protected double confidence = 0.8;
    private int priority = 2;
    private String rule = "(at[\\s]*|about[\\s]*|at about[\\s]*)?(([0-9]|0[0-9]|1[0-9]|2[0-3])([0-5][0-9])[\\s]*" + TemporalConstants.TIME_ZONE + ")";

    public Time5Rule() {
    }

    @Override
    public Type getType() {
        return Type.TIME;
    }

    @Override
    public List<Temporal> getTemporal(String text) {
        Matcher m = Utils.getMatch(rule, text);
        Time time = new Time();
        int hours = Integer.parseInt(m.group(3));
        int minute = Integer.parseInt(m.group(4));
        int timezone = 0;
        if (m.group(4) != null) {
            timezone = parser.getTimeZone(m.group(5));
            time.setTimezone(timezone);
        }
        time.setHours(hours);
        time.setMinutes(minute);
        Temporal temporal = TemporalObjectGenerator.generateTemporalTime(type, time);
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

    @Override
    public int compareTo(Rule o) {
        return super.compare(this, o);
    }

}