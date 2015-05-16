package com.tag;



import javax.servlet.ServletContext;

import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Title. <br>
 * Description.
 * <p/>
 * Copyright: Copyright (c) 12-11-12 下午2:15
 * <p/>
 * Author: baibo
 * <p/> 
 * Version: 1.0
 * <p/>
 */
public class UtilsFunction {

    public static Object getSpringBean(ServletContext servletContext, String name) {
        return WebApplicationContextUtils.getWebApplicationContext(servletContext).getBean(name);
    }

}
