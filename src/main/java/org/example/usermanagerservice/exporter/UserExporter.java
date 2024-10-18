package org.example.usermanagerservice.exporter;

import org.example.usermanagerservice.entity.User;

import java.util.List;
public interface UserExporter {
    void export(List<User> users, String filePath);
}
