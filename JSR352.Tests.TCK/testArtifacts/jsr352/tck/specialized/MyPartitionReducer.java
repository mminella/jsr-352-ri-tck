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

import javax.batch.annotation.AfterCompletion;
import javax.batch.annotation.BatchContext;
import javax.batch.annotation.BeforeCompletion;
import javax.batch.annotation.Begin;
import javax.batch.annotation.PartitionReducer;
import javax.batch.annotation.Rollback;
import javax.batch.runtime.context.StepContext;

import jsr352.tck.reusable.ExternalizableString;

@PartitionReducer
@javax.inject.Named("MyPartitionReducer")
public class MyPartitionReducer {

	@BatchContext
	StepContext ctx;
	
    @Begin
	public Externalizable txBegin() throws Exception {
		
		ExternalizableString eString = new ExternalizableString("C");
		
		return eString; 
		
	}
    
    
    @BeforeCompletion
    public void txBeforeCompletion() {
    	
    }
    
    @Rollback
    public void txRollback() {
    	
    }
    
    @AfterCompletion
    public void txAfterCompletion(String status) {
    	
    	
    }

}
