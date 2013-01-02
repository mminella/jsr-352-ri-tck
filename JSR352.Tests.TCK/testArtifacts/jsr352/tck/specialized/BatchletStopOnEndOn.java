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
package jsr352.tck.specialized;

import java.util.logging.Logger;

import javax.batch.annotation.*;
import javax.batch.annotation.Process;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;

@Batchlet("BatchletStopOnEndOn")
@javax.inject.Named("BatchletStopOnEndOn")
public class BatchletStopOnEndOn {

    private final static String sourceClass = BatchletStopOnEndOn.class.getName();
    private final static Logger logger = Logger.getLogger(sourceClass);

    @BatchContext
    StepContext<?,?> stepCtx;

    @BatchContext
    JobContext<?> jobCtx;
    

    @BatchProperty(name="execution.number")
    String executionNumberString;

    @BeginStep
    public void begin() throws Exception {
        logger.fine(sourceClass + ".begin()");	            
    }

    /*
     * Appends "intended.exit.status" property to the current Job-level ExitStatus
     */
    @Process
    public String process() throws Exception {
        logger.fine(sourceClass + ".calculateExitStatus(), executionNumberString = " + executionNumberString);
        
        int execNum = Integer.parseInt(executionNumberString);

        String stepId = stepCtx.getId();
        
        logger.fine(sourceClass + ".calculateExitStatus(), execution # = " + execNum + ", stepId = " + stepId);
        
        String exitStatus = calculateExitStatus();
        
        logger.fine(sourceClass + ".process(); Exiting with exitStatus = " + exitStatus);
        
        return exitStatus;
    }
    
    private String calculateExitStatus() {

        logger.fine(sourceClass + ".calculateExitStatus(), executionNumberString = " + executionNumberString);
        
        int execNum = Integer.parseInt(executionNumberString);

        String stepId = stepCtx.getId();
        
        logger.fine(sourceClass + ".calculateExitStatus(), execution # = " + execNum + ", stepId = " + stepId);
        
        /*
         * Tests that stop @on and end @on don't result in re-running already completed steps.
         */
        if (stepId.equals("step1")) {
            switch (execNum) {
                case 1: return "ES.STEP1";
                default: return "ILLEGAL.STATE";
            }
        } else if (stepId.equals("step2")) {
            switch (execNum) {
                case 2: return "ES.STEP2";
                default: return "ILLEGAL.STATE";
            }
        } else if (stepId.equals("step3")) {
            switch (execNum) {
                case 3: return "ES.STEP3";
                default: return "ILLEGAL.STATE";
            }
        } else {
            return "ILLEGAL.STATE";
        }
    }

    @Stop
    public void cancel() throws Exception {
        // Do nothing since this is too quick to bother canceling.
        logger.fine(sourceClass + ".cancel()");		
    }

    @EndStep
    public void end() throws Exception {
        logger.fine(sourceClass + ".end()");
    }
}
