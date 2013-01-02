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
package com.ibm.batch.container;

import com.ibm.batch.container.artifact.proxy.PartitionAnalyzerProxy;
import com.ibm.batch.container.context.impl.FlowContextImpl;
import com.ibm.batch.container.context.impl.SplitContextImpl;
import com.ibm.batch.container.context.impl.StepContextImpl;

public interface IExecutionElementController extends IController {

    public enum ExecutionWasStarted { YES, NO }

    /*
     * @return exitStatus
     */
    public String execute() throws AbortedBeforeStartException;
    
    public void setStepContext(StepContextImpl<?, ?> stepContext);
    
    public void setFlowContext(FlowContextImpl flowContext);
    
    public void setSplitContext(SplitContextImpl splitContext);
    
    //TODO implement these in the controllers
    //public void registerListeners(List<Listener> listeners);
    
    //public void registerCollectors(List<Collector> collectors);
    
    //public void registerAnalyzers(List<Collector> collectors);
    
    public void setAnalyzerProxy(PartitionAnalyzerProxy analyzerProxy);
    
    
}
