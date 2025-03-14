package kr.co.ch06.controller;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.service.User1Service;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Controller
public class User1Controller {

    private final User1Service user1Service;

    @GetMapping("/user1/list")
    public String list(Model model){

        List<User1DTO> user1List = user1Service.findAll();
        model.addAttribute("user1List", user1List);

        return "/user1/list";
    }

    @GetMapping("/user1/register")
    public String register(){
        return "/user1/register";
    }

    @PostMapping("/user1/register")
    public String register(User1DTO user1DTO){
        log.info("register user1DTO: {}", user1DTO);

        // 서비스 호출
        user1Service.register(user1DTO);

        // 리다이렉트 이동
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/modify")
    public String modify(String uid, Model model){ // 스프링부트는 @RequestParam("uid") 안해도 됨
        log.info("modify uid: {}", uid);

        // 수정 데이터 조회
        User1DTO user1DTO = user1Service.findById(uid);

        // 모델 참조
        model.addAttribute(user1DTO);

        return "/user1/modify";
    }

    @PostMapping("/user1/modify")
    public String modify(User1DTO user1DTO){
        log.info("user1DTO: {}", user1DTO);

        // 서비스 호출
        user1Service.modify(user1DTO);

        // 리다이렉트
        return "redirect:/user1/list";
    }

    @GetMapping("/user1/delete")
    public String delete(String uid){
        log.info("uid: {}", uid);

        // 서비스 호출
        user1Service.delete(uid);

        // 리다이렉트
        return "redirect:/user1/list";
    }
}
