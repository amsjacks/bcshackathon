package test;

import org.junit.Test;
import parser_api_requests.IResourceParser;
import parser_api_requests.ResourceParsingException;
import parser_api_requests.XMLResourceParser;

import java.io.IOException;
import java.util.List;

/**
 * Created by Lindsey on 2017-03-11.
 */
public class test {
    private List<String> directorList;

    @Test
    public void testParse() throws ResourceParsingException, IOException {
        String DATA_SOURCE = "./data/directors.xml";
        IResourceParser parser = new XMLResourceParser(DATA_SOURCE);
        directorList = parser.parse();
        System.out.println(directorList);
    }
}
