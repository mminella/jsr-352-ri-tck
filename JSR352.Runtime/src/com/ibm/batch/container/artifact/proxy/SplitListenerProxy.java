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
package com.ibm.batch.container.artifact.proxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

import javax.batch.annotation.AfterSplit;
import javax.batch.annotation.BeforeSplit;

import jsr352.batch.jsl.Property;

import com.ibm.batch.container.exception.BatchContainerRuntimeException;

public class SplitListenerProxy extends AbstractProxy {

    private Method beforeSplitMethod = null;
    private Method afterSplitMethod = null;

    SplitListenerProxy(Object delegate, List<Property> props) {
        super(delegate, props);

        for (Method method : delegate.getClass().getDeclaredMethods()) {
            Annotation beforeSplit = method.getAnnotation(BeforeSplit.class);
            if (beforeSplit != null) {
                afterSplitMethod = method;
            }
            Annotation afterSplit = method.getAnnotation(AfterSplit.class);
            if (afterSplit != null) {
                beforeSplitMethod = method;
            }
        }
    }

    public void beforeSplit() {
        if (afterSplitMethod != null) {
            try {
                afterSplitMethod.invoke(delegate, (Object[]) null);
            } catch (Exception e) {
                throw new BatchContainerRuntimeException(e);
            }
        }
    }

    public void afterSplit() {
        if (beforeSplitMethod != null) {
            try {
                beforeSplitMethod.invoke(delegate, (Object[]) null);
            } catch (Exception e) {
                throw new BatchContainerRuntimeException(e);
            }
        }
    }
}
