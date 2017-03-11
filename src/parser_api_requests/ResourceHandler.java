package parser_api_requests;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

// Handler for XML resource parsing
public class ResourceHandler extends DefaultHandler {
    private List<String> directorNames;
    private StringBuilder accumulator;


    // EFFECTS: constructs resource handler for XML parser
    public ResourceHandler(List<String> directorNames) {
        this.directorNames = directorNames;
        accumulator = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if(qName == "Data"){
             directorNames.add(accumulator.toString().trim());
        }

        accumulator.setLength(0);

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        accumulator.append(ch, start, length);
    }
}
