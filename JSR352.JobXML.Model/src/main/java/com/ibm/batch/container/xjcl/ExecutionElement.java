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
package com.ibm.batch.container.xjcl;

import java.util.List;

/*
 * This is a marker interface.  It's not hugely useful,
 * but lets us have more meaningful method signatures
 * reflecting the common "execution" aspect of each of
 * Step, Flow, Split, Decision, without forcing us
 * to make a common XSD base type just to have this in the model.
 */
public interface ExecutionElement {
    String getId();
    List<ControlElement> getControlElements();
}

