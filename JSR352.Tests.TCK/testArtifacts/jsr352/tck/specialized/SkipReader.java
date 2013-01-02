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

import javax.batch.annotation.BatchProperty;
import javax.batch.annotation.CheckpointInfo;
import javax.batch.annotation.ItemReader;
import javax.batch.annotation.Open;
import javax.batch.annotation.ReadItem;

import jsr352.tck.chunktypes.ArrayIndexCheckpointData;
import jsr352.tck.chunktypes.ReadRecord;
import jsr352.tck.reusable.MyChildException;
import jsr352.tck.reusable.MyParentException;


@ItemReader("SkipReader")
@javax.inject.Named("SkipReader")
public class SkipReader {
	
	private int count = 0;
	private int[] readerDataArray;
	private int idx;
	private boolean threwSkipException = false;
	boolean throwChildEx = false;
	ArrayIndexCheckpointData _cpd = new ArrayIndexCheckpointData();
	
	@BatchProperty(name="readrecord.fail")
    String readrecordfailNumberString = null;
	
	@BatchProperty(name="execution.number")
    String executionNumberString;
	
	@BatchProperty(name="app.arraysize")
    String appArraySizeString;
		
	int[] failnum;
	int execnum;
	int arraysize;
	
	public SkipReader(){
			
	}
		
		@Open
		public void openMe(ArrayIndexCheckpointData cpd) {
			
			if (!readrecordfailNumberString.equals("null")) {
				String[] readFailPointsStrArr = readrecordfailNumberString.split(",");
				failnum = new int[readFailPointsStrArr.length];
				for (int i = 0; i < readFailPointsStrArr.length; i++) {
					failnum[i] = Integer.parseInt(readFailPointsStrArr[i]);
				}
			}
			else {
				failnum = new int[1];
				failnum[0] = -1;
			}
			
            execnum = Integer.parseInt(executionNumberString);
            
    		arraysize = Integer.parseInt(appArraySizeString);
    		readerDataArray =  new int[arraysize];
    		
    		for (int i = 0; i<arraysize; i++){
    			// init the data array
    			readerDataArray[i] = i;
    		}
    	
			if (cpd == null){
				//position at the beginning
				idx = 0;
			}
			else {
				// position at index held in the cpd
				idx = cpd.getCurrentIndex() + 1; 
			}
			System.out.println("READ: starting at index: " + idx);
		}
		
		@ReadItem
		public ReadRecord readIt() throws Exception {
		
			
			if (threwSkipException){
				count++;
				idx++;
				threwSkipException = false;
				throwChildEx= true;
			}
			
			int i = idx;
			
			if (i == arraysize) {
				return null;
			}
			if (execnum == 2){
				failnum[0] = -1;
			}
						
			if (isFailnum(idx)){
				System.out.println("READ: got the fail num..." + failnum);
				threwSkipException = true;
				if (!throwChildEx){
					throw new MyParentException("fail on purpose with MyParentException");
				}
				else {
					throwChildEx = false;
					throw new MyChildException("fail on purpose with MyChildException");
				}
			}
			count = count + 1;
			idx = idx+1;
			_cpd.setCurrentIndex(i);
		    return new ReadRecord(readerDataArray[i]);
		}
		
		@CheckpointInfo
		public ArrayIndexCheckpointData getCPD() {
			
			System.out.println("READ: in getCPD cpd index from store: " + _cpd.getCurrentIndex());
			System.out.println("READ: in getCPD idx : " + idx);
			
		    return _cpd;   
		}

		private boolean isFailnum(int idxIn) {
		
			boolean ans = false;
			for (int i = 0; i < failnum.length; i++) {
				if (idxIn == failnum[i]){
					ans = true;
				}
			}
			return ans;
		}
}