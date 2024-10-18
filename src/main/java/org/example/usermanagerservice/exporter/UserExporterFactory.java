package org.example.usermanagerservice.exporter;

public class UserExporterFactory {

    public static UserExporter getExporter(String format) {
        switch (format.toLowerCase()) {
            case "csv":
                return new CsvUserExporter();
            default:
                throw new IllegalArgumentException("Unknown export format: " + format);
        }
    }
}
