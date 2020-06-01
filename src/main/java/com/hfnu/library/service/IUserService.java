package com.hfnu.library.service;

import com.hfnu.library.domain.BorrowingBooks;
import com.hfnu.library.domain.Department;
import com.hfnu.library.domain.User;
import com.hfnu.library.domain.Vo.BorrowingBooksVo;
import com.hfnu.library.utils.page.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 12:45
 */
public interface IUserService {

    //验证用户是否存在
    List<User> findUserByUserName(String userName);

    //用户登录
    User userLogin(String userName, String password);

    //更新用户信息
    boolean updateUser(User user, HttpServletRequest request);

    //查询用户借书记录
    List<BorrowingBooksVo> findAllBorrowingBooks(HttpServletRequest request);

    //用户还书
    boolean userReturnBook(int bookId, HttpServletRequest request);

    //用户借书
    boolean userBorrowingBook(int bookId, HttpServletRequest request);

    //通过id查找用户
    User findUserById(int id);

    //分页查询用户
    Page<User> findUserByPage(int pageNum);

    //添加用户
    int insertUser(User user);

    //根据用户id删除用户
    int deleteUserById(int userId);

    //查询所有部门
    List<Department> findAllDepts();


}
