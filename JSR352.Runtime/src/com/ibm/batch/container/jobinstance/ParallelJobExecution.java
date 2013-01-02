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
package com.ibm.batch.container.jobinstance;

import com.ibm.batch.container.services.ParallelTaskResult;


public class ParallelJobExecution {
    
    
    private final transient ParallelTaskResult taskResult;
    private final RuntimeJobExecutionImpl jobExecution;

    public ParallelJobExecution(RuntimeJobExecutionImpl jobExecution, ParallelTaskResult taskResult) {
        this.jobExecution = jobExecution;
        this.taskResult = taskResult;
    }

    public RuntimeJobExecutionImpl getJobExecution() {
        return jobExecution;
    }
    
    public void waitForResult() {
        this.taskResult.waitForResult();
    }
    
}
