/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.elasticsearch.client.ml.job.process;

import org.elasticsearch.common.xcontent.XContentParser;
import org.elasticsearch.test.AbstractXContentTestCase;
import org.joda.time.DateTime;

import java.time.Instant;

public class DataCountsTests extends AbstractXContentTestCase<DataCounts> {

    public static DataCounts createTestInstance(String jobId) {
        return new DataCounts(jobId, randomIntBetween(1, 1_000_000),
                randomIntBetween(1, 1_000_000), randomIntBetween(1, 1_000_000), randomIntBetween(1, 1_000_000),
                randomIntBetween(1, 1_000_000), randomIntBetween(1, 1_000_000), randomIntBetween(1, 1_000_000),
                randomIntBetween(1, 1_000_000), randomIntBetween(1, 1_000_000), randomIntBetween(1, 1_000_000),
                new DateTime(randomDateTimeZone()).toDate(), new DateTime(randomDateTimeZone()).toDate(),
                new DateTime(randomDateTimeZone()).toDate(), new DateTime(randomDateTimeZone()).toDate(),
                new DateTime(randomDateTimeZone()).toDate(), randomBoolean() ? null : Instant.now());
    }

    @Override
    public DataCounts createTestInstance() {
        return createTestInstance(randomAlphaOfLength(10));
    }

    @Override
    protected DataCounts doParseInstance(XContentParser parser) {
        return DataCounts.PARSER.apply(parser, null);
    }

    @Override
    protected boolean supportsUnknownFields() {
        return true;
    }

}
