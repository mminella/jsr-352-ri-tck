/*
 * Copyright 2012 International Business Machines Corp.
 * 
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package com.ibm.batch.container.xjcl;

import jsr352.batch.jsl.Flow;
import jsr352.batch.jsl.JSLJob;

import com.ibm.batch.container.xjcl.impl.FlowNavigatorImpl;
import com.ibm.batch.container.xjcl.impl.JobNavigatorImpl;

public class NavigatorFactory {
    public static Navigator<JSLJob> createJobNavigator(JSLJob job) {
        return new JobNavigatorImpl(job);
    }
    
    public static Navigator<Flow> createFlowNavigator(Flow flow) {
        return new FlowNavigatorImpl(flow);
    }
}
