/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ratpackframework.path.internal;

import com.google.common.collect.ImmutableMap;
import org.ratpackframework.path.PathTokens;

import java.util.AbstractMap;
import java.util.Set;

public class DefaultPathTokens extends AbstractMap<String, String> implements PathTokens {

  private final ImmutableMap<String, String> delegate;

  public DefaultPathTokens(ImmutableMap<String, String> delegate) {
    this.delegate = delegate;
  }

  @SuppressWarnings("NullableProblems")
  @Override
  public Set<Entry<String, String>> entrySet() {
    return delegate.entrySet();
  }

  @Override
  public Boolean getAsBoolean(String key) {
    if (!containsKey(key)) {
      return null;
    }
    return Boolean.valueOf(get(key));
  }

  @Override
  public Byte getAsByte(String key) {
    if (!containsKey(key)) {
      return null;
    }
    return Byte.valueOf(get(key));
  }

  @Override
  public Short getAsShort(String key) {
    if (!containsKey(key)) {
      return null;
    }
    return Short.valueOf(get(key));
  }

  @Override
  public Integer getAsInt(String key) {
    if (!containsKey(key)) {
      return null;
    }
    return Integer.valueOf(get(key));
  }

  @Override
  public Long getAsLong(String key) {
    if (!containsKey(key)) {
      return null;
    }
    return Long.valueOf(get(key));
  }
}