/*
 *   Copyright 2016-2020 Oleksii V. KHALIKOV, PE
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ua.com.gfalcon.tomcat;

import java.io.File;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class Server {

  private static final Logger LOGGER = LoggerFactory.getLogger(Server.class);

  public void start() throws LifecycleException {
    String webappDirLocation = "src/main/webapp/";
    Tomcat tomcat = new Tomcat();

    //The port that we should run on can be set into an environment variable
    //Look for that variable and default to 8080 if it isn't there.
    String webPort = System.getenv("PORT");
    if (webPort == null || webPort.isEmpty()) {
      webPort = "8080";
    }

    tomcat.setPort(Integer.parseInt(webPort));

    StandardContext ctx = (StandardContext) tomcat.addWebapp("/",
        new File(webappDirLocation).getAbsolutePath());
    LOGGER.info("configuring app with basedir: {}",
        new File("./" + webappDirLocation).getAbsolutePath());

    // Declare an alternative location for your "WEB-INF/classes" dir
    // Servlet 3.0 annotation will work
    File additionWebInfClasses = new File("target/classes");
    WebResourceRoot resources = new StandardRoot(ctx);
    resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
        additionWebInfClasses.getAbsolutePath(), "/"));
    ctx.setResources(resources);

    tomcat.start();
    tomcat.getServer().await();
  }

}
