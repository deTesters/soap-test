package nl.deTesters.googledays.soaptest.freemarker;

import freemarker.template.*;
import java.io.*;
import java.util.*;

public class FTLHelloWorld {

    public static void main(String[] args) throws IOException {

        //Freemarker configuration object
        freemarker.template.Configuration cfg = new freemarker.template.Configuration();
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setDirectoryForTemplateLoading(new File("src/test/resources/templates/"));
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        try {
            //Load template from source folder
            Template template = cfg.getTemplate("helloworld.ftl");

            //Build data model
            Map<String, Object> input = new HashMap<String, Object>();
            input.put("nameOfPerson", "Robin");
            input.put("phonenumberOfPerson", "1234567890");

            // Console output

            Writer out = new OutputStreamWriter(System.out);
            template.process(input, out);
            out.flush();

            // File output
            Writer file = new FileWriter (new File("FTL_helloworld.xml"));
            template.process(input, file);
            file.flush();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
