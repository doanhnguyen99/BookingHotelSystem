package com.uet.hotelsystem.service;

import com.uet.hotelsystem.model.RoomEntity;
import com.uet.hotelsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public Page<RoomEntity> listAll(int pageNum) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        return roomRepository.findAll(pageable);
    }

    public List<RoomEntity> getAll(){
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
