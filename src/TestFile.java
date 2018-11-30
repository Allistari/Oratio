import java.io.IOException;

public class TestFile {
    public static void main(String[] args) throws IOException {
        OratioLinkedList<String> myList = new OratioLinkedList<String>(); //you can use your list similar to an ArrayList
        OratioTree<String> tree = new OratioTree<String>();

        PhoneticTranslator pt = new PhoneticTranslator();

        myList.add("Bob");
        myList.add("AAAAAAAAAAAAAAAAAAAAAAQA");
        myList.add("adhaowidhawo");
        myList.add("xxxxx");
        myList.add("xdsfsdfsdfsdxxxx",0);
        myList.remove(0);


        System.out.println("asas");
        System.out.println(myList.size());
        System.out.println(myList.indexOf("Bob"));

        tree.add("Yeet", "lmao");
        tree.add("Yeettt", "tttt");
        tree.add("Yeettt", "t");
        tree.add("Yeeeeettt", "tt");

        System.out.println(tree.altGet("lmao"));
        System.out.println(tree.get("t"));
        System.out.println(tree.get("tttt"));


        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        System.out.println(pt.getPronounce("explosives"));


    }
}
