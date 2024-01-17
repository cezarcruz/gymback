package br.com.messaging.out.email;

import br.com.gymback.core.gateway.SendEmailGateway;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.Personalization;
import jakarta.inject.Named;
import java.io.IOException;
import java.security.SecureRandom;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Named
public class SendGridEmailGateway implements SendEmailGateway {
  private static final SendGrid SEND_GRID = new SendGrid(System.getenv("SENDGRID_API_KEY"));

  @Override
  public void send(final String email, final String template) {

    Request request = new Request();
    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");

    try {
      request.setBody(doStuff());
      Response response = SEND_GRID.api(request);

      if (response.getStatusCode() >= 200 && response.getStatusCode() < 300) {
        log.info("email sent to {}", email);
      } else {
        log.error(response.getBody());
      }

    } catch (final IOException e) {
      throw new RuntimeException(e); //todo change this exception to business something
    }

  }

  private String  doStuff() throws IOException {
    Email from = new Email("cezarcruz22@gmail.com");

    // Replace these with your guest list or your personal email for testing purposes
    Personalization personalization = new Personalization();
    personalization.addDynamicTemplateData("code", new SecureRandom().nextInt(999999));
    personalization.addTo(new Email("cezarcruz@outlook.com"));

    Request request = new Request();

    request.setMethod(Method.POST);
    request.setEndpoint("mail/send");
    Mail mail = new Mail();
    mail.setFrom(from);
    mail.setTemplateId("d-263234620c2a4fdbb20530cfa911537b");

    mail.addPersonalization(personalization);

    return mail.build();
  }

}
