package org.apache.maven.surefire.its;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.surefire.its.fixture.OutputValidator;
import org.apache.maven.surefire.its.fixture.SurefireJUnit4IntegrationTestCase;
import org.apache.maven.surefire.its.fixture.TestFile;
import org.junit.Test;

/**
 * Asserts proper behaviour of console output when forking
 * SUREFIRE-639
 * SUREFIRE-651
 *
 * @author Kristian Rosenvold
 */
public class ForkConsoleOutputWithErrorsIT
    extends SurefireJUnit4IntegrationTestCase
{
    @Test
    public void xmlFileContainsConsoleOutput()
    {
        final OutputValidator outputValidator = unpack( "/fork-consoleOutputWithErrors" ).
            failNever().redirectToFile( true ).executeTest();
        final TestFile surefireReportsFile =
            outputValidator.getSurefireReportsXmlFile( "TEST-forkConsoleOutput.Test2.xml" );
        surefireReportsFile.assertContainsText( "sout: Will Fail soon" );
        surefireReportsFile.assertContainsText( "serr: Will Fail now" );
    }

    @Test
    public void aaa() {
        unpack("/fork-consoleOutputWithErrors")
                .forkCount(1)
                .debugLogging()
//                .debugSurefireFork()
//                .debugJvm(true)
                .failNever()
                .redirectToFile(false)
                .executeTest()
                .getSurefireReportsXmlFile("TEST-forkConsoleOutput.Test2.xml")
                .assertContainsText("sout: Will Fail soon")
                .assertContainsText("serr: Will Fail now");
    }
}


//[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.19.1:test (default-test) on project
// sapho-server: Execution default-test of goal org.apache.maven.plugins:maven-surefire-plugin:2.19.1:test failed:
// java.lang.RuntimeException: Foo,Bar,YouPhone,1.2.3.4,"{: For input string: ""{" -> [Help 1]
//        org.apache.maven.lifecycle.LifecycleExecutionException: Failed to execute goal org.apache.maven
// .plugins:maven-surefire-plugin:2.19.1:test (default-test) on project sapho-server: Execution default-test of goal
// org.apache.maven.plugins:maven-surefire-plugin:2.19.1:test failed: java.lang.RuntimeException: Foo,Bar,YouPhone,
// 1.2.3.4,"{
//        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:213)
//        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:154)
//        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:146)
//        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:117)
//        at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:81)
//        at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build
// (SingleThreadedBuilder.java:51)
//        at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:128)
//        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:309)
//        at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:194)
//        at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:107)
//        at org.apache.maven.cli.MavenCli.execute(MavenCli.java:993)
//        at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:345)
//        at org.apache.maven.cli.MavenCli.main(MavenCli.java:191)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.lang.reflect.Method.invoke(Method.java:498)
//        at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:289)
//        at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:229)
//        at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:415)
//        at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:356)
//        at org.codehaus.classworlds.Launcher.main(Launcher.java:47)
//        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
//        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
//        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
//        at java.lang.reflect.Method.invoke(Method.java:498)
//        at com.intellij.rt.execution.CommandLineWrapper.main(CommandLineWrapper.java:65)
//        Caused by: org.apache.maven.plugin.PluginExecutionException: Execution default-test of goal org.apache
// .maven.plugins:maven-surefire-plugin:2.19.1:test failed: java.lang.RuntimeException: Foo,Bar,YouPhone,1.2.3.4,"{
//        at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:145)
//        at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:208)
//        ... 26 more
//        Caused by: java.lang.RuntimeException: java.lang.RuntimeException: Foo,Bar,YouPhone,1.2.3.4,"{
//        at org.apache.maven.plugin.surefire.booterclient.output.ThreadedStreamConsumer.close(ThreadedStreamConsumer
// .java:127)
//        at org.apache.maven.plugin.surefire.booterclient.ForkStarter.fork(ForkStarter.java:569)
//        at org.apache.maven.plugin.surefire.booterclient.ForkStarter.fork(ForkStarter.java:460)
//        at org.apache.maven.plugin.surefire.booterclient.ForkStarter.run(ForkStarter.java:229)
//        at org.apache.maven.plugin.surefire.booterclient.ForkStarter.run(ForkStarter.java:201)
//        at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeProvider(AbstractSurefireMojo.java:1026)
//        at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeAfterPreconditionsChecked
// (AbstractSurefireMojo.java:862)
//        at org.apache.maven.plugin.surefire.AbstractSurefireMojo.execute(AbstractSurefireMojo.java:755)
//        at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:134)
//        ... 27 more
//        Caused by: java.lang.RuntimeException: Foo,Bar,YouPhone,1.2.3.4,"{
//        at org.apache.maven.plugin.surefire.booterclient.output.ForkClient.createReportEntry(ForkClient.java:286)
//        at org.apache.maven.plugin.surefire.booterclient.output.ForkClient.processLine(ForkClient.java:152)
//        at org.apache.maven.plugin.surefire.booterclient.output.ForkClient.consumeLine(ForkClient.java:115)
//        at org.apache.maven.plugin.surefire.booterclient.output.ThreadedStreamConsumer$Pumper.run
// (ThreadedStreamConsumer.java:70)
//        at java.lang.Thread.run(Thread.java:748)
//        Caused by: java.lang.NumberFormatException: For input string: ""{"
//        at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
//        at java.lang.Integer.parseInt(Integer.java:569)
//        at java.lang.Integer.valueOf(Integer.java:740)
//        at java.lang.Integer.decode(Integer.java:1197)
//        at org.apache.maven.plugin.surefire.booterclient.output.ForkClient.createReportEntry(ForkClient.java:278)
//        ... 4 more
