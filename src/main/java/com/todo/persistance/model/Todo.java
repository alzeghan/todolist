package com.todo.persistance.model;

import javax.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@Entity(name="todo")
@NamedQueries({
        @NamedQuery(name = "findTodosByUser", query = "SELECT t FROM todo t where t.userId = ?1 order by t.dueDate"),
        @NamedQuery(name = "findTodosByTitle", query = "SELECT t FROM todo t where t.userId = ?1 and upper(t.title) like ?2 order by t.dueDate")
})
public class Todo implements Serializable {

    @Id
    @Generated(GenerationTime.INSERT)
    private long id;

    private long userId;

    @Column(columnDefinition="TEXT")
    private String title;

    private boolean done;

    @Enumerated(value = EnumType.ORDINAL)
    private TodoPriority todoPriority;

    @Temporal(TemporalType.DATE)
    private Date dueDate;

    public Todo() {
        todoPriority = TodoPriority.LOW;
    }

    public Todo(long userId, String title, boolean done, TodoPriority todoPriority, Date dueDate) {
        this.userId = userId;
        this.title = title;
        this.done = done;
        this.todoPriority = todoPriority;
        this.dueDate = dueDate;
    }

    public long getId() {
        return id;
    }
    

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(long id) {
		this.id = id;
	}

	public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public TodoPriority getPriority() {
        return todoPriority;
    }

    public void setPriority(TodoPriority todoPriority) {
        this.todoPriority = todoPriority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Todo{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", done=").append(done);
        sb.append(", priority=").append(todoPriority);
        sb.append(", dueDate=").append(dueDate);
        sb.append('}');
        return sb.toString();
    }
}
