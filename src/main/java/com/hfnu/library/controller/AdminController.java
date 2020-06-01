package com.hfnu.library.controller;

import com.hfnu.library.domain.BookCategory;
import com.hfnu.library.domain.User;
import com.hfnu.library.domain.Vo.BookVo;
import com.hfnu.library.service.IAdminService;
import com.hfnu.library.service.IBookCategoryService;
import com.hfnu.library.service.IUserService;
import com.hfnu.library.utils.page.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 0:30
 */
@Controller
public class AdminController {
    @Resource
    private IAdminService adminService;

    @Resource
    private IBookCategoryService bookCategoryService;

    @Resource
    private IUserService userService;

    /**
     * 判断admin是否存在
     * @param adminName
     * @return
     */
    @RequestMapping(path = "/isAdminExist",
                    method = RequestMethod.POST)
    @ResponseBody
    public String adminIsExist(@Param("adminName") String adminName){
        boolean b = adminService.adminIsExist(adminName);
        if (b){
            return "true";
        }else {
            return "false";
        }
    }

    /**
     * 管理员登陆
     * @param adminName
     * @param password
     * @return
     */
    @GetMapping("/adminLogin")
    public String adminLogin(@Param("adminName") String adminName, @Param("password") String password, HttpServletRequest request){
        boolean res = adminService.adminLogin(adminName,password);
        if (res == false){
            return "adminLogin";
        }
        request.getSession().setAttribute("admin","admin");
        return "admin/index";
    }

    /**
     * 管理员退出登陆
     * @param request
     * @return
     */
    @RequestMapping("/adminLogOut")
    public String userLogOut(HttpServletRequest request){
        //request.getSession().invalidate();清除所有W··
        request.getSession().invalidate();
        return "adminLogin";
    }
    /**
     * 返回添加书籍页面
     * @return
     */
    @RequestMapping("/addBookPage")
    public String addBookPage(){
        return "admin/addBook";
    }

    /**
     * 返回查询书籍页面
     * @param model
     * @return
     */
    @RequestMapping("/showBooksPage")
    public String showBooksPage(Model model){
        Page<BookVo> page = new Page<>();
        page.setPageCount(1);
        page.setPageNum(1);
        model.addAttribute("page",page);
        return "admin/showBooks";
    }

    /**
     * 返回添加类别页面
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping("/addCategoryPage")
    public String addCategoryPage(@RequestParam("pageNum") int pageNum, Model model){
        Page<BookCategory> page = bookCategoryService.selectBookCategoryByPageNum(pageNum);
        model.addAttribute("page",page);
        return "admin/addCategory";
    }

    /**
     * 返回查询用户页面
     * @return
     */
    @RequestMapping("/showUsersPage")
    public String showUsersPage(Model model,@RequestParam("pageNum") int pageNum){
        Page<User> page = userService.findUserByPage(pageNum);
        model.addAttribute("page",page);
        return "admin/showUsers";
    }

    /**
     * 返回新增用户页面
     * @return
     */
    @RequestMapping("/addUserPage")
    public String addUserPage(){
        return "admin/addUser";
    }
}
