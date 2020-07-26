package de.dugurlu.brewery.model.mapper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Component;

@Component
public class DateMapper {
  public OffsetDateTime asOffsetDateTime(Timestamp t) {
    if (t == null) {
      return null;
    }
    LocalDateTime dateTime = t.toLocalDateTime();
    return OffsetDateTime.of(dateTime.getYear(), dateTime.getMonthValue(), dateTime.getDayOfMonth(),
        dateTime.getHour(), dateTime.getMinute(), dateTime.getSecond(), dateTime.getNano(),
        ZoneOffset.UTC);
  }

  public Timestamp asTimestamp(OffsetDateTime dateTime) {
    if (dateTime == null) {
      return null;
    }
    return Timestamp.valueOf(dateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime());
  }
}
