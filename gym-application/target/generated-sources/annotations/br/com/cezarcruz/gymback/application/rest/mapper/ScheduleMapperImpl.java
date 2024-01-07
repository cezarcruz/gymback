package br.com.cezarcruz.gymback.application.rest.mapper;

import br.com.cezarcruz.gymback.application.rest.dto.request.CreateScheduleRequest;
import br.com.cezarcruz.gymback.application.rest.dto.response.ScheduleResponse;
import br.com.cezarcruz.gymback.core.domain.ScheduleDomain;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import java.time.LocalTime;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-07T20:45:44-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21 (Eclipse Adoptium)"
)
@Singleton
@Named
public class ScheduleMapperImpl implements ScheduleMapper {

    @Override
    public ScheduleResponse from(ScheduleDomain source) {
        if ( source == null ) {
            return null;
        }

        String weekDay = null;
        LocalTime startHour = null;
        LocalTime endHour = null;

        weekDay = source.weekDay();
        startHour = source.startHour();
        endHour = source.endHour();

        ScheduleResponse scheduleResponse = new ScheduleResponse( weekDay, startHour, endHour );

        return scheduleResponse;
    }

    @Override
    public ScheduleDomain from(CreateScheduleRequest source) {
        if ( source == null ) {
            return null;
        }

        String weekDay = null;
        LocalTime startHour = null;
        LocalTime endHour = null;

        weekDay = source.weekDay();
        startHour = source.startHour();
        endHour = source.endHour();

        String id = null;

        ScheduleDomain scheduleDomain = new ScheduleDomain( id, weekDay, startHour, endHour );

        return scheduleDomain;
    }
}
