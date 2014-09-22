package com.codeminders.labs.timeextractor.rules.frequency;

import java.util.ArrayList;
import java.util.List;

import com.codeminders.labs.timeextractor.constants.Type;
import com.codeminders.labs.timeextractor.rules.BaseRule;
import com.codeminders.labs.timeextractor.temporal.entites.Temporal;
import com.codeminders.labs.timeextractor.utils.TemporalParser;

public class FrequencyTime extends BaseRule {

    private String frequencyTime;
    private TemporalParser parser;
    {
        parser = new TemporalParser();
    }

    public FrequencyTime(String frequencyTime) {
        this.frequencyTime = frequencyTime;
    }

    @Override
    public Type getType() {
        return Type.SET;
    }

    @Override
    public List<Temporal> getTemporal() {
        Temporal temporal = parser.getTemporalForEveryPeriod(frequencyTime);
        List<Temporal> temporalList = new ArrayList<Temporal>();
        temporalList.add(temporal);
        return temporalList;
    }

}