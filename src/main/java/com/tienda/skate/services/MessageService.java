package com.tienda.skate.services;

import com.tienda.skate.model.Message;
import com.tienda.skate.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    public Optional<Message> get(int id) {
        return messageRepository.getMessage(id);
    }

    public void save(Message mensaje) {
        if (mensaje.getIdMessage() == 0) {
            messageRepository.save(mensaje);
        } else {
            Optional<Message> m = messageRepository.getMessage(mensaje.getIdMessage());
            if (m.isPresent()) {
                m.get();
            } else {
                messageRepository.save(mensaje);
            }
        }
    }

    public Message saveOld(Message mensaje) {
        if (mensaje.getIdMessage() == 0) {
            return messageRepository.save(mensaje);
        } else {
            Optional<Message> m = messageRepository.getMessage(mensaje.getIdMessage());
            if (m.isPresent()) {
                return m.get();
            } else {
                return messageRepository.save(mensaje);
            }
        }
    }

    public Message Update(Message mensaje) {
        if (mensaje.getIdMessage() != 0) {
            Optional<Message> ms = messageRepository.getMessage(mensaje.getIdMessage());
            if (ms.isPresent()) {
                if (mensaje.getMessageText() != null) {
                    ms.get().setMessageText(mensaje.getMessageText());
                }
                messageRepository.save(ms.get());
                return ms.get();
            } else {
                return mensaje;
            }
        } else {
            return mensaje;
        }
    }

    public boolean delete(int id) {
        boolean marca = false;
        Optional<Message> m = messageRepository.getMessage(id);
        if (m.isPresent()) {
            messageRepository.delete(m.get());
            marca = true;
        }
        return marca;
    }
}
