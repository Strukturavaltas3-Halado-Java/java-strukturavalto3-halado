package training.books;

public enum Genre {

    SCI_FI, BELLES_LETTRES;

    public static boolean isValidGenre(String genre) {
        for (Genre g : Genre.values()) {
            if (g.toString().equals(genre)) {
                return true;
            }
        }
        return false;
    }
}
