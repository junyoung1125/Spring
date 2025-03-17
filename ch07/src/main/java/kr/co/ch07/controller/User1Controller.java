package kr.co.ch07.controller;

import kr.co.ch07.dto.User1DTO;
import kr.co.ch07.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service service;

    @GetMapping("/user1/list")
    public String list(Model model){

        // 서비스 호출
        List<User1DTO> user1DTOList = service.findAll();

        // 모델 참조
        model.addAttribute("user1DTOList", user1DTOList);

        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){

        // 서비스 호출
        service.register(user1DTO);

        // 리다이렉트 이동
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(String uid, Model model){

        // 수정 데이터 조회 서비스 호출
        User1DTO user1DTO = service.findById(uid);

        // 모델 참조
        model.addAttribute(user1DTO);

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO){

        // 서비스 호출
        service.modify(user1DTO);

        // 리다이렉트
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(String uid){
        service.delete(uid);
        return "redirect:/user1/list";
    }


}