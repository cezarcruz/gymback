package br.com.cezarcruz.gymback.gateway.out.gateway.schedule;

import br.com.cezarcruz.gymback.core.domain.Schedule;
import java.util.List;

public interface SaveScheduleGateway {
  Schedule save(final Schedule schedule);
  List<Schedule> save(final List<Schedule> schedule);
}
