package org.example.usermanagerservice.exporter;

import com.opencsv.CSVWriter;
import org.example.usermanagerservice.entity.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvUserExporter implements UserExporter {

    @Override
    public void export(List<User> users, String filePath) {

        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            String[] header = {
                    "ID", "Gender", "Email", "Phone", "Cell", "Nat",
                    "Name Title", "Name First", "Name Last",
                    "Location Street Number", "Location Street Name",
                    "Location City", "Location State", "Location Country",
                    "Location Postcode", "Coordinates Latitude", "Coordinates Longitude",
                    "Timezone Offset", "Timezone Description",
                    "Picture Large", "Picture Medium", "Picture Thumbnail",
                    "Login UUID", "Login Username", "Login Password",
                    "Login Salt", "Login MD5", "Login SHA1", "Login SHA256",
                    "DOB Date", "DOB Age", "Registered Date", "Registered Age",
                    "ID Name", "ID Value"
            };
            writer.writeNext(header);

            for (User user : users) {
                String[] data = {
                        user.getId().toString(),
                        user.getGender(),
                        user.getEmail(),
                        user.getPhone(),
                        user.getCell(),
                        user.getNat(),
                        user.getName().getTitle(),
                        user.getName().getFirst(),
                        user.getName().getLast(),
                        String.valueOf(user.getLocation().getStreet().getNumber()),
                        user.getLocation().getStreet().getName(),
                        user.getLocation().getCity(),
                        user.getLocation().getState(),
                        user.getLocation().getCountry(),
                        user.getLocation().getPostcode(),
                        user.getLocation().getCoordinates().getLatitude(),
                        user.getLocation().getCoordinates().getLongitude(),
                        user.getLocation().getTimezone().getTimezoneOffset(),
                        user.getLocation().getTimezone().getDescription(),
                        user.getPicture().getLarge(),
                        user.getPicture().getMedium(),
                        user.getPicture().getThumbnail(),
                        user.getLogin().getUuid(),
                        user.getLogin().getUsername(),
                        user.getLogin().getPassword(),
                        user.getLogin().getSalt(),
                        user.getLogin().getMd5(),
                        user.getLogin().getSha1(),
                        user.getLogin().getSha256(),
                        user.getDob().getDobDate().toString(),
                        String.valueOf(user.getDob().getDobAge()),
                        user.getRegistered().getRegDate().toString(),
                        String.valueOf(user.getRegistered().getRegAge()),
                        user.getUserid().getName(),
                        user.getUserid().getValue()
                };
                writer.writeNext(data);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
