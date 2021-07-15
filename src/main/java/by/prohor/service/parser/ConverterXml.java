package by.prohor.service.parser;

import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Artsiom Prokharau 15.07.2021
 */

public class ConverterXml {

    private static final String FILE_NAME = "/home/prohor/IdeaProjects/Spring_Intro/test1.xml";

    private Unmarshaller unmarshaller;

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }

    public UserDto XMLToObj() {
        UserDto userDto = null;
        try (FileInputStream is = new FileInputStream(FILE_NAME)) {
            userDto = (UserDto) this.unmarshaller.unmarshal(new StreamSource(is));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return userDto;
    }
}
