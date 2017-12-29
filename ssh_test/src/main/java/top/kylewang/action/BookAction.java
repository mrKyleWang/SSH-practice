package top.kylewang.action;

import com.alibaba.fastjson.JSONArray;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import top.kylewang.entity.Book;
import top.kylewang.service.IBookService;

import java.io.IOException;
import java.util.List;

/**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:26
 */
@Controller
@Scope("prototype")
@Namespace("/book")
@ParentPackage("struts-default")
public class BookAction extends ActionSupport {

    @Autowired
    private IBookService bookService;

    @Action(value = "/findAll")
    public void findAll(){

        List<Book> list=  bookService.findAll();
        String jsonString = JSONArray.toJSONString(list);
        try {
            ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
            ServletActionContext.getResponse().getWriter().write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
