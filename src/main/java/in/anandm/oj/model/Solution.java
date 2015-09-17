package in.anandm.oj.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "solution")
public class Solution implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "solution_file_path")
    private String solutionFilePath;

    @Column(name = "language")
    @Enumerated(EnumType.STRING)
    private Language language;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "submitted_at")
    private Date submittedAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "evaluated_at")
    private Date evaluatedAt;

    @Column(name = "compilation_errors")
    private String compilationErrors;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private EvaluationResultStatus status;

    /**
     * 
     */
    public Solution() {
        super();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSolutionFilePath() {
        return solutionFilePath;
    }

    public void setSolutionFilePath(String solutionFilePath) {
        this.solutionFilePath = solutionFilePath;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(Date submittedAt) {
        this.submittedAt = submittedAt;
    }

    public Date getEvaluatedAt() {
        return evaluatedAt;
    }

    public void setEvaluatedAt(Date evaluatedAt) {
        this.evaluatedAt = evaluatedAt;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getCompilationErrors() {
        return compilationErrors;
    }

    public void setCompilationErrors(String compilationErrors) {
        this.compilationErrors = compilationErrors;
    }

    public EvaluationResultStatus getStatus() {
        return status;
    }

    public void setStatus(EvaluationResultStatus status) {
        this.status = status;
    }

}
