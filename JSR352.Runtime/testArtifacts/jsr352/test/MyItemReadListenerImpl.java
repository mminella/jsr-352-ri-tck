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

import java.sql.SQLException;
import java.util.logging.Logger;

import javax.batch.annotation.AfterRead;
import javax.batch.annotation.BeforeRead;
import javax.batch.annotation.ItemReadListener;
import javax.batch.annotation.OnReadError;

import jsr352.tck.chunktypes.ReadRecord;


@ItemReadListener("MyItemReadListener")
public class MyItemReadListenerImpl {

	private final static String sourceClass = MyItemReadListenerImpl.class.getName();
	private final static Logger logger = Logger.getLogger(sourceClass);

	@BeforeRead
	public void beforeRead(){
		logger.finer("In beforeRead()");
	}
	
	@AfterRead
	public void afterRead(ReadRecord item) throws Exception {
		logger.finer("In afterRead(), item = " + item.getCount());
	}
	
	@OnReadError
	public void onReadRerror (SQLException e) throws Exception {
		logger.finer("In onReadRerror() " + e);
	}
}
