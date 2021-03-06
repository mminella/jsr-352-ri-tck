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

import java.sql.SQLException;
import java.util.logging.Logger;

import javax.batch.annotation.AfterProcess;
import javax.batch.annotation.BeforeProcess;
import javax.batch.annotation.ItemProcessListener;
import javax.batch.annotation.OnProcessError;

import jsr352.tck.chunktypes.ReadRecord;
import jsr352.tck.chunktypes.WriteRecord;


@ItemProcessListener("MyItemProcessListener")
public class MyItemProcessListenerImpl {
	private final static String sourceClass = MyItemProcessListenerImpl.class.getName();
	private final static Logger logger = Logger.getLogger(sourceClass);

	@BeforeProcess
	public void beforeProcess(ReadRecord item) {
		logger.finer("In beforeProcess(), item = " + item.getCount());
	}
	
	@AfterProcess
	public void afterProcess(ReadRecord input, WriteRecord output) throws Exception {
		logger.finer("In afterProcess(), input = " + input.getCount() + ", output = " + output.getCount());		
	}
	
	@OnProcessError
	public void onProcessError(SQLException e, ReadRecord input) throws Exception {
		logger.finer("In onProcessError(), input = " + input.getCount() + ", " + e);
	}
	
}
