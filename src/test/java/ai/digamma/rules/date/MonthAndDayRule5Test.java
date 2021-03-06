package ai.digamma.rules.date;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import ai.digamma.service.DateTimeExtractor;
import org.junit.Test;

import ai.digamma.entities.TemporalExtraction;
import ai.digamma.rules.general.GeneralTest;
import ai.digamma.temporal.entities.DayOfWeek;

public class MonthAndDayRule5Test extends GeneralTest {

    @Test
    public void monthAndDayRule4Test1() {

        String toPredict = "Sunday 17 of July";
        List<TemporalExtraction> predicted =  new ArrayList<>(DateTimeExtractor.extract(toPredict,settings));
        assertEquals("Sunday 17 of July", predicted.get(0).getTemporalExpression());
        assertEquals(7, predicted.get(0).getTemporal().get(0).getStartDate().getDate().getMonth());
        assertEquals(DayOfWeek.SU, predicted.get(0).getTemporal().get(0).getStartDate().getDate().getDayOfWeek());
        assertEquals(17, predicted.get(0).getTemporal().get(0).getStartDate().getDate().getDay());

    }

}
