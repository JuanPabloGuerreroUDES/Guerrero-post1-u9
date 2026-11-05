package com.clinica.recordatorios.channel;

import com.clinica.recordatorios.channel.gateway.NotificadorSmsGateway;
import com.clinica.recordatorios.domain.CanalNotificacion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

class ReminderChannelFactoryImplTest {

    private EmailReminderChannel emailReminderChannel;
    private SmsReminderChannel smsReminderChannel;
    private ReminderChannelFactoryImpl factory;

    @BeforeEach
    void setUp() {
        emailReminderChannel = new EmailReminderChannel();
        smsReminderChannel = new SmsReminderChannel(mock(NotificadorSmsGateway.class));
        factory = new ReminderChannelFactoryImpl(emailReminderChannel, smsReminderChannel);
    }

    @Test
    void obtenerCanal_tipoEmail_retornaEstrategiaDeEmail() {
        assertSame(emailReminderChannel, factory.obtenerCanal(CanalNotificacion.EMAIL));
    }

    @Test
    void obtenerCanal_tipoSms_retornaEstrategiaDeSms() {
        assertSame(smsReminderChannel, factory.obtenerCanal(CanalNotificacion.SMS));
    }
}
