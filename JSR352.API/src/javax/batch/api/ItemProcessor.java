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

/**
 * ItemProcessor is used in chunk processing to operate on an input item and
 * produce an output item.
 * 
 */
public interface ItemProcessor<T, R> {
	/**
	 * The processItem method is part of a chunk step. It accepts an input item
	 * from an item reader and returns an item that gets passed onto the item
	 * writer. If processItem returns null, no value is passed onto the chunk's
	 * item writer. This effectively enables processItem to filter out unwanted
	 * input items.
	 * 
	 * @param item
	 *            specifies the input item to process.
	 * @return output item to write.
	 * @throws Exception
	 *             thrown for any errors.
	 */
	public R processItem(T item) throws Exception;
}
