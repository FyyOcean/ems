package com.baizhi.ems.controller;

import com.baizhi.ems.entity.User;
import com.baizhi.ems.service.UserService;
import com.baizhi.ems.utils.ValidateImageCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    //开发用户登录
    @RequestMapping("login")
    public  String login(String username,String password,HttpSession session){
        //查询是否存在此username
        User user = userService.login(username, password);
        //判断用户名密码为空 说明不存在   //不为空登陆成功
        if(user!=null){
            session.setAttribute("user",user);
            return "redirect:/emp/findAll";//查询所有的员工
        }else{
            return "redirect:/ems/login.jsp";
        }


    }
    //开发用户注册
    @PostMapping("regist")
    public String regist(User user, String code, HttpSession session){
        System.out.println(user);
        //验证码是否通过
        if(session.getAttribute("code").toString().equalsIgnoreCase(code)){//痛过之后注册
            userService.save(user);
            return "redirect:/ems/login.jsp";
        }else {
            return "redirect:/ems/regist.jsp";
        }

    }
    //生成验证码
    @RequestMapping("getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {
        //生成验证码
        String securityCode = ValidateImageCodeUtils.getSecurityCode();
        //将验证码放入session
        session.setAttribute("code",securityCode);
        //生成图片
        BufferedImage image = ValidateImageCodeUtils.createImage(securityCode);
        ServletOutputStream os = response.getOutputStream();
        ImageIO.write(image,"png",os);

    }
}
