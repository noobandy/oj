package in.anandm.oj.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "test_case")
public class TestCase implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @GeneratedValue(generator = "system-uuid")
    private String id;

    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @Column(name = "input_file_path")
    private String inputFilePath;

    @Column(name = "output_file_path")
    private String outputFilePath;

    // milliseconds

    @Column(name = "max_time_limit")
    private long maxTimeLimit;

    // bytes
    @Column(name = "max_memory_limit")
    private long maxMemoryLimit;

    @ElementCollection
    @CollectionTable(name = "test_case_extra_data",
            joinColumns = { @JoinColumn(name = "test_case_id") })
    @MapKeyColumn(name = "data_key")
    @Column(name = "data_value")
    private Map<String, String> extraData = new HashMap<String, String>();

    /**
     * 
     */
    public TestCase() {
        super();

    }

    public String getInputFilePath() {
        return inputFilePath;
    }

    public void setInputFilePath(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    public String getOutputFilePath() {
        return outputFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
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

    public Map<String, String> getExtraData() {
        return extraData;
    }

    public void setExtraData(Map<String, String> extraData) {
        this.extraData = extraData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

}
