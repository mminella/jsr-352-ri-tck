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

import javax.batch.annotation.ItemProcessor;
import javax.batch.annotation.ProcessItem;

import jsr352.tck.chunktypes.ReadRecord;

@ItemProcessor("DoSomethingArrayItemProcessor")
@javax.inject.Named("DoSomethingArrayItemProcessor")
public class DoSomethingArrayItemProcessorImpl {
	private int update = 100;
	
	@ProcessItem
	public ReadRecord processData(ReadRecord record) throws Exception {
		
		ReadRecord processedRecord = record;
		int currData = processedRecord.getCount();
		processedRecord.setRecord(currData + update);
		return processedRecord;
	}
}
