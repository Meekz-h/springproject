package edu.wgu.d387_sample_code.timezone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TimezoneConverter {
    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM d, y hh:mm a");
    ZoneId zEastern = ZoneId.of("America/New_York");
    ZoneId zUniversal = ZoneId.of("UTC");
    ZoneId zMountain = ZoneId.of("America/Denver");

    LocalDateTime localDateTime = LocalDateTime.of(2025,5,3,14,30);

    ZonedDateTime zonedEastern = localDateTime.atZone(zEastern);
    ZonedDateTime zonedUniversal = zonedEastern.withZoneSameInstant(zUniversal);
    ZonedDateTime zonedMountain = zonedEastern.withZoneSameInstant(zMountain);

    LocalDateTime localDateTimeEastern = zonedEastern.toLocalDateTime();
    LocalDateTime localDateTimeUniversal = zonedUniversal.toLocalDateTime();
    LocalDateTime localDateTimeMountain = zonedMountain.toLocalDateTime();

    String eastern = localDateTimeEastern.format(df) +" EST";
    String universal = localDateTimeUniversal.format(df) +" UTC";
    String mountain = localDateTimeMountain.format(df) +" MST";

    public List<String> getDates(){

        List<String> eventTimes = new ArrayList<String>();
        eventTimes.add(eastern);
        eventTimes.add(mountain);
        eventTimes.add(universal);
        return eventTimes;
    }


}
