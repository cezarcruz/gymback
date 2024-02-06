/* Under MIT License (C)2024 */
package br.com.gymback.application.rest.dto.response;

import java.util.List;

public record ClassRoomResponse(
    String id,
    String name,
    TeacherResponse teacher,
    ModalityResponse modality,
    List<ScheduleResponse> schedule) {}
