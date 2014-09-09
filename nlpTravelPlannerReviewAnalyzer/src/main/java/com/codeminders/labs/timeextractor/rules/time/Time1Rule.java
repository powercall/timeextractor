package com.codeminders.labs.timeextractor.rules.time;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.codeminders.labs.timeextractor.constants.Type;
import com.codeminders.labs.timeextractor.rules.BaseRule;
import com.codeminders.labs.timeextractor.temporal.entites.Temporal;
import com.codeminders.labs.timeextractor.temporal.entites.Time;
import com.codeminders.labs.timeextractor.utils.TemporalObjectGenerator;
import com.codeminders.labs.timeextractor.utils.TimeConvertor;

public class Time1Rule extends BaseRule {

    protected Locale locale = Locale.US;
    protected double confidence = 0.83;
    private String hours;
    private String aMPm;
    private String timezone;

    public Time1Rule(String hours, String aMPm, String timezone) {
        this.hours = hours;
        this.aMPm = aMPm;
        this.timezone = timezone;
    }

    @Override
    public Type getType() {
        return Type.TIME;
    }

    @Override
    public List<Temporal> getTemporal() {
        Time time = new Time();
        int hours = Integer.parseInt(this.hours);
        hours = TimeConvertor.convertTime(hours, aMPm);
        time.setHours(hours);
        Temporal temporal = TemporalObjectGenerator.generateTemporalTime(type, time);
        List<Temporal> temporalList = new ArrayList<Temporal>();
        temporalList.add(temporal);
        return temporalList;
    }
}