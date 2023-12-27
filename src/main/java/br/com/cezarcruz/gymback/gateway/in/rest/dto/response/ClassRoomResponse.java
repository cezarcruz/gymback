package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

import java.util.List;

public record ClassRoomResponse(

    String id,
    String name,
    TeacherResponse teacher,
    ModalityResponse modality,

    List<ScheduleResponse> schedule
) {

}
