/**
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
package com.ibm.batch.container.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.batch.container.artifact.proxy.PartitionAnalyzerProxy;
import com.ibm.batch.container.exception.BatchContainerRuntimeException;
import com.ibm.batch.container.impl.JobControllerImpl;
import com.ibm.batch.container.jobinstance.RuntimeJobExecutionImpl;
import com.ibm.batch.container.services.IBatchKernelService;

/*
 * I took out the 'work type' constant since I don't see that we want to use
 * the same thread pool for start requests as we'd use for stop requests.
 * The stop seems like it should be synchronous from the JobOperator's
 * perspective, as it returns a 'success' boolean.
 */
public class BatchWorkUnit implements Runnable {

    private String CLASSNAME = BatchWorkUnit.class.getName();
    private Logger logger = Logger.getLogger(BatchWorkUnit.class.getPackage().getName());

    private RuntimeJobExecutionImpl jobExecutionImpl = null;
    private IBatchKernelService batchKernel = null;
    private final JobControllerImpl controller;
    
    private PartitionAnalyzerProxy analyzerProxy;
    private boolean notifyCallbackWhenDone;

    public BatchWorkUnit(IBatchKernelService batchKernel, RuntimeJobExecutionImpl jobExecutionImpl) {
        this(batchKernel, jobExecutionImpl, null, true);
    }
    
    public BatchWorkUnit(IBatchKernelService batchKernel, RuntimeJobExecutionImpl jobExecutionImpl, PartitionAnalyzerProxy analyzerProxy, boolean notifyCallbackWhenDone) {
        this.setBatchKernel(batchKernel);
        this.setJobExecutionImpl(jobExecutionImpl);
        this.analyzerProxy = analyzerProxy;
        this.setNotifyCallbackWhenDone(notifyCallbackWhenDone);
        
        controller = new JobControllerImpl(this.getJobExecutionImpl());
        controller.setAnalyzerProxy(this.analyzerProxy);
        
    }

    public JobControllerImpl getController() {
        return this.controller;
    }

    @Override
    public void run() {
        String method = "run";
        if (logger.isLoggable(Level.FINER)) {
            logger.entering(CLASSNAME, method);
        }

        if (logger.isLoggable(Level.INFO)) {
            logger.info("==========================================================");
            logger.info("Invoking executeJob on JobController; " + "JobInstance id=" + getJobExecutionImpl().getInstanceId()
                    + ", executionId=" + getJobExecutionImpl().getExecutionId());
            logger.info("==========================================================");
        }

        try {
            controller.executeJob();
        } catch (Exception e) {
            if (logger.isLoggable(Level.FINE)) {
                logger.fine("Exception when invoking executeJob on JobController; " + "JobInstance id="
                        + getJobExecutionImpl().getInstanceId() + ", executionId=" + getJobExecutionImpl().getExecutionId());
                logger.fine("Job Batch Status = " + getBatchStatus() + ";  Job Exit Status = "
                        + getExitStatus());
            }

            
            if (isNotifyCallbackWhenDone()) {
            	getBatchKernel().jobExecutionDone(getJobExecutionImpl());
            }

            throw new BatchContainerRuntimeException("This job failed unexpectedly.", e);

        }
        if (logger.isLoggable(Level.INFO)) {
            logger.info("==========================================================");
            logger.info("Done invoking executeJob on JobController; " + "JobInstance id=" + getJobExecutionImpl().getInstanceId()
                    + ", executionId=" + getJobExecutionImpl().getExecutionId());
            logger.info("Job Batch Status = " + getBatchStatus() + ";  Job Exit Status = "
                    + getExitStatus());
            logger.info("==========================================================");
        }

        if (isNotifyCallbackWhenDone()) {
        	getBatchKernel().jobExecutionDone(getJobExecutionImpl());
        }

        if (logger.isLoggable(Level.FINER)) {
            logger.exiting(CLASSNAME, method);
        }
    }

	public void setAnalyzerProxy(PartitionAnalyzerProxy analyzerProxy) {
		this.analyzerProxy = analyzerProxy;
	}

	public PartitionAnalyzerProxy getAnalyzerProxy() {
		return analyzerProxy;
	}
	
	private String getBatchStatus() {
		return jobExecutionImpl.getJobContext().getBatchStatus();
	}
	
	private String getExitStatus() {
		return jobExecutionImpl.getJobContext().getExitStatus();
	}

	public void setBatchKernel(IBatchKernelService batchKernel) {
		this.batchKernel = batchKernel;
	}

	public IBatchKernelService getBatchKernel() {
		return batchKernel;
	}

	public void setJobExecutionImpl(RuntimeJobExecutionImpl jobExecutionImpl) {
		this.jobExecutionImpl = jobExecutionImpl;
	}

	public RuntimeJobExecutionImpl getJobExecutionImpl() {
		return jobExecutionImpl;
	}

	public void setNotifyCallbackWhenDone(boolean notifyCallbackWhenDone) {
		this.notifyCallbackWhenDone = notifyCallbackWhenDone;
	}

	public boolean isNotifyCallbackWhenDone() {
		return notifyCallbackWhenDone;
	}

}
