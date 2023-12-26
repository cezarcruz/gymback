package br.com.cezarcruz.gymback.core.usecase.classroom;

import br.com.cezarcruz.gymback.core.domain.ClassRoom;
import br.com.cezarcruz.gymback.gateway.out.gateway.classroom.SaveClassRoomGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.modality.GetModalityGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.schedule.SaveScheduleGateway;
import br.com.cezarcruz.gymback.gateway.out.gateway.teacher.GetTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateClassRoomUseCase {

  private final SaveClassRoomGateway saveClassRoomGateway;
  private final GetTeacherGateway getTeacherGateway;
  private final GetModalityGateway getModalityGateway;
  private final SaveScheduleGateway saveScheduleGateway;

  public ClassRoom create(final ClassRoom classRoom) {

    var classRoomWithTeacher = getTeacherGateway.findById(classRoom.teacher().id())
        .map(classRoom::withTeacher)
        .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

    var validClassRoom = getModalityGateway.findById(classRoom.modality().id())
        .map(classRoomWithTeacher::withModality)
        .orElseThrow(() -> new RuntimeException("Modalidade não encontrada"));

    var schedules = saveScheduleGateway.save(classRoom.schedule());

    return saveClassRoomGateway.save(validClassRoom.withSchedule(schedules));

  }

}
