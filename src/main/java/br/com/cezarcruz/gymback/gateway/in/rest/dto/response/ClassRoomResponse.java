package br.com.cezarcruz.gymback.gateway.in.rest.dto.response;

import java.util.List;

public record ClassRoomResponse(
    String name,
    TeacherResponse teacher,
    ModalityResponse modality,

    List<String> weekDays
) {

}
