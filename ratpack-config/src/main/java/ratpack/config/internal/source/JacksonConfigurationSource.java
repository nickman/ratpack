/*
 * Copyright 2015 the original author or authors.
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

package ratpack.config.internal.source;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import ratpack.config.ConfigurationSource;
import ratpack.config.internal.util.PathUtil;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;

public abstract class JacksonConfigurationSource implements ConfigurationSource {
  private final ByteSource byteSource;

  public JacksonConfigurationSource(Path path) {
    this(Files.asByteSource(path.toFile()));
  }

  public JacksonConfigurationSource(String pathOrUrl) {
    this(PathUtil.asByteSource(pathOrUrl));
  }

  public JacksonConfigurationSource(URL url) {
    this(Resources.asByteSource(url));
  }

  public JacksonConfigurationSource(ByteSource byteSource) {
    this.byteSource = byteSource;
  }

  @Override
  public ObjectNode loadConfigurationData(ObjectMapper objectMapper) throws Exception {
    try (InputStream inputStream = byteSource.openStream()) {
      JsonParser parser = getFactory(objectMapper).createParser(inputStream);
      return objectMapper.readTree(parser);
    }
  }

  protected abstract JsonFactory getFactory(ObjectMapper objectMapper);
}
