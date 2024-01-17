/* Under MIT License (C)2024 */
package br.com.gymback.worker.listener;

import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.core.exceptions.BusinessException;
import br.com.gymback.core.gateway.SendEmailGateway;
import jakarta.inject.Named;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;

@Slf4j
@Named
public class StudentCreatedListener {

  //todo should be a use case
  private final SendEmailGateway sendEmailGateway;

  public StudentCreatedListener(SendEmailGateway sendEmailGateway) {
    this.sendEmailGateway = sendEmailGateway;
  }


  @KafkaListener(topics = {"new-topic"})
  public void receive(@Payload final Message<StudentDomain> message) throws BusinessException {
    log.info("payload {}", message.getPayload());
    log.info("headers {}", message.getHeaders());

    sendEmailGateway.send("", "");
  }
}
