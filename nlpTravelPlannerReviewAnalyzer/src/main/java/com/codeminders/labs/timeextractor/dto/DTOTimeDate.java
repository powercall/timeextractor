package com.codeminders.labs.timeextractor.dto;

import com.codeminders.labs.timeextractor.temporal.entities.Temporal;
import com.codeminders.labs.timeextractor.temporal.entities.TimeDate;
import com.codeminders.labs.timeextractor.temporal.entities.Type;

public class DTOTimeDate implements DTOTemporal {

	private TimeDate startDateTime;
	private TimeDate endDateTime;
	private Type type;

	public DTOTimeDate(Temporal temporal) {
		this.startDateTime = temporal.getStartDate();
		this.endDateTime = temporal.getEndDate();
		type = temporal.getType();
	}

	public TimeDate getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(TimeDate startDateTime) {
		this.startDateTime = startDateTime;
	}

	public TimeDate getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(TimeDate endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
