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
package javax.batch.api;

import java.io.Externalizable;

/**
 * PartitionAnalyzer receives control to process data and final results from
 * each partitions. If a PartitionCollector is configured on the step, the
 * PartitionAnalyzer receives control to process the data and results from the
 * partition collector. While a separate PartitionCollector instance is invoked
 * on each thread processing a step partition, the PartitionAnalyzer runs on a
 * single, consistent thread each time it is invoked.
 * 
 */
public interface PartitionAnalyzer {
	/**
	 * The analyzeCollectorData method receives control each time a Partition
	 * collector sends its payload. It receives as an input the Externalizable
	 * object from the collector.
	 * 
	 * @param data
	 *            specifies the payload sent by a PartitionCollector.
	 * @throws Exception
	 *             is thrown if an error occurs.
	 */
	public void analyzeCollectorData(Externalizable data) throws Exception;

	/**
	 * The analyzeStatus method receives control each time a partition ends. It
	 * receives as input the batch and exit status strings of the partition.
	 * 
	 * @param batchStatus
	 *            specifies the batch status of a partition.
	 * @param exitStatus
	 *            specifies the exit status of a partition.
	 * @throws Exception
	 *             is thrown if an error occurs.
	 */
	public void analyzeStatus(String batchStatus, String exitStatus)
			throws Exception;
}
