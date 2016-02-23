package com.todo.ui.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.todo.util.TodoListUtils;


public class StatusStyleTag extends SimpleTagSupport {

    private boolean status;

    @Override
    public void doTag() throws JspException, IOException {

        JspWriter out = getJspContext().getOut();
        String statusStyle = TodoListUtils.getStatusStyle(status);
        out.print(statusStyle);

    }

    /*
     * setters for tag attributes
     */

    public void setStatus(boolean status) {
        this.status = status;
    }

}
