package in.anandm.oj.command;

import in.anandm.oj.model.Language;

import org.springframework.web.multipart.MultipartFile;

public class SolutionSubmissionCommand {

    private String problemId;

    private Language language;

    private String solution;

    private MultipartFile solutionFile;

    private String username;

    /**
     * 
     */
    public SolutionSubmissionCommand() {
        super();

    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public MultipartFile getSolutionFile() {
        return solutionFile;
    }

    public void setSolutionFile(MultipartFile solutionFile) {
        this.solutionFile = solutionFile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
