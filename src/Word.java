public class Word {

    private String word;
    private String[] tags;

    public String getWord() {
        return word;
    }

    public String getIPAPronounce() {
        System.out.println("1: " + tags[0] + "\n" + "2: " + tags[1]);
        return tags[0].substring(tags[0].indexOf(":") + 1);
    }
}
