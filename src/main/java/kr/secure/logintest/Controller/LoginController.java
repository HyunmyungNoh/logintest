package kr.secure.logintest.Controller;

import kr.secure.logintest.Dto.MemberDto;
import kr.secure.logintest.Service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;

    @GetMapping("/")
    public String index() {
        return "/home/index";
    }

    @GetMapping("/member/signup")
    public String signupForm(Model model) {
        model.addAttribute("member",new MemberDto());

        return "/member/signupForm";
    }

    @PostMapping("/member/signup")
    public String signup(MemberDto memberDto) {
        loginService.signUp(memberDto);

        return "redirect:/";
    }

    @GetMapping("/member/login")
    public String login() {
        return "/member/loginForm";
    }
}