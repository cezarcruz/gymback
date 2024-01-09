package br.com.gymback.core.fixtures;

import br.com.gymback.core.domain.ClassRoomDomain;
import org.instancio.Instancio;

public class ClassRoomFixtures {
  public static ClassRoomDomain getClassRoom() {
    return Instancio.create(ClassRoomDomain.class);
  }
}
