package br.com.gymback.core.usecase.classroom;

import br.com.gymback.core.domain.ClassRoomDomain;
import br.com.gymback.core.gateway.classroom.SaveClassRoomGateway;
import br.com.gymback.core.gateway.modality.GetModalityGateway;
import br.com.gymback.core.gateway.schedule.SaveScheduleGateway;
import br.com.gymback.core.gateway.teacher.GetTeacherGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;

@Named
@RequiredArgsConstructor
public class CreateClassRoomUseCase {

  private final SaveClassRoomGateway saveClassRoomGateway;
  private final GetTeacherGateway getTeacherGateway;
  private final GetModalityGateway getModalityGateway;
  private final SaveScheduleGateway saveScheduleGateway;

  public ClassRoomDomain create(final ClassRoomDomain classRoom) {

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
