/* Under MIT License (C)2024 */
package br.com.gymback.persistence.out.mysql;

import br.com.gymback.core.domain.ScheduleDomain;
import br.com.gymback.core.gateway.schedule.SaveScheduleGateway;
import br.com.gymback.persistence.out.mysql.mapper.SchedulePersistenceMapper;
import br.com.gymback.persistence.out.mysql.repository.ScheduleRepository;
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
  public ScheduleDomain save(final ScheduleDomain schedule) {

    final var entity = schedulePersistenceMapper.toEntity(schedule);
    final var saved = scheduleRepository.save(entity);
    return schedulePersistenceMapper.toDomain(saved);
  }

  @Override
  public List<ScheduleDomain> save(List<ScheduleDomain> schedule) {
    // todo use saveAll ;)
    return schedule.stream().map(this::save).collect(Collectors.toList());
  }
}
