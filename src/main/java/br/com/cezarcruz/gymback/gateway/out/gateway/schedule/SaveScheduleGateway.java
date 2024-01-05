package br.com.cezarcruz.gymback.gateway.out.gateway.schedule;

import br.com.cezarcruz.gymback.core.domain.ScheduleDomain;
import java.util.List;

public interface SaveScheduleGateway {
  ScheduleDomain save(final ScheduleDomain schedule);
  List<ScheduleDomain> save(final List<ScheduleDomain> schedule);
}
