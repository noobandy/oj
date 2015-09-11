package in.anandm.oj.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "evaluation_result")
public class EvaluationResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "solution_id")
    private Solution solution;

    @ManyToOne
    @JoinColumn(name = "test_case_id")
    private TestCase testCase;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private EvaluationResultStatus status;

    /**
     * 
     */
    public EvaluationResult() {
        super();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Solution getSolution() {
        return solution;
    }

    public void setSolution(Solution solution) {
        this.solution = solution;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    public EvaluationResultStatus getStatus() {
        return status;
    }

    public void setStatus(EvaluationResultStatus status) {
        this.status = status;
    }

}
