package com.uet.hotelsystem.controller;

import com.uet.hotelsystem.model.RoomEntity;
import com.uet.hotelsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/all")
    public String viewAllRoom(Model model){
        List<RoomEntity> roomEntityList = roomService.listAll();
        model.addAttribute("listRooms", roomEntityList);
        return "room-management";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        RoomEntity roomEntity = new RoomEntity();
        model.addAttribute("room", roomEntity);
        return "new_room";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("room") RoomEntity roomEntity) {
        roomService.save(roomEntity);
        return "redirect:/room/all";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditRoomPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_room");
        RoomEntity roomEntity = roomService.getRoom(id);
        mav.addObject("room", roomEntity);
        return mav;
    }


}
