package com.todo.ui.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.todo.persistance.model.TaskPriority;
import com.todo.util.TodoListUtils;

public class PriorityIconTag extends SimpleTagSupport {

    private String priority;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        String priorityIcon = TodoListUtils.getPriorityIcon(TaskPriority.valueOf(priority));
        out.print(priorityIcon);
    }

    /*
     * setters for tag attributes
     */

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
