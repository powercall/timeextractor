package ai.digamma.rules.composite;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import ai.digamma.service.DateTimeExtractor;
import org.junit.Test;

import ai.digamma.entities.TemporalExtraction;
import ai.digamma.rules.general.GeneralTest;
import ai.digamma.temporal.entities.Type;

//composite rule date + time: 2014-02-02 + 11am

public class CompositeDateTime extends GeneralTest {

    @Test
    public void compositeDateTime1() {

        String toPredict = "2014-02-02 11am";
        List<TemporalExtraction> predicted =  new ArrayList<>(DateTimeExtractor.extract(toPredict,settings));
        assertEquals("2014-02-02 11am", predicted.get(0).getTemporalExpression());
        assertEquals(Type.TIME_DATE, predicted.get(0).getTemporal().get(0).getType());
        assertEquals(2014, predicted.get(0).getTemporal().get(0).getStartDate().getDate().getYear());
        assertEquals(2, predicted.get(0).getTemporal().get(0).getStartDate().getDate().getMonth());
        assertEquals(2, predicted.get(0).getTemporal().get(0).getStartDate().getDate().getDay());
        assertEquals(11, predicted.get(0).getTemporal().get(0).getStartDate().getTime().getHours());
        assertEquals(11, predicted.get(0).getTemporal().get(0).getEndDate().getTime().getHours());

    }

    @Test
    public void compositeDateTime2() {

        String toPredict = "11am 2014-02-02";
        List<TemporalExtraction> predicted =  new ArrayList<>(DateTimeExtractor.extract(toPredict,settings));
        assertEquals("11am 2014-02-02", predicted.get(0).getTemporalExpression());
        assertEquals(Type.TIME_DATE, predicted.get(0).getTemporal().get(0).getType());
        assertEquals(2014, predicted.get(0).getTemporal().get(0).getStartDate().getDate().getYear());
        assertEquals(2, predicted.get(0).getTemporal().get(0).getStartDate().getDate().getMonth());
        assertEquals(2, predicted.get(0).getTemporal().get(0).getStartDate().getDate().getDay());
        assertEquals(11, predicted.get(0).getTemporal().get(0).getStartDate().getTime().getHours());
        assertEquals(11, predicted.get(0).getTemporal().get(0).getEndDate().getTime().getHours());

    }

}
