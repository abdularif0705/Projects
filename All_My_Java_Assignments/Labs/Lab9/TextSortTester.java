public class TextSortTester{
    public static void main(String[] args) throws Exception{
        TextFileSorter sorter = new TextFileSorter();

        sorter.setInput(args[0]);
        sorter.setOutput(args[1]);
        sorter.setOrder(args[2].charAt(0));

        sorter.readFromFile();
        sorter.sorting();
    }
}