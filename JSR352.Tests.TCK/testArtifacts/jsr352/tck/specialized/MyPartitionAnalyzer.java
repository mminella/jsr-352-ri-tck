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
package jsr352.tck.specialized;

import java.io.Externalizable;

import javax.batch.annotation.AnalyzeCollectorData;
import javax.batch.annotation.AnalyzeExitStatus;
import javax.batch.annotation.BatchContext;
import javax.batch.annotation.PartitionAnalyzer;
import javax.batch.runtime.context.JobContext;
import javax.batch.runtime.context.StepContext;

import jsr352.tck.reusable.ExternalizableString;

@PartitionAnalyzer
@javax.inject.Named
public class MyPartitionAnalyzer {

	private String analyzedData = "";
	
	private String analyzedExits = "";
	
	@BatchContext
	JobContext jobCtx;
		
	@BatchContext
	StepContext ctx;
	
	@AnalyzeCollectorData 
	public void analyzeCollectorData(Externalizable data) throws Exception {
		
		analyzedData = analyzedData  + ((ExternalizableString)data).getString() + "A";
		 
	}
	
	@AnalyzeExitStatus 
	public void analyze(String exitStatus)throws Exception {
		//analyzedExits = analyzedExits + exitStatus + "S";
		//ctx.setExitStatus(analyzedExits);
		
		ctx.setExitStatus(analyzedData);
		jobCtx.setExitStatus(ctx.getExitStatus());
	}

}
