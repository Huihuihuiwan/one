package com.hfnu.library;

import com.hfnu.library.domain.Department;
import com.hfnu.library.domain.User;
import com.hfnu.library.domain.Vo.BorrowingBooksVo;
import com.hfnu.library.mapper.UserMapper;
import com.hfnu.library.service.IBorrowingBooksRecordService;
import com.hfnu.library.service.IUserService;
import com.hfnu.library.utils.page.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Resource
    private IUserService userService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private IBorrowingBooksRecordService borrowingBooksRecordService;
    @Test
    public void findUsersByName(){
        List<User> users=userService.findUserByUserName("wendy");
        if(null!=users){
            for(User u:users){
                System.out.println(u.getUserId() + "\t" + u.getUserName());
            }
        }else{
            System.out.println("null");
        }
    }

    @Test
    public void findAllDepts(){
        List<Department> depts=userService.findAllDepts();
        if(null==depts){
            System.out.println("null");
        }else{
            for(Department d:depts){
                System.out.println(d.getDeptName());
            }
        }
    }
    @Test
    public void updateUserTest(){
        User user=new User();

    }

    @Test
    public void selectByPage(){
        List<User> users=userMapper.selectByPageNum(0,5);
        if(null!=users){
            for(User u:users){
                System.out.println(u.getUserId()+" "+u.getUserName());
            }
        }
    }

    @Test
    public void tsetSelcetCount(){
        int n=userMapper.selectUserCount();
        System.out.println(n);
    }

    @Test
    public void testSelectAllBorrowingBooksByPageNum(){
        Page<BorrowingBooksVo> page=borrowingBooksRecordService.selectAllByPage(1);
        if(null!=page){
            for(BorrowingBooksVo b:page.getList()){
                System.out.println(b.getUser().getUserName()+" "+b.getBook().getBookName());
            }
        }
    }
}
