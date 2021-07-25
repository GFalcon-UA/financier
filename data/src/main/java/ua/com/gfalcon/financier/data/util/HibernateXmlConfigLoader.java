/*
 *   Copyright 2016-2021 Oleksii V. KHALIKOV, PE
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

package ua.com.gfalcon.financier.data.util;

import java.io.InputStream;
import java.io.Reader;
import java.util.Objects;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import ua.com.gfalcon.financier.util.XmlParser;

/**
 * Loader Hibernate XML config file for injecting Hiberante properties into Spring bean definition.
 *
 * @author Oleksii Khalikov
 * @since 1.0.0
 */
public class HibernateXmlConfigLoader extends XmlParser<HibernateConfiguration> {

    public static final String PROPERTY = "property";
    public static final String NAME = "name";
    public static final String VALUE = "value";
    public static final String MAPPING = "mapping";
    public static final String PACKAGE = "package";
    private Property entry;

    protected HibernateXmlConfigLoader(XMLStreamReader reader) {
        super(reader);
        setContext();
    }

    public HibernateXmlConfigLoader(InputStream inputStream) throws XMLStreamException {
        super(inputStream);
        setContext();
    }

    protected HibernateXmlConfigLoader(Reader streamReader) throws XMLStreamException {
        super(streamReader);
        setContext();
    }

    @Override
    protected void parseEndElement(String nodeName) {
        if (PROPERTY.equals(nodeName)) {
            getContext().addProperty(entry.getKey(), entry.getValue());
            entry = null;
        }
    }

    @Override
    protected void parseStartElement(String nodeName) {
        if (PROPERTY.equals(nodeName)) {
            entry = new Property();
            for (int i = 0; i < getReader().getAttributeCount(); i++) {
                if (NAME.equals(getReader().getAttributeLocalName(i))) {
                    entry.setKey(getReader().getAttributeValue(i));
                } else if (VALUE.equals(getReader().getAttributeLocalName(i))) {
                    entry.setValue(getReader().getAttributeValue(i));
                }
            }
        } else if (MAPPING.equals(nodeName)) {
            for (int i = 0; i < getReader().getAttributeCount(); i++) {
                if (PACKAGE.equals(getReader().getAttributeLocalName(i))) {
                    getContext().addPackage(getReader().getAttributeValue(i));
                }
            }
        }
    }

    @Override
    protected void parseText(String text) {
        if (Objects.nonNull(entry)) {
            entry.setValue(text);
        }
    }

    private void setContext() {
        setContext(new HibernateConfiguration());
    }

    private class Property {

        private String key;
        private String value;

        public Property() {
            // nothing
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }

}
