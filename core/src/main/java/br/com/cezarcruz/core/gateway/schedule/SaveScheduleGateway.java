package br.com.cezarcruz.core.gateway.schedule;

import br.com.cezarcruz.core.domain.ScheduleDomain;
import java.util.List;

public interface SaveScheduleGateway {
  ScheduleDomain save(final ScheduleDomain schedule);
  List<ScheduleDomain> save(final List<ScheduleDomain> schedule);
}
