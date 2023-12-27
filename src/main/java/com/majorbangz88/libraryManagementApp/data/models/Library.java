package com.majorbangz88.libraryManagementApp.data.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Library")
public class Library {

    private String libraryName;
    private String address;
    private String adminName;
    private String adminPassword;
    private boolean isLoggedIn;
    private Catalog catalog;
    private StaffMembers staffMembers;
    private Patron patrons;
}
