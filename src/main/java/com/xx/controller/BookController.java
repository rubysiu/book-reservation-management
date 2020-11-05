package com.xx.controller;

import com.xx.domain.Appointment;
import com.xx.domain.Book;
import com.xx.domain.Student;
import com.xx.dto.AppointExecution;
import com.xx.dto.Result;
import com.xx.enums.AppointStateEnum;
import com.xx.exception.NoNumberException;
import com.xx.exception.RepeatAppointException;
import com.xx.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/books")
@Slf4j
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    private String List(Model model){
        List<Book> list = bookService.getList();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping(value = "/search",method = RequestMethod.POST)
    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name = request.getParameter("name");
       name = name.trim();

       request.setAttribute("name",name);
       request.setAttribute("list",bookService.getSomeList(name));
       request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
    }
    @RequestMapping(value = "/{bookId}/detail",method = RequestMethod.GET)
    private String detail(@PathVariable("bookId") Long bookId, Model model){
        if (bookId == null) {
            return "redict:/book/list";
        }
        Book book = bookService.getById(bookId);
        if (book == null) {
            return "forward:/book/list";
        }
        model.addAttribute("book",book);
        return "detail";
    }
    @RequestMapping(value = "/verify",method = RequestMethod.POST)
    @ResponseBody
    private Map validate(long studentId,String password){
        HashMap resultMap = new HashMap();
        Student student = null;
        student = bookService.validateStu(studentId, password);
        if (student != null) {
            resultMap.put("result","SUCCESS");
            return resultMap;
        }else {
            resultMap.put("result","FAILED");
            return resultMap;
        }
    }
    //执行预约的逻辑
    @RequestMapping(value = "/{bookId}/appoint", method = RequestMethod.POST)
    @ResponseBody
    private Result<AppointExecution> execute(@PathVariable("bookId") Long bookId, @RequestParam("studentId") Long studentId){
        Result<AppointExecution> result;
        AppointExecution execution=null;

        try{//手动try catch,在调用appoint方法时可能报错
            execution=bookService.appoint(bookId, studentId);
            result=new Result<AppointExecution>(true,execution);
            return result;

        } catch(NoNumberException e1) {
            execution=new AppointExecution(bookId, AppointStateEnum.NO_NUMBER);
            result=new Result<AppointExecution>(true,execution);
            return result;
        }catch(RepeatAppointException e2){
            execution=new AppointExecution(bookId,AppointStateEnum.REPEAT_APPOINT);
            result=new Result<AppointExecution>(true,execution);
            return result;
        }catch (Exception e){
            execution=new AppointExecution(bookId,AppointStateEnum.INNER_ERROR);
            result=new Result<AppointExecution>(true,execution);
            return result;
        }
    }
    @RequestMapping("/appoint")
    public String appointBooks(@RequestParam("studentId") long studentId,Model model){
        List<Appointment> appointList = new ArrayList<Appointment>();
        appointList = bookService.getAppointByStu(studentId);
        model.addAttribute("appointList",appointList);
        return "appointBookList";
    }
}
