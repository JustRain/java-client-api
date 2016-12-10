package com.offbytwo.jenkins;

import java.net.URI;
import java.util.List;

import org.junit.Test;

import com.offbytwo.jenkins.model.Build;
import com.offbytwo.jenkins.model.JobWithDetails;
import com.offbytwo.jenkins.model.TestReport;
import com.offbytwo.jenkins.model.TestResult;
import com.offbytwo.jenkins.model.TestSuites;

public class JenkinsTestManualTestReport {

    @Test
    public void firstTest() throws Exception {

        JenkinsServer js = new JenkinsServer(URI.create("http://localhost:10090/buildserver/"), "admin", "admin");
        JobWithDetails job = js.getJob("non-maven-test");
        Build lastCompletedBuild = job.getLastCompletedBuild();
        TestReport testReport = lastCompletedBuild.getTestReport();

        System.out.println(" --- TestReport ---");
        System.out.println("totalCount: " + testReport.getTotalCount());
        System.out.println(" failCount: " + testReport.getFailCount());
        System.out.println(" skipCount: " + testReport.getSkipCount());
        
        TestResult testResult = lastCompletedBuild.getTestResult();
        System.out.println(" --- TestResult ---");

        System.out.println(" PassCount: " + testResult.getPassCount());
        System.out.println(" failCount: " + testResult.getFailCount());
        System.out.println(" skipCount: " + testResult.getSkipCount());
        System.out.println("  duration: " + testResult.getDuration());
        System.out.println("   isEmpty: " + testResult.isEmpty());
        List<TestSuites> suites = testResult.getSuites();
        
        
    }
}
