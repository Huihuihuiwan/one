package com.hfnu.library.service.impl;

import com.hfnu.library.domain.*;
import com.hfnu.library.mapper.AdminMapper;
import com.hfnu.library.mapper.BookCategoryMapper;
import com.hfnu.library.mapper.BookMapper;
import com.hfnu.library.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/2/3 23:08
 */
@Service
public class AdminServiceImpl implements IAdminService {

    /*
    *  @Resource:直接按照bean的id注入，可以单独使用
    * name用于指定bean的id
    * */
    //持久层
    @Resource
    private AdminMapper adminMapper;

    @Resource
    private BookMapper bookMapper;

    @Resource
    private BookCategoryMapper bookCategoryMapper;

    @Override
    public boolean adminIsExist(String name) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminNameEqualTo(name);
        List<Admin> admin = adminMapper.selectByExample(adminExample);
        if (admin == null){
            return false;
        }
        if (admin.size() < 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean adminLogin(String name, String password) {
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminNameEqualTo(name);
        List<Admin> admin = adminMapper.selectByExample(adminExample);
        if (admin == null){
            return false;
        }

        for (Admin a : admin) {
            if (a.getAdminPwd().equals(password)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        int n = bookMapper.insert(book);
        if (n > 0){
            return true;
        }
        return false;
    }

    @Override
    public List<BookCategory> getBookCategorys() {
        BookCategoryExample bookCategoryExample = new BookCategoryExample();
        return bookCategoryMapper.selectByExample(bookCategoryExample);
    }

    @Override
    public boolean addBookCategory(BookCategory bookCategory) {
        int n = bookCategoryMapper.insert(bookCategory);
        if (n > 0){
            return true;
        }
        return false;
    }
}
