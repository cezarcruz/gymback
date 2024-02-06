/* Under MIT License (C)2024 */
package br.com.gymback.core.gateway.teacher;

import br.com.gymback.core.domain.TeacherDomain;

public interface SaveTeacherGateway {
  TeacherDomain save(final TeacherDomain teacher);
}
