package com.hfnu.library.controller;

import com.hfnu.library.domain.Book;
import com.hfnu.library.domain.BookCategory;
import com.hfnu.library.domain.Vo.BookVo;
import com.hfnu.library.service.IAdminService;
import com.hfnu.library.service.IBookCategoryService;
import com.hfnu.library.service.IBookService;
import com.hfnu.library.utils.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 17:35
 */
@Controller
public class BookController {

    @Resource
    private IAdminService adminService;

    @Resource
    private IBookService bookService;

    @Resource
    private IBookCategoryService bookCategoryService;

    /**
     * 管理员录入新书
     * @param book
     * @return
     *
     * addBook.js中post的请求
     */
    @RequestMapping("/addBook")
    @ResponseBody
    public String addBook(Book book){
        boolean res = adminService.addBook(book);
        if (res){
            return "true";
        }
        return "false";
    }

    /**
     * 查询所有书籍种类
     * @return
     *
     * addBook.js、showBooks.js
     * 中post的请求，查询所有书籍的种类
     */
    @RequestMapping("/findAllBookCategory")
    @ResponseBody
    public List<BookCategory> findAllBookCategory(){
        return adminService.getBookCategorys();
    }

    /**
     * 返回查询书籍结果页
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping("/showBooksResultPageByCategoryId")
    public String showBooksResultPageByCategoryId(@RequestParam("pageNum") int pageNum, @RequestParam("bookCategory") int bookCategory, Model model){
        Page<BookVo> page = bookService.findBooksByCategoryId(bookCategory,pageNum);
        model.addAttribute("page",page);
        model.addAttribute("bookCategory",bookCategory);
        return "admin/showBooks";
    }

    /**
     * 新建书籍种类
     * @param bookCategory
     * @return
     */
    @RequestMapping("/addBookCategory")
    @ResponseBody
    public String addBookCategory(BookCategory bookCategory){
        boolean b = adminService.addBookCategory(bookCategory);
        if (b){
            return "true";
        }
        return "false";
    }

    /**
     * 根据书籍种类id删除种类
     * @param bookCategoryId
     * @return
     */
    @RequestMapping("deleteCategory")
    @ResponseBody
    public String deleteBookCategoryById(@RequestParam("bookCategoryId")int bookCategoryId){
        int res = bookCategoryService.deleteBookCategoryById(bookCategoryId);
        if (res > 0){
            return "true";
        }
        return "false";
    }

    /**
     * 返回用户查询书籍结果页
     * @param bookName
     * @return
     */
    @RequestMapping("/findBookByName")
    public String findBooksResultPage(@RequestParam("bookName") String bookName,Model model){
        List<BookVo> bookVos = bookService.findBooksByBookName(bookName);
        model.addAttribute("bookList",bookVos);
        return "user/findBook";
    }
}
