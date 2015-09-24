<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!doctype html>

<html>
<head>
<title><spring:message code="submission.addsubmissionpage.title" />
</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/ace-builds-1.2.0/src-noconflict/ace.js"></script>
<style type="text/css" media="screen">
    #editor { 
        height: 100%;
    }
</style>
</head>

<body>
	<div class="row">
		<div class="col-md-12">
			<ol class="breadcrumb">
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/problem">Problem</a></li>
				<li><a
					href="${pageContext.request.contextPath}/problem/${problemCode}">Problem
						Code</a></li>
				<li><a
					href="${pageContext.request.contextPath}/problem/${problemCode}/submission">Submission</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/problem/${problemCode}/submission/${submissionId}">User</a></li>
			</ol>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<strong>Language</strong> <div class="badge">Java</div>
			<div id="editor">
				import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author anandm
 * @date Sep 17, 2015 4:12:00 PM
 */
public class Main {

    public void run() throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));

        int noOfTestCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < noOfTestCases; i++) {
            int number = Integer.parseInt(reader.readLine());

            System.out.println(number * number);
        }
        reader.close();
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.run();

    }

}
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			
			   var editor = ace.edit("editor");
			   editor.setTheme("ace/theme/github");
			   editor.getSession().setMode("ace/mode/java");
			   editor.setReadOnly(true);
			  
		});
	</script>
</body>
</html>