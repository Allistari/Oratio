public class Word {

    private String word;
    private String[] tags;

    public String getWord() {
        return word;
    }

    public String getIPAPronounce() {
        return tags[1].substring(tags[1].indexOf(":") + 1);
    }
}
