package ua.com.company.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import ua.com.company.model.Message;
import ua.com.company.model.User;
import ua.com.company.repository.MessageRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageServiceImpl messageService;

    private Message message;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        message = new Message();
        message.setId(1L);
        message.setContent("Test message");
        User user = new User();
        user.setId(1L);
        message.setSender(user);
        User user1 = new User();
        user1.setId(2L);
        message.setReceiver(user1);
    }

    @Test
    void testCreateMessage() {
        when(messageRepository.save(message)).thenReturn(message);

        Message createdMessage = messageService.createMessage(message);
        assertNotNull(createdMessage);
        assertEquals(message.getContent(), createdMessage.getContent());
    }

    @Test
    void testGetMessagesBySenderId() {
        List<Message> messages = Arrays.asList(message);
        when(messageRepository.findBySenderId(1L)).thenReturn(messages);

        List<Message> foundMessages = messageService.getMessagesBySenderId(1L);
        assertFalse(foundMessages.isEmpty());
        assertEquals(1, foundMessages.size());
        assertEquals(message.getContent(), foundMessages.get(0).getContent());
    }

    @Test
    void testGetMessagesByReceiverId() {
        List<Message> messages = Arrays.asList(message);
        when(messageRepository.findBySenderId(2L)).thenReturn(messages);

        List<Message> foundMessages = messageService.getMessagesByReceiverId(2L);
        assertFalse(foundMessages.isEmpty());
        assertEquals(1, foundMessages.size());
        assertEquals(message.getContent(), foundMessages.get(0).getContent());
    }

    @Test
    void testDeleteMessage() {
        doNothing().when(messageRepository).deleteById(1L);

        messageService.deleteMessage(1L);
        verify(messageRepository, times(1)).deleteById(1L);
    }
}
