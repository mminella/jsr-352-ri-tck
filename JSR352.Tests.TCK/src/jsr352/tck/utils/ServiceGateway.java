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
package jsr352.tck.utils;

import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ibm.batch.tck.spi.BatchContainerServiceProvider;

public class ServiceGateway {
    private final static Logger logger = 
        Logger.getLogger(ServiceGateway.class.getName());

    public static BatchContainerServiceProvider getServices() { 
        BatchContainerServiceProvider services = null;
        ServiceLoader<BatchContainerServiceProvider> loader = 
            ServiceLoader.load(BatchContainerServiceProvider.class);

        for (BatchContainerServiceProvider provider : loader) {
            if (provider != null) {
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine("Loaded BatchContainerServiceProvider with className = " + provider.getClass().getCanonicalName());
                }
                // Use first one
                services = provider;
                break;
            }
        }

        if (services == null) {
            throw new IllegalStateException("Bad TCK classpath; check your run/debug config.  Probably the remedy is to add the 'Runtime' project as a classpath entry to the TCK run configuration (on the other hand it should NOT" +
            		" be present on the build time clsspath.  The low level problem is that we couldn't find/load a BatchContainerServiceProvider instance.  ");
        }
        return services;
    } 
}
