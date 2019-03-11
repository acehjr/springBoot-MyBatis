package com.example.unknowtruth.common.config;


import com.example.unknowtruth.common.basic.ResultCode;
import com.example.unknowtruth.common.basic.ResultDto;
import com.example.unknowtruth.common.utils.ErrorConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
@Slf4j
public class ApplicationControllerAdvice {


    @Autowired
    private MessageSource messageSource;

    /**
     * 全局异常处理
     *
     * @param ex Exception
     * @return String
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResultDto exceptionHandler(HttpServletResponse response, Exception ex) {
        try {
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Type", "application/json;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache, no-store, max-age=0");
            response.setHeader("Expires", "1L");
            response.setStatus(ErrorConstant.RUNTIME_EXCEPTION.getCode());

            return new ResultDto(ResultCode.FAIL,ex.getMessage());
        } finally {
            log.debug("ApplicationControllerAdvice exceptionHandler remove thread local");
        }
        //return null;
    }

    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * controller有参数才会铺抓
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
//        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
//        System.out.println(binder);
    }

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
//    @ModelAttribute
//    public void addAttributes(Model model) {
//        model.addAttribute("author", "Magical Sam");
//    }



}
