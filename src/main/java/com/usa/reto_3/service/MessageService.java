package com.usa.reto_3.service;

import com.usa.reto_3.model.MessageModel;
import com.usa.reto_3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<MessageModel> obtener(){
        return messageRepository.findAll();
    }

    public Optional<MessageModel> obtenerPorId(int id) {
        return messageRepository. findById(id);
    }

    public void crear(MessageModel message){
        if(!messageRepository.existsById(message.getIdMessage())) {
            messageRepository.save(message);
        }
    }

    public MessageModel actualizar(MessageModel message) {
        if( messageRepository.existsById(message.getIdMessage())) {
            Optional<MessageModel> e= messageRepository.findById(message.getIdMessage());
            if(e.isPresent()) {
                if(message.getMessageText()!=null) {
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public void eliminar(int id) {
        messageRepository.deleteById(id);
    }

}
