package forkConsoleOutput;

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

import java.util.logging.Logger;

import org.junit.Test;

public class Test2 {
    @Test
    public void test6281() {
        System.out.println("sout: I am talking to you");
        System.out.println("sout: Will Fail soon");
        System.err.println("serr: And you too");
        System.err.println("serr: Will Fail now");
        throw new RuntimeException("FailHere");
    }

    @Test
    public void testXXX() {
        System.err.println("INFO: 1 * Server responded with a response on thread grizzly-http-server-0\n"+
        "1 < 200\n"+
        "1 < Content-Disposition: attachment; filename=service_action_log.csv\n"+
        "1 < Content-Type: text/csv\n");
                System.err.println("id,user\n1,5,Foo,Bar,Xxx,Yyy,\"{\n\"\"a\"\":\"\"b\"\"\n}\",c");
//        Logger.getLogger("foo").info("INFO: 1 * Server responded with a response on thread grizzly-http-server-0\n"+
//        "1 < 200\n"+
//        "1 < Content-Disposition: attachment; filename=service_action_log.csv\n"+
//        "1 < Content-Type: text/csv\n"+
//        "id,user\n1,5,Foo,Bar,Xxx,Yyy,\"{\n\"\"a\"\":\"\"b\"\"\n}\",c");
        new RuntimeException("FailHere").printStackTrace();
    }
}
