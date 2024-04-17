package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import com.ohgiraffers.thymeleaf.model.dto.SelectCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;


@Controller
@RequestMapping("/lecture")
public class LectureController {

    @GetMapping("/expression")
    public ModelAndView expression(ModelAndView mv) {

        /* ModelAndView 는 Spring-Web-MVC 파트에서 깊게 다룰 예정
        *   지금은 내가 보여줄 동적인 페이지와 정보들을 담을 클래스라고 생각해보자
        * */

        mv.addObject("member", new MemberDTO("이지은",20,'여',"서울시 도봉구"));
        mv.addObject("hello","hello <h3>thymeleaf!!</h3>");
        mv.setViewName("/lecture/expression");

        return mv;
    }

    @GetMapping("/conditional")
    public ModelAndView conditional(ModelAndView mv) {
        
        mv.addObject("num",1);
        mv.addObject("str","바나나");

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("홍길동",20,'남',"서울시 도봉구"));
        memberList.add(new MemberDTO("홍길동1",25,'여',"서울시 도봉구1"));
        memberList.add(new MemberDTO("홍길동2",23,'남',"서울시 도봉구2"));
        memberList.add(new MemberDTO("홍길동3",28,'여',"서울시 도봉구3"));

        mv.addObject("memberList",memberList);

        return mv;
    }
    @GetMapping("/etc")
    public ModelAndView etc(ModelAndView mv) {

        SelectCriteria selectCriteria = new SelectCriteria(1,10,3);
        mv.addObject(selectCriteria);

        MemberDTO member = new MemberDTO("이지은",20,'여',"서울시 도봉구");
        mv.addObject("member",member);

        List<MemberDTO> memberList = new ArrayList<>();
        memberList.add(new MemberDTO("홍길동",20,'여',"서울시 도봉구"));
        memberList.add(new MemberDTO("홍길동2",22,'남',"서울시 도봉구2"));
        memberList.add(new MemberDTO("홍길동3",28,'여',"서울시 도봉구3"));
        memberList.add(new MemberDTO("홍길동4",29,'남',"서울시 도봉구4"));
        mv.addObject("memberList",memberList);

        Map<String, MemberDTO> memberMap = new HashMap<>();
        memberMap.put("m01",new MemberDTO("홍길동",20,'여',"서울시 도봉구"));
        memberMap.put("m02",new MemberDTO("홍길동2",22,'남',"서울시 도봉구2"));
        memberMap.put("m03",new MemberDTO("홍길동3",28,'여',"서울시 도봉구3"));
        memberMap.put("m04",new MemberDTO("홍길동4",29,'남',"서울시 도봉구4"));

        mv.addObject("memberMap",memberMap);
        return mv;
    }
}
