package br.com.gymback.worker.listener;

import br.com.gymback.core.domain.StudentDomain;
import br.com.gymback.core.exceptions.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QueueListener {
  @KafkaListener(topics = {"new-topic"}, groupId = "worker")
  public void receive(@Payload final Message<StudentDomain> message) throws BusinessException {
    log.info("payload {}", message.getPayload());
    log.info("headers {}", message.getHeaders());
  }
}
