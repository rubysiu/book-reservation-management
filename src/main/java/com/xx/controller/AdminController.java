package com.xx.controller;

import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.xx.domain.Admin;
import com.xx.domain.Appointment;
import com.xx.domain.Book;
import com.xx.service.AdminService;
import com.xx.utils.Md5Utils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = {"/appoint","/appoint/{page}"})
    private String appoint(@PathVariable(value = "page",required = false) String pageNo,@RequestParam(value = "studentId",required = false,defaultValue = "")Long studentId,Model model){
        int pageOn = 1;
        if ("".equals(pageNo)||pageNo!=null){
            pageOn = Integer.parseInt(pageNo);
        }
//        if (studentId!=null||"".equals(studentId)){
//            pageOn = 1;
//        }

        PageInfo<Appointment> page = adminService.queryByPage(studentId,pageOn, 5);
        model.addAttribute("studentId",studentId);
        model.addAttribute("list",page.getList());
        model.addAttribute("page",page);
        return "admin/appoint";
    }

    @RequestMapping(value = {"/books","/books/{page}"})
    private String books(@PathVariable(value = "page",required = false) String pageNo,@RequestParam(value = "name",required = false,defaultValue = "")String name,Model model){
        int pageOn = 1;
        if ("".equals(pageNo)||pageNo!=null){
            pageOn = Integer.parseInt(pageNo);
        }
//        if (name.length()!= 0){
//            pageOn = 1;
//        }
        PageInfo<Book> page = adminService.getBookAll(name,pageOn, 5);
        model.addAttribute("name",name);
        model.addAttribute("page",page);
        model.addAttribute("list",page.getList());
        System.out.println(page.getList());
        return "admin/books";
    }

    @RequestMapping("/adminInfo/{token}")
    private String adminInfo(@PathVariable(value = "token")String token, Model model){
        Admin admin = adminService.validate(md5Utils.getMD5(token));
        System.out.println("md5admin"+admin);
        model.addAttribute("admin",admin);
        return "admin/admin-info";
    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    private int editToken(@Param("id") Integer id, @Param("token")String token, @Param("password")String password){
        System.out.println(id);
        System.out.println(password);
        int admin = adminService.editToken(id,token,md5Utils.getMD5(password));
        return admin;
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
