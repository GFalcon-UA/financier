/*
 *   Copyright 2016-2020 Oleksii V. KHALIKOV, PE
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package ua.com.gfalcon.financier.server.util;

import java.io.InputStream;
import java.io.Reader;
import java.util.Objects;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public abstract class XmlParser<T> {

  private final XMLStreamReader reader;
  private T context;

  protected XmlParser(XMLStreamReader reader) {
    this.reader = reader;
  }

  protected XmlParser(InputStream inputStream) throws XMLStreamException {
    this(getReader(inputStream));
  }

  protected XmlParser(Reader streamReader) throws XMLStreamException {
    this(getReader(streamReader));
  }

  private static XMLStreamReader getReader(InputStream inputStream) throws XMLStreamException {
    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    return inputFactory.createXMLStreamReader(inputStream);
  }

  private static XMLStreamReader getReader(Reader streamReader) throws XMLStreamException {
    XMLInputFactory inputFactory = XMLInputFactory.newInstance();
    return inputFactory.createXMLStreamReader(streamReader);
  }

  public T parse() throws XMLStreamException {
    if (Objects.isNull(this.context)) {
      throw new IllegalStateException("Context is not initialized");
    }
    while (reader.hasNext()) {
      int event = reader.next();
      if (event == XMLStreamConstants.START_ELEMENT) {
        parseStartElement(reader.getLocalName());
      } else if (event == XMLStreamConstants.CHARACTERS) {
        parseText(reader.getText());
      } else if (event == XMLStreamConstants.END_ELEMENT) {
        parseEndElement(reader.getLocalName());
      }
    }
    return getContext();
  }

  protected abstract void parseStartElement(String nodeName);

  protected abstract void parseEndElement(String nodeName);

  protected abstract void parseText(String text);

  protected T getContext() {
    return this.context;
  }

  protected void setContext(T context) {
    this.context = context;
  }

  public XMLStreamReader getReader() {
    return this.reader;
  }

}
