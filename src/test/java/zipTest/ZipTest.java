package zipTest;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ZipTest {

    @Test
    public void ZipExtractTest() throws IOException, CsvException {

        ClassLoader classLoader = ZipTest.class.getClassLoader();

        try (
                InputStream resource = classLoader.getResourceAsStream("ZipTest.zip");
                ZipInputStream zis = new ZipInputStream(resource)
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null) {

                if (entry.getName().endsWith(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertThat(pdf.text).contains("String_3");

                } else if (entry.getName().endsWith(".xlsx")) {
                    XLS xls = new XLS(zis);
                    assertTrue(xls.excel.getSheetAt(0).getRow(2).getCell(1).getStringCellValue().contains("String_3"));

                } else if (entry.getName().endsWith(".csv")) {
                    CSVReader reader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> contentCsv = reader.readAll();
                    assertTrue(contentCsv.get(2)[1].contains("String_3"));
                }
            }
        }
    }
}
