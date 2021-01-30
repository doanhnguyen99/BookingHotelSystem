package com.uet.hotelsystem.repository;

import com.uet.hotelsystem.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
}
