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

import javax.batch.annotation.AfterWrite;
import javax.batch.annotation.BeforeWrite;
import javax.batch.annotation.OnWriteError;

import jsr352.batch.jsl.Property;

import com.ibm.batch.container.exception.BatchContainerRuntimeException;

public class ItemWriteListenerProxy extends AbstractProxy {

    private Method beforeWriteMethod = null;
    private Method afterWriteMethod = null;
    private Method onWriteErrorMethod = null;

    ItemWriteListenerProxy(Object delegate, List<Property> props) {
        super(delegate, props);

        for (Method method : this.delegate.getClass().getDeclaredMethods()) {
            Annotation beforeWrite = method.getAnnotation(BeforeWrite.class);
            if (beforeWrite != null) {
                beforeWriteMethod = method;
            }

            Annotation afterWrite = method.getAnnotation(AfterWrite.class);
            if (afterWrite != null) {
                afterWriteMethod = method;
            }

            Annotation onWriteError = method.getAnnotation(OnWriteError.class);
            if (onWriteError != null) {
                onWriteErrorMethod = method;
            }
        }
    }

    public void beforeWrite() {
        if (beforeWriteMethod != null) {
            try {
                beforeWriteMethod.invoke(delegate, (Object[]) null);
            } catch (Exception e) {
                throw new BatchContainerRuntimeException(e);
            }
        }
    }

    public void afterWrite() {
        if (afterWriteMethod != null) {
            try {
                afterWriteMethod.invoke(delegate, (Object[]) null);
            } catch (Exception e) {
                throw new BatchContainerRuntimeException(e);
            }
        }
    }

    public void onWriteError() {
        if (onWriteErrorMethod != null) {
            try {
                onWriteErrorMethod.invoke(delegate, (Object[]) null);
            } catch (Exception e) {
                throw new BatchContainerRuntimeException(e);
            }
        }
    }
}
