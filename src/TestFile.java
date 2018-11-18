public class TestFile {
    public static void main(String[] args) {
        OratioLinkedList<String> myList = new OratioLinkedList<String>();   //you can use your list similar to an ArrayList

        myList.add("Bob");
        myList.add("AAAAAAAAAAAAAAAAAAAAAAQA");
        myList.add("adhaowidhawo");
        myList.add("xxxxx");
        myList.add("xdsfsdfsdfsdxxxx",0);


        System.out.println("asas");
        System.out.println(myList.size());
        System.out.println(myList.indexOf("Bob"));


        for(int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
    }
}
