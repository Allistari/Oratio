public class Word {

    private String word;
    private String[] tags;

    public String getWord() {
        return word;
    }

    public String getIPAPronounce() {
        return tags[0].substring(tags[0].indexOf(":") + 1);
    }

}
