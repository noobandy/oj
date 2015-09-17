package in.anandm.oj.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "problem")
public class Problem implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "problem_statement")
    private String problemStatement;

    // bytes
    @Column(name = "max_solution_size_limit")
    private long maxSolutionSizeLimit;

    // milliseconds

    @Column(name = "max_time_limit")
    private long maxTimeLimit;

    // bytes
    @Column(name = "max_memory_limit")
    private long maxMemoryLimit;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    /**
     * 
     */
    public Problem() {
        super();

    }

    public long getMaxSolutionSizeLimit() {
        return maxSolutionSizeLimit;
    }

    public void setMaxSolutionSizeLimit(long maxSolutionSizeLimit) {
        this.maxSolutionSizeLimit = maxSolutionSizeLimit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProblemStatement() {
        return problemStatement;
    }

    public void setProblemStatement(String problemStatement) {
        this.problemStatement = problemStatement;
    }

    public long getMaxTimeLimit() {
        return maxTimeLimit;
    }

    public void setMaxTimeLimit(long maxTimeLimit) {
        this.maxTimeLimit = maxTimeLimit;
    }

    public long getMaxMemoryLimit() {
        return maxMemoryLimit;
    }

    public void setMaxMemoryLimit(long maxMemoryLimit) {
        this.maxMemoryLimit = maxMemoryLimit;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
