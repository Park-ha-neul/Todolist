package com.tdl.api.controller.mus;

import com.tdl.api.config.service.KakaoService;
import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Log4j2
@Controller
public class KakaoController {

    @Autowired
    private KakaoService kakao;

    @RequestMapping(value = "/")
    public String index() throws Exception {
        return "/index";
    }

    @GetMapping("/Kakao")
    public String Kakao(@RequestParam("code") String code, HttpSession session, ModelMap modelMap) throws  Exception {
        String access_token = kakao.getAccessToken(code);

        HashMap<String,Object> userInfo = kakao.getUserInfo(access_token, session);

        if (userInfo.get("nickname")==null ||
                userInfo.get("email")==null ||
                userInfo.get("age_range")==null) {

            modelMap.addAttribute("msg", "로그인에 실패하였습니다. kakao에서 개인정보활용에 동의해주세요.");
            modelMap.addAttribute("url", "/index");


        } else if (userInfo.get("nickname") != null) {
            session.setAttribute("user_name", userInfo.get("nickname"));
            session.setAttribute("user_mail", userInfo.get("email"));
            session.setAttribute("user_range", userInfo.get("age_range"));
            session.setAttribute("user_profile_image", userInfo.get("profile_image"));
            session.setAttribute("user_thumbnail_image", userInfo.get("thumbnail_image"));

            log.info("카카오에서 받아온 userInfo 값");
            log.info("user_name : " + session.getAttribute("nickname"));
            log.info("email : " + session.getAttribute("email"));
            log.info("age_range : " + session.getAttribute("age_range"));
            log.info("profile_image : " + session.getAttribute("profile_image"));
            log.info("thumbnail_image : " + session.getAttribute("thumbnail_image"));

            log.info(this.getClass().getName() + ".kakaologin end");

            modelMap.addAttribute("msg", "로그인 되었습니다. \"" + session.getAttribute("user_name" + "\"님 환영합니다."));
            modelMap.addAttribute("url", "/index");
        }

        return "/";
    }

    @RequestMapping(value = "kakaologout")
    public String kakaologout(ModelMap modelMap, HttpSession session) throws Exception {

        session.invalidate();
        modelMap.addAttribute("msg", "로그아웃 되었습니다.");
        modelMap.addAttribute("url", "/index");

        return "/";
    }
}
