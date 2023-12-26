package br.com.cezarcruz.gymback.gateway.out.persistence.mysql;

import br.com.cezarcruz.gymback.core.domain.Schedule;
import br.com.cezarcruz.gymback.gateway.out.gateway.schedule.SaveScheduleGateway;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.mapper.SchedulePersistenceMapper;
import br.com.cezarcruz.gymback.gateway.out.persistence.mysql.repository.ScheduleRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ScheduleMysqlGateway implements SaveScheduleGateway {

  private final ScheduleRepository scheduleRepository;
  private final SchedulePersistenceMapper schedulePersistenceMapper;

  @Override
  public Schedule save(final Schedule schedule) {

    final var entity = schedulePersistenceMapper.toEntity(schedule);
    final var saved = scheduleRepository.save(entity);
    return schedulePersistenceMapper.toDomain(saved);
  }

  @Override
  public List<Schedule> save(List<Schedule> schedule) {
    //todo use saveAll ;)
    return schedule.stream()
        .map(this::save)
        .collect(Collectors.toList());
  }
}
