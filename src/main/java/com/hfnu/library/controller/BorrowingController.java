package com.hfnu.library.controller;

import com.hfnu.library.domain.Vo.BorrowingBooksVo;
import com.hfnu.library.service.IBorrowingBooksRecordService;
import com.hfnu.library.utils.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

/**
 * Author : wendy_wan
 * Created : 2020/2/5 8:19
 */
@Controller
public class BorrowingController {
    @Resource
    private IBorrowingBooksRecordService borrowingBooksRecordService;

    /**
     * 返回所有用户借书记录页面
     * @param model
     * @param pageNum
     * @return
     */
    @GetMapping("/allBorrowBooksRecordPage")
    public String allBorrowBooksRecordPage(Model model,@RequestParam("pageNum") int pageNum){
        Page<BorrowingBooksVo> page = borrowingBooksRecordService.selectAllByPage(pageNum);
        model.addAttribute("page",page);
        return "admin/allBorrowingBooksRecord";
    }
}
