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
package jsr352.test;

import javax.batch.annotation.*;
import javax.batch.annotation.Process;


@Batchlet("MyBatchlet")
public class MyBatchletImpl {
    
    private static int count = 1;
    
    public static String GOOD_EXIT_STATUS = "VERY GOOD INVOCATION";       
    
	
	@Process
	public String process() throws Exception {
		System.out.println("MyBatchLetImpl.process() - @Process #" + count++);
		return GOOD_EXIT_STATUS;
				
	}
	
	@Stop
	public void cancel() throws Exception {
		System.out.println("MyBatchLetImpl.cancel() - @Cancel #" + count);		
	}
	

}
