package com.xx.controller;

import com.github.pagehelper.PageInfo;
import com.xx.domain.Admin;
import com.xx.domain.Appointment;
import com.xx.domain.Book;
import com.xx.service.AdminService;
import com.xx.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private Md5Utils md5Utils;


    @RequestMapping("/login")
    private String login(){
        return "/admin/login";
    }


    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    @ResponseBody
    private Map validate(String token){
        HashMap resultMap = new HashMap();
        Admin admin  =null;
        admin = adminService.validate(md5Utils.getMD5(token));
        System.out.println(admin);
        if (admin != null) {
            resultMap.put("result","SUCCESS");
            return resultMap;
        }else {
            resultMap.put("result","FAILED");
            return resultMap;
        }

    }
    @RequestMapping(value ={""})
    private String jump(){
        return "redirect:/admin/index";
    }

    @RequestMapping("/index")
    private String index(@CookieValue("token") String token, Model model){
        model.addAttribute("token",token);
        return "admin/index";
    }

    @RequestMapping("/welcome")
    private String welcome(){

        return "admin/welcome";
    }

    @RequestMapping("/appoint")
    private String appoint(Model model){
//        adminService.getAppointAll(1,1);
        PageInfo<Appointment> page = adminService.queryByPage(1, 5);
        model.addAttribute("list",page.getList());
        model.addAttribute("page",page);
        return "admin/appoint";
    }

    @RequestMapping(value = {"/books/{page}"})
    private String books(@PathVariable(value = "page",required = false) int pageNo, Model model){
        PageInfo<Book> page = adminService.getBookAll(pageNo, 5);
        model.addAttribute("page",page);
        model.addAttribute("list",page.getList());
        System.out.println(page.getList());
        return "admin/books";
    }

    @RequestMapping("/articleList")
    private String articleList(){
        return "admin/article-list";
    }

    @RequestMapping("/danyeList")
    private String danyeList(){
        return "admin/danye-list";
    }
}
