/* Under MIT License (C)2024 */
package br.com.messaging.out.kafka;

import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.core.gateway.student.NotifyStudentGateway;
import jakarta.inject.Named;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;

@Named
@RequiredArgsConstructor
public class StudentKafkaGateway implements NotifyStudentGateway {

  private final KafkaTemplate<String, StudentDomain> kafkaTemplate;

  public void notify(final StudentDomain studentDomain) {
    kafkaTemplate.send("new-topic", studentDomain);
  }
}
