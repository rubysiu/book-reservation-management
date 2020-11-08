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


//    @RequestMapping(value ={""})
//    private String jump(){
//        return "redirect:/admin/index";
//    }
    @RequestMapping(value = {"","/index"})
    private String index(@CookieValue("token") String token, Model model){
        model.addAttribute("token",token);
        return "admin/index";
    }
    @RequestMapping("/welcome")
    private String welcome(){
        return "admin/welcome";
    }

    /**
     * 登录页面
     * @return
     */
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
    /**
     * 预约页面
     * @param pageNo
     * @param studentId
     * @param model
     * @return
     */
    @RequestMapping(value = {"/appoint","/appoint/{page}"})
    private String appoint(@PathVariable(value = "page",required = false) String pageNo,@RequestParam(value = "studentId",required = false,defaultValue = "")Long studentId,Model model){
        int pageOn = 1;
        if ("".equals(pageNo)||pageNo!=null){
            pageOn = Integer.parseInt(pageNo);
        }
        PageInfo<Appointment> page = adminService.queryByPage(studentId,pageOn, 5);
        model.addAttribute("studentId",studentId);
        model.addAttribute("list",page.getList());
        model.addAttribute("page",page);
        return "admin/appoint";
    }

    /**
     * 书籍页面
     * @param pageNo
     * @param name
     * @param model
     * @return
     */
    @RequestMapping(value = {"/books","/books/{page}"})
    private String books(@PathVariable(value = "page",required = false) String pageNo,@RequestParam(value = "name",required = false,defaultValue = "")String name,Model model){
        int pageOn = 1;
        if ("".equals(pageNo)||pageNo!=null){
            pageOn = Integer.parseInt(pageNo);
        }
        PageInfo<Book> page = adminService.getBookAll(name,pageOn, 5);
        model.addAttribute("name",name);
        model.addAttribute("page",page);
        model.addAttribute("list",page.getList());
        System.out.println(page.getList());
        return "admin/books";
    }

    /**
     * 添加书籍
     * @param name
     * @param introd
     * @param number
     * @return
     */
    @RequestMapping(value = "/addBook",method = RequestMethod.POST)
    @ResponseBody
    private int addBook(String name,String introd,int number){
        return adminService.addBook(name,introd,number);

    }
    @RequestMapping("/addBookInfo")
    private String addBookInfo(){
        return "admin/book-add";
    }

    /**
     * 修改书籍
     * @param model
     * @param bookId
     * @return
     */
    @RequestMapping("/editBookInfo/{bookId}")
    private String editBookInfo(Model model,@PathVariable(value = "bookId") Long bookId){
        Book book = adminService.getById(bookId);
        model.addAttribute("book",book);
        return "/admin/book-edit";
    }
    @RequestMapping(value = "/editBook",method = RequestMethod.POST)
    @ResponseBody
    private int editBook(Long bookId,String name,String introd,Integer number){
        System.out.println("book"+bookId+"+"+name+"+"+introd+"+"+number);
       return adminService.editBook(bookId,name,introd,number);


    }

    /**
     * 删除书籍
     * @param bookIds
     * @return
     */
    @RequestMapping("/delBook/{bookId}")
    @ResponseBody
    private int delBook(@PathVariable("bookId") Integer[] bookIds){
       return adminService.delBook(bookIds);
    }

    /**
     * 修改信息
     * @param token
     * @param model
     * @return
     */
    @RequestMapping("/adminInfo/{token}")
    private String adminInfo(@PathVariable(value = "token")String token, Model model){
        Admin admin = adminService.validate(md5Utils.getMD5(token));
        System.out.println("md5admin"+admin);
        model.addAttribute("admin",admin);
        return "admin/admin-info";
    }
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @ResponseBody
    private int editToken(Integer id, String token,String password){
        return adminService.editToken(id,token,md5Utils.getMD5(password));
    }

    /**
     * 删除预约
     * @param ids
     * @return
     */
    @RequestMapping("/delAppoint/{id}")
    @ResponseBody
    private int delAppoint(@PathVariable("id")Integer[] ids){
        return adminService.delAppoint(ids);
    }

    @RequestMapping(value = {"/student","/student/{page}",})
    private String student(@PathVariable(value = "page",required = false) String pageNo,@RequestParam(value = "studenId",required = false,defaultValue = "")Long studenId,Model model){
        return "admin/student";
    }

    @RequestMapping("/danyeList")
    private String danyeList(){
        return "admin/danye-list";
    }
}
