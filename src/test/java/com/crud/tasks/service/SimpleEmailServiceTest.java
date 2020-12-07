package com.crud.tasks.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mail.javamail.JavaMailSender;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SimpleEmailServiceTest {

    @InjectMocks
    private SimpleEmailService simpleEmailService;

    @Mock
    private JavaMailSender javaMailSender;

    @Test
    public void shouldSendEmail() {
        //Given
        //Mail mail = new Mail("test@test.com", "Test", "Test message");

        //SimpleMailMessage mailMessage = new SimpleMailMessage();
        //mailMessage.setTo(mail.getMailTo());
        //mailMessage.setSubject(mail.getSubject());
        //mailMessage.setText(mail.getMessage());

        //When
        //simpleEmailService.send(mail, EmailType.TRELLO_CARD_MAIL);

        //Then
        //verify(javaMailSender, times(1)).send(mailMessage);
    }

}