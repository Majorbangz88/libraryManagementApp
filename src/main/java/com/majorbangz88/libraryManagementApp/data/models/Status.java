package com.majorbangz88.libraryManagementApp.data.models;

public enum Status {

    AVAILABLE(),
    OUT_OF_STOCK();

    private String[] status;

    Status(String... status) {
        this.status = status;
    }

    public String[] getStatus() {
        return status;
    }

    public void setStatus(String[] status) {
        this.status = status;
    }
//    public static Status returnGenre(String statuses) {
//        for (Status status1 : Status.values()) {
//            for (String cityState: status1.getStatus()) {
//                if (cityState.equalsIgnoreCase(statuses)) {
//                    return status1;
//                }
//            }
//        }
//        throw new NullPointerException("Entry not valid");
//    }
}
