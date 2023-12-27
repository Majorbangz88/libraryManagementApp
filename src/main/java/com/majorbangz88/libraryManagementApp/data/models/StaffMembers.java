package com.majorbangz88.libraryManagementApp.data.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("StaffMembers")
public class StaffMembers {

    @Id
    private String id;
    private String Role;
}
