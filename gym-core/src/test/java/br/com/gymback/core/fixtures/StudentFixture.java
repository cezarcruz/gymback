package br.com.gymback.core.fixtures;

import br.com.gymback.core.domain.StudentDomain;
import org.instancio.Instancio;

public class StudentFixture {

  public static StudentDomain getStudent() {
    return Instancio.create(StudentDomain.class);
  }

}
