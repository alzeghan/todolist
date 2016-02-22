package com.todo.util;

import java.beans.PropertyEditorSupport;

import com.todo.persistance.model.TaskPriority;

public class TodoPriorityPropertyEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        TaskPriority value = (TaskPriority) getValue();
        return value.toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(TaskPriority.valueOf(text));
    }
}
