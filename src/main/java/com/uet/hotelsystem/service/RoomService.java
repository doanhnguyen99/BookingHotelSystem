package com.uet.hotelsystem.service;

import com.uet.hotelsystem.model.RoomEntity;
import com.uet.hotelsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<RoomEntity> listAll(){
        return roomRepository.findAll();
    }

    public void save(RoomEntity roomEntity){
        roomRepository.save(roomEntity);
    }

    public RoomEntity getRoom(Long id){
        return roomRepository.findById(id).get();
    }

    public void deleteRoom(Long id){
        roomRepository.deleteById(id);
    }
}
