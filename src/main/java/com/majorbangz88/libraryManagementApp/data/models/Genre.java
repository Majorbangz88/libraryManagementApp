package com.majorbangz88.libraryManagementApp.data.models;

public enum Genre {

        POLITICS(),
        ROMANCE(),
        EDUCATIONAL(),
        BUSINESS(),
        MARRIAGE(),
        RELIGION();

        private String[] books;

        Genre(String... books) {
            this.books = books;
        }

        public String[] getStates() {
            return books;
        }

        public void setBooks(String[] books) {
            this.books = books;
        }
//        public static Genre returnGenre(String zones) {
//            for (Genre genre : Genre.values()) {
//                for (String cityState: genre.getStates()) {
//                    if (cityState.equalsIgnoreCase(zones)) {
//                        return genre;
//                    }
//                }
//            }
//            throw new NullPointerException("Entry not valid");
//        }

}
