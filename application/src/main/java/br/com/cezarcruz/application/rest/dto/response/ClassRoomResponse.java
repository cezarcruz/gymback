package br.com.cezarcruz.application.rest.dto.response;

import java.util.List;

public record ClassRoomResponse(

    String id,
    String name,
    TeacherResponse teacher,
    ModalityResponse modality,

    List<br.com.cezarcruz.gymback.gateway.in.rest.dto.response.ScheduleResponse> schedule
) {

}
