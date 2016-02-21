package com.todo.util;

import java.beans.PropertyEditorSupport;

import com.todo.persistance.model.TodoPriority;

public class TodoPriorityPropertyEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        TodoPriority value = (TodoPriority) getValue();
        return value.toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(TodoPriority.valueOf(text));
    }
}
