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
package com.ibm.batch.container.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import jsr352.batch.jsl.Batchlet;
import jsr352.batch.jsl.Chunk;
import jsr352.batch.jsl.Decision;
import jsr352.batch.jsl.Flow;
import jsr352.batch.jsl.Split;
import jsr352.batch.jsl.Step;

import com.ibm.batch.container.IExecutionElementController;
import com.ibm.batch.container.jobinstance.RuntimeJobExecutionImpl;
import com.ibm.batch.container.xjcl.ExecutionElement;

public class ExecutionElementControllerFactory {

    private final static String CLASSNAME = ExecutionElementControllerFactory.class.getName();
    private final static Logger logger = Logger.getLogger(CLASSNAME);

    public static IExecutionElementController getExecutionElementController(RuntimeJobExecutionImpl jobExecutionImpl, ExecutionElement executionElement) {

        String methodName = "getExecutionElementController";
        
        if(logger.isLoggable(Level.FINER)) { logger.logp (Level.FINER, CLASSNAME, methodName, "Get Execution Element Controller for", executionElement.getId());}
        
        if (executionElement instanceof Step) {
            Step step = (Step)executionElement;
            
            if (step.getPartition() != null) {
            	
            	if (step.getPartition().getPartitionPlan() != null) {
            		String instances = step.getPartition().getPartitionPlan().getInstances();
            		
            		if (instances != null && !!!instances.equals("1")) {
            	
            			if(logger.isLoggable(Level.FINER)) {  
            				logger.logp (Level.FINER, CLASSNAME, methodName, "Found partitioned step", step);
            			}            		
            			return new PartitionedStepControllerImpl(jobExecutionImpl, step);
            		}
            		
            	}
            	
            }
            
            
            Batchlet batchlet = step.getBatchlet();
            
            if (batchlet != null) {
                if(logger.isLoggable(Level.FINER)) {  logger.logp (Level.FINER, CLASSNAME, methodName, "Found batchlet", batchlet);}
                if(logger.isLoggable(Level.FINER)) {  logger.logp (Level.FINER, CLASSNAME, methodName, "Found batchlet", batchlet.getRef());}
                
                if (step.getChunk() != null) {
                    throw new IllegalArgumentException("Step contains both a batchlet and a chunk.  Aborting.");
                }       
                return new BatchletStepControllerImpl(jobExecutionImpl, step);
            } else {
                Chunk chunk = step.getChunk();
                if(logger.isLoggable(Level.FINER)) {  logger.logp (Level.FINER, CLASSNAME, methodName, "Found chunk", chunk);}
                if (chunk == null) {
                    throw new IllegalArgumentException("Step does not contain either a batchlet or a chunk.  Aborting.");
                }
                return new ChunkStepControllerImpl(jobExecutionImpl, step);
            }           
        } else if (executionElement instanceof Decision) {
            return new DecisionControllerImpl(jobExecutionImpl, (Decision)executionElement);
        } else if (executionElement instanceof Flow) {
            return new FlowControllerImpl(jobExecutionImpl, (Flow)executionElement);
        } else if (executionElement instanceof Split) {
            return new SplitControllerImpl(jobExecutionImpl, (Split)executionElement);
        }  else {
            throw new UnsupportedOperationException("Only support steps, flows, splits, and decisions so far.");
        }
        
    }
}
