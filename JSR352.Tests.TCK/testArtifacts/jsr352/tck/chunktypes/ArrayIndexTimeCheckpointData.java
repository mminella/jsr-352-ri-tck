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
package jsr352.tck.chunktypes;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@javax.inject.Named("ArrayIndexTimeCheckpointData")
public class ArrayIndexTimeCheckpointData implements Externalizable {

    private final static long serialVersionUID = 1L;
    private static int i = 0;
    
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    	i = in.readInt();
    	
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
    	System.out.println("AJM: must have been checkpointed, writing out array index: " + i);
        out.writeInt(i);

    }
    
    public int getCurrentIndex(){
    	return i;
    }
    
    public void setCurrentIndex(int incoming_idx){
    	i = incoming_idx;
    }
}
