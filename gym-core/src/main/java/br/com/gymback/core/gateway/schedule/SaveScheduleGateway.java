package br.com.gymback.core.gateway.schedule;

import br.com.gymback.core.domain.ScheduleDomain;
import java.util.List;

public interface SaveScheduleGateway {
  ScheduleDomain save(final ScheduleDomain schedule);
  List<ScheduleDomain> save(final List<ScheduleDomain> schedule);
}
