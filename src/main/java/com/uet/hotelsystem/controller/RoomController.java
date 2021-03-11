package com.uet.hotelsystem.controller;

import com.uet.hotelsystem.model.RoomEntity;
import com.uet.hotelsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @RequestMapping("/all")
    public String viewHomePage(Model model) {
        return viewPage(model, 1);
    }

    @RequestMapping("/page/{pageNum}")
    public String viewPage(Model model,
                           @PathVariable(name = "pageNum") int pageNum) {

        Page<RoomEntity> page = roomService.listAll(pageNum);
        List<RoomEntity> listRooms = page.getContent();
        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());
        model.addAttribute("listRooms", listRooms);
        return "room-management";
    }

    @RequestMapping("/new")
    public String showNewRoomPage(Model model) {
        RoomEntity roomEntity = new RoomEntity();
        model.addAttribute("room", roomEntity);
        return "new_room";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRoom(@ModelAttribute("room") RoomEntity roomEntity) {
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

    @RequestMapping("/delete/{id}")
    public String deleteRoom(@PathVariable(name = "id") Long id) {
        roomService.deleteRoom(id);
        return "redirect:/room/all";
    }
}